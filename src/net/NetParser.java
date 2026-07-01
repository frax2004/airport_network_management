// Generated from c:/Users/franc/Desktop/Università/lab di alg/airport_network_management/src/NetParser.g4 by ANTLR 4.13.1
package net;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class NetParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INLINE_COMMENT=1, COMMENT=2, SPACE=3, DECLARE=4, ROUTE=5, FROM=6, TO=7, 
		AIRPORT=8, AT=9, COST=10, NUMBER=11, LEFT_PAREN=12, RIGHT_PAREN=13, SEMI=14, 
		COMMA=15, IDENTIFIER=16;
	public static final int
		RULE_network = 0, RULE_airportStatement = 1, RULE_routeStatement = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"network", "airportStatement", "routeStatement"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'declare'", "'route'", "'from'", "'to'", "'airport'", 
			"'at'", "'cost'", null, "'('", "')'", "';'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INLINE_COMMENT", "COMMENT", "SPACE", "DECLARE", "ROUTE", "FROM", 
			"TO", "AIRPORT", "AT", "COST", "NUMBER", "LEFT_PAREN", "RIGHT_PAREN", 
			"SEMI", "COMMA", "IDENTIFIER"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "NetParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public NetParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NetworkContext extends ParserRuleContext {
		public List<AirportStatementContext> airportStatement() {
			return getRuleContexts(AirportStatementContext.class);
		}
		public AirportStatementContext airportStatement(int i) {
			return getRuleContext(AirportStatementContext.class,i);
		}
		public List<RouteStatementContext> routeStatement() {
			return getRuleContexts(RouteStatementContext.class);
		}
		public RouteStatementContext routeStatement(int i) {
			return getRuleContext(RouteStatementContext.class,i);
		}
		public NetworkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_network; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NetParserListener ) ((NetParserListener)listener).enterNetwork(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NetParserListener ) ((NetParserListener)listener).exitNetwork(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NetParserVisitor ) return ((NetParserVisitor<? extends T>)visitor).visitNetwork(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NetworkContext network() throws RecognitionException {
		NetworkContext _localctx = new NetworkContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_network);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(7); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(6);
					airportStatement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(9); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(12); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(11);
				routeStatement();
				}
				}
				setState(14); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DECLARE );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AirportStatementContext extends ParserRuleContext {
		public Token airport_id;
		public Token x;
		public Token y;
		public Token z;
		public TerminalNode DECLARE() { return getToken(NetParser.DECLARE, 0); }
		public TerminalNode AIRPORT() { return getToken(NetParser.AIRPORT, 0); }
		public TerminalNode AT() { return getToken(NetParser.AT, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(NetParser.LEFT_PAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(NetParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(NetParser.COMMA, i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(NetParser.RIGHT_PAREN, 0); }
		public TerminalNode SEMI() { return getToken(NetParser.SEMI, 0); }
		public TerminalNode IDENTIFIER() { return getToken(NetParser.IDENTIFIER, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(NetParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(NetParser.NUMBER, i);
		}
		public AirportStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_airportStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NetParserListener ) ((NetParserListener)listener).enterAirportStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NetParserListener ) ((NetParserListener)listener).exitAirportStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NetParserVisitor ) return ((NetParserVisitor<? extends T>)visitor).visitAirportStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AirportStatementContext airportStatement() throws RecognitionException {
		AirportStatementContext _localctx = new AirportStatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_airportStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			match(DECLARE);
			setState(17);
			match(AIRPORT);
			setState(18);
			((AirportStatementContext)_localctx).airport_id = match(IDENTIFIER);
			setState(19);
			match(AT);
			setState(20);
			match(LEFT_PAREN);
			setState(21);
			((AirportStatementContext)_localctx).x = match(NUMBER);
			setState(22);
			match(COMMA);
			setState(23);
			((AirportStatementContext)_localctx).y = match(NUMBER);
			setState(24);
			match(COMMA);
			setState(25);
			((AirportStatementContext)_localctx).z = match(NUMBER);
			setState(26);
			match(RIGHT_PAREN);
			setState(27);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RouteStatementContext extends ParserRuleContext {
		public Token src_id;
		public Token dst_id;
		public Token cost;
		public TerminalNode DECLARE() { return getToken(NetParser.DECLARE, 0); }
		public TerminalNode ROUTE() { return getToken(NetParser.ROUTE, 0); }
		public TerminalNode FROM() { return getToken(NetParser.FROM, 0); }
		public TerminalNode TO() { return getToken(NetParser.TO, 0); }
		public TerminalNode COST() { return getToken(NetParser.COST, 0); }
		public TerminalNode SEMI() { return getToken(NetParser.SEMI, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(NetParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(NetParser.IDENTIFIER, i);
		}
		public TerminalNode NUMBER() { return getToken(NetParser.NUMBER, 0); }
		public RouteStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_routeStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NetParserListener ) ((NetParserListener)listener).enterRouteStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NetParserListener ) ((NetParserListener)listener).exitRouteStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NetParserVisitor ) return ((NetParserVisitor<? extends T>)visitor).visitRouteStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RouteStatementContext routeStatement() throws RecognitionException {
		RouteStatementContext _localctx = new RouteStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_routeStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			match(DECLARE);
			setState(30);
			match(ROUTE);
			setState(31);
			match(FROM);
			setState(32);
			((RouteStatementContext)_localctx).src_id = match(IDENTIFIER);
			setState(33);
			match(TO);
			setState(34);
			((RouteStatementContext)_localctx).dst_id = match(IDENTIFIER);
			setState(35);
			match(COST);
			setState(36);
			((RouteStatementContext)_localctx).cost = match(NUMBER);
			setState(37);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0010(\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0001\u0000\u0004\u0000\b\b\u0000\u000b\u0000\f\u0000"+
		"\t\u0001\u0000\u0004\u0000\r\b\u0000\u000b\u0000\f\u0000\u000e\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0000\u0000"+
		"\u0003\u0000\u0002\u0004\u0000\u0000&\u0000\u0007\u0001\u0000\u0000\u0000"+
		"\u0002\u0010\u0001\u0000\u0000\u0000\u0004\u001d\u0001\u0000\u0000\u0000"+
		"\u0006\b\u0003\u0002\u0001\u0000\u0007\u0006\u0001\u0000\u0000\u0000\b"+
		"\t\u0001\u0000\u0000\u0000\t\u0007\u0001\u0000\u0000\u0000\t\n\u0001\u0000"+
		"\u0000\u0000\n\f\u0001\u0000\u0000\u0000\u000b\r\u0003\u0004\u0002\u0000"+
		"\f\u000b\u0001\u0000\u0000\u0000\r\u000e\u0001\u0000\u0000\u0000\u000e"+
		"\f\u0001\u0000\u0000\u0000\u000e\u000f\u0001\u0000\u0000\u0000\u000f\u0001"+
		"\u0001\u0000\u0000\u0000\u0010\u0011\u0005\u0004\u0000\u0000\u0011\u0012"+
		"\u0005\b\u0000\u0000\u0012\u0013\u0005\u0010\u0000\u0000\u0013\u0014\u0005"+
		"\t\u0000\u0000\u0014\u0015\u0005\f\u0000\u0000\u0015\u0016\u0005\u000b"+
		"\u0000\u0000\u0016\u0017\u0005\u000f\u0000\u0000\u0017\u0018\u0005\u000b"+
		"\u0000\u0000\u0018\u0019\u0005\u000f\u0000\u0000\u0019\u001a\u0005\u000b"+
		"\u0000\u0000\u001a\u001b\u0005\r\u0000\u0000\u001b\u001c\u0005\u000e\u0000"+
		"\u0000\u001c\u0003\u0001\u0000\u0000\u0000\u001d\u001e\u0005\u0004\u0000"+
		"\u0000\u001e\u001f\u0005\u0005\u0000\u0000\u001f \u0005\u0006\u0000\u0000"+
		" !\u0005\u0010\u0000\u0000!\"\u0005\u0007\u0000\u0000\"#\u0005\u0010\u0000"+
		"\u0000#$\u0005\n\u0000\u0000$%\u0005\u000b\u0000\u0000%&\u0005\u000e\u0000"+
		"\u0000&\u0005\u0001\u0000\u0000\u0000\u0002\t\u000e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}