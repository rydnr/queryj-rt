// Generated from org/acmsl/queryj/templates/packaging/antlr/TemplateDef.g4 by ANTLR 4.2
package org.acmsl.queryj.templates.packaging.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TemplateDefParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TemplateDefVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TemplateDefParser#typeRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeRule(@NotNull TemplateDefParser.TypeRuleContext ctx);

	/**
	 * Visit a parse tree produced by {@link TemplateDefParser#disabledRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisabledRule(@NotNull TemplateDefParser.DisabledRuleContext ctx);

	/**
	 * Visit a parse tree produced by {@link TemplateDefParser#templateDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplateDef(@NotNull TemplateDefParser.TemplateDefContext ctx);

	/**
	 * Visit a parse tree produced by {@link TemplateDefParser#outputRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutputRule(@NotNull TemplateDefParser.OutputRuleContext ctx);

	/**
	 * Visit a parse tree produced by {@link TemplateDefParser#nameRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNameRule(@NotNull TemplateDefParser.NameRuleContext ctx);

	/**
	 * Visit a parse tree produced by {@link TemplateDefParser#filenameBuilderRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilenameBuilderRule(@NotNull TemplateDefParser.FilenameBuilderRuleContext ctx);

	/**
	 * Visit a parse tree produced by {@link TemplateDefParser#packageRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageRule(@NotNull TemplateDefParser.PackageRuleContext ctx);
}