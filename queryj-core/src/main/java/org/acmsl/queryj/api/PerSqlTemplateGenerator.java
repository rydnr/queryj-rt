/*
                        QueryJ Core

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
 * Filename: PerSqlTemplateGenerator.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Entities responsible of generating PerSqlTemplates.
 *
 * Date: 2014/04/18
 * Time: 08:49
 *
 */
package org.acmsl.queryj.api;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;

/**
 * Entities responsible of generating {@link PerSqlTemplate}s.
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/04/18 08:49
 */
@ThreadSafe
public interface PerSqlTemplateGenerator
    <N extends PerSqlTemplate<C>, C extends PerSqlTemplateContext>
    extends TemplateGenerator<N, C>
{
}
