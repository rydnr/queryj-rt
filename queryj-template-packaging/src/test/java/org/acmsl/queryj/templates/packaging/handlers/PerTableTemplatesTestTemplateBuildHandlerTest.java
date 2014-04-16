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
 * Filename: PerTableTemplatesTestTemplateBuildHandlerTest.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: 
 *
 * Date: 2014/04/16
 * Time: 21:50
 *
 */
package org.acmsl.queryj.templates.packaging.handlers;

/*
 * Importing JetBrains annotations.
 */
import org.acmsl.queryj.QueryJCommand;
import org.acmsl.queryj.templates.packaging.Literals;

/*
 * Importing JetBrains annotations.
 */
import org.easymock.EasyMock;
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 *
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/04/16 21:50
 */
@RunWith(JUnit4.class)
public class PerTableTemplatesTestTemplateBuildHandlerTest
{
    /**
     * Tests whether retrieveTemplateName() works.
     */
    @Test
    public void retrieveTemplateName_works()
    {
        @NotNull final PerTableTemplatesTestTemplateBuildHandler instance =
            new PerTableTemplatesTestTemplateBuildHandler();

        @NotNull final QueryJCommand command = EasyMock.createNiceMock(QueryJCommand.class);

        Assert.assertEquals(Literals.PER_TABLE_TEMPLATES_TEST, instance.retrieveTemplateName(command));
    }
}
