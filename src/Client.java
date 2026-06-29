import java.io.IOException;
import java.io.PrintStream;

import collections.UndirectedGraph;

public static void main(String[] args) {
  if(args.length < 1) {
    System.err.println("No input file.");
    return;
  }

  try (PrintStream output = new PrintStream("out.json")) {
    Network
    // Parse the file
    .loadFromFile(args[0])
    // And then convert to graph
    .map(Network::toGraph)
    // And then convert to minimum spanning tree
    .map(UndirectedGraph::computeMST)
    // And then convert to json string
    .map(UndirectedGraph::toJSONString)
    // And then print the output to a file
    .ifPresent(output::println);
  } catch(IOException e) {
    System.err.println(e.getMessage());
  }
}
