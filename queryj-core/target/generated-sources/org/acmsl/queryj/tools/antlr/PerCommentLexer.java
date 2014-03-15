// Generated from org/acmsl/queryj/tools/antlr/PerComment.g4 by ANTLR 4.2
package org.acmsl.queryj.tools.antlr;

/*
                        QueryJ-Core

    Copyright (C) 2002-today  Jose San Leandro Armendariz
                        chous@acm-sl.org

    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public
    License as published by the Free Software Foundation; either
    version 2 of the License, or any later version.

    This library is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    General Public License for more details.

    You should have received a copy of the GNU General Public
    License along with this library; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

    Thanks to ACM S.L. for distributing this library under the GPL license.
    Contact info: chous@acm-sl.org
    Postal Address: c/Playa de Lagoa, 1
                    Urb. Valdecabanas
                    Boadilla del monte
                    28660 Madrid
                    Spain

 ******************************************************************************
 *
 * Generated from PerComment.g4 by ANTLR.
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: ANTLR lexer for PerComment.g4
 *
 */

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PerCommentLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, STATIC=2, ISATYPE=3, ISAREFS=4, ISA=5, DECORATOR=6, READONLY=7, 
		RELATIONSHIP=8, BOOL=9, ORASEQ=10, IDENT=11, TEXT=12, SQUOTE=13, DQUOTE=14, 
		QUOTE=15, OPEN_PAREN=16, CLOSE_PAREN=17, COMMA=18;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"WS", "'@static'", "'@isatype'", "'@isarefs'", "'@isa'", "'@decorator'", 
		"'@readonly'", "'@relationship'", "'@bool'", "'@oraseq'", "IDENT", "TEXT", 
		"SQUOTE", "DQUOTE", "QUOTE", "'('", "')'", "','"
	};
	public static final String[] ruleNames = {
		"WS", "STATIC", "ISATYPE", "ISAREFS", "ISA", "DECORATOR", "READONLY", 
		"RELATIONSHIP", "BOOL", "ORASEQ", "IDENT", "TEXT", "SQUOTE", "DQUOTE", 
		"QUOTE", "OPEN_PAREN", "CLOSE_PAREN", "COMMA", "NAMECHAR", "DIGIT", "LETTER", 
		"DOT"
	};


	public PerCommentLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PerComment.g4"; }

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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\24\u00b0\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\6\2\61\n\2"+
		"\r\2\16\2\62\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\f\3\f\6\f\u0089\n\f\r\f\16\f\u008a\5\f\u008d\n\f\3\r\3\r\3\r\6\r\u0092"+
		"\n\r\r\r\16\r\u0093\5\r\u0096\n\r\3\16\3\16\3\17\3\17\3\20\3\20\5\20\u009e"+
		"\n\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\5\24\u00a9\n\24\3\25"+
		"\3\25\3\26\3\26\3\27\3\27\2\2\30\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\2)\2+\2-\2\3\2\6\5"+
		"\2\13\f\16\17\"\"\6\2$$)+..BB\6\2&&/\60<<aa\4\2C\\c|\u00b4\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\3\60\3\2\2\2\5\66\3\2\2\2\7>\3\2\2\2\tG\3\2\2\2\13P\3\2\2\2\rU\3\2"+
		"\2\2\17`\3\2\2\2\21j\3\2\2\2\23x\3\2\2\2\25~\3\2\2\2\27\u008c\3\2\2\2"+
		"\31\u0095\3\2\2\2\33\u0097\3\2\2\2\35\u0099\3\2\2\2\37\u009d\3\2\2\2!"+
		"\u009f\3\2\2\2#\u00a1\3\2\2\2%\u00a3\3\2\2\2\'\u00a8\3\2\2\2)\u00aa\3"+
		"\2\2\2+\u00ac\3\2\2\2-\u00ae\3\2\2\2/\61\t\2\2\2\60/\3\2\2\2\61\62\3\2"+
		"\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\64\3\2\2\2\64\65\b\2\2\2\65\4\3\2"+
		"\2\2\66\67\7B\2\2\678\7u\2\289\7v\2\29:\7c\2\2:;\7v\2\2;<\7k\2\2<=\7e"+
		"\2\2=\6\3\2\2\2>?\7B\2\2?@\7k\2\2@A\7u\2\2AB\7c\2\2BC\7v\2\2CD\7{\2\2"+
		"DE\7r\2\2EF\7g\2\2F\b\3\2\2\2GH\7B\2\2HI\7k\2\2IJ\7u\2\2JK\7c\2\2KL\7"+
		"t\2\2LM\7g\2\2MN\7h\2\2NO\7u\2\2O\n\3\2\2\2PQ\7B\2\2QR\7k\2\2RS\7u\2\2"+
		"ST\7c\2\2T\f\3\2\2\2UV\7B\2\2VW\7f\2\2WX\7g\2\2XY\7e\2\2YZ\7q\2\2Z[\7"+
		"t\2\2[\\\7c\2\2\\]\7v\2\2]^\7q\2\2^_\7t\2\2_\16\3\2\2\2`a\7B\2\2ab\7t"+
		"\2\2bc\7g\2\2cd\7c\2\2de\7f\2\2ef\7q\2\2fg\7p\2\2gh\7n\2\2hi\7{\2\2i\20"+
		"\3\2\2\2jk\7B\2\2kl\7t\2\2lm\7g\2\2mn\7n\2\2no\7c\2\2op\7v\2\2pq\7k\2"+
		"\2qr\7q\2\2rs\7p\2\2st\7u\2\2tu\7j\2\2uv\7k\2\2vw\7r\2\2w\22\3\2\2\2x"+
		"y\7B\2\2yz\7d\2\2z{\7q\2\2{|\7q\2\2|}\7n\2\2}\24\3\2\2\2~\177\7B\2\2\177"+
		"\u0080\7q\2\2\u0080\u0081\7t\2\2\u0081\u0082\7c\2\2\u0082\u0083\7u\2\2"+
		"\u0083\u0084\7g\2\2\u0084\u0085\7s\2\2\u0085\26\3\2\2\2\u0086\u008d\7"+
		"B\2\2\u0087\u0089\5\'\24\2\u0088\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a"+
		"\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008d\3\2\2\2\u008c\u0086\3\2"+
		"\2\2\u008c\u0088\3\2\2\2\u008d\30\3\2\2\2\u008e\u0096\5\27\f\2\u008f\u0096"+
		"\7B\2\2\u0090\u0092\n\3\2\2\u0091\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093"+
		"\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0096\3\2\2\2\u0095\u008e\3\2"+
		"\2\2\u0095\u008f\3\2\2\2\u0095\u0091\3\2\2\2\u0096\32\3\2\2\2\u0097\u0098"+
		"\7)\2\2\u0098\34\3\2\2\2\u0099\u009a\7$\2\2\u009a\36\3\2\2\2\u009b\u009e"+
		"\5\33\16\2\u009c\u009e\5\35\17\2\u009d\u009b\3\2\2\2\u009d\u009c\3\2\2"+
		"\2\u009e \3\2\2\2\u009f\u00a0\7*\2\2\u00a0\"\3\2\2\2\u00a1\u00a2\7+\2"+
		"\2\u00a2$\3\2\2\2\u00a3\u00a4\7.\2\2\u00a4&\3\2\2\2\u00a5\u00a9\5+\26"+
		"\2\u00a6\u00a9\5)\25\2\u00a7\u00a9\t\4\2\2\u00a8\u00a5\3\2\2\2\u00a8\u00a6"+
		"\3\2\2\2\u00a8\u00a7\3\2\2\2\u00a9(\3\2\2\2\u00aa\u00ab\4\62;\2\u00ab"+
		"*\3\2\2\2\u00ac\u00ad\t\5\2\2\u00ad,\3\2\2\2\u00ae\u00af\7\60\2\2\u00af"+
		".\3\2\2\2\n\2\62\u008a\u008c\u0093\u0095\u009d\u00a8\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}