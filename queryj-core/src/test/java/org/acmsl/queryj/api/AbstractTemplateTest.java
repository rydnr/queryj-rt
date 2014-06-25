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
 * Importing JetBrains annotations.
 */
import org.acmsl.queryj.api.exceptions.InvalidPerTableTemplateException;
import org.acmsl.queryj.api.exceptions.InvalidTemplateException;
import org.easymock.EasyMock;
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;
import org.jetbrains.annotations.Nullable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

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
     */
    @Test
    public void generateOutput_calls_TemplateDebuggingService_when_debugging()
    {
        @NotNull final TemplateContext templateContext = EasyMock.createNiceMock(TemplateContext.class);

        @NotNull final AbstractTemplate<TemplateContext> instance =
            new AbstractTemplate<TemplateContext>(templateContext, "org.acmsl.queryj.placeholders", true)
            {
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
                        new InvalidPerTableTemplateException("name", "tableName", "repository", null) {};
                }

                /**
                 * {@inheritDoc}
                 */
                @Nullable
                @Override
                public STGroup retrieveGroup()
                {
                    return null;
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
            }
    }
}
