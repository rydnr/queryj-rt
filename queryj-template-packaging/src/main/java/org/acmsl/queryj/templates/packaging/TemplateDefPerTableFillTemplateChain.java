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
import org.acmsl.queryj.api.FillTemplateChain;
import org.acmsl.queryj.api.PerTableTemplateContext;
import org.acmsl.queryj.api.TemplateContext;
import org.acmsl.queryj.api.exceptions.QueryJBuildException;
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;

import java.util.List;

/**
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/05/31 08:39
 */
@ThreadSafe
public class TemplateDefPerTableFillTemplateChain
    implements FillTemplateChain<TemplateDefPerTableTemplateContext>
{
    public TemplateDefPerTableFillTemplateChain(final TemplateDefPerTableTemplateContext context)
    {
        super(context);
    }

    /**
     * Retrieves the handlers.
     *
     * @return such handlers.
     */
    @NotNull
    @Override
    public List<?> getHandlers()
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieves the template context.
     *
     * @return such information.
     */
    @NotNull
    @Override
    public TemplateDefPerTableTemplateContext getTemplateContext()
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Performs the required processing.
     *
     * @param relevantOnly to include only the relevant ones: the ones that are necessary to
     *                     be able to find out if two template realizations are equivalent. Usually,
     *                     generation timestamps,
     *                     documentation, etc. can be considered not relevant.
     */
    @NotNull
    @Override
    public QueryJCommand providePlaceholders(final boolean relevantOnly) throws QueryJBuildException
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
