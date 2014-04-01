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
import org.acmsl.queryj.QueryJCommand;
import org.acmsl.queryj.QueryJCommandWrapper;
import org.acmsl.queryj.QueryJSettings;
import org.acmsl.queryj.api.exceptions.BasePackageNameNotAvailableException;
import org.acmsl.queryj.api.exceptions.DecoratorFactoryNotAvailableException;
import org.acmsl.queryj.api.exceptions.FileNameNotAvailableException;
import org.acmsl.queryj.api.exceptions.JndiLocationNotAvailableException;
import org.acmsl.queryj.api.exceptions.PackageNameNotAvailableException;
import org.acmsl.queryj.api.exceptions.RepositoryNameNotAvailableException;
import org.acmsl.queryj.api.exceptions.VersionNotAvailableException;
import org.acmsl.queryj.customsql.CustomSqlProvider;
import org.acmsl.queryj.customsql.exceptions.CustomSqlProviderNotAvailableException;
import org.acmsl.queryj.customsql.handlers.CustomSqlProviderRetrievalHandler;
import org.acmsl.queryj.metadata.DecoratorFactory;
import org.acmsl.queryj.metadata.MetadataManager;
import org.acmsl.queryj.metadata.vo.Attribute;
import org.acmsl.queryj.tools.exceptions.MetadataManagerNotAvailableException;
import org.acmsl.queryj.tools.handlers.DatabaseMetaDataRetrievalHandler;

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
    implements QueryJTemplateContext,
               Serializable
{
    /**
     * The serial version id.
     */
    private static final long serialVersionUID = 3405496681880071590L;

    /**
     * The package name key.
     */
    public static final String PACKAGE_NAME = "packageName";

    /**
     * The file name key.
     */
    public static final String FILE_NAME = "fileName";

    /**
     * Retrieves the file name.
     * @return such information.
     */
    @Override
    @NotNull
    public String getFileName()
    {
        return getFileName(getCommand());
    }

    /**
     * Retrieves the file name.
     * @param command the command.
     * @return such information.
     */
    @NotNull
    protected String getFileName(@NotNull final QueryJCommand command)
    {
        @Nullable final String result =
            new QueryJCommandWrapper<String>(command).getSetting(FILE_NAME);

        if (result == null)
        {
            throw new FileNameNotAvailableException();
        }

        return result;
    }

    /**
     * Retrieves the version.
     * @return such information.
     */
    @NotNull
    public String getVersion()
    {
        return getVersion(getCommand());
    }


    /**
     * Retrieves the version.
     * @param command the command.
     * @return such information.
     */
    @NotNull
    protected String getVersion(@NotNull final QueryJCommand command)
    {
        @Nullable final String result =
            new QueryJCommandWrapper<String>(command).getSetting(QueryJSettings.VERSION);

        if (result == null)
        {
            throw new VersionNotAvailableException();
        }

        return result;
    }

    /**
     * Concatenates given attributes.
     * @param attributes the attributes.
     * @return the CSV version of given list.
     */
    @NotNull
    protected String toCsv(@NotNull final List<Attribute<String>> attributes)
    {
        @NotNull final StringBuilder result = new StringBuilder();

        for (@Nullable final Attribute<String> t_Attribute : attributes)
        {
            if (t_Attribute != null)
            {
                if (result.length() > 0)
                {
                    result.append(",");
                }
                result.append(t_Attribute.getName());
            }
        }

        return result.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode()
    {
        return
            new HashCodeBuilder().append(AbstractTemplateContext.class.getName()).append(this.m__Command).toHashCode();
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

        return new EqualsBuilder().append(this.m__Command, other.m__Command).isEquals();
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
            + ", \"command\": " + m__Command
            + " }";
    }
}
