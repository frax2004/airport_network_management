// Generated from c:/Dev/uni/algo/airport_network_management/src/NetParser.g4 by ANTLR 4.13.1
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
		THROUGH=8, AIRPORT=9, AT=10, COST=11, MOUNTAIN=12, PLAIN=13, SEA=14, RIVER=15, 
		DESERT=16, NUMBER=17, LEFT_PAREN=18, RIGHT_PAREN=19, LEFT_SQUARE=20, RIGHT_SQUARE=21, 
		SEMI=22, COMMA=23, IDENTIFIER=24;
	public static final int
		RULE_network = 0, RULE_airportStatement = 1, RULE_routeStatement = 2, 
		RULE_territory = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"network", "airportStatement", "routeStatement", "territory"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'declare'", "'route'", "'from'", "'to'", "'through'", 
			"'airport'", "'at'", "'cost'", "'mountain'", "'plain'", "'sea'", "'river'", 
			"'desert'", null, "'('", "')'", "'['", "']'", "';'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INLINE_COMMENT", "COMMENT", "SPACE", "DECLARE", "ROUTE", "FROM", 
			"TO", "THROUGH", "AIRPORT", "AT", "COST", "MOUNTAIN", "PLAIN", "SEA", 
			"RIVER", "DESERT", "NUMBER", "LEFT_PAREN", "RIGHT_PAREN", "LEFT_SQUARE", 
			"RIGHT_SQUARE", "SEMI", "COMMA", "IDENTIFIER"
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
			setState(9); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(8);
					airportStatement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(11); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(14); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(13);
				routeStatement();
				}
				}
				setState(16); 
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
			setState(18);
			match(DECLARE);
			setState(19);
			match(AIRPORT);
			setState(20);
			((AirportStatementContext)_localctx).airport_id = match(IDENTIFIER);
			setState(21);
			match(AT);
			setState(22);
			match(LEFT_PAREN);
			setState(23);
			((AirportStatementContext)_localctx).x = match(NUMBER);
			setState(24);
			match(COMMA);
			setState(25);
			((AirportStatementContext)_localctx).y = match(NUMBER);
			setState(26);
			match(COMMA);
			setState(27);
			((AirportStatementContext)_localctx).z = match(NUMBER);
			setState(28);
			match(RIGHT_PAREN);
			setState(29);
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
		public TerritoryContext territory;
		public List<TerritoryContext> territories = new ArrayList<TerritoryContext>();
		public Token cost;
		public TerminalNode DECLARE() { return getToken(NetParser.DECLARE, 0); }
		public TerminalNode ROUTE() { return getToken(NetParser.ROUTE, 0); }
		public TerminalNode FROM() { return getToken(NetParser.FROM, 0); }
		public TerminalNode TO() { return getToken(NetParser.TO, 0); }
		public TerminalNode THROUGH() { return getToken(NetParser.THROUGH, 0); }
		public TerminalNode LEFT_SQUARE() { return getToken(NetParser.LEFT_SQUARE, 0); }
		public TerminalNode RIGHT_SQUARE() { return getToken(NetParser.RIGHT_SQUARE, 0); }
		public TerminalNode COST() { return getToken(NetParser.COST, 0); }
		public TerminalNode SEMI() { return getToken(NetParser.SEMI, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(NetParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(NetParser.IDENTIFIER, i);
		}
		public List<TerritoryContext> territory() {
			return getRuleContexts(TerritoryContext.class);
		}
		public TerritoryContext territory(int i) {
			return getRuleContext(TerritoryContext.class,i);
		}
		public TerminalNode NUMBER() { return getToken(NetParser.NUMBER, 0); }
		public List<TerminalNode> COMMA() { return getTokens(NetParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(NetParser.COMMA, i);
		}
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			match(DECLARE);
			setState(32);
			match(ROUTE);
			setState(33);
			match(FROM);
			setState(34);
			((RouteStatementContext)_localctx).src_id = match(IDENTIFIER);
			setState(35);
			match(TO);
			setState(36);
			((RouteStatementContext)_localctx).dst_id = match(IDENTIFIER);
			setState(37);
			match(THROUGH);
			setState(38);
			match(LEFT_SQUARE);
			setState(39);
			((RouteStatementContext)_localctx).territory = territory();
			((RouteStatementContext)_localctx).territories.add(((RouteStatementContext)_localctx).territory);
			setState(44);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(40);
					match(COMMA);
					setState(41);
					((RouteStatementContext)_localctx).territory = territory();
					((RouteStatementContext)_localctx).territories.add(((RouteStatementContext)_localctx).territory);
					}
					} 
				}
				setState(46);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(47);
			match(RIGHT_SQUARE);
			setState(48);
			match(COST);
			setState(49);
			((RouteStatementContext)_localctx).cost = match(NUMBER);
			setState(50);
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
	public static class TerritoryContext extends ParserRuleContext {
		public TerminalNode MOUNTAIN() { return getToken(NetParser.MOUNTAIN, 0); }
		public TerminalNode PLAIN() { return getToken(NetParser.PLAIN, 0); }
		public TerminalNode SEA() { return getToken(NetParser.SEA, 0); }
		public TerminalNode RIVER() { return getToken(NetParser.RIVER, 0); }
		public TerminalNode DESERT() { return getToken(NetParser.DESERT, 0); }
		public TerritoryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_territory; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NetParserListener ) ((NetParserListener)listener).enterTerritory(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NetParserListener ) ((NetParserListener)listener).exitTerritory(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NetParserVisitor ) return ((NetParserVisitor<? extends T>)visitor).visitTerritory(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TerritoryContext territory() throws RecognitionException {
		TerritoryContext _localctx = new TerritoryContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_territory);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 126976L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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
		"\u0004\u0001\u00187\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0001\u0000\u0004\u0000\n\b"+
		"\u0000\u000b\u0000\f\u0000\u000b\u0001\u0000\u0004\u0000\u000f\b\u0000"+
		"\u000b\u0000\f\u0000\u0010\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0005\u0002+\b\u0002\n\u0002\f\u0002.\t\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001,\u0000\u0004\u0000\u0002\u0004\u0006\u0000"+
		"\u0001\u0001\u0000\f\u00105\u0000\t\u0001\u0000\u0000\u0000\u0002\u0012"+
		"\u0001\u0000\u0000\u0000\u0004\u001f\u0001\u0000\u0000\u0000\u00064\u0001"+
		"\u0000\u0000\u0000\b\n\u0003\u0002\u0001\u0000\t\b\u0001\u0000\u0000\u0000"+
		"\n\u000b\u0001\u0000\u0000\u0000\u000b\t\u0001\u0000\u0000\u0000\u000b"+
		"\f\u0001\u0000\u0000\u0000\f\u000e\u0001\u0000\u0000\u0000\r\u000f\u0003"+
		"\u0004\u0002\u0000\u000e\r\u0001\u0000\u0000\u0000\u000f\u0010\u0001\u0000"+
		"\u0000\u0000\u0010\u000e\u0001\u0000\u0000\u0000\u0010\u0011\u0001\u0000"+
		"\u0000\u0000\u0011\u0001\u0001\u0000\u0000\u0000\u0012\u0013\u0005\u0004"+
		"\u0000\u0000\u0013\u0014\u0005\t\u0000\u0000\u0014\u0015\u0005\u0018\u0000"+
		"\u0000\u0015\u0016\u0005\n\u0000\u0000\u0016\u0017\u0005\u0012\u0000\u0000"+
		"\u0017\u0018\u0005\u0011\u0000\u0000\u0018\u0019\u0005\u0017\u0000\u0000"+
		"\u0019\u001a\u0005\u0011\u0000\u0000\u001a\u001b\u0005\u0017\u0000\u0000"+
		"\u001b\u001c\u0005\u0011\u0000\u0000\u001c\u001d\u0005\u0013\u0000\u0000"+
		"\u001d\u001e\u0005\u0016\u0000\u0000\u001e\u0003\u0001\u0000\u0000\u0000"+
		"\u001f \u0005\u0004\u0000\u0000 !\u0005\u0005\u0000\u0000!\"\u0005\u0006"+
		"\u0000\u0000\"#\u0005\u0018\u0000\u0000#$\u0005\u0007\u0000\u0000$%\u0005"+
		"\u0018\u0000\u0000%&\u0005\b\u0000\u0000&\'\u0005\u0014\u0000\u0000\'"+
		",\u0003\u0006\u0003\u0000()\u0005\u0017\u0000\u0000)+\u0003\u0006\u0003"+
		"\u0000*(\u0001\u0000\u0000\u0000+.\u0001\u0000\u0000\u0000,-\u0001\u0000"+
		"\u0000\u0000,*\u0001\u0000\u0000\u0000-/\u0001\u0000\u0000\u0000.,\u0001"+
		"\u0000\u0000\u0000/0\u0005\u0015\u0000\u000001\u0005\u000b\u0000\u0000"+
		"12\u0005\u0011\u0000\u000023\u0005\u0016\u0000\u00003\u0005\u0001\u0000"+
		"\u0000\u000045\u0007\u0000\u0000\u00005\u0007\u0001\u0000\u0000\u0000"+
		"\u0003\u000b\u0010,";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}