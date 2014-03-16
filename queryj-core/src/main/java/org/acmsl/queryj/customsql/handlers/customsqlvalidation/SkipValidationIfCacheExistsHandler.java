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
 * Filename: SkipValidationIfCacheExistsHandler.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: 
 *
 * Date: 2014/03/16
 * Time: 16:39
 *
 */
package org.acmsl.queryj.customsql.handlers.customsqlvalidation;

/*
 * Importing JetBrains annotations.
 */
import org.acmsl.commons.utils.io.FileUtils;
import org.acmsl.queryj.QueryJCommand;
import org.acmsl.queryj.api.exceptions.QueryJBuildException;
import org.acmsl.queryj.customsql.CustomSqlProvider;
import org.acmsl.queryj.customsql.Sql;
import org.acmsl.queryj.tools.handlers.AbstractQueryJCommandHandler;
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;

import java.io.File;
import java.nio.charset.Charset;

/**
 *
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/03/16 16:39
 */
@ThreadSafe
public class SkipValidationIfCacheExistsHandler
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
        @NotNull final Sql<String> t_Sql = new RetrieveQueryHandler().retrieveCurrentSql(command);

        return validationCacheFound(t_Sql, command, new CacheValidationOutcomeHandler());
    }

    protected boolean validationCacheFound(
        @NotNull final Sql<String> sql,
        @NotNull final QueryJCommand command,
        @NotNull final CacheValidationOutcomeHandler handler)
        throws QueryJBuildException
    {
        final boolean result;

        @NotNull final File outputFolder = handler.retrieveOutputFolderForSqlHashes(command);

        @NotNull final Charset charset = retrieveCharset(command);

        result = hashExists(outputFolder, charset);

        return result;
    }

    private boolean hashExists(final File outputFolder, final Charset charset)
    {
        @NotNull final String path = hashPath(outputFolder.getAbsolutePath(), hash);

        if (!existsAlready(path))
        {
            new File(outputFolder.getAbsolutePath()).mkdirs();
            FileUtils.getInstance().writeFileIfPossible(path, "", charset);
        }
    }
}
