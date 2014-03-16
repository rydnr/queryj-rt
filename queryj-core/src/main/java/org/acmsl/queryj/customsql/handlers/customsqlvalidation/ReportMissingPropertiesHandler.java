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
 * Filename: ReportMissingPropertiesHandler.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: 
 *
 * Date: 2014/03/16
 * Time: 10:34
 *
 */
package org.acmsl.queryj.customsql.handlers.customsqlvalidation;

/*
 * Importing JetBrains annotations.
 */
import org.acmsl.commons.logging.UniqueLogFactory;
import org.acmsl.queryj.QueryJCommand;
import org.acmsl.queryj.api.exceptions.QueryJBuildException;
import org.acmsl.queryj.customsql.Property;
import org.acmsl.queryj.customsql.Sql;
import org.acmsl.queryj.customsql.handlers.CustomSqlValidationHandler;
import org.acmsl.queryj.tools.handlers.AbstractQueryJCommandHandler;
import org.apache.commons.logging.Log;
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 *
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/03/16 10:34
 */
@ThreadSafe
public class ReportMissingPropertiesHandler
    extends AbstractQueryJCommandHandler
{
    /**
     * Asks the handler to process the command. The idea is that each
     * command handler decides if such command is suitable of being
     * processed, and if so perform the concrete actions the command
     * represents.
     *
     * @param command the command to process (or not).
     * @return <code>true</code> if the handler actually process the command,
     *         or maybe because it's not desirable to continue the chain.
     */
    @Override
    public boolean handle(@NotNull final QueryJCommand command) throws QueryJBuildException
    {
        return true;
    }

    /**
     * Reports any undeclared property.
     * @param properties the declared properties.
     * @param columns the properties from the result set.
     * @param sql the query itself.
     */
    protected void diagnoseMissingProperties(
        @NotNull final List<Property<String>> properties,
        @NotNull final List<Property<String>> columns,
        @NotNull final Sql<String> sql)
    {
        @Nullable final Log t_Log = UniqueLogFactory.getLog(CustomSqlValidationHandler.class);

        if (t_Log != null)
        {
            @NotNull final List<Property<String>> t_lMissingProperties =
                detectMissingProperties(properties, columns);

            int t_iIndex = 1;

            for (@Nullable final Property<String> t_MissingProperty : t_lMissingProperties)
            {
                if  (t_MissingProperty != null)
                {
                    t_Log.warn(
                        "Column not declared ("
                        + t_iIndex + ", "
                        + t_MissingProperty.getColumnName() + ", "
                        + t_MissingProperty.getType() + "), in sql "
                        + sql.getId());
                }

                t_iIndex++;
            }
        }
    }

}
