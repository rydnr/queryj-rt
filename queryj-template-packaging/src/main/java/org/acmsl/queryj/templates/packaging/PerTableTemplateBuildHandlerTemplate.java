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
 * Filename: PerTableTemplateBuildHandlerTemplate.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Template for per-table template build handlers.
 *
 * Date: 2014/04/29
 * Time: 05:56
 *
 */
package org.acmsl.queryj.templates.packaging;

/*
 * Importing JetBrains annotations.
 */
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;

/**
 * Template for per-table template build handlers.
 * @param <C> the template packaging context type.
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/04/29 05:56
 */
@ThreadSafe
public class PerTableTemplateBuildHandlerTemplate<C extends TemplatePackagingContext>
    extends TemplateBuildHandlerTemplate<C>
{
    /**
     * The serial version id.
     */
    private static final long serialVersionUID = 9122581776783678705L;

    /**
     * Creates a new instance using given context.
     * @param context the context.
     */
    public PerTableTemplateBuildHandlerTemplate(@NotNull final C context)
    {
        super(context);
    }

    /**
     * Retrieves the template name.
     * @return "PerTableTemplateBuildHandler".
     */
    @NotNull
    @Override
    public String getTemplateName()
    {
        return Literals.PER_TABLE_TEMPLATE_BUILD_HANDLER;
    }
}
