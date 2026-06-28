import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;

public record Network(Collection<? extends Airport> airports, Collection<? extends Route> routes) {

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
