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
 * Filename: BasePerForeignKeyTemplateBuildHandlerTest.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Tests for BasePerForeignKeyTemplateBuildHandler.
 *
 * Date: 2014/05/06
 * Time: 14:56
 *
 */
package org.acmsl.queryj.api.handlers;

/*
 * Importing JetBrains annotations.
 */
import org.acmsl.queryj.QueryJCommand;
import org.acmsl.queryj.api.PerForeignKeyTemplate;
import org.acmsl.queryj.api.PerForeignKeyTemplateFactory;
import org.acmsl.queryj.api.exceptions.QueryJBuildException;
import org.acmsl.queryj.metadata.engines.Engine;
import org.acmsl.queryj.metadata.vo.ForeignKey;
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;
import org.jetbrains.annotations.Nullable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

/**
 * Tests for {@link BasePerForeignKeyTemplateBuildHandler}.
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/05/06 14:56
 */
@RunWith(JUnit4.class)
public class BasePerForeignKeyTemplateBuildHandlerTest
{
    /**
     * Checks
     * @return such instance.
     */
    @Test
    public void decorate_creates_a_ForeignKeyDecorator()
    {
    }

    /**
     * Creates a new {@link BasePerForeignKeyTemplateBuildHandler} instance.
     * @return such instance.
     */
    @NotNull
    protected BasePerForeignKeyTemplateBuildHandler createHandler()
    {
        return
            new BasePerForeignKeyTemplateBuildHandler()
            {
                /**
                 * {@inheritDoc}
                 */
                @NotNull
                @Override
                protected PerForeignKeyTemplateFactory retrieveTemplateFactory()
                {
                    return null;
                }

                /**
                 * {@inheritDoc}
                 */
                @Nullable
                @Override
                protected PerForeignKeyTemplate createTemplate(
                    @NotNull final PerForeignKeyTemplateFactory templateFactory,
                    @NotNull final ForeignKey<String> foreignKey,
                    @NotNull final QueryJCommand parameters)
                {
                    return null;
                }

                /**
                 * {@inheritDoc}
                 */
                @NotNull
                @Override
                protected String retrievePackage(
                    @NotNull final ForeignKey<String> foreignKey,
                    @NotNull final Engine<String> engineName,
                    @NotNull final String projectPackage)
                {
                    return null;
                }

                /**
                 * {@inheritDoc}
                 */
                @Override
                protected void storeTemplates(
                    @NotNull final List templates, @NotNull final QueryJCommand parameters)
                {
                }
            };
    }
}
