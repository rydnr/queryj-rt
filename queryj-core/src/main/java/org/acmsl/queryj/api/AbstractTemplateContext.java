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
 * Filename: AbstractTemplate.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Represents generic templates.
 *
 */
package org.acmsl.queryj.api;

/*
 * Importing QueryJ Core classes.
 */
import org.acmsl.queryj.Literals;
import org.acmsl.queryj.QueryJCommand;
import org.acmsl.queryj.QueryJCommandWrapper;
import org.acmsl.queryj.QueryJSettings;
import org.acmsl.queryj.api.exceptions.FileNameNotAvailableException;
import org.acmsl.queryj.api.exceptions.PackageNameNotAvailableException;
import org.acmsl.queryj.api.exceptions.QueryJNonCheckedException;
import org.acmsl.queryj.api.exceptions.RootDirNotAvailableException;
import org.acmsl.queryj.api.exceptions.TemplateNameNotAvailableException;
import org.acmsl.queryj.api.exceptions.VersionNotAvailableException;
import org.acmsl.queryj.metadata.DecoratorFactory;
import org.acmsl.queryj.tools.exceptions.MissingOutputDirAtRuntimeException;

/*
 * Importing Apache Commons Lang classes.
 */
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/*
 * Importing some JetBrains annotations.
 */
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;

/*
 * Importing some JDK classes.
 */
import java.io.File;
import java.io.Serializable;
import java.util.List;

/**
 * Abstract implementation of {@link QueryJTemplateContext}.
 * @author <a href="mailto:chous@acm-sl.org">Jose San Leandro Armendariz</a>
 * @since 3.0
 * Created: 2012/05/20
 */
