import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import collections.Edge;
import collections.UndirectedGraph;
import net.NetParser;
import net.NetScanner;

public final class Network {

  private Map<String, Integer> ids = new HashMap<>();
  private final Collection<? extends Airport> airports;
  private final Collection<? extends Route> routes;
  
  public Network(Collection<? extends Airport> airports, Collection<? extends Route> routes) {
    this.airports = airports;
    this.routes = routes;

    int i = 0;
    for(Airport airport : this.airports) {
      this.ids.put(airport.id(), i++);
    }
  }

  public Collection<? extends Airport> getAirports() {
    return this.airports;
  }

  public Collection<? extends Route> getRoutes() {
    return this.routes;
  }

  public Map<String, Integer> getIds() {
    return this.ids;
  }

  /**
   * Parse a file and load the network object
   * @param path the input path
   * @return the network if no exception was thrown, an empty option otherwise.
   */
  public static Optional<Network> loadFromFile(String path) {
    try {
      CharStream istream = CharStreams.fromFileName(path);
      NetScanner scanner = new NetScanner(istream);
      CommonTokenStream tokens = new CommonTokenStream(scanner);
      NetParser parser = new NetParser(tokens);
      ParseTree tree = parser.network();
      return Optional.of(new NetworkBuilder(tree).build());
    } catch(Exception e) {}

    return Optional.empty();
  }

  /**
   * Converts this network to its graph representation
   * @return The undirected graph representation of this network
   */
  public UndirectedGraph toGraph() {
    UndirectedGraph G = new UndirectedGraph(airports.size());

    ToDoubleFunction<String> toTerritoryCost = s -> switch (s) {
      case "mountain" -> 4;
      case "plain" -> 1;
      case "sea" -> 1.2;
      case "river" -> .5;
      case "desert" -> 3;
      default -> 0;
    };

    ToIntFunction<Airport> toID = airport -> this.ids.get(airport.id());

    Function<Route, Edge> toEdge = route -> new Edge(
      toID.applyAsInt(route.src()),
      toID.applyAsInt(route.dst()),
      route.cost() + Arrays
      .stream(route.territories())
      .mapToDouble(toTerritoryCost)
      .sum() * route.distance()
    );

    routes.stream().map(toEdge).forEach(G::addEdge);

    return G;
  }
}
