// Generated from grammar/MiniLangLexer.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiniLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PROGRAM=1, INTEGER=2, BOOLEAN=3, BEGIN=4, END=5, WHILE=6, DO=7, READ=8, 
		VAR=9, FALSE=10, TRUE=11, WRITE=12, STRING=13, IF=14, THEN=15, ELSE=16, 
		COMENTARIO=17, OPAD=18, OPMULT=19, OPREL=20, OPLOG=21, OPNEG=22, PVIG=23, 
		PONTO=24, ATRIB=25, DPONTOS=26, VIG=27, ABPAR=28, FPAR=29, ABCHA=30, FCHA=31, 
		CADEIA=32, ID=33, CTE=34, EB=35, ERRO=36;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PROGRAM", "INTEGER", "BOOLEAN", "BEGIN", "END", "WHILE", "DO", "READ", 
			"VAR", "FALSE", "TRUE", "WRITE", "STRING", "IF", "THEN", "ELSE", "COMENTARIO", 
			"OPAD", "OPMULT", "OPREL", "OPLOG", "OPNEG", "PVIG", "PONTO", "ATRIB", 
			"DPONTOS", "VIG", "ABPAR", "FPAR", "ABCHA", "FCHA", "CADEIA", "ID", "CTE", 
			"EB", "ERRO"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "'~'", "';'", 
			"'.'", "':='", "':'", "','", "'('", "')'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PROGRAM", "INTEGER", "BOOLEAN", "BEGIN", "END", "WHILE", "DO", 
			"READ", "VAR", "FALSE", "TRUE", "WRITE", "STRING", "IF", "THEN", "ELSE", 
			"COMENTARIO", "OPAD", "OPMULT", "OPREL", "OPLOG", "OPNEG", "PVIG", "PONTO", 
			"ATRIB", "DPONTOS", "VIG", "ABPAR", "FPAR", "ABCHA", "FCHA", "CADEIA", 
			"ID", "CTE", "EB", "ERRO"
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



	    private void erroLexico() {
	        throw new RuntimeException(
	            "Erro Léxico! Linha "
	            + getLine()
	            + ": "
	            + getText()
	        );
	    }


	public MiniLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MiniLangLexer.g4"; }

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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 32:
			ID_action((RuleContext)_localctx, actionIndex);
			break;
		case 33:
			CTE_action((RuleContext)_localctx, actionIndex);
			break;
		case 35:
			ERRO_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void ID_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:

			          if (getText().length() > 16) {
			            setText(getText().substring(0, 16));
			          }
			      
			break;
		}
	}
	private void CTE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:

			        try {
			            int valor = Integer.parseInt(getText());

			            if (valor > 32767) {
			                throw new RuntimeException(
			                    "Erro! Linha " + getLine()
			                    + ": Valor inteiro acima do limite máximo de 2 bytes : "
			                    + getText()
			                );
			            }
			        }
			        catch (NumberFormatException e) {
			            throw new RuntimeException(
			                "Erro! Linha " + getLine()
			                + ": Valor inteiro acima do limite máximo de 2 bytes : "
			                + getText()
			            );
			        }
			    
			break;
		}
	}
	private void ERRO_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			 erroLexico(); 
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2&\u0100\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3"+
		"\22\3\22\3\22\7\22\u00a9\n\22\f\22\16\22\u00ac\13\22\3\22\3\22\3\23\3"+
		"\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00bd"+
		"\n\25\3\26\3\26\3\26\3\26\3\26\5\26\u00c4\n\26\3\27\3\27\3\30\3\30\3\31"+
		"\3\31\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37"+
		"\3 \3 \3!\3!\7!\u00dd\n!\f!\16!\u00e0\13!\3!\3!\3\"\3\"\7\"\u00e6\n\""+
		"\f\"\16\"\u00e9\13\"\3\"\3\"\3#\5#\u00ee\n#\3#\6#\u00f1\n#\r#\16#\u00f2"+
		"\3#\3#\3$\6$\u00f8\n$\r$\16$\u00f9\3$\3$\3%\3%\3%\2\2&\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24"+
		"\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&\3"+
		"\2\36\4\2RRrr\4\2TTtt\4\2QQqq\4\2IIii\4\2CCcc\4\2OOoo\4\2KKkk\4\2PPpp"+
		"\4\2VVvv\4\2GGgg\4\2DDdd\4\2NNnn\4\2FFff\4\2YYyy\4\2JJjj\4\2XXxx\4\2H"+
		"Hhh\4\2UUuu\4\2WWww\4\2\f\f\17\17\4\2--//\4\2,,\61\61\4\2>>@@\5\2\f\f"+
		"\17\17$$\4\2C\\c|\5\2\62;C\\c|\3\2\62;\5\2\13\f\17\17\"\"\2\u010a\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2"+
		"\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2"+
		"\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2"+
		"I\3\2\2\2\3K\3\2\2\2\5S\3\2\2\2\7[\3\2\2\2\tc\3\2\2\2\13i\3\2\2\2\rm\3"+
		"\2\2\2\17s\3\2\2\2\21v\3\2\2\2\23{\3\2\2\2\25\177\3\2\2\2\27\u0085\3\2"+
		"\2\2\31\u008a\3\2\2\2\33\u0090\3\2\2\2\35\u0097\3\2\2\2\37\u009a\3\2\2"+
		"\2!\u009f\3\2\2\2#\u00a4\3\2\2\2%\u00af\3\2\2\2\'\u00b1\3\2\2\2)\u00bc"+
		"\3\2\2\2+\u00c3\3\2\2\2-\u00c5\3\2\2\2/\u00c7\3\2\2\2\61\u00c9\3\2\2\2"+
		"\63\u00cb\3\2\2\2\65\u00ce\3\2\2\2\67\u00d0\3\2\2\29\u00d2\3\2\2\2;\u00d4"+
		"\3\2\2\2=\u00d6\3\2\2\2?\u00d8\3\2\2\2A\u00da\3\2\2\2C\u00e3\3\2\2\2E"+
		"\u00ed\3\2\2\2G\u00f7\3\2\2\2I\u00fd\3\2\2\2KL\t\2\2\2LM\t\3\2\2MN\t\4"+
		"\2\2NO\t\5\2\2OP\t\3\2\2PQ\t\6\2\2QR\t\7\2\2R\4\3\2\2\2ST\t\b\2\2TU\t"+
		"\t\2\2UV\t\n\2\2VW\t\13\2\2WX\t\5\2\2XY\t\13\2\2YZ\t\3\2\2Z\6\3\2\2\2"+
		"[\\\t\f\2\2\\]\t\4\2\2]^\t\4\2\2^_\t\r\2\2_`\t\13\2\2`a\t\6\2\2ab\t\t"+
		"\2\2b\b\3\2\2\2cd\t\f\2\2de\t\13\2\2ef\t\5\2\2fg\t\b\2\2gh\t\t\2\2h\n"+
		"\3\2\2\2ij\t\13\2\2jk\t\t\2\2kl\t\16\2\2l\f\3\2\2\2mn\t\17\2\2no\t\20"+
		"\2\2op\t\b\2\2pq\t\r\2\2qr\t\13\2\2r\16\3\2\2\2st\t\16\2\2tu\t\4\2\2u"+
		"\20\3\2\2\2vw\t\3\2\2wx\t\13\2\2xy\t\6\2\2yz\t\16\2\2z\22\3\2\2\2{|\t"+
		"\21\2\2|}\t\6\2\2}~\t\3\2\2~\24\3\2\2\2\177\u0080\t\22\2\2\u0080\u0081"+
		"\t\6\2\2\u0081\u0082\t\r\2\2\u0082\u0083\t\23\2\2\u0083\u0084\t\13\2\2"+
		"\u0084\26\3\2\2\2\u0085\u0086\t\n\2\2\u0086\u0087\t\3\2\2\u0087\u0088"+
		"\t\24\2\2\u0088\u0089\t\13\2\2\u0089\30\3\2\2\2\u008a\u008b\t\17\2\2\u008b"+
		"\u008c\t\3\2\2\u008c\u008d\t\b\2\2\u008d\u008e\t\n\2\2\u008e\u008f\t\13"+
		"\2\2\u008f\32\3\2\2\2\u0090\u0091\t\23\2\2\u0091\u0092\t\n\2\2\u0092\u0093"+
		"\t\3\2\2\u0093\u0094\t\b\2\2\u0094\u0095\t\t\2\2\u0095\u0096\t\5\2\2\u0096"+
		"\34\3\2\2\2\u0097\u0098\t\b\2\2\u0098\u0099\t\22\2\2\u0099\36\3\2\2\2"+
		"\u009a\u009b\t\n\2\2\u009b\u009c\t\20\2\2\u009c\u009d\t\13\2\2\u009d\u009e"+
		"\t\t\2\2\u009e \3\2\2\2\u009f\u00a0\t\13\2\2\u00a0\u00a1\t\r\2\2\u00a1"+
		"\u00a2\t\23\2\2\u00a2\u00a3\t\13\2\2\u00a3\"\3\2\2\2\u00a4\u00a5\7\61"+
		"\2\2\u00a5\u00a6\7\61\2\2\u00a6\u00aa\3\2\2\2\u00a7\u00a9\n\25\2\2\u00a8"+
		"\u00a7\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2"+
		"\2\2\u00ab\u00ad\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad\u00ae\b\22\2\2\u00ae"+
		"$\3\2\2\2\u00af\u00b0\t\26\2\2\u00b0&\3\2\2\2\u00b1\u00b2\t\27\2\2\u00b2"+
		"(\3\2\2\2\u00b3\u00b4\7@\2\2\u00b4\u00bd\7?\2\2\u00b5\u00b6\7>\2\2\u00b6"+
		"\u00bd\7?\2\2\u00b7\u00b8\7?\2\2\u00b8\u00bd\7?\2\2\u00b9\u00ba\7>\2\2"+
		"\u00ba\u00bd\7@\2\2\u00bb\u00bd\t\30\2\2\u00bc\u00b3\3\2\2\2\u00bc\u00b5"+
		"\3\2\2\2\u00bc\u00b7\3\2\2\2\u00bc\u00b9\3\2\2\2\u00bc\u00bb\3\2\2\2\u00bd"+
		"*\3\2\2\2\u00be\u00bf\t\4\2\2\u00bf\u00c4\t\3\2\2\u00c0\u00c1\t\6\2\2"+
		"\u00c1\u00c2\t\t\2\2\u00c2\u00c4\t\16\2\2\u00c3\u00be\3\2\2\2\u00c3\u00c0"+
		"\3\2\2\2\u00c4,\3\2\2\2\u00c5\u00c6\7\u0080\2\2\u00c6.\3\2\2\2\u00c7\u00c8"+
		"\7=\2\2\u00c8\60\3\2\2\2\u00c9\u00ca\7\60\2\2\u00ca\62\3\2\2\2\u00cb\u00cc"+
		"\7<\2\2\u00cc\u00cd\7?\2\2\u00cd\64\3\2\2\2\u00ce\u00cf\7<\2\2\u00cf\66"+
		"\3\2\2\2\u00d0\u00d1\7.\2\2\u00d18\3\2\2\2\u00d2\u00d3\7*\2\2\u00d3:\3"+
		"\2\2\2\u00d4\u00d5\7+\2\2\u00d5<\3\2\2\2\u00d6\u00d7\7}\2\2\u00d7>\3\2"+
		"\2\2\u00d8\u00d9\7\177\2\2\u00d9@\3\2\2\2\u00da\u00de\7$\2\2\u00db\u00dd"+
		"\n\31\2\2\u00dc\u00db\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2"+
		"\u00de\u00df\3\2\2\2\u00df\u00e1\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e2"+
		"\7$\2\2\u00e2B\3\2\2\2\u00e3\u00e7\t\32\2\2\u00e4\u00e6\t\33\2\2\u00e5"+
		"\u00e4\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2"+
		"\2\2\u00e8\u00ea\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00eb\b\"\3\2\u00eb"+
		"D\3\2\2\2\u00ec\u00ee\t\26\2\2\u00ed\u00ec\3\2\2\2\u00ed\u00ee\3\2\2\2"+
		"\u00ee\u00f0\3\2\2\2\u00ef\u00f1\t\34\2\2\u00f0\u00ef\3\2\2\2\u00f1\u00f2"+
		"\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4"+
		"\u00f5\b#\4\2\u00f5F\3\2\2\2\u00f6\u00f8\t\35\2\2\u00f7\u00f6\3\2\2\2"+
		"\u00f8\u00f9\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fb"+
		"\3\2\2\2\u00fb\u00fc\b$\2\2\u00fcH\3\2\2\2\u00fd\u00fe\13\2\2\2\u00fe"+
		"\u00ff\b%\5\2\u00ffJ\3\2\2\2\13\2\u00aa\u00bc\u00c3\u00de\u00e7\u00ed"+
		"\u00f2\u00f9\6\b\2\2\3\"\2\3#\3\3%\4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}