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
 * Filename: AbstractTemplateTest.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Tests for AbstractTemplate.
 *
 * Date: 2014/06/25
 * Time: 15:29
 *
 */
package org.acmsl.queryj.api;

/*
 * Importing QueryJ Core classes.
 */
import org.acmsl.queryj.api.AbstractTemplateGeneratorTest.DoNothingDebuggingService;
import org.acmsl.queryj.api.exceptions.InvalidPerTableTemplateException;
import org.acmsl.queryj.api.exceptions.InvalidTemplateException;

/*
 * Importing JUnit4 classes.
 */
import org.acmsl.queryj.api.exceptions.QueryJBuildException;
import org.acmsl.queryj.api.handlers.fillhandlers.FillHandler;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

/*
 * Importing JetBrains annotations.
 */
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Importing JUnit/EasyMock classes.
 */
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

/**
 * Tests for {@link AbstractTemplate}.
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/06/25 15:29
 */
@RunWith(JUnit4.class)
public class AbstractTemplateTest
{
    /**
     * Checks generateOutput() calls TemplateDebuggingService.debug() in
     * a debugging session.
     * throws Exception if the test fails.
     */
    @Test
    public void generateOutput_calls_TemplateDebuggingService_when_debugging()
    throws  Exception
    {
        @NotNull final TemplateContext templateContext = EasyMock.createNiceMock(TemplateContext.class);

        @NotNull final AbstractTemplate<TemplateContext> instance =
            new AbstractTemplate<TemplateContext>(templateContext, "org.acmsl.queryj.placeholders", true)
            {
                /**
                 * An empty array list.
                 */
                @NotNull
                public final List<FillTemplateChain<? extends FillHandler<?>>> emptyList = new ArrayList<>(0);

                /**
                 * {@inheritDoc}
                 */
                @NotNull
                @Override
                public InvalidTemplateException buildInvalidTemplateException(
                    @NotNull final TemplateContext context,
                    @NotNull final ST template,
                    @NotNull final Throwable actualException)
                {
                    return
                        new InvalidPerTableTemplateException(
                            "name", "tableName", "repository", EasyMock.createNiceMock(Throwable.class)) {};
                }

                /**
                 * {@inheritDoc}
                 */
                @Nullable
                @Override
                public STGroup retrieveGroup()
                {
                    @NotNull final STGroup result = EasyMock.createNiceMock(STGroup.class);

                    @NotNull final ST template = EasyMock.createNiceMock(ST.class);

                    EasyMock.expect(result.getInstanceOf("source")).andReturn(template);
                    EasyMock.replay(result);

                    EasyMock.expect(template.add(CONTEXT, emptyList));
                    EasyMock.replay(template);

                    return result;
                }

                /**
                 * {@inheritDoc}
                 * @return
                 */
                @NotNull
                @Override
                public String getTemplateName()
                {
                    return "test";
                }

                /**
                 * {@inheritDoc}
                 */
                @Override
                @NotNull
                public List<FillTemplateChain<? extends FillHandler<?>>> buildFillTemplateChains(
                    @NotNull final TemplateContext context)
                {
                    return emptyList;
                }
            };

        @NotNull final DoNothingDebuggingService<TemplateContext> templateDebuggingService =
            new DoNothingDebuggingService<>();

        instance.generate(false, templateDebuggingService);

        Assert.assertTrue(templateDebuggingService.called);
    }
}
