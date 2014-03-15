// Generated from org/acmsl/queryj/templates/packaging/antlr/TemplateDef.g4 by ANTLR 4.2
package org.acmsl.queryj.templates.packaging.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TemplateDefParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__8=1, T__7=2, T__6=3, T__5=4, T__4=5, T__3=6, T__2=7, T__1=8, T__0=9, 
		ID=10, COMMENT=11, WS=12, LINE_COMMENT=13;
	public static final String[] tokenNames = {
		"<INVALID>", "'filename'", "'builder'", "'package'", "'type'", "'name'", 
		"'output'", "':'", "'disabled'", "';'", "ID", "COMMENT", "WS", "LINE_COMMENT"
	};
	public static final int
		RULE_templateDef = 0, RULE_nameRule = 1, RULE_typeRule = 2, RULE_outputRule = 3, 
		RULE_filenameBuilderRule = 4, RULE_packageRule = 5, RULE_disabledRule = 6;
	public static final String[] ruleNames = {
		"templateDef", "nameRule", "typeRule", "outputRule", "filenameBuilderRule", 
		"packageRule", "disabledRule"
	};

	@Override
	public String getGrammarFileName() { return "TemplateDef.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TemplateDefParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class TemplateDefContext extends ParserRuleContext {
		public DisabledRuleContext disabledRule() {
			return getRuleContext(DisabledRuleContext.class,0);
		}
		public TerminalNode EOF() { return getToken(TemplateDefParser.EOF, 0); }
		public PackageRuleContext packageRule() {
			return getRuleContext(PackageRuleContext.class,0);
		}
		public OutputRuleContext outputRule() {
			return getRuleContext(OutputRuleContext.class,0);
		}
		public FilenameBuilderRuleContext filenameBuilderRule() {
			return getRuleContext(FilenameBuilderRuleContext.class,0);
		}
		public TypeRuleContext typeRule() {
			return getRuleContext(TypeRuleContext.class,0);
		}
		public NameRuleContext nameRule() {
			return getRuleContext(NameRuleContext.class,0);
		}
		public TemplateDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateDefVisitor ) return ((TemplateDefVisitor<? extends T>)visitor).visitTemplateDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemplateDefContext templateDef() throws RecognitionException {
		TemplateDefContext _localctx = new TemplateDefContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_templateDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14); nameRule();
			setState(15); typeRule();
			setState(16); outputRule();
			setState(17); filenameBuilderRule();
			setState(18); packageRule();
			setState(20);
			_la = _input.LA(1);
			if (_la==8) {
				{
				setState(19); disabledRule();
				}
			}

			setState(22); match(EOF);
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

	public static class NameRuleContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TemplateDefParser.ID, 0); }
		public NameRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nameRule; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateDefVisitor ) return ((TemplateDefVisitor<? extends T>)visitor).visitNameRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameRuleContext nameRule() throws RecognitionException {
		NameRuleContext _localctx = new NameRuleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_nameRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24); match(5);
			setState(25); match(7);
			setState(26); match(ID);
			setState(27); match(9);
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

	public static class TypeRuleContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TemplateDefParser.ID, 0); }
		public TypeRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeRule; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateDefVisitor ) return ((TemplateDefVisitor<? extends T>)visitor).visitTypeRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeRuleContext typeRule() throws RecognitionException {
		TypeRuleContext _localctx = new TypeRuleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_typeRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29); match(4);
			setState(30); match(7);
			setState(31); match(ID);
			setState(32); match(9);
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

	public static class OutputRuleContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TemplateDefParser.ID, 0); }
		public OutputRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outputRule; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateDefVisitor ) return ((TemplateDefVisitor<? extends T>)visitor).visitOutputRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OutputRuleContext outputRule() throws RecognitionException {
		OutputRuleContext _localctx = new OutputRuleContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_outputRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34); match(6);
			setState(35); match(7);
			setState(36); match(ID);
			setState(37); match(9);
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

	public static class FilenameBuilderRuleContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TemplateDefParser.ID, 0); }
		public FilenameBuilderRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filenameBuilderRule; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateDefVisitor ) return ((TemplateDefVisitor<? extends T>)visitor).visitFilenameBuilderRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FilenameBuilderRuleContext filenameBuilderRule() throws RecognitionException {
		FilenameBuilderRuleContext _localctx = new FilenameBuilderRuleContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_filenameBuilderRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39); match(1);
			setState(40); match(2);
			setState(41); match(7);
			setState(42); match(ID);
			setState(43); match(9);
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

	public static class PackageRuleContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TemplateDefParser.ID, 0); }
		public PackageRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageRule; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateDefVisitor ) return ((TemplateDefVisitor<? extends T>)visitor).visitPackageRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PackageRuleContext packageRule() throws RecognitionException {
		PackageRuleContext _localctx = new PackageRuleContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_packageRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45); match(3);
			setState(46); match(7);
			setState(47); match(ID);
			setState(48); match(9);
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

	public static class DisabledRuleContext extends ParserRuleContext {
		public DisabledRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_disabledRule; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateDefVisitor ) return ((TemplateDefVisitor<? extends T>)visitor).visitDisabledRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DisabledRuleContext disabledRule() throws RecognitionException {
		DisabledRuleContext _localctx = new DisabledRuleContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_disabledRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50); match(8);
			setState(51); match(9);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\178\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\3\2\3\2\5\2"+
		"\27\n\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\2\2"+
		"\t\2\4\6\b\n\f\16\2\2\61\2\20\3\2\2\2\4\32\3\2\2\2\6\37\3\2\2\2\b$\3\2"+
		"\2\2\n)\3\2\2\2\f/\3\2\2\2\16\64\3\2\2\2\20\21\5\4\3\2\21\22\5\6\4\2\22"+
		"\23\5\b\5\2\23\24\5\n\6\2\24\26\5\f\7\2\25\27\5\16\b\2\26\25\3\2\2\2\26"+
		"\27\3\2\2\2\27\30\3\2\2\2\30\31\7\2\2\3\31\3\3\2\2\2\32\33\7\7\2\2\33"+
		"\34\7\t\2\2\34\35\7\f\2\2\35\36\7\13\2\2\36\5\3\2\2\2\37 \7\6\2\2 !\7"+
		"\t\2\2!\"\7\f\2\2\"#\7\13\2\2#\7\3\2\2\2$%\7\b\2\2%&\7\t\2\2&\'\7\f\2"+
		"\2\'(\7\13\2\2(\t\3\2\2\2)*\7\3\2\2*+\7\4\2\2+,\7\t\2\2,-\7\f\2\2-.\7"+
		"\13\2\2.\13\3\2\2\2/\60\7\5\2\2\60\61\7\t\2\2\61\62\7\f\2\2\62\63\7\13"+
		"\2\2\63\r\3\2\2\2\64\65\7\n\2\2\65\66\7\13\2\2\66\17\3\2\2\2\3\26";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}