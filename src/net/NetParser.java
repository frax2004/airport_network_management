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
		THROUGH=8, AIRPORT=9, AT=10, COST=11, MOUNTAIN=12, PLAIN=13, SEA=14, RIVER=15, 
		DESERT=16, NUMBER=17, LEFT_PAREN=18, RIGHT_PAREN=19, LEFT_SQUARE=20, RIGHT_SQUARE=21, 
		SEMI=22, COMMA=23, IDENTIFIER=24;
	public static final int
		RULE_network = 0;
	private static String[] makeRuleNames() {
		return new String[] {
			"network"
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
		try {
			enterOuterAlt(_localctx, 1);
			{
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
		"\u0004\u0001\u0018\u0005\u0002\u0000\u0007\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0000\u0000\u0001\u0000\u0000\u0000\u0003\u0000\u0002\u0001"+
		"\u0000\u0000\u0000\u0002\u0003\u0001\u0000\u0000\u0000\u0003\u0001\u0001"+
		"\u0000\u0000\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}