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
 * Filename: TemplateDefPerTableFillTemplateChainFactoryImpl.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: 
 *
 * Date: 2014/05/31
 * Time: 08:35
 *
 */
package org.acmsl.queryj.templates.packaging;

/*
 * Importing JetBrains annotations.
 */
import org.acmsl.queryj.api.FillTemplateChain;
import org.acmsl.queryj.api.PerTableTemplateContext;
import org.acmsl.queryj.placeholders.BasePerTableFillTemplateChain;
import org.acmsl.queryj.placeholders.FillTemplateChainWrapper;
import org.acmsl.queryj.placeholders.PerTableFillTemplateChainFactoryImpl;
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;
import org.jetbrains.annotations.Nullable;

/**
 * Creates the chain to provide all per-table placeholders.
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/05/31 08:35
 */
@ThreadSafe
public class TemplateDefPerTableFillTemplateChainFactoryImpl
    extends PerTableFillTemplateChainFactoryImpl
{
    /**
     * Creates {@link org.acmsl.queryj.api.FillTemplateChain} instances for given context.
     * @param context the {@link org.acmsl.queryj.api.PerTableTemplateContext} needed.
     * @return the FillTemplateChain, or {@code null} if the context is invalid.
     */
    @Nullable
    @Override
    public FillTemplateChain<PerTableTemplateContext> createFillChain(
        @NotNull final PerTableTemplateContext context)
    {
        return
            new FillTemplateChainWrapper<>(
                new TemplateDefPerTableFillTemplateChain(context));
    }
}
