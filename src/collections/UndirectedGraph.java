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
public final class UndirectedGraph {

  /**
   * keeps track of the edge count
   */
  private int edgeCount = 0;

  /**
   * the adjacency list graph internal data structure
   */
  private final List<List<Edge>> adjacencyList;

  /**
   * Constructs an undirected graph
   * @param nodeCount the nodes count
   */
  public UndirectedGraph(int nodeCount) {
    this.adjacencyList = IntStream
    .range(0, nodeCount)
    .mapToObj(_ -> (List<Edge>)new ArrayList<Edge>())
    .toList();
  }

  /**
   * Get the total weight of this graph, that is, the sum of the weights of the edges
   * @return the sum of the weighted edges
   */
  public double weight() {
    return this
    .edges()
    .mapToDouble(Edge::weight)
    .sum();
  }

  /**
   * Get the edge set of this graph
   * @return the edges
   */
  public Stream<Edge> edges() {
    return this
    .adjacencyList
    .stream()
    .flatMap(List::stream)
    .filter(edge -> edge.from() < edge.to());
  }

  /**
   * Adds an undirected edge to the graph
   * @param edge the edge
   */
  public void addEdge(Edge edge) {
    this.adjacencyList.get(edge.from()).add(edge);
    this.adjacencyList.get(edge.to()).add(edge);
    this.edgeCount++;
  }

  /**
   * Get the node count
   * @return the node count
   */
  public int getNodeCount() {
    return this.adjacencyList.size();
  }

  /**
   * Get the edge count
   * @return the edge count
   */
  public int getEdgeCount() {
    return this.edgeCount;
  }

  /**
   * Get an undirected edge
   * @param from one vertex
   * @param to the other vertex
   */
  public Edge getEdge(int from, int to) {
    return this.adjacencyList.get(from).get(to);
  }

  /**
   * Computes the minimum spanning forest for this graph using Prim's algorithm
   * (eager version) taking O(|E| log |V|) worst case. 
   * @return the minimum spanning forest
   */
  public UndirectedGraph computeMinimumSpanningForest() {

    int V = this.getNodeCount();
    Edge[] edgeTo = new Edge[V];
    double[] distTo = new double[V];
    boolean[] marked = new boolean[V];
    IndexMinPriorityQueue<Double> queue = new IndexMinPriorityQueue<>(V);

    Arrays.fill(distTo, Double.POSITIVE_INFINITY);

    IntConsumer visit = vertex -> {
      marked[vertex] = true;
      for(Edge edge : this.adjacencyList.get(vertex)) {
        int other = edge.to();
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
  public String toJSONString() {
    return "{\"count\": %s, \"links\": %s}".formatted(
      this.getNodeCount(),
      this.adjacencyList
      .stream()
      .flatMap(List::stream)
      .map(Edge::toJSONString)
      .toList()
      .toString()
    );
  }
}
