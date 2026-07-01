// Generated from c:/Users/franc/Desktop/Università/lab di alg/airport_network_management/src/NetScanner.g4 by ANTLR 4.13.1
package net;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class NetScanner extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INLINE_COMMENT=1, COMMENT=2, SPACE=3, DECLARE=4, ROUTE=5, FROM=6, TO=7, 
		AIRPORT=8, AT=9, COST=10, NUMBER=11, LEFT_PAREN=12, RIGHT_PAREN=13, SEMI=14, 
		COMMA=15, IDENTIFIER=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INLINE_COMMENT", "COMMENT", "SPACE", "DECLARE", "ROUTE", "FROM", "TO", 
			"AIRPORT", "AT", "COST", "NUMBER", "LEFT_PAREN", "RIGHT_PAREN", "SEMI", 
			"COMMA", "IDENTIFIER"
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


	public NetScanner(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "NetScanner.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0010\u0089\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0005\u0000&\b\u0000\n\u0000\f\u0000)\t\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u00011\b\u0001"+
		"\n\u0001\f\u00014\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0003\nf\b"+
		"\n\u0001\n\u0001\n\u0001\n\u0005\nk\b\n\n\n\f\nn\t\n\u0003\np\b\n\u0001"+
		"\n\u0001\n\u0004\nt\b\n\u000b\n\f\nu\u0003\nx\b\n\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0000\u0000\u0010\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004"+
		"\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017"+
		"\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010\u0001\u0000\u0006\u0002"+
		"\u0000\n\n\r\r\u0003\u0000\n\n\r\r..\u0003\u0000\t\n\r\r  \u0001\u0000"+
		"19\u0001\u000009\u0001\u0000AZ\u008f\u0000\u0001\u0001\u0000\u0000\u0000"+
		"\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000"+
		"\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000"+
		"\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f"+
		"\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013"+
		"\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017"+
		"\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b"+
		"\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f"+
		"\u0001\u0000\u0000\u0000\u0001!\u0001\u0000\u0000\u0000\u0003,\u0001\u0000"+
		"\u0000\u0000\u0005:\u0001\u0000\u0000\u0000\u0007>\u0001\u0000\u0000\u0000"+
		"\tF\u0001\u0000\u0000\u0000\u000bL\u0001\u0000\u0000\u0000\rQ\u0001\u0000"+
		"\u0000\u0000\u000fT\u0001\u0000\u0000\u0000\u0011\\\u0001\u0000\u0000"+
		"\u0000\u0013_\u0001\u0000\u0000\u0000\u0015e\u0001\u0000\u0000\u0000\u0017"+
		"y\u0001\u0000\u0000\u0000\u0019{\u0001\u0000\u0000\u0000\u001b}\u0001"+
		"\u0000\u0000\u0000\u001d\u007f\u0001\u0000\u0000\u0000\u001f\u0081\u0001"+
		"\u0000\u0000\u0000!\"\u0005/\u0000\u0000\"#\u0005/\u0000\u0000#\'\u0001"+
		"\u0000\u0000\u0000$&\b\u0000\u0000\u0000%$\u0001\u0000\u0000\u0000&)\u0001"+
		"\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000"+
		"(*\u0001\u0000\u0000\u0000)\'\u0001\u0000\u0000\u0000*+\u0006\u0000\u0000"+
		"\u0000+\u0002\u0001\u0000\u0000\u0000,-\u0005/\u0000\u0000-.\u0005*\u0000"+
		"\u0000.2\u0001\u0000\u0000\u0000/1\u0007\u0001\u0000\u00000/\u0001\u0000"+
		"\u0000\u000014\u0001\u0000\u0000\u000020\u0001\u0000\u0000\u000023\u0001"+
		"\u0000\u0000\u000035\u0001\u0000\u0000\u000042\u0001\u0000\u0000\u0000"+
		"56\u0005*\u0000\u000067\u0005/\u0000\u000078\u0001\u0000\u0000\u00008"+
		"9\u0006\u0001\u0000\u00009\u0004\u0001\u0000\u0000\u0000:;\u0007\u0002"+
		"\u0000\u0000;<\u0001\u0000\u0000\u0000<=\u0006\u0002\u0000\u0000=\u0006"+
		"\u0001\u0000\u0000\u0000>?\u0005d\u0000\u0000?@\u0005e\u0000\u0000@A\u0005"+
		"c\u0000\u0000AB\u0005l\u0000\u0000BC\u0005a\u0000\u0000CD\u0005r\u0000"+
		"\u0000DE\u0005e\u0000\u0000E\b\u0001\u0000\u0000\u0000FG\u0005r\u0000"+
		"\u0000GH\u0005o\u0000\u0000HI\u0005u\u0000\u0000IJ\u0005t\u0000\u0000"+
		"JK\u0005e\u0000\u0000K\n\u0001\u0000\u0000\u0000LM\u0005f\u0000\u0000"+
		"MN\u0005r\u0000\u0000NO\u0005o\u0000\u0000OP\u0005m\u0000\u0000P\f\u0001"+
		"\u0000\u0000\u0000QR\u0005t\u0000\u0000RS\u0005o\u0000\u0000S\u000e\u0001"+
		"\u0000\u0000\u0000TU\u0005a\u0000\u0000UV\u0005i\u0000\u0000VW\u0005r"+
		"\u0000\u0000WX\u0005p\u0000\u0000XY\u0005o\u0000\u0000YZ\u0005r\u0000"+
		"\u0000Z[\u0005t\u0000\u0000[\u0010\u0001\u0000\u0000\u0000\\]\u0005a\u0000"+
		"\u0000]^\u0005t\u0000\u0000^\u0012\u0001\u0000\u0000\u0000_`\u0005c\u0000"+
		"\u0000`a\u0005o\u0000\u0000ab\u0005s\u0000\u0000bc\u0005t\u0000\u0000"+
		"c\u0014\u0001\u0000\u0000\u0000df\u0005-\u0000\u0000ed\u0001\u0000\u0000"+
		"\u0000ef\u0001\u0000\u0000\u0000fo\u0001\u0000\u0000\u0000gp\u00050\u0000"+
		"\u0000hl\u0007\u0003\u0000\u0000ik\u0007\u0004\u0000\u0000ji\u0001\u0000"+
		"\u0000\u0000kn\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000lm\u0001"+
		"\u0000\u0000\u0000mp\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000"+
		"og\u0001\u0000\u0000\u0000oh\u0001\u0000\u0000\u0000pw\u0001\u0000\u0000"+
		"\u0000qs\u0005.\u0000\u0000rt\u0007\u0004\u0000\u0000sr\u0001\u0000\u0000"+
		"\u0000tu\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000uv\u0001\u0000"+
		"\u0000\u0000vx\u0001\u0000\u0000\u0000wq\u0001\u0000\u0000\u0000wx\u0001"+
		"\u0000\u0000\u0000x\u0016\u0001\u0000\u0000\u0000yz\u0005(\u0000\u0000"+
		"z\u0018\u0001\u0000\u0000\u0000{|\u0005)\u0000\u0000|\u001a\u0001\u0000"+
		"\u0000\u0000}~\u0005;\u0000\u0000~\u001c\u0001\u0000\u0000\u0000\u007f"+
		"\u0080\u0005,\u0000\u0000\u0080\u001e\u0001\u0000\u0000\u0000\u0081\u0082"+
		"\u0007\u0005\u0000\u0000\u0082\u0083\u0007\u0005\u0000\u0000\u0083\u0084"+
		"\u0007\u0005\u0000\u0000\u0084\u0085\u0005-\u0000\u0000\u0085\u0086\u0007"+
		"\u0004\u0000\u0000\u0086\u0087\u0007\u0004\u0000\u0000\u0087\u0088\u0007"+
		"\u0004\u0000\u0000\u0088 \u0001\u0000\u0000\u0000\b\u0000\'2elouw\u0001"+
		"\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}