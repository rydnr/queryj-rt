/*
                        QueryJ Template Packaging

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
 * Filename: TemplateDefPerRepositoryFillTemplateChainFactoryImpl.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Creates the chain to provide all per-repository placeholders,
 *              with access to the TemplateDef information.
 *
 * Date: 2014/06/06
 * Time: 18:21
 *
 */
package org.acmsl.queryj.templates.packaging;

/*
 * Importing JetBrains annotations.
 */
import org.acmsl.queryj.api.FillTemplateChain;
import org.acmsl.queryj.placeholders.FillTemplateChainWrapper;
import org.acmsl.queryj.placeholders.PerRepositoryFillTemplateChainFactoryImpl;
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;
import org.jetbrains.annotations.Nullable;

/**
 * Creates the chain to provide all per-table placeholders, with access to the
 * {@link TemplateDef} information.
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/06/06 18:21
 */
@ThreadSafe
@SuppressWarnings("unused")
public class TemplateDefPerRepositoryFillTemplateChainFactoryImpl
    extends PerRepositoryFillTemplateChainFactoryImpl<TemplateDefPerRepositoryTemplateContext>
{
    /**
     * Creates {@link org.acmsl.queryj.api.FillTemplateChain} instances for given context.
     * @param context the {@link org.acmsl.queryj.api.PerRepositoryTemplateContext} needed.
     * @return the FillTemplateChain, or {@code null} if the context is invalid.
     */
    @Nullable
    @Override
    public FillTemplateChain<TemplateDefPerRepositoryTemplateContext> createFillChain(
        @NotNull final TemplateDefPerRepositoryTemplateContext context)
    {
        return
            new FillTemplateChainWrapper<>(
                new TemplateDefPerRepositoryFillTemplateChain(context));
    }
}
