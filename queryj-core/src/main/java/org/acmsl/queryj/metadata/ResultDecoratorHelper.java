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
 * Filename: ResultDecoratorHelper.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: 
 *
 * Date: 2014/05/13
 * Time: 08:06
 *
 */
package org.acmsl.queryj.metadata;

/*
 * Importing JetBrains annotations.
 */
import org.acmsl.queryj.customsql.Property;
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;

import java.util.List;

/**
 *
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/05/13 08:06
 */
@ThreadSafe
public class ResultDecoratorHelper
{
    /**
     * Default constructor.
     */
    public ResultDecoratorHelper() {}

    /**
     * Singleton to avoid double-check locking.
     */
    private static final class ResultDecoratorHelperSingletonContainer
    {
        /**
         * The singleton instance.
         */
        public static final ResultDecoratorHelper SINGLETON = new ResultDecoratorHelper();
    }

    /**
     * Retrieves the singleton instance.
     * @return such instance.
     */
    public static ResultDecoratorHelper getInstance()
    {
        return ResultDecoratorHelperSingletonContainer.SINGLETON;
    }

    /**
     * Checks whether given {@link Property} list contains nullable items or not.
     * @param properties the properties.
     * @return {@code true} in such case.
     */
    public boolean containNullableProperties(final List<Property<DecoratedString>> properties)
    {
        return false;  //To change body of created methods use File | Settings | File Templates.
    }

}
