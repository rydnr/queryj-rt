/*
                        QueryJ

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
    Contact info: jose.sanleandro@acm-sl.com

 ******************************************************************************
 *
 * Filename: BasePerCustomResultFillTemplateChain.java
 *
 * Author: Jose San Leandro Armendariz (chous)
 *
 * Description: Sets up the chain required to provide placeholder replacements
 *              for per-custom-result templates.
 *
 * Date: 6/17/12
 * Time: 12:38 PM
 *
 */
package org.acmsl.queryj.api.handlers.fillhandlers;

/*
 *Importing project classes.
*/
import org.acmsl.queryj.QueryJCommand;
import org.acmsl.queryj.api.FillTemplateChain;
import org.acmsl.queryj.api.PerCustomResultTemplateContext;
import org.acmsl.queryj.api.PerTableTemplateContext;
import org.acmsl.queryj.api.exceptions.QueryJBuildException;
import org.acmsl.queryj.api.handlers.TemplateContextFillAdapterHandler;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Sets up the chain required to provide placeholder replacements for
 * {@link org.acmsl.queryj.api.PerCustomResultTemplate per-custom-result templates}.
 * @author <a href="mailto:chous@acm-sl.org">chous</a>
 * @since 3.0
 * Created: 2012/06/17
 */
public class BasePerCustomResultFillTemplateChain<BC extends PerCustomResultTemplateContext>
    implements FillTemplateChain<BC>
{
    /**
     * Creates a {@code BasePerTableFillTemplateChain} using given context.
     * @param context the {@link org.acmsl.queryj.api.PerTableTemplateContext context}.
     */
    public BasePerTableFillTemplateChain(@NotNull final C context)
    {
        super(context);
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public QueryJCommand providePlaceholders(final boolean relevantOnly)
        throws QueryJBuildException
    {
        return new FillTemplateChainWrapper<>(this).providePlaceholders(relevantOnly);
    }

    /**
     * Retrieves the additional per-table handlers.
     * @param context the {@link org.acmsl.queryj.api.PerTableTemplateContext context}.
     * @return such handlers.
     */
    @NotNull
    @Override
    protected List<FillHandler<?>> getHandlers(@NotNull final PerTableTemplateContext context)
    {
        @NotNull final List<FillHandler<?>> result = new ArrayList<>(12);

        result.add(
            new TemplateContextFillAdapterHandler<>(
                new CustomResultsHandler(context)));

        result.add(
            new TemplateContextFillAdapterHandler<>(
                new DAOClassNameHandler(context)));

        result.add(
            new TemplateContextFillAdapterHandler<>(
                new DAOImplementationClassNameHandler(context)));

        result.add(
            new TemplateContextFillAdapterHandler<>(
                new DAOFactoryClassNameHandler(context)));

        result.add(
            new TemplateContextFillAdapterHandler<>(
                new ForeignKeyListHandler(context)));

        result.add(
            new TemplateContextFillAdapterHandler<>(
                new NonPrimaryKeyAttributesHandler(context)));

        result.add(
            new TemplateContextFillAdapterHandler<>(
                new PrimaryKeyHandler(context)));

        result.add(
            new TemplateContextFillAdapterHandler<>(
                new TableHandler(context)));

        result.add(
            new TemplateContextFillAdapterHandler<>(
                new TableNameHandler(context)));

        result.add(
            new TemplateContextFillAdapterHandler<>(
                new ValueObjectNameHandler(context)));

        result.add(
            new TemplateContextFillAdapterHandler<>(
                new TableAttributeTypeImportsHandler(context)));

        result.add(
            new TemplateContextFillAdapterHandler<>(
                new StaticValuesHandler(context)));

        return result;
    }

}
