import java.util.Arrays;
import collections.UndirectedGraph;
import static com.raylib.Raylib.*;
import com.raylib.Raylib.Rectangle;



public static void main(String[] args) {
  if(args.length < 1) {
    System.err.println("No input file.");
    return;
  }


  Optional<Network> network = Network
  // Parse the file
  .loadFromFile(args[0]);
  
  Optional<UndirectedGraph> graph = network
  // And then convert to graph
  .map(Network::toGraph);

  Optional<UndirectedGraph> msf = graph
  // And then convert to minimum spanning tree
  .map(UndirectedGraph::computeMinimumSpanningForest);

  Optional<Airport[]> airports = network
  .map(Network::getAirports)
  .map(data -> data.toArray(Airport[]::new));

  int WIDTH = 1200;
  int HEIGHT = 800;

  BiConsumer<UndirectedGraph, Rectangle> DrawGraph = (G, bounds) -> {
    Arrays.min(airports.get(), (lhs, rhs) -> 0);

    Consumer<Airport> DrawAirport = (airport) -> {
      
    };

    for(Airport airport : airports.get()) {
      DrawCircle((int)airport.x(), (int)airport.z(), 5, GetColor(0xffd900ff));
    }


    G.edges().forEach(edge -> {
      Airport src = airports.get()[edge.from()];
      Airport dst = airports.get()[edge.to()];
      DrawLine((int)src.x(), (int)src.z(), (int)dst.x(), (int)dst.z(), G == graph.get() ? GetColor(0xff0000ff) : GetColor(0x00ff00ff));
    });

  };

  InitWindow(WIDTH, HEIGHT, "Prim's Minimum Spanning Tree (Eager Version)");
  SetTargetFPS(60);

  while(!WindowShouldClose()) {
    BeginDrawing();
    ClearBackground(GetColor(0x111111ff));

    DrawGraph.accept(graph.orElse(null), rect(0, 0, WIDTH/2, HEIGHT));
    DrawGraph.accept(msf.orElse(null), rect(WIDTH/2, 0, WIDTH/2, HEIGHT));

    EndDrawing();
  }

  CloseWindow();
}



private static Rectangle rect(float x, float y, float w, float h) {
  Rectangle rec = new Rectangle();
  rec.x(x);
  rec.y(y);
  rec.width(w);
  rec.height(h);
  return rec;
}

