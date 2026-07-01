package collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Represents an adjacency list based undirected graph
 * UndirectedGraph
 */
public class UndirectedGraph {

  /**
   * keeps track of the edge count
   */
  private int edgeCount = 0;

  /**
   * the adjacency list graph internal data structure
   */
  private final List<List<UndirectedWeightedEdge>> adjacencyList;

  /**
   * Constructs an undirected graph
   * @param nodeCount the nodes count
   */
  public UndirectedGraph(int nodeCount) {
    this.adjacencyList = IntStream
    .range(0, nodeCount)
    .mapToObj(_ -> (List<UndirectedWeightedEdge>)new ArrayList<UndirectedWeightedEdge>())
    .toList();
  }

  /**
   * Get the total weight of this graph, that is, the sum of the weights of the edges
   * @return the sum of the weighted edges
   */
  public final double weight() {
    return this
    .edges()
    .mapToDouble(UndirectedWeightedEdge::weight)
    .sum();
  }

  /**
   * Get the edge set of this graph
   * @return the edges
   */
  public final Stream<UndirectedWeightedEdge> edges() {
    List<UndirectedWeightedEdge> edges = new ArrayList<>();
    for(int v = 0; v < this.getNodeCount(); v++) {
      for(UndirectedWeightedEdge edge : this.adjacencyList.get(v)) {
        if(edge.other(v) > v) edges.add(edge);
      }
    }

    return edges.stream();
  }

  /**
   * Adds an undirected edge to the graph
   * @param edge the edge
   */
  public final void addEdge(UndirectedWeightedEdge edge) {
    int v = edge.either();
    this.adjacencyList.get(v).add(edge);
    this.adjacencyList.get(edge.other(v)).add(edge);
    this.edgeCount++;
  }

  /**
   * Get the node count
   * @return the node count
   */
  public final int getNodeCount() {
    return this.adjacencyList.size();
  }

  /**
   * Get the edge count
   * @return the edge count
   */
  public final int getEdgeCount() {
    return this.edgeCount;
  }

  /**
   * Computes the minimum spanning forest for this graph using Prim's algorithm
   * (eager version) taking O(|E| log |V|) worst case. 
   * @return the minimum spanning forest
   */
  public UndirectedGraph computeMinimumSpanningForest() {

    int V = this.getNodeCount();
    UndirectedWeightedEdge[] edgeTo = new UndirectedWeightedEdge[V];
    double[] distTo = new double[V];
    boolean[] marked = new boolean[V];
    IndexMinPriorityQueue<Double> queue = new IndexMinPriorityQueue<>(V);

    Arrays.fill(distTo, Double.POSITIVE_INFINITY);

    IntConsumer visit = vertex -> {
      marked[vertex] = true;
      for(UndirectedWeightedEdge edge : this.adjacencyList.get(vertex)) {
        int other = edge.other(vertex);
        if(marked[other]) continue;
        if(edge.weight() < distTo[other]) {
          distTo[other] = edge.weight();
          edgeTo[other] = edge;
          if(queue.contains(other)) {
            queue.decrease(other, distTo[other]);
          } else queue.insert(other, distTo[other]);
        }
      }
    };

    IntConsumer prim = root -> {
      distTo[root] = 0;
      queue.insert(root, distTo[root]);
      
      while(!queue.isEmpty()) {
        visit.accept(queue.extract());
      }
    };

    for(int v = 0; v < V; v++) {
      if(!marked[v]) prim.accept(v);
    }


    UndirectedGraph MSF = new UndirectedGraph(V);

    Arrays
    .stream(edgeTo)
    .filter(Objects::nonNull)
    .forEach(MSF::addEdge);
    
    return MSF;
  }

  /**
   * Converts this graph into an unformatted json string
   * @return the json string representation of the graph
   */
  public final String toJSONString() {
    return "{\"count\": %s, \"links\": %s}".formatted(
      this.getNodeCount(),
      this.adjacencyList
      .stream()
      .flatMap(List::stream)
      .map(UndirectedWeightedEdge::toJSONString)
      .toList()
      .toString()
    );
  }
}
