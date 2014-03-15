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

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PerCommentParser}.
 */
public interface PerCommentListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PerCommentParser#tabStatic}.
	 * @param ctx the parse tree
	 */
	void enterTabStatic(@NotNull PerCommentParser.TabStaticContext ctx);
	/**
	 * Exit a parse tree produced by {@link PerCommentParser#tabStatic}.
	 * @param ctx the parse tree
	 */
	void exitTabStatic(@NotNull PerCommentParser.TabStaticContext ctx);

	/**
	 * Enter a parse tree produced by {@link PerCommentParser#colIsarefs}.
	 * @param ctx the parse tree
	 */
	void enterColIsarefs(@NotNull PerCommentParser.ColIsarefsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PerCommentParser#colIsarefs}.
	 * @param ctx the parse tree
	 */
	void exitColIsarefs(@NotNull PerCommentParser.ColIsarefsContext ctx);

	/**
	 * Enter a parse tree produced by {@link PerCommentParser#ident}.
	 * @param ctx the parse tree
	 */
	void enterIdent(@NotNull PerCommentParser.IdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PerCommentParser#ident}.
	 * @param ctx the parse tree
	 */
	void exitIdent(@NotNull PerCommentParser.IdentContext ctx);

	/**
	 * Enter a parse tree produced by {@link PerCommentParser#colAnnotation}.
	 * @param ctx the parse tree
	 */
	void enterColAnnotation(@NotNull PerCommentParser.ColAnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PerCommentParser#colAnnotation}.
	 * @param ctx the parse tree
	 */
	void exitColAnnotation(@NotNull PerCommentParser.ColAnnotationContext ctx);

	/**
	 * Enter a parse tree produced by {@link PerCommentParser#tabAnnotation}.
	 * @param ctx the parse tree
	 */
	void enterTabAnnotation(@NotNull PerCommentParser.TabAnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PerCommentParser#tabAnnotation}.
	 * @param ctx the parse tree
	 */
	void exitTabAnnotation(@NotNull PerCommentParser.TabAnnotationContext ctx);

	/**
	 * Enter a parse tree produced by {@link PerCommentParser#colBool}.
	 * @param ctx the parse tree
	 */
	void enterColBool(@NotNull PerCommentParser.ColBoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link PerCommentParser#colBool}.
	 * @param ctx the parse tree
	 */
	void exitColBool(@NotNull PerCommentParser.ColBoolContext ctx);

	/**
	 * Enter a parse tree produced by {@link PerCommentParser#tabIsa}.
	 * @param ctx the parse tree
	 */
	void enterTabIsa(@NotNull PerCommentParser.TabIsaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PerCommentParser#tabIsa}.
	 * @param ctx the parse tree
	 */
	void exitTabIsa(@NotNull PerCommentParser.TabIsaContext ctx);

	/**
	 * Enter a parse tree produced by {@link PerCommentParser#tableComment}.
	 * @param ctx the parse tree
	 */
	void enterTableComment(@NotNull PerCommentParser.TableCommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PerCommentParser#tableComment}.
	 * @param ctx the parse tree
	 */
	void exitTableComment(@NotNull PerCommentParser.TableCommentContext ctx);

	/**
	 * Enter a parse tree produced by {@link PerCommentParser#colReadonly}.
	 * @param ctx the parse tree
	 */
	void enterColReadonly(@NotNull PerCommentParser.ColReadonlyContext ctx);
	/**
	 * Exit a parse tree produced by {@link PerCommentParser#colReadonly}.
	 * @param ctx the parse tree
	 */
	void exitColReadonly(@NotNull PerCommentParser.ColReadonlyContext ctx);

	/**
	 * Enter a parse tree produced by {@link PerCommentParser#tabIsatype}.
	 * @param ctx the parse tree
	 */
	void enterTabIsatype(@NotNull PerCommentParser.TabIsatypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PerCommentParser#tabIsatype}.
	 * @param ctx the parse tree
	 */
	void exitTabIsatype(@NotNull PerCommentParser.TabIsatypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link PerCommentParser#freeText}.
	 * @param ctx the parse tree
	 */
	void enterFreeText(@NotNull PerCommentParser.FreeTextContext ctx);
	/**
	 * Exit a parse tree produced by {@link PerCommentParser#freeText}.
	 * @param ctx the parse tree
	 */
	void exitFreeText(@NotNull PerCommentParser.FreeTextContext ctx);

	/**
	 * Enter a parse tree produced by {@link PerCommentParser#tabDecorator}.
	 * @param ctx the parse tree
	 */
	void enterTabDecorator(@NotNull PerCommentParser.TabDecoratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PerCommentParser#tabDecorator}.
	 * @param ctx the parse tree
	 */
	void exitTabDecorator(@NotNull PerCommentParser.TabDecoratorContext ctx);

	/**
	 * Enter a parse tree produced by {@link PerCommentParser#tabRelationship}.
	 * @param ctx the parse tree
	 */
	void enterTabRelationship(@NotNull PerCommentParser.TabRelationshipContext ctx);
	/**
	 * Exit a parse tree produced by {@link PerCommentParser#tabRelationship}.
	 * @param ctx the parse tree
	 */
	void exitTabRelationship(@NotNull PerCommentParser.TabRelationshipContext ctx);

	/**
	 * Enter a parse tree produced by {@link PerCommentParser#columnComment}.
	 * @param ctx the parse tree
	 */
	void enterColumnComment(@NotNull PerCommentParser.ColumnCommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PerCommentParser#columnComment}.
	 * @param ctx the parse tree
	 */
	void exitColumnComment(@NotNull PerCommentParser.ColumnCommentContext ctx);

	/**
	 * Enter a parse tree produced by {@link PerCommentParser#colOraseq}.
	 * @param ctx the parse tree
	 */
	void enterColOraseq(@NotNull PerCommentParser.ColOraseqContext ctx);
	/**
	 * Exit a parse tree produced by {@link PerCommentParser#colOraseq}.
	 * @param ctx the parse tree
	 */
	void exitColOraseq(@NotNull PerCommentParser.ColOraseqContext ctx);
}