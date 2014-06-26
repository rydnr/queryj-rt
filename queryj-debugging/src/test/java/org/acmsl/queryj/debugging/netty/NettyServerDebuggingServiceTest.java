/*
                        QueryJ Debugging

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
 * Filename: NettyServerDebuggingServiceTest.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Tests for NettyServerDebuggingService.
 *
 * Date: 2014/06/26
 * Time: 18:36
 *
 */
package org.acmsl.queryj.debugging.netty;

/*
 * Importing JetBrains annotations.
 */
import org.acmsl.commons.utils.io.FileUtils;
import org.acmsl.queryj.api.AbstractTemplateGenerator;
import org.acmsl.queryj.api.TemplateContext;
import org.acmsl.queryj.debugging.AbstractTemplateTest;
import org.acmsl.queryj.debugging.AbstractTemplateTest.MyTestableAbstractTemplate;
import org.acmsl.queryj.debugging.STInspectorDebuggingService;
import org.acmsl.queryj.metadata.DecoratorFactory;
import org.acmsl.queryj.tools.debugging.TemplateDebuggingService;
import org.easymock.EasyMock;
import org.jetbrains.annotations.NotNull;

/*
 * Importing JUnit classes.
 */
import org.jetbrains.annotations.Nullable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.nio.charset.Charset;

/**
 * Tests for {@link NettyServerDebuggingService}.
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/06/26 18:36
 */
@RunWith(JUnit4.class)
public class NettyServerDebuggingServiceTest
{
    /**
     * Checks a reload makes the server request
     * a template reload.
     */
    @Test
    public void reload_makes_returns_a_reload_command()
    {
        @NotNull final NettyServerDebuggingService instance =
            new NettyServerDebuggingService();

        // setup an AbstractTemplateGenerator
        @NotNull final TemplateContext templateContext = EasyMock.createNiceMock(TemplateContext.class);
        EasyMock.expect(templateContext.getFileName()).andReturn("foo.java").anyTimes();
        EasyMock.expect(templateContext.isDebugEnabled()).andReturn(true);
        EasyMock.replay(templateContext);

        @NotNull final DecoratorFactory decoratorFactory = EasyMock.createNiceMock(DecoratorFactory.class);

        @SuppressWarnings("unchecked")
        @NotNull final AbstractTemplateGenerator<MyTestableAbstractTemplate<TemplateContext>, TemplateContext> generator =
            new AbstractTemplateGenerator(false, 1)
            {
                /**
                 * {@inheritDoc}
                 */
                @NotNull
                @Override
                public DecoratorFactory getDecoratorFactory()
                {
                    return decoratorFactory;
                }

                /**
                 * {@inheritDoc}
                 */
                @Override
                protected boolean isInDevMode(@NotNull final String templateFileName)
                {
                    return true;
                }

                /**
                 * {@inheritDoc}
                 */
                @Nullable
                @Override
                public TemplateDebuggingService resolveTemplateDebuggingService()
                {
                    return instance;
                }

                /**
                 * {@inheritDoc}
                 */
                @Nullable
                @Override
                protected String retrieveHash(
                    @NotNull final String fileName,
                    @NotNull final File outputDir,
                    @NotNull final File rootFolder,
                    @NotNull final Charset charset,
                    @NotNull final FileUtils fileUtils)
                {
                    return "";
                }
            };

        @NotNull final AbstractTemplateTest.MyTestableAbstractTemplate<TemplateContext> template =
            new AbstractTemplateTest.MyTestableAbstractTemplate<>(templateContext);

        @NotNull final File outputDir = EasyMock.createNiceMock(File.class);
        EasyMock.expect(outputDir.getAbsolutePath()).andReturn("/tmp").anyTimes();
        EasyMock.expect(outputDir.exists()).andReturn(true).anyTimes();
        EasyMock.replay(outputDir);
        @NotNull final File rootFolder = EasyMock.createNiceMock(File.class);
        EasyMock.expect(rootFolder.getAbsolutePath()).andReturn("/tmp").anyTimes();
        EasyMock.expect(rootFolder.exists()).andReturn(true).anyTimes();
        EasyMock.replay(rootFolder);

        instance.write(template, outputDir, rootFolder, Charset.defaultCharset());

        EasyMock.verify(template.template);

        // Simulate the server receives a reload command:
        // Create a client
        // Send the "reload" command

        // check the generator restarts the generation for that template.
    }
}
