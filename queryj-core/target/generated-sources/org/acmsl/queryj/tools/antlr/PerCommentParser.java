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
 * Description: ANTLR parser for PerComment.g4
 *
 */

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PerCommentParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, STATIC=2, ISATYPE=3, ISAREFS=4, ISA=5, DECORATOR=6, READONLY=7, 
		RELATIONSHIP=8, BOOL=9, ORASEQ=10, IDENT=11, TEXT=12, SQUOTE=13, DQUOTE=14, 
		QUOTE=15, OPEN_PAREN=16, CLOSE_PAREN=17, COMMA=18;
	public static final String[] tokenNames = {
		"<INVALID>", "WS", "'@static'", "'@isatype'", "'@isarefs'", "'@isa'", 
		"'@decorator'", "'@readonly'", "'@relationship'", "'@bool'", "'@oraseq'", 
		"IDENT", "TEXT", "SQUOTE", "DQUOTE", "QUOTE", "'('", "')'", "','"
	};
	public static final int
		RULE_tableComment = 0, RULE_columnComment = 1, RULE_tabAnnotation = 2, 
		RULE_tabStatic = 3, RULE_tabIsa = 4, RULE_tabIsatype = 5, RULE_tabDecorator = 6, 
		RULE_tabRelationship = 7, RULE_colAnnotation = 8, RULE_colReadonly = 9, 
		RULE_colBool = 10, RULE_ident = 11, RULE_colIsarefs = 12, RULE_colOraseq = 13, 
		RULE_freeText = 14;
	public static final String[] ruleNames = {
		"tableComment", "columnComment", "tabAnnotation", "tabStatic", "tabIsa", 
		"tabIsatype", "tabDecorator", "tabRelationship", "colAnnotation", "colReadonly", 
		"colBool", "ident", "colIsarefs", "colOraseq", "freeText"
	};

	@Override
	public String getGrammarFileName() { return "PerComment.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PerCommentParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class TableCommentContext extends ParserRuleContext {
		public FreeTextContext freeText() {
			return getRuleContext(FreeTextContext.class,0);
		}
		public TabAnnotationContext tabAnnotation(int i) {
			return getRuleContext(TabAnnotationContext.class,i);
		}
		public List<TabAnnotationContext> tabAnnotation() {
			return getRuleContexts(TabAnnotationContext.class);
		}
		public TableCommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableComment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PerCommentListener ) ((PerCommentListener)listener).enterTableComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PerCommentListener ) ((PerCommentListener)listener).exitTableComment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PerCommentVisitor ) return ((PerCommentVisitor<? extends T>)visitor).visitTableComment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableCommentContext tableComment() throws RecognitionException {
		TableCommentContext _localctx = new TableCommentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_tableComment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30); freeText();
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STATIC) | (1L << ISATYPE) | (1L << ISA) | (1L << DECORATOR) | (1L << RELATIONSHIP))) != 0)) {
				{
				{
				setState(31); tabAnnotation();
				}
				}
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ColumnCommentContext extends ParserRuleContext {
		public ColAnnotationContext colAnnotation(int i) {
			return getRuleContext(ColAnnotationContext.class,i);
		}
		public List<ColAnnotationContext> colAnnotation() {
			return getRuleContexts(ColAnnotationContext.class);
		}
		public FreeTextContext freeText() {
			return getRuleContext(FreeTextContext.class,0);
		}
		public ColumnCommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnComment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PerCommentListener ) ((PerCommentListener)listener).enterColumnComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PerCommentListener ) ((PerCommentListener)listener).exitColumnComment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PerCommentVisitor ) return ((PerCommentVisitor<? extends T>)visitor).visitColumnComment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnCommentContext columnComment() throws RecognitionException {
		ColumnCommentContext _localctx = new ColumnCommentContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_columnComment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37); freeText();
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ISAREFS) | (1L << READONLY) | (1L << BOOL) | (1L << ORASEQ))) != 0)) {
				{
				{
				setState(38); colAnnotation();
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class TabAnnotationContext extends ParserRuleContext {
		public TabRelationshipContext tabRelationship() {
			return getRuleContext(TabRelationshipContext.class,0);
		}
		public TabDecoratorContext tabDecorator() {
			return getRuleContext(TabDecoratorContext.class,0);
		}
		public TabIsaContext tabIsa() {
			return getRuleContext(TabIsaContext.class,0);
		}
		public TabStaticContext tabStatic() {
			return getRuleContext(TabStaticContext.class,0);
		}
		public TabIsatypeContext tabIsatype() {
			return getRuleContext(TabIsatypeContext.class,0);
		}
		public TabAnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tabAnnotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PerCommentListener ) ((PerCommentListener)listener).enterTabAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PerCommentListener ) ((PerCommentListener)listener).exitTabAnnotation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PerCommentVisitor ) return ((PerCommentVisitor<? extends T>)visitor).visitTabAnnotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TabAnnotationContext tabAnnotation() throws RecognitionException {
		TabAnnotationContext _localctx = new TabAnnotationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_tabAnnotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			switch (_input.LA(1)) {
			case STATIC:
				{
				setState(44); tabStatic();
				}
				break;
			case ISA:
				{
				setState(45); tabIsa();
				}
				break;
			case ISATYPE:
				{
				setState(46); tabIsatype();
				}
				break;
			case DECORATOR:
				{
				setState(47); tabDecorator();
				}
				break;
			case RELATIONSHIP:
				{
				setState(48); tabRelationship();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class TabStaticContext extends ParserRuleContext {
		public TerminalNode STATIC() { return getToken(PerCommentParser.STATIC, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TabStaticContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tabStatic; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PerCommentListener ) ((PerCommentListener)listener).enterTabStatic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PerCommentListener ) ((PerCommentListener)listener).exitTabStatic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PerCommentVisitor ) return ((PerCommentVisitor<? extends T>)visitor).visitTabStatic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TabStaticContext tabStatic() throws RecognitionException {
		TabStaticContext _localctx = new TabStaticContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tabStatic);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51); match(STATIC);
			setState(52); ident();
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

	public static class TabIsaContext extends ParserRuleContext {
		public TerminalNode ISA() { return getToken(PerCommentParser.ISA, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TabIsaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tabIsa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PerCommentListener ) ((PerCommentListener)listener).enterTabIsa(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PerCommentListener ) ((PerCommentListener)listener).exitTabIsa(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PerCommentVisitor ) return ((PerCommentVisitor<? extends T>)visitor).visitTabIsa(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TabIsaContext tabIsa() throws RecognitionException {
		TabIsaContext _localctx = new TabIsaContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_tabIsa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54); match(ISA);
			setState(55); ident();
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

	public static class TabIsatypeContext extends ParserRuleContext {
		public TerminalNode ISATYPE() { return getToken(PerCommentParser.ISATYPE, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TabIsatypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tabIsatype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PerCommentListener ) ((PerCommentListener)listener).enterTabIsatype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PerCommentListener ) ((PerCommentListener)listener).exitTabIsatype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PerCommentVisitor ) return ((PerCommentVisitor<? extends T>)visitor).visitTabIsatype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TabIsatypeContext tabIsatype() throws RecognitionException {
		TabIsatypeContext _localctx = new TabIsatypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_tabIsatype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57); match(ISATYPE);
			setState(58); ident();
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

	public static class TabDecoratorContext extends ParserRuleContext {
		public TerminalNode DECORATOR() { return getToken(PerCommentParser.DECORATOR, 0); }
		public TabDecoratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tabDecorator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PerCommentListener ) ((PerCommentListener)listener).enterTabDecorator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PerCommentListener ) ((PerCommentListener)listener).exitTabDecorator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PerCommentVisitor ) return ((PerCommentVisitor<? extends T>)visitor).visitTabDecorator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TabDecoratorContext tabDecorator() throws RecognitionException {
		TabDecoratorContext _localctx = new TabDecoratorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_tabDecorator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60); match(DECORATOR);
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

	public static class TabRelationshipContext extends ParserRuleContext {
		public List<TerminalNode> CLOSE_PAREN() { return getTokens(PerCommentParser.CLOSE_PAREN); }
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public TerminalNode CLOSE_PAREN(int i) {
			return getToken(PerCommentParser.CLOSE_PAREN, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PerCommentParser.COMMA); }
		public List<TerminalNode> OPEN_PAREN() { return getTokens(PerCommentParser.OPEN_PAREN); }
		public TerminalNode RELATIONSHIP() { return getToken(PerCommentParser.RELATIONSHIP, 0); }
		public TerminalNode OPEN_PAREN(int i) {
			return getToken(PerCommentParser.OPEN_PAREN, i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(PerCommentParser.COMMA, i);
		}
		public List<IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public TabRelationshipContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tabRelationship; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PerCommentListener ) ((PerCommentListener)listener).enterTabRelationship(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PerCommentListener ) ((PerCommentListener)listener).exitTabRelationship(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PerCommentVisitor ) return ((PerCommentVisitor<? extends T>)visitor).visitTabRelationship(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TabRelationshipContext tabRelationship() throws RecognitionException {
		TabRelationshipContext _localctx = new TabRelationshipContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_tabRelationship);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62); match(RELATIONSHIP);
			setState(71); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(63); match(OPEN_PAREN);
				setState(64); ident();
				setState(65); match(COMMA);
				setState(66); ident();
				setState(67); match(CLOSE_PAREN);
				setState(69);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(68); match(COMMA);
					}
				}

				}
				}
				setState(73); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==OPEN_PAREN );
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

	public static class ColAnnotationContext extends ParserRuleContext {
		public ColOraseqContext colOraseq() {
			return getRuleContext(ColOraseqContext.class,0);
		}
		public ColBoolContext colBool() {
			return getRuleContext(ColBoolContext.class,0);
		}
		public ColReadonlyContext colReadonly() {
			return getRuleContext(ColReadonlyContext.class,0);
		}
		public ColIsarefsContext colIsarefs() {
			return getRuleContext(ColIsarefsContext.class,0);
		}
		public ColAnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colAnnotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PerCommentListener ) ((PerCommentListener)listener).enterColAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PerCommentListener ) ((PerCommentListener)listener).exitColAnnotation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PerCommentVisitor ) return ((PerCommentVisitor<? extends T>)visitor).visitColAnnotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColAnnotationContext colAnnotation() throws RecognitionException {
		ColAnnotationContext _localctx = new ColAnnotationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_colAnnotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			switch (_input.LA(1)) {
			case READONLY:
				{
				setState(75); colReadonly();
				}
				break;
			case BOOL:
				{
				setState(76); colBool();
				}
				break;
			case ISAREFS:
				{
				setState(77); colIsarefs();
				}
				break;
			case ORASEQ:
				{
				setState(78); colOraseq();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ColReadonlyContext extends ParserRuleContext {
		public TerminalNode READONLY() { return getToken(PerCommentParser.READONLY, 0); }
		public ColReadonlyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colReadonly; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PerCommentListener ) ((PerCommentListener)listener).enterColReadonly(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PerCommentListener ) ((PerCommentListener)listener).exitColReadonly(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PerCommentVisitor ) return ((PerCommentVisitor<? extends T>)visitor).visitColReadonly(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColReadonlyContext colReadonly() throws RecognitionException {
		ColReadonlyContext _localctx = new ColReadonlyContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_colReadonly);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81); match(READONLY);
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

	public static class ColBoolContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(PerCommentParser.BOOL, 0); }
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PerCommentParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PerCommentParser.COMMA, i);
		}
		public List<IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public ColBoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colBool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PerCommentListener ) ((PerCommentListener)listener).enterColBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PerCommentListener ) ((PerCommentListener)listener).exitColBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PerCommentVisitor ) return ((PerCommentVisitor<? extends T>)visitor).visitColBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColBoolContext colBool() throws RecognitionException {
		ColBoolContext _localctx = new ColBoolContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_colBool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83); match(BOOL);
			setState(84); ident();
			setState(85); match(COMMA);
			setState(86); ident();
			setState(89);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(87); match(COMMA);
				setState(88); ident();
				}
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

	public static class IdentContext extends ParserRuleContext {
		public TerminalNode TEXT(int i) {
			return getToken(PerCommentParser.TEXT, i);
		}
		public TerminalNode SQUOTE(int i) {
			return getToken(PerCommentParser.SQUOTE, i);
		}
		public TerminalNode DQUOTE(int i) {
			return getToken(PerCommentParser.DQUOTE, i);
		}
		public List<TerminalNode> TEXT() { return getTokens(PerCommentParser.TEXT); }
		public List<TerminalNode> DQUOTE() { return getTokens(PerCommentParser.DQUOTE); }
		public List<TerminalNode> SQUOTE() { return getTokens(PerCommentParser.SQUOTE); }
		public List<TerminalNode> IDENT() { return getTokens(PerCommentParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(PerCommentParser.IDENT, i);
		}
		public IdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ident; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PerCommentListener ) ((PerCommentListener)listener).enterIdent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PerCommentListener ) ((PerCommentListener)listener).exitIdent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PerCommentVisitor ) return ((PerCommentVisitor<? extends T>)visitor).visitIdent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentContext ident() throws RecognitionException {
		IdentContext _localctx = new IdentContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_ident);
		int _la;
		try {
			setState(106);
			switch (_input.LA(1)) {
			case SQUOTE:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(91); match(SQUOTE);
				setState(93); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(92);
					_la = _input.LA(1);
					if ( !(_la==IDENT || _la==TEXT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					}
					setState(95); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==IDENT || _la==TEXT );
				setState(97); match(SQUOTE);
				}
				}
				break;
			case DQUOTE:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(98); match(DQUOTE);
				setState(100); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(99);
					_la = _input.LA(1);
					if ( !(_la==IDENT || _la==TEXT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					}
					setState(102); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==IDENT || _la==TEXT );
				setState(104); match(DQUOTE);
				}
				}
				break;
			case IDENT:
			case TEXT:
				enterOuterAlt(_localctx, 3);
				{
				setState(105);
				_la = _input.LA(1);
				if ( !(_la==IDENT || _la==TEXT) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ColIsarefsContext extends ParserRuleContext {
		public List<TerminalNode> CLOSE_PAREN() { return getTokens(PerCommentParser.CLOSE_PAREN); }
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public TerminalNode CLOSE_PAREN(int i) {
			return getToken(PerCommentParser.CLOSE_PAREN, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PerCommentParser.COMMA); }
		public List<TerminalNode> OPEN_PAREN() { return getTokens(PerCommentParser.OPEN_PAREN); }
		public TerminalNode ISAREFS() { return getToken(PerCommentParser.ISAREFS, 0); }
		public TerminalNode OPEN_PAREN(int i) {
			return getToken(PerCommentParser.OPEN_PAREN, i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(PerCommentParser.COMMA, i);
		}
		public List<IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public ColIsarefsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colIsarefs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PerCommentListener ) ((PerCommentListener)listener).enterColIsarefs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PerCommentListener ) ((PerCommentListener)listener).exitColIsarefs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PerCommentVisitor ) return ((PerCommentVisitor<? extends T>)visitor).visitColIsarefs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColIsarefsContext colIsarefs() throws RecognitionException {
		ColIsarefsContext _localctx = new ColIsarefsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_colIsarefs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108); match(ISAREFS);
			setState(117); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(109); match(OPEN_PAREN);
				setState(110); ident();
				setState(111); match(COMMA);
				setState(112); ident();
				setState(113); match(CLOSE_PAREN);
				setState(115);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(114); match(COMMA);
					}
				}

				}
				}
				setState(119); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==OPEN_PAREN );
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

	public static class ColOraseqContext extends ParserRuleContext {
		public TerminalNode ORASEQ() { return getToken(PerCommentParser.ORASEQ, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public ColOraseqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colOraseq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PerCommentListener ) ((PerCommentListener)listener).enterColOraseq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PerCommentListener ) ((PerCommentListener)listener).exitColOraseq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PerCommentVisitor ) return ((PerCommentVisitor<? extends T>)visitor).visitColOraseq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColOraseqContext colOraseq() throws RecognitionException {
		ColOraseqContext _localctx = new ColOraseqContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_colOraseq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121); match(ORASEQ);
			setState(122); ident();
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

	public static class FreeTextContext extends ParserRuleContext {
		public List<TerminalNode> CLOSE_PAREN() { return getTokens(PerCommentParser.CLOSE_PAREN); }
		public TerminalNode QUOTE(int i) {
			return getToken(PerCommentParser.QUOTE, i);
		}
		public TerminalNode TEXT(int i) {
			return getToken(PerCommentParser.TEXT, i);
		}
		public List<TerminalNode> TEXT() { return getTokens(PerCommentParser.TEXT); }
		public List<TerminalNode> SQUOTE() { return getTokens(PerCommentParser.SQUOTE); }
		public List<TerminalNode> OPEN_PAREN() { return getTokens(PerCommentParser.OPEN_PAREN); }
		public TerminalNode COMMA(int i) {
			return getToken(PerCommentParser.COMMA, i);
		}
		public TerminalNode SQUOTE(int i) {
			return getToken(PerCommentParser.SQUOTE, i);
		}
		public List<TerminalNode> QUOTE() { return getTokens(PerCommentParser.QUOTE); }
		public TerminalNode CLOSE_PAREN(int i) {
			return getToken(PerCommentParser.CLOSE_PAREN, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PerCommentParser.COMMA); }
		public TerminalNode OPEN_PAREN(int i) {
			return getToken(PerCommentParser.OPEN_PAREN, i);
		}
		public List<TerminalNode> IDENT() { return getTokens(PerCommentParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(PerCommentParser.IDENT, i);
		}
		public FreeTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_freeText; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PerCommentListener ) ((PerCommentListener)listener).enterFreeText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PerCommentListener ) ((PerCommentListener)listener).exitFreeText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PerCommentVisitor ) return ((PerCommentVisitor<? extends T>)visitor).visitFreeText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FreeTextContext freeText() throws RecognitionException {
		FreeTextContext _localctx = new FreeTextContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_freeText);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(124);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IDENT) | (1L << TEXT) | (1L << SQUOTE) | (1L << QUOTE) | (1L << OPEN_PAREN) | (1L << CLOSE_PAREN) | (1L << COMMA))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				}
				setState(127); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IDENT) | (1L << TEXT) | (1L << SQUOTE) | (1L << QUOTE) | (1L << OPEN_PAREN) | (1L << CLOSE_PAREN) | (1L << COMMA))) != 0) );
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\24\u0084\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\7\2#\n\2\f"+
		"\2\16\2&\13\2\3\3\3\3\7\3*\n\3\f\3\16\3-\13\3\3\4\3\4\3\4\3\4\3\4\5\4"+
		"\64\n\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\5\tH\n\t\6\tJ\n\t\r\t\16\tK\3\n\3\n\3\n\3\n\5\nR\n\n\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\f\5\f\\\n\f\3\r\3\r\6\r`\n\r\r\r\16\ra\3\r\3"+
		"\r\3\r\6\rg\n\r\r\r\16\rh\3\r\3\r\5\rm\n\r\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\5\16v\n\16\6\16x\n\16\r\16\16\16y\3\17\3\17\3\17\3\20\6\20\u0080"+
		"\n\20\r\20\16\20\u0081\3\20\2\2\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36\2\4\3\2\r\16\4\2\r\17\21\24\u0087\2 \3\2\2\2\4\'\3\2\2\2\6\63\3\2"+
		"\2\2\b\65\3\2\2\2\n8\3\2\2\2\f;\3\2\2\2\16>\3\2\2\2\20@\3\2\2\2\22Q\3"+
		"\2\2\2\24S\3\2\2\2\26U\3\2\2\2\30l\3\2\2\2\32n\3\2\2\2\34{\3\2\2\2\36"+
		"\177\3\2\2\2 $\5\36\20\2!#\5\6\4\2\"!\3\2\2\2#&\3\2\2\2$\"\3\2\2\2$%\3"+
		"\2\2\2%\3\3\2\2\2&$\3\2\2\2\'+\5\36\20\2(*\5\22\n\2)(\3\2\2\2*-\3\2\2"+
		"\2+)\3\2\2\2+,\3\2\2\2,\5\3\2\2\2-+\3\2\2\2.\64\5\b\5\2/\64\5\n\6\2\60"+
		"\64\5\f\7\2\61\64\5\16\b\2\62\64\5\20\t\2\63.\3\2\2\2\63/\3\2\2\2\63\60"+
		"\3\2\2\2\63\61\3\2\2\2\63\62\3\2\2\2\64\7\3\2\2\2\65\66\7\4\2\2\66\67"+
		"\5\30\r\2\67\t\3\2\2\289\7\7\2\29:\5\30\r\2:\13\3\2\2\2;<\7\5\2\2<=\5"+
		"\30\r\2=\r\3\2\2\2>?\7\b\2\2?\17\3\2\2\2@I\7\n\2\2AB\7\22\2\2BC\5\30\r"+
		"\2CD\7\24\2\2DE\5\30\r\2EG\7\23\2\2FH\7\24\2\2GF\3\2\2\2GH\3\2\2\2HJ\3"+
		"\2\2\2IA\3\2\2\2JK\3\2\2\2KI\3\2\2\2KL\3\2\2\2L\21\3\2\2\2MR\5\24\13\2"+
		"NR\5\26\f\2OR\5\32\16\2PR\5\34\17\2QM\3\2\2\2QN\3\2\2\2QO\3\2\2\2QP\3"+
		"\2\2\2R\23\3\2\2\2ST\7\t\2\2T\25\3\2\2\2UV\7\13\2\2VW\5\30\r\2WX\7\24"+
		"\2\2X[\5\30\r\2YZ\7\24\2\2Z\\\5\30\r\2[Y\3\2\2\2[\\\3\2\2\2\\\27\3\2\2"+
		"\2]_\7\17\2\2^`\t\2\2\2_^\3\2\2\2`a\3\2\2\2a_\3\2\2\2ab\3\2\2\2bc\3\2"+
		"\2\2cm\7\17\2\2df\7\20\2\2eg\t\2\2\2fe\3\2\2\2gh\3\2\2\2hf\3\2\2\2hi\3"+
		"\2\2\2ij\3\2\2\2jm\7\20\2\2km\t\2\2\2l]\3\2\2\2ld\3\2\2\2lk\3\2\2\2m\31"+
		"\3\2\2\2nw\7\6\2\2op\7\22\2\2pq\5\30\r\2qr\7\24\2\2rs\5\30\r\2su\7\23"+
		"\2\2tv\7\24\2\2ut\3\2\2\2uv\3\2\2\2vx\3\2\2\2wo\3\2\2\2xy\3\2\2\2yw\3"+
		"\2\2\2yz\3\2\2\2z\33\3\2\2\2{|\7\f\2\2|}\5\30\r\2}\35\3\2\2\2~\u0080\t"+
		"\3\2\2\177~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082"+
		"\3\2\2\2\u0082\37\3\2\2\2\17$+\63GKQ[ahluy\u0081";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}