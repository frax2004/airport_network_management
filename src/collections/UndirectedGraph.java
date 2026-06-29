package collections;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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
   * Computes the minimum spanning tree for this graph
   * @return the minimum spanning tree
   */
  public UndirectedGraph computeMST() {
    UndirectedGraph MST = new UndirectedGraph(this.adjacencyList.size());

    return MST;
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
