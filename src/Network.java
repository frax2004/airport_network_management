import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import collections.Edge;
import collections.UndirectedGraph;
import net.NetParser;
import net.NetScanner;

public record Network(Collection<? extends Airport> airports, Collection<? extends Route> routes) {

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

    Map<String, Integer> nodes = new HashMap<>();
    int i = 0;
    for(Airport airport : airports) {
      nodes.put(airport.id(), i++);
    }

    ToDoubleFunction<String> toTerritoryCost = s -> switch (s) {
      case "mountain" -> 4;
      case "plain" -> 1;
      case "sea" -> 1.2;
      case "river" -> .5;
      case "desert" -> 3;
      default -> 0;
    };

    Function<Route, Edge> toEdge = route -> new Edge(
      nodes.get(route.src().id()),
      nodes.get(route.dst().id()),
      route.cost() + Arrays
      .stream(route.territories())
      .mapToDouble(toTerritoryCost)
      .sum() * route.distance()
    );

    routes.stream().map(toEdge).forEach(G::addEdge);

    return G;
  }
}