@ThreadSafe
public abstract class AbstractTemplateContext
    implements TemplateContext,
               Serializable
{
    /**
     * The serial version id.
     */
    private static final long serialVersionUID = 3405496681880071590L;

    /**
     * The package name key.
     */
    public static final String PACKAGE_NAME = Literals.PACKAGE_NAME; "packageName";

    /**
     * The command.
     */
    private QueryJCommand m__Command;

    /**
     * The pk.
     */
    private String m__Pk;

    /**
     * The decorator factory.
     */
    private DecoratorFactory m__DecoratorFactory;

    /**
     * Creates an {@link AbstractTemplateContext} with given information.
     * @param pk something unique to the template.
     * @param decoratorFactory the {@link DecoratorFactory} instance..
     * @param command the {@link org.acmsl.queryj.QueryJCommand} instance.
     */
    protected AbstractTemplateContext(
        @NotNull final String pk,
        @NotNull final DecoratorFactory decoratorFactory,
        @NotNull final QueryJCommand command)
    {
        immutableSetPk(pk);
        immutableSetDecoratorFactory(decoratorFactory);
        immutableSetCommand(command);
    }

    /**
     * Specifies the pk.
     * @param pk such pk.
     */
    protected final void immutableSetPk(@NotNull final String pk)
    {
        this.m__Pk = pk;
    }

    /**
     * Specifies the pk.
     * @param pk such pk.
     */
    @SuppressWarnings("unused")
    protected void setPk(@NotNull final String pk)
    {
        immutableSetPk(pk);
    }

    /**
     * Retrieves the pk.
     * @return such information.
     */
    @NotNull
    protected String getPk()
    {
        return this.m__Pk;
    }

    /**
     * Specifies the decorator factory.
     * @param
     */
    protected final void immutableSetDecoratorFactory(@NotNull final DecoratorFactory decoratorFactory)
    {
        this.m__DecoratorFactory = decoratorFactory;
    }

    /**
     * Specifies the command.
     * @param command the command.
     */
    private void immutableSetCommand(@NotNull final QueryJCommand command)
    {
        m__Command = command;
    }

    /**
     * Specifies the command.
     * @param command the command.
     */
    @SuppressWarnings("unused")
    protected void setCommand(@NotNull final QueryJCommand command)
    {
        immutableSetCommand(command);
    }

    /**
     * Retrieves the command.
     * @return such command.
     */
    @NotNull
    public QueryJCommand getCommand()
    {
        return m__Command;
    }

    /**
     * Annotates a value in the command.
     * @param key the key.
     * @param value the value.
     * @param command the command.
     * @param <T> the type.
     */
    protected final <T> void immutableSetValue(
        @NotNull final String key, @NotNull final T value, @NotNull final QueryJCommand command)
    {
        immutableSetValue(key, getPk(), value, command);
    }

    /**
     * Annotates a value in the command.
     * @param key the key.
     * @param pk the pk.
     * @param value the value.
     * @param command the command.
     * @param <T> the type.
     */
    protected final <T> void immutableSetValue(
        @NotNull final String key,
        @NotNull final String pk,
        @NotNull final T value,
        @NotNull final QueryJCommand command)
    {
        new QueryJCommandWrapper<T>(command).setSetting(key + '|' + pk, value);
    }

    /**
     * Retrieves the value.
     * @param key the key.
     * @param command the command.
     * @param exceptionToThrow the exception to throw.
     * @param <T> the value type.
     * @return such information.
     */
    @NotNull
    protected <T> T getValue(
        @NotNull final String key,
        @NotNull final QueryJCommand command,
        @NotNull final QueryJNonCheckedException exceptionToThrow)
    {
        return getValue(key, getPk(), command, exceptionToThrow);
    }

    /**
     * Retrieves the value.
     * @param key the key.
     * @param pk the primary key.
     * @param command the command.
     * @param exceptionToThrow the exception to throw.
     * @param <T> the value type.
     * @return such information.
     */
    @NotNull
    protected <T> T getValue(
        @NotNull final String key,
        @NotNull final String pk,
        @NotNull final QueryJCommand command,
        @NotNull final QueryJNonCheckedException exceptionToThrow)
    {
        @Nullable final T result;

        @Nullable final T aux =
            new QueryJCommandWrapper<T>(command).getSetting(key + '|' + pk);

        if (aux == null)
        {
            result = new QueryJCommandWrapper<T>(command).getSetting(key);
        }
        else
        {
            result = aux;
        }

        if (result == null)
        {
            throw exceptionToThrow;
        }

        return result;
    }

    /**
     * Retrieves the value.
     * @param key the key.
     * @param command the command.
     * @param exceptionToThrow the exception to throw.
     * @param <T> the value type.
     * @return such information.
     */
    @NotNull
    protected <T> List<T> getListValue(
        @NotNull final String key,
        @NotNull final QueryJCommand command,
        @NotNull final QueryJNonCheckedException exceptionToThrow)
    {
        return getListValue(key, getPk(), command, exceptionToThrow);
    }

    /**
     * Retrieves the value.
     * @param key the key.
     * @param pk the primary key.
     * @param command the command.
     * @param exceptionToThrow the exception to throw.
     * @param <T> the value type.
     * @return such information.
     */
    @NotNull
    protected <T> List<T> getListValue(
        @NotNull final String key,
        @NotNull final String pk,
        @NotNull final QueryJCommand command,
        @NotNull final QueryJNonCheckedException exceptionToThrow)
    {
        @Nullable final List<T> result;

        @Nullable final List<T> aux =
            new QueryJCommandWrapper<T>(command).getListSetting(key + '|' + pk);

        if (aux == null)
        {
            result = new QueryJCommandWrapper<T>(command).getListSetting(key);
        }
        else
        {
            result = aux;
        }

        if (result == null)
        {
            throw exceptionToThrow;
        }

        return result;
    }

    /**
     * Retrieves the template name.
     * @return such information.
     */
    @NotNull
    public String getTemplateName()
    {
        return getValue(buildTemplateNameKey(), getCommand(), new TemplateNameNotAvailableException());
    }

    /**
     * Builds the template name key.
     * @return such information.
     */
    @NotNull
    protected String buildTemplateNameKey()
    {
        return "templateName";
    }

    /**
     * Retrieves the file name.
     * @return such information.
     */
    @NotNull
    public String getFileName()
    {
        return getValue(buildFileNameKey(), getCommand(), new FileNameNotAvailableException());
    }

    /**
     * Builds a file name key.
     * @return such key.
     */
    @NotNull
    protected String buildFileNameKey()
    {
        return "fileName";
    }

    /**
     * Retrieves the package name.
     * @return such information.
     */
    @NotNull
    public String getPackageName()
    {
        return getValue(buildPackageNameKey(), getCommand(), new PackageNameNotAvailableException());
    }

    /**
     * Builds the package name.
     * @return such value.
     */
    @NotNull
    protected String buildPackageNameKey()
    {
        return "packageName";
    }

    /**
     * Retrieves the root dir.
     * @return such folder.
     */
    @NotNull
    public File getRootDir()
    {
        return getValue(buildRootDirKey(), getCommand(), new RootDirNotAvailableException());
    }

    /**
     * Builds the root dir key.
     * @return such key.
     */
    @NotNull
    protected String buildRootDirKey()
    {
        return QueryJSettings.OUTPUT_FOLDER;
    }

    /**
     * Retrieves the output dir.
     * @return such folder.
     */
    @NotNull
    public File getOutputDir()
    {
        return getValue(buildOutputDirKey(), getCommand(), new MissingOutputDirAtRuntimeException());
    }

    /**
     * Builds the output dir key.
     * @return such key.
     */
    @NotNull
    protected String buildOutputDirKey()
    {
        return "outputDir";
    }

    /**
     * Retrieves the version.
     * @return such information.
     */
    @Override
    @NotNull
    public String getVersion()
    {
        return getValue(buildVersionKey(), getCommand(), new VersionNotAvailableException());
    }

    /**
     * Builds the version key.
     * @return such key.
     */
    @NotNull
    protected String buildVersionKey()
    {
        return QueryJSettings.VERSION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode()
    {
        return
            new HashCodeBuilder()
                .append(AbstractTemplateContext.class.getName())
                .append(this.m__Pk)
                .append(this.m__Command)
                .toHashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable final Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final AbstractTemplateContext other = (AbstractTemplateContext) obj;

        return
            new EqualsBuilder()
                .append(this.m__Pk, other.m__Pk)
                .append(this.m__Command, other.m__Command)
                .isEquals();
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public String toString()
    {
        return
              "{ \"class\": \"" + AbstractTemplateContext.class.getSimpleName() + '"'
            + ", \"package\": \"org.acmsl.queryj.api\""
            + ", \"pk\": \"" + m__Pk + '"'
            + ", \"command\": " + m__Command
            + " }";
    }
}
