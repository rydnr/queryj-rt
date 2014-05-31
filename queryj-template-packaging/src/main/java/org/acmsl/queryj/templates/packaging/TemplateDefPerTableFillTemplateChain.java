/*
                        queryj

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
 * Filename: TemplateDefPerTableFillTemplateChain.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: 
 *
 * Date: 2014/05/31
 * Time: 08:39
 *
 */
package org.acmsl.queryj.templates.packaging;

/*
 * Importing JetBrains annotations.
 */
import org.acmsl.queryj.QueryJCommand;
import org.acmsl.queryj.api.AbstractFillTemplateChain;
import org.acmsl.queryj.api.FillTemplateChain;
import org.acmsl.queryj.api.PerTableTemplateContext;
import org.acmsl.queryj.api.TemplateContext;
import org.acmsl.queryj.api.exceptions.QueryJBuildException;
import org.acmsl.queryj.api.handlers.TemplateContextFillAdapterHandler;
import org.acmsl.queryj.api.handlers.fillhandlers.FillHandler;
import org.acmsl.queryj.placeholders.CustomResultsHandler;
import org.acmsl.queryj.placeholders.DAOClassNameHandler;
import org.acmsl.queryj.placeholders.DAOFactoryClassNameHandler;
import org.acmsl.queryj.placeholders.DAOImplementationClassNameHandler;
import org.acmsl.queryj.placeholders.FillTemplateChainWrapper;
import org.acmsl.queryj.placeholders.ForeignKeyListHandler;
import org.acmsl.queryj.placeholders.NonPrimaryKeyAttributesHandler;
import org.acmsl.queryj.placeholders.PrimaryKeyHandler;
import org.acmsl.queryj.placeholders.StaticValuesHandler;
import org.acmsl.queryj.placeholders.TableAttributeTypeImportsHandler;
import org.acmsl.queryj.placeholders.TableHandler;
import org.acmsl.queryj.placeholders.TableNameHandler;
import org.acmsl.queryj.placeholders.ValueObjectNameHandler;
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/05/31 08:39
 */
@ThreadSafe
public class TemplateDefPerTableFillTemplateChain
    extends AbstractFillTemplateChain<TemplateDefPerTableTemplateContext>
{
    /**
     * Creates a {@link PerTableFillTemplateChain} using given context.
     * @param context the {@link org.acmsl.queryj.api.PerTableTemplateContext context}.
     */
    public TemplateDefPerTableFillTemplateChain(@NotNull final TemplateDefPerTableTemplateContext context)
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
