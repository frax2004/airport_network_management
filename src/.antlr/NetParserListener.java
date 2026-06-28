// Generated from c:/Users/franc/Desktop/Università/lab di alg/airport_network_management/src/NetParser.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NetParser}.
 */
public interface NetParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NetParser#network}.
	 * @param ctx the parse tree
	 */
	void enterNetwork(NetParser.NetworkContext ctx);
	/**
	 * Exit a parse tree produced by {@link NetParser#network}.
	 * @param ctx the parse tree
	 */
	void exitNetwork(NetParser.NetworkContext ctx);
	/**
	 * Enter a parse tree produced by {@link NetParser#airportStatement}.
	 * @param ctx the parse tree
	 */
	void enterAirportStatement(NetParser.AirportStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link NetParser#airportStatement}.
	 * @param ctx the parse tree
	 */
	void exitAirportStatement(NetParser.AirportStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link NetParser#routeStatement}.
	 * @param ctx the parse tree
	 */
	void enterRouteStatement(NetParser.RouteStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link NetParser#routeStatement}.
	 * @param ctx the parse tree
	 */
	void exitRouteStatement(NetParser.RouteStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link NetParser#territory}.
	 * @param ctx the parse tree
	 */
	void enterTerritory(NetParser.TerritoryContext ctx);
	/**
	 * Exit a parse tree produced by {@link NetParser#territory}.
	 * @param ctx the parse tree
	 */
	void exitTerritory(NetParser.TerritoryContext ctx);
}