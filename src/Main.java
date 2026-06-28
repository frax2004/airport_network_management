import java.io.IOException;
import java.io.PrintStream;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import net.NetParser;
import net.NetScanner;


public class Main {
  public static void main(String[] args) {
    if(args.length < 1) {
      System.err.println("No input file.");
      return;
    }

    Network network = null;
    try {
      network = parse(args[0]);
    } catch(Exception e) {
      System.err.println(e.getMessage());
      return;
    }

    UndirectedGraph G = network.toGraph();
    UndirectedGraph MST = G.computeMST();

    try (PrintStream output = new PrintStream("out.json")) {
      output.println(G.toJSONString());
    } catch(IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static Network parse(String path) throws IOException {
    CharStream istream = CharStreams.fromFileName(path);
    NetScanner scanner = new NetScanner(istream);
    CommonTokenStream tokens = new CommonTokenStream(scanner);
    NetParser parser = new NetParser(tokens);
    ParseTree tree = parser.network();

    return new NetworkBuilder(tree).build();
  }
}
