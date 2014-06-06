/*
                        QueryJ Template Packaging

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
 * Filename: TemplateDefPerTableFillTemplateChainTest.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Tests for TemplateDefPerTableFillTemplateChain.
 *
 * Date: 2014/06/06
 * Time: 06:03
 *
 */
package org.acmsl.queryj.templates.packaging;

/*
 * Importing JetBrains annotations.
 */
import org.acmsl.queryj.api.handlers.TemplateContextFillAdapterHandler;
import org.acmsl.queryj.api.handlers.fillhandlers.FillHandler;
import org.acmsl.queryj.templates.packaging.placeholders.TemplateDefHandler;
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

import java.util.List;

/**
 * Tests for {@link TemplateDefPerTableFillTemplateChain}.
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/06/06 06:03
 */
@RunWith(JUnit4.class)
public class TemplateDefPerTableFillTemplateChainTest
{
    /**
     * Checks getHandlers() include the handler to resolve
     * "templateDef" placeholder.
     */
    @Test
    public void getHandlers_include_templateDef_placeholder()
    {
        @NotNull final TemplateDefPerTableTemplateContext context =
            EasyMock.createNiceMock(TemplateDefPerTableTemplateContext.class);

        @NotNull final TemplateDefPerTableFillTemplateChain instance =
            new TemplateDefPerTableFillTemplateChain(context);

        @NotNull final List<?> handlers = instance.getHandlers();

        boolean found = false;

        for (@Nullable final Object handler : handlers)
        {
            if (handler instanceof TemplateContextFillAdapterHandler)
            {
                @NotNull final TemplateContextFillAdapterHandler fillAdapterHandler =
                    (TemplateContextFillAdapterHandler) handler;

                if (fillAdapterHandler.getPlaceHolder().equals("templateDef"))
                {
                    found = true;
                    break;
                }
                TemplateDefHandler
            }
        }
    }
}
