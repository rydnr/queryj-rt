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
 * Filename: StaticValuesHandler.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: 
 *
 * Date: 2014/03/27
 * Time: 07:21
 *
 */
package org.acmsl.queryj.placeholders;

/*
 * Importing JetBrains annotations.
 */
import org.acmsl.queryj.api.PerTableTemplateContext;
import org.acmsl.queryj.api.exceptions.QueryJBuildException;
import org.acmsl.queryj.metadata.vo.Row;
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Resolves the static
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/03/27 07:21
 */
@ThreadSafe
public class StaticValuesHandler
    extends AbstractTemplateContextFillHandler<PerTableTemplateContext, List<Row<String>>>
{
    public StaticValuesHandler(@NotNull final PerTableTemplateContext context)
    {
        super(context);
    }

    /**
     * Retrieves the static rows for the table.
     * @return such rows.
     */
    @NotNull
    @Override
    protected List<Row<String>> getValue(@NotNull final PerTableTemplateContext context)
        throws QueryJBuildException
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieves "static_values".
     * @return such placeholder.
     */
    @NotNull
    @Override
    public String getPlaceHolder()
    {
        return "static_values";
    }
}
