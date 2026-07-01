
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.tree.ParseTree;

import net.NetParser;
import net.NetParserBaseVisitor;

public final class NetworkBuilder extends NetParserBaseVisitor<Object> {

  private final Map<String, Airport> airports = new HashMap<>();
  private final List<Route> routes = new ArrayList<>();
  private final ParseTree parseTree;

  public NetworkBuilder(ParseTree tree) {
    this.parseTree = tree;
  }

  @Override 
  public Object visitAirportStatement(NetParser.AirportStatementContext ctx) {
    String id = ctx.airport_id.getText();
    double x = Double.parseDouble(ctx.x.getText());
    double y = Double.parseDouble(ctx.y.getText());
    double z = Double.parseDouble(ctx.z.getText());

    boolean ok = true;
    if(airports.containsKey(id)) {
      ok = false;
      System.err.printf("Redeclaration of airport \"%s\".\n", id);
    }

    if(ok) {
      this.airports.put(id, new Airport(id, x, y, z));
    }

    return null;
  }

  @Override 
  public Object visitRouteStatement(NetParser.RouteStatementContext ctx) {
    String src_id = ctx.src_id.getText();
    String dst_id = ctx.dst_id.getText();
    double weight = Double.parseDouble(ctx.cost.getText());
  
    boolean ok = true;
    Airport src = this.airports.getOrDefault(src_id, null);
    if(src == null) {
      ok = false;
      System.err.printf("In route declaration, no matching source airport with code \"%s\"\n", src_id);
    }

    Airport dst = this.airports.getOrDefault(dst_id, null);
    if(dst == null) {
      ok = false;
      System.err.printf("In route declaration, no matching destination airport with code \"%s\"\n", src_id);
    }

    if(ok) this.routes.add(new Route(src, dst, weight));

    return null;
  }

  public Network build() {
    this.visit(this.parseTree);
    return new Network(this.airports.values(), this.routes);
  }
}

