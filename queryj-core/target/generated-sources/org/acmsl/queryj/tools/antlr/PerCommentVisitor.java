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
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PerCommentParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PerCommentVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PerCommentParser#tabStatic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTabStatic(@NotNull PerCommentParser.TabStaticContext ctx);

	/**
	 * Visit a parse tree produced by {@link PerCommentParser#colIsarefs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColIsarefs(@NotNull PerCommentParser.ColIsarefsContext ctx);

	/**
	 * Visit a parse tree produced by {@link PerCommentParser#ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdent(@NotNull PerCommentParser.IdentContext ctx);

	/**
	 * Visit a parse tree produced by {@link PerCommentParser#colAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColAnnotation(@NotNull PerCommentParser.ColAnnotationContext ctx);

	/**
	 * Visit a parse tree produced by {@link PerCommentParser#tabAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTabAnnotation(@NotNull PerCommentParser.TabAnnotationContext ctx);

	/**
	 * Visit a parse tree produced by {@link PerCommentParser#colBool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColBool(@NotNull PerCommentParser.ColBoolContext ctx);

	/**
	 * Visit a parse tree produced by {@link PerCommentParser#tabIsa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTabIsa(@NotNull PerCommentParser.TabIsaContext ctx);

	/**
	 * Visit a parse tree produced by {@link PerCommentParser#tableComment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableComment(@NotNull PerCommentParser.TableCommentContext ctx);

	/**
	 * Visit a parse tree produced by {@link PerCommentParser#colReadonly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColReadonly(@NotNull PerCommentParser.ColReadonlyContext ctx);

	/**
	 * Visit a parse tree produced by {@link PerCommentParser#tabIsatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTabIsatype(@NotNull PerCommentParser.TabIsatypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link PerCommentParser#freeText}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFreeText(@NotNull PerCommentParser.FreeTextContext ctx);

	/**
	 * Visit a parse tree produced by {@link PerCommentParser#tabDecorator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTabDecorator(@NotNull PerCommentParser.TabDecoratorContext ctx);

	/**
	 * Visit a parse tree produced by {@link PerCommentParser#tabRelationship}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTabRelationship(@NotNull PerCommentParser.TabRelationshipContext ctx);

	/**
	 * Visit a parse tree produced by {@link PerCommentParser#columnComment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnComment(@NotNull PerCommentParser.ColumnCommentContext ctx);

	/**
	 * Visit a parse tree produced by {@link PerCommentParser#colOraseq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColOraseq(@NotNull PerCommentParser.ColOraseqContext ctx);
}