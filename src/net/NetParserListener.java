// Generated from c:/Users/franc/Desktop/Università/lab di alg/airport_network_management/src/NetParser.g4 by ANTLR 4.13.1
package net;
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
}