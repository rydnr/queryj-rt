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
 * Filename: NullAttributeWhenConvertingToPropertyException.java
 *
 * Author: Jose San Leandro Armendariz (chous)
 *
 * Description: A null attribute was found when converting attributes to
 *              (implicit) properties.
 *
 * Date: 2013/08/04
 * Time: 10:14
 *
 */
package org.acmsl.queryj.api.exceptions;

/*
 * Importing QueryJ-Core classes.
 */
import org.acmsl.queryj.customsql.Result;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;

/*
 * Importing JetBrains annotations.
 */
import org.jetbrains.annotations.NotNull;

/**
 * A null attribute was found when converting attributes to (implicit)
 * properties.
 * @author <a href="mailto:chous@acm-sl.org">Jose San Leandro</a>
 * @since 2013/08/04
 */
@ThreadSafe
@SuppressWarnings("unused")
public class NullAttributeWhenConvertingToPropertyException
    extends QueryJNonCheckedException
{
    private static final long serialVersionUID = -1912316398509090418L;

    /**
     * Creates the exception with the {@link Result}.
     * @param customResult the custom SQL result.
     */
    public NullAttributeWhenConvertingToPropertyException(@NotNull final Result<?> customResult)
    {
        super("null.attribute.when.converting.to.property", new Object[] { customResult.getId() });
    }
}
