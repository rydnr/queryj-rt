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
 * Filename: BasePerCustomResultTemplateBuildHandlerTest.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: 
 *
 * Date: 2014/05/17
 * Time: 12:30
 *
 */
package org.acmsl.queryj.api.handlers;

/*
 * Importing JetBrains annotations.
 */
import org.acmsl.queryj.QueryJCommand;
import org.acmsl.queryj.api.PerCustomResultTemplate;
import org.acmsl.queryj.api.PerCustomResultTemplateFactory;
import org.acmsl.queryj.api.exceptions.QueryJBuildException;
import org.acmsl.queryj.customsql.CustomSqlProvider;
import org.acmsl.queryj.customsql.Property;
import org.acmsl.queryj.customsql.Result;
import org.acmsl.queryj.metadata.MetadataManager;
import org.acmsl.queryj.metadata.engines.Engine;
import org.jetbrains.annotations.NotNull;

/*
 * Importing JUnit classes.
 */
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

/**
 *
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/05/17 12:30
 */
@RunWith(JUnit4.class)
public class BasePerCustomResultTemplateBuildHandlerTest
{
    @Test
    public void fixDuplicated_removes_extra_results_differing_only_in_cardinality()
    {
        @NotNull final BasePerCustomResultTemplateBuildHandler instance =
            new BasePerCustomResultTemplateBuildHandler()
            {
                @Override
                protected PerCustomResultTemplateFactory retrieveTemplateFactory()
                {
                    return null;
                }

                @Override
                protected PerCustomResultTemplate createTemplate(
                    @NotNull final PerCustomResultTemplateFactory templateFactory,
                    @NotNull final Result<String> result,
                    @NotNull final List<Property<String>> properties,
                    @NotNull final QueryJCommand parameters)
                {
                    return null;
                }

                @Override
                protected String retrievePackage(@NotNull final Result<String> customResult, @NotNull final
                CustomSqlProvider customSqlProvider, @NotNull final MetadataManager metadataManager,
                                                 @NotNull final Engine<String> engine, @NotNull final QueryJCommand
                    parameters)
                    throws QueryJBuildException
                {
                    return null;  //To change body of implemented methods use File | Settings | File Templates.
                }

                @Override
                protected void storeTemplates(@NotNull final List templates, @NotNull final QueryJCommand parameters)
                {
                    //To change body of implemented methods use File | Settings | File Templates.
                }
            }
    }
}
