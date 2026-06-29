import java.io.IOException;
import java.io.PrintStream;

import collections.UndirectedGraph;

public class Main {
  public static void main(String[] args) {
    if(args.length < 1) {
      System.err.println("No input file.");
      return;
    }

    try (PrintStream output = new PrintStream("out.json")) {
      Network
      .loadFromFile(args[0])
      .map(Network::toGraph)
      .map(UndirectedGraph::computeMST)
      .map(UndirectedGraph::toJSONString)
      .ifPresent(output::println);
    } catch(IOException e) {
      System.err.println(e.getMessage());
    }
  }
}
