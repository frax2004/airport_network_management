import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import com.raylib.Raylib.Rectangle;
import com.raylib.Raylib.Vector2;

import static com.raylib.Raylib.*;

import collections.UndirectedWeightedEdge;
import collections.UndirectedGraph;
import net.NetParser;
import net.NetScanner;


/**
 * Represent an airport network
 * Network
 */
public final class Network extends UndirectedGraph {

  /**
   * Map an airport name to an id
   */
  private Map<String, Integer> ids = new HashMap<>();

  /**
   * The airport array
   */
  private final Airport[] airports;

  /**
   * The route array
   */
  private final Route[] routes;
  
  /**
   * Constructs a network
   * @param airports the airports
   * @param routes the routes
   */
  public Network(Collection<? extends Airport> airports, Collection<? extends Route> routes) {
    super(airports.size());
    this.airports = airports.toArray(Airport[]::new);
    this.routes = routes.toArray(Route[]::new);

    this.ids = IntStream
    .range(0, airports.size())
    .boxed()
    .collect(Collectors.toMap(i -> this.airports[i].id(), Function.identity()));

    routes
    .stream()
    .map(this::toEdge)
    .forEach(this::addEdge);
  }

  /**
   * Get the airports of this network
   * @return The airports
   */
  public Airport[] getAirports() {
    return Arrays.copyOf(this.airports, this.airports.length);
  }

  /**
   * Get the routes of this network
   * @return The routes
   */
  public Route[] getRoutes() {
    return Arrays.copyOf(this.routes, this.routes.length);
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
   * Computes the minimum spanning forest with Prim's algorithm (Eager Version)
   * @return the minimum spanning forest for this network
   */
  @Override
  public Network computeMinimumSpanningForest() {
    return new Network(
      Arrays.asList(this.airports), 
      super
      .computeMinimumSpanningForest()
      .edges()
      .map(this::toRoute)
      .toList()
    );
  }

  /**
   * Draws this network into the screen
   * @param bounds a rectangle which sets the viewport for drawing
   */
  public void draw(Rectangle bounds) {
    var xStats = Arrays.stream(this.airports).mapToDouble(Airport::x).summaryStatistics();
    var yStats = Arrays.stream(this.airports).mapToDouble(Airport::z).summaryStatistics();
    var costStats = this.edges().mapToDouble(UndirectedWeightedEdge::weight).summaryStatistics();
    double minX = xStats.getMin();
    double maxX = xStats.getMax();
    double minY = yStats.getMin();
    double maxY = yStats.getMax();
    double minCost = costStats.getMin();
    double maxCost = costStats.getMax();
    
    Function<Airport, Vector2> toCoords = (airport) -> rl.vec2(
      (float)(bounds.x() + ((airport.x() - minX)/(maxX - minX)) * bounds.width()),
      (float)(bounds.y() + ((airport.z() - minY)/(maxY - minY)) * bounds.height())
    );
    
    Consumer<UndirectedWeightedEdge> DrawEdge = edge -> {
      Vector2 begin = toCoords.apply(airports[edge.either()]); 
      Vector2 end = toCoords.apply(airports[edge.other(edge.either())]);

      float theta = 0;
      String label = "%.4f".formatted(edge.weight());

      float textWidth = MeasureTextEx(GetFontDefault(), label, 20, 2).x();

      DrawTextPro(
        GetFontDefault(),
        label,
        rl.vec2(
          (float)(begin.x() + .5*(end.x() - begin.x() - textWidth)),
          (float)(begin.y() + .5*(end.y() - begin.y()) - 5)
        ),
        rl.vec2(0, 0),
        theta,
        20.0f,
        2.0f,
        rl.hex2rgb(0xffffffff)
      );

      DrawLineV(
        begin,
        end,
        rl.rgblerp(
          rl.hex2rgb(0x00ff00ff), 
          rl.hex2rgb(0xff0000ff), 
          (float)((edge.weight() - minCost) / (maxCost - minCost))
        )
      );


    };

    this.edges().forEach(DrawEdge);

    Arrays
    .stream(airports)
    .forEach(airport -> airport.draw(toCoords.apply(airport), 5, rl.hex2rgb(0xffd900ff)));
  }

  /**
   * Convert a route to an edge
   * @param route the route
   * @return the associated edge
   */
  private UndirectedWeightedEdge toEdge(Route route) {
    return new UndirectedWeightedEdge(
      this.toID(route.src()),
      this.toID(route.dst()),
      route.cost() * route.distance()
    );
  }

  /**
   * Convert an edge to a route
   * @param edge the edge
   * @return the associated route
   */
  private Route toRoute(UndirectedWeightedEdge edge) {
    return new Route(
      this.airports[edge.either()],
      this.airports[edge.other(edge.either())],
      edge.weight()
    );
  }

  /**
   * Converts an airport to its id
   * @param airport the airport
   * @return the associated id
   */
  private int toID(Airport airport) {
    return this.ids.get(airport.id());
  }

}
