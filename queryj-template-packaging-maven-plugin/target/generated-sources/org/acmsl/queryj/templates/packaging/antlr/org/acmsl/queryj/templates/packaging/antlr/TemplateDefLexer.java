// Generated from org/acmsl/queryj/templates/packaging/antlr/TemplateDef.g4 by ANTLR 4.2
package org.acmsl.queryj.templates.packaging.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TemplateDefLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__8=1, T__7=2, T__6=3, T__5=4, T__4=5, T__3=6, T__2=7, T__1=8, T__0=9, 
		ID=10, COMMENT=11, WS=12, LINE_COMMENT=13;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'filename'", "'builder'", "'package'", "'type'", "'name'", "'output'", 
		"':'", "'disabled'", "';'", "ID", "COMMENT", "WS", "LINE_COMMENT"
	};
	public static final String[] ruleNames = {
		"T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", 
		"ID", "COMMENT", "WS", "LINE_COMMENT"
	};


	public TemplateDefLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TemplateDef.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\17~\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\6\13V\n\13\r\13\16\13W\3"+
		"\f\3\f\3\f\3\f\7\f^\n\f\f\f\16\fa\13\f\3\f\3\f\3\f\3\f\3\f\3\r\6\ri\n"+
		"\r\r\r\16\rj\3\r\3\r\3\16\3\16\3\16\3\16\7\16s\n\16\f\16\16\16v\13\16"+
		"\3\16\5\16y\n\16\3\16\3\16\3\16\3\16\3_\2\17\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\3\2\5\n\2.\60\62;>>@@C\\^^aac|"+
		"\5\2\13\f\16\17\"\"\4\2\f\f\17\17\u0082\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\3\35"+
		"\3\2\2\2\5&\3\2\2\2\7.\3\2\2\2\t\66\3\2\2\2\13;\3\2\2\2\r@\3\2\2\2\17"+
		"G\3\2\2\2\21I\3\2\2\2\23R\3\2\2\2\25U\3\2\2\2\27Y\3\2\2\2\31h\3\2\2\2"+
		"\33n\3\2\2\2\35\36\7h\2\2\36\37\7k\2\2\37 \7n\2\2 !\7g\2\2!\"\7p\2\2\""+
		"#\7c\2\2#$\7o\2\2$%\7g\2\2%\4\3\2\2\2&\'\7d\2\2\'(\7w\2\2()\7k\2\2)*\7"+
		"n\2\2*+\7f\2\2+,\7g\2\2,-\7t\2\2-\6\3\2\2\2./\7r\2\2/\60\7c\2\2\60\61"+
		"\7e\2\2\61\62\7m\2\2\62\63\7c\2\2\63\64\7i\2\2\64\65\7g\2\2\65\b\3\2\2"+
		"\2\66\67\7v\2\2\678\7{\2\289\7r\2\29:\7g\2\2:\n\3\2\2\2;<\7p\2\2<=\7c"+
		"\2\2=>\7o\2\2>?\7g\2\2?\f\3\2\2\2@A\7q\2\2AB\7w\2\2BC\7v\2\2CD\7r\2\2"+
		"DE\7w\2\2EF\7v\2\2F\16\3\2\2\2GH\7<\2\2H\20\3\2\2\2IJ\7f\2\2JK\7k\2\2"+
		"KL\7u\2\2LM\7c\2\2MN\7d\2\2NO\7n\2\2OP\7g\2\2PQ\7f\2\2Q\22\3\2\2\2RS\7"+
		"=\2\2S\24\3\2\2\2TV\t\2\2\2UT\3\2\2\2VW\3\2\2\2WU\3\2\2\2WX\3\2\2\2X\26"+
		"\3\2\2\2YZ\7\61\2\2Z[\7,\2\2[_\3\2\2\2\\^\13\2\2\2]\\\3\2\2\2^a\3\2\2"+
		"\2_`\3\2\2\2_]\3\2\2\2`b\3\2\2\2a_\3\2\2\2bc\7,\2\2cd\7\61\2\2de\3\2\2"+
		"\2ef\b\f\2\2f\30\3\2\2\2gi\t\3\2\2hg\3\2\2\2ij\3\2\2\2jh\3\2\2\2jk\3\2"+
		"\2\2kl\3\2\2\2lm\b\r\2\2m\32\3\2\2\2no\7\61\2\2op\7\61\2\2pt\3\2\2\2q"+
		"s\n\4\2\2rq\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2ux\3\2\2\2vt\3\2\2\2"+
		"wy\7\17\2\2xw\3\2\2\2xy\3\2\2\2yz\3\2\2\2z{\7\f\2\2{|\3\2\2\2|}\b\16\2"+
		"\2}\34\3\2\2\2\b\2W_jtx\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}