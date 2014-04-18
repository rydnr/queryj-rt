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
 * Filename: PerSqlTemplate.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: 
 *
 * Date: 2014/04/18
 * Time: 08:51
 *
 */
package org.acmsl.queryj.api;

/*
 * Importing JetBrains annotations.
 */
import org.acmsl.queryj.api.exceptions.InvalidTemplateException;
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;
import org.stringtemplate.v4.ST;

/**
 * Templ
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/04/18 08:51
 */
@ThreadSafe
public interface PerSqlTemplate<C extends PerSqlTemplateContext>
    extends  QueryJTemplate<C>
{
    /**
     * Builds a context-specific exception.
     * @param context  the context.
     * @param template the {@link org.stringtemplate.v4.ST} instance.
     * @param actualException the actual exception.
     * @return the specific {@link org.acmsl.queryj.api.exceptions.InvalidTemplateException} for the template.
     */
    @SuppressWarnings("unused")
    @NotNull
    public InvalidTemplateException buildInvalidTemplateException(
        @NotNull final C context,
        @NotNull final ST template,
        @NotNull final Throwable actualException);
}