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
 * Filename: BasePerRepositoryTemplateWritingHandler.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Writes per-repository templates.
 *
 */
package org.acmsl.queryj.api.handlers;

/*
 * Importing some project classes.
 */
import org.acmsl.queryj.QueryJCommand;
import org.acmsl.queryj.api.PerRepositoryTemplateGenerator;
import org.acmsl.queryj.api.AbstractBasePerRepositoryTemplate;
import org.acmsl.queryj.api.PerRepositoryTemplateContext;
import org.acmsl.queryj.api.exceptions.QueryJBuildException;
import org.acmsl.queryj.metadata.engines.Engine;

/*
 * Importing some JetBrains annotations.
 */
import org.jetbrains.annotations.NotNull;

/*
 * Importing some JDK classes.
 */
import java.io.File;

/**
 * Writes <i>per-repository</i> templates.
 * @author <a href="mailto:chous@acm-sl.org">Jose San Leandro Armendariz</a>
 */
public abstract class BasePerRepositoryTemplateWritingHandler
    <T extends AbstractBasePerRepositoryTemplate<C>,
     C extends PerRepositoryTemplateContext,
     G extends PerRepositoryTemplateGenerator<T, C>>
    extends    AbstractQueryJTemplateWritingHandler<T, C, G>
    implements TemplateWritingHandler
{
    /**
     * Creates a <code>BasePerRepositoryTemplateWritingHandler</code> instance.
     */
    public BasePerRepositoryTemplateWritingHandler() {}

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    protected File retrieveOutputDir(
        @NotNull final C context,
        @NotNull final File rootDir,
        @NotNull final QueryJCommand parameters)
        throws QueryJBuildException
    {
        return
            retrieveOutputDir(
                context,
                rootDir,
                retrieveEngine(parameters, retrieveDatabaseMetaData(parameters)),
                parameters);
    }

    /**
     * Retrieves the output dir from the attribute map.
     * @param projectFolder the project folder.
     * using a different package naming scheme.
     * @param engine the engine.
     * @param parameters the parameter map.
     * @return such folder.
     */
    @NotNull
    protected abstract File retrieveOutputDir(
        @NotNull final C context,
        @NotNull final File projectFolder,
        @NotNull final Engine<String> engine,
        @NotNull final QueryJCommand parameters);
}
