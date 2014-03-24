/*
                        QueryJ Maven

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
 * Filename: QueryJMojo.java
 *
 * Author: Jose San Leandro Armendariz/Jose Juan.
 *
 * Description: Executes QueryJ.
 */
package org.acmsl.queryj.tools.maven;

/*
 * Importing QueryJ Core classes.
 */
import org.acmsl.queryj.tools.ant.AntExternallyManagedFieldsElement;
import org.acmsl.queryj.tools.ant.AntFieldElement;
import org.acmsl.queryj.tools.ant.AntTableElement;
import org.acmsl.queryj.tools.ant.AntTablesElement;
import org.acmsl.queryj.tools.ant.QueryJTask;
import org.acmsl.queryj.tools.handlers.ParameterValidationHandler;

/*
 * Importing some ACM-SL Commons classes.
 */
import org.acmsl.commons.logging.UniqueLogFactory;

/*
 * Importing some Maven classes.
 */
import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.Mojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.logging.Log;

/*
 * Importing some Ant classes.
 */
import org.apache.tools.ant.Project;
import org.apache.tools.ant.types.Path;

/*
 * Importing some Jetbrains annotations.
 */
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Importing some JDK classes.
 */
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;

/**
 * Executes QueryJ.
 * @author <a href="mailto:chous@acm-sl.org">Jose San Leandro Armendariz</a>
 * @goal queryj
 * @execute phase="generate-sources"
 * @threadSafe
 */
@SuppressWarnings("unused")
@ThreadSafe
public class QueryJMojo
    extends AbstractMojo
    implements Mojo
{
    /**
     * The location of pom.properties within the jar file.
     */
    protected static final String POM_PROPERTIES_LOCATION =
        "META-INF/maven/org.acmsl.queryj/queryj-maven/pom.properties";

    /**
     * The key for the QueryJ package.
     */
    protected static final String QUERYJ_PACKAGE = "queryj.package";

    /**
     * String literal: "(unknown)"
     */
    public static final String UNKNOWN_LITERAL = "(unknown)";

    /**
     * String literal: "version"
     */
    public static final String VERSION_LITERAL = "version";

    /**
     * String literal: "Strange... Cannot read my own "
     */
    public static final String CANNOT_READ_MY_OWN_POM = "Strange... Cannot read my own ";

    /**
     * The driver.
     * @parameter property="driver" @required
     */
    private String m__strDriver;

    /**
     * The url.
     * @parameter property="url" @required
     */
    private String m__strUrl;

    /**
     * The user name.
     * @parameter property="username" @required
     */
    private String m__strUsername;

    /**
     * The password.
     * @parameter property="password" @required
     */
    private String m__strPassword;

    /**
     * The catalog.
     * @parameter property="catalog"
     */
    private String catalog;

    /**
     * The schema.
     * @parameter property="schema" @required
     */
    private String schema;

    /**
     * The repository.
     * @parameter property="repository" @required
     */
    private String m__strRepository;

    /**
     * The package name.
     * @parameter property="packageName" @required
     */
    private String m__strPackageName;

    /**
     * The output directory.
     * @parameter property="outputDir"
     */
    private File m__OutputDir;

    /**
     * The data source.
     * @parameter property="jndiDataSource"
     */
    private String m__strJndiDataSource;

    /**
     * The sql xml file.
     * @parameter property="sqlXmlFile"
     */
    private File m__SqlXmlFile;

    /**
     * The header file.
     * @parameter property="headerFile"
     */
    private File m__HeaderFile;

    /**
     * The list of external managed fields
     * @parameter
     */
    private ExternallyManagedField[] externallyManagedFields = new ExternallyManagedField[0];

    /**
     * The grammar folder.
     * @parameter property="grammarFolder"
     */
    private File m__GrammarFolder;

    /**
     * The grammar bundle.
     * @parameter property="grammarName"
     */
    private String m__strGrammarName;

    /**
     * The grammar suffix.
     * @parameter property="grammarSuffix"
     */
    private String m__strGrammarSuffix;

    /**
     * The list of tables.
     * @parameter
     */
    private Table[] m__aTables = new Table[0];
    // @*** parameter property="tables"

    /**
     * The file encoding.
     * @parameter property="encoding" default-value="${project.build.sourceEncoding}"
     */
    private String m__strEncoding;

    /**
     * Whether to generate file timestamps.
     * @parameter property="disableGenerationTimestamps"
     */
    private Boolean m__bDisableGenerationTimestamps;

    /**
     * Whether to disable NotNull annotations.
     * @parameter property="disableNotNullAnnotations"
     */
    private Boolean m__bDisableNotNullAnnotations = false;

    /**
     * Whether to disable checkthread.org annotations.
     * @parameter property="disableCheckthreadAnnotations"
     */
    private Boolean m__bDisableCheckthreadAnnotations = false;

    /**
 	* The current build session instance. This is used for toolchain manager API calls.
 	*
 	* @parameter default-value="${session}"
 	* @required
 	* @readonly
 	*/
 	private MavenSession session;

    /**
     * Specifies the driver.
     * @param driver such value.
     */
    protected final void immutableSetDriver(@NotNull final String driver)
    {
        m__strDriver = driver;
    }

    /**
     * Specifies the driver.
     * @param driver such value.
     */
    public void setDriver(@NotNull final String driver)
    {
        immutableSetDriver(driver);
    }

    /**
     * Returns the driver.
     * @return such value.
     */
    @Nullable
    protected final String immutableGetDriver()
    {
        return m__strDriver;
    }

    /**
     * Returns the driver.
     * @return such value.
     */
    @Nullable
    protected String getDriver()
    {
        String result = System.getProperty("queryj.driver");

        if (result == null)
        {
            result = immutableGetDriver();
        }

        return result;
    }

    /**
     * Specifies the url.
     * @param url the url.
     */
    protected final void immutableSetUrl(@NotNull final String url)
    {
        m__strUrl = url;
    }

    /**
     * Specifies the url.
     * @param url the url.
     */
    public void setUrl(@NotNull final String url)
    {
        immutableSetUrl(url);
    }

    /**
     * Returns the url.
     * @return such value.
     */
    @Nullable
    protected final String immutableGetUrl()
    {
        return m__strUrl;
    }

    /**
     * Returns the url.
     * @return such value.
     */
    @Nullable
    protected String getUrl()
    {
        String result = System.getProperty("queryj.url");

        if (result == null)
        {
            result = immutableGetUrl();
        }

        return result;
    }

    /**
     * Specifies the username.
     * @param username the new value.
     */
    protected final void immutableSetUsername(@NotNull final String username)
    {
        m__strUsername = username;
    }

    /**
     * Specifies the username.
     * @param username the new value.
     */
    public void setUsername(@NotNull final String username)
    {
        immutableSetUsername(username);
    }

    /**
     * Returns the user name.
     * @return such value.
     */
    @Nullable
    protected final String immutableGetUsername()
    {
        return m__strUsername;
    }

    /**
     * Returns the user name.
     * @return such value.
     */
    @Nullable
    protected String getUsername()
    {
        String result = System.getProperty("queryj.username");

        if (result == null)
        {
            result = immutableGetUsername();
        }

        return result;
    }

    /**
     * Specifies the password.
     * @param password the password.
     */
    protected final void immutableSetPassword(@NotNull final String password)
    {
        m__strPassword = password;
    }

    /**
     * Specifies the password.
     * @param password the password.
     */
    public void setPassword(@NotNull final String password)
    {
        immutableSetPassword(password);
    }

    /**
     * Returns the password.
     * @return such value.
     */
    @Nullable
    protected final String immutableGetPassword()
    {
        return m__strPassword;
    }

    /**
     * Returns the password.
     * @return such value.
     */
    @Nullable
    protected String getPassword()
    {
        String result = System.getProperty("queryj.password");

        if (result == null)
        {
            result = immutableGetPassword();
        }

        return result;
    }

    /**
     * Specifies the catalog.
     * @param catalog the catalog.
     */
    protected final void immutableSetCatalog(@NotNull final String catalog)
    {
        this.catalog = catalog;
    }

    /**
     * Specifies the catalog.
     * @param catalog the catalog.
     */
    public void setCatalog(@NotNull final String catalog)
    {
        immutableSetCatalog(catalog);
    }

    /**
     * Returns the catalog.
     * @return such value.
     */
    @Nullable
    protected final String immutableGetCatalog()
    {
        return catalog;
    }

    /**
     * Returns the catalog.
     * @return such value.
     */
    @Nullable
    protected String getCatalog()
    {
        String result = System.getProperty("queryj.catalog");

        if (result == null)
        {
            result = immutableGetCatalog();
        }

        return result;
    }

    /**
     * Specifies the schema.
     * @param schema the schema.
     */
    protected final void immutableSetSchema(@NotNull final String schema)
    {
        this.schema = schema;
    }

    /**
     * Specifies the schema.
     * @param schema the schema.
     */
    public void setSchema(@NotNull final String schema)
    {
        immutableSetSchema(schema);
    }

    /**
     * Returns the schema.
     * @return such value.
     */
    @Nullable
    protected final String immutableGetSchema()
    {
        return schema;
    }

    /**
     * Returns the schema.
     * @return such value, or an empty string if not initialized.
     */
    @NotNull
    protected String getSchema()
    {
        String result = System.getProperty("queryj.schema");

        if (result == null)
        {
            result = immutableGetSchema();
        }

        if  (result == null)
        {
            result = "";
        }

        return result;
    }

    /**
     * Specifies the repository.
     * @param repository the repository.
     */
    protected final void immutableSetRepository(@NotNull final String repository)
    {
        m__strRepository = repository;
    }

    /**
     * Specifies the repository.
     * @param repository the repository.
     */
    public void setRepository(@NotNull final String repository)
    {
        immutableSetRepository(repository);
    }

    /**
     * Returns the repository.
     * @return such value.
     */
    @Nullable
    protected final String immutableGetRepository()
    {
        return m__strRepository;
    }

    /**
     * Returns the repository.
     * @return such value, or an empty string if not initialized.
     */
    @NotNull
    protected String getRepository()
    {
        String result = System.getProperty("queryj.repository");

        if (result == null)
        {
            result = immutableGetRepository();
        }

        if  (result == null)
        {
            result = "";
        }

        return result;
    }

    /**
     * Specifies the package name.
     * @param packageName the package name.
     */
    protected final void immutableSetPackageName(@NotNull final String packageName)
    {
        m__strPackageName = packageName;
    }

    /**
     * Specifies the package name.
     * @param packageName the package name.
     */
    public void setPackageName(@NotNull final String packageName)
    {
        immutableSetPackageName(packageName);
    }

    /**
     * Returns the package name.
     * @return such value.
     */
    @Nullable
    protected final String immutableGetPackageName()
    {
        return m__strPackageName;
    }

    /**
     * Returns the package name.
     * @return such value.
     */
    @Nullable
    protected String getPackageName()
    {
        String result = System.getProperty(QUERYJ_PACKAGE);

        if (result == null)
        {
            result = immutableGetPackageName();
        }

        return result;
    }

    /**
     * Specifies the output directory.
     * @param outputDir such directory.
     */
    protected final void immutableSetOutputDir(@NotNull final File outputDir)
    {
        m__OutputDir = outputDir;
    }

    /**
     * Specifies the output directory.
     * @param outputDir such directory.
     */
    public void setOutputDir(@NotNull final File outputDir)
    {
        immutableSetOutputDir(outputDir);
    }

    /**
     * Returns the output directory.
     * @return such directory.
     */
    @Nullable
    protected final File immutableGetOutputDir()
    {
        return m__OutputDir;
    }

    /**
     * Returns the output directory.
     * @return such directory.
     */
    @Nullable
    protected File getOutputDir()
    {
        final File result;

        final String aux = System.getProperty(QUERYJ_PACKAGE);

        if (aux == null)
        {
            result = immutableGetOutputDir();
        }
        else
        {
            result = new File(aux);
        }

        return result;
    }

    /**
     * Specifies the JNDI path to the data source.
     * @param jndiPath such path.
     */
    protected final void immutableSetJndiDataSource(@NotNull final String jndiPath)
    {
        m__strJndiDataSource = jndiPath;
    }

    /**
     * Specifies the JNDI path to the data source.
     * @param jndiPath such path.
     */
    public void setJndiDataSource(@NotNull final String jndiPath)
    {
        immutableSetJndiDataSource(jndiPath);
    }

    /**
     * Returns the JNDI location of the data source.
     * @return such value.
     */
    @Nullable
    protected final String immutableGetJndiDataSource()
    {
        return m__strJndiDataSource;
    }

    /**
     * Returns the JNDI location of the data source.
     * @return such value.
     */
    @Nullable
    protected String getJndiDataSource()
    {
        String result = System.getProperty("queryj.jndi");

        if (result == null)
        {
            result = immutableGetJndiDataSource();
        }

        return result;
    }

    /**
     * Specifies the XML file where the SQL queries are defined.
     * @param sqlFile such file.
     */
    protected final void immutableSetSqlXmlFile(@NotNull final File sqlFile)
    {
        m__SqlXmlFile = sqlFile;
    }

    /**
     * Specifies the XML file where the SQL queries are defined.
     * @param sqlFile such file.
     */
    public void setSqlXmlFile(@NotNull final File sqlFile)
    {
        immutableSetSqlXmlFile(sqlFile);
    }

    /**
     * Return the sql xml file.
     * @return such file.
     */
    @Nullable
    protected final File immutableGetSqlXmlFile()
    {
        return m__SqlXmlFile;
    }

    /**
     * Return the sql xml file.
     * @return such file.
     */
    @Nullable
    protected File getSqlXmlFile()
    {
        final File result;

        @Nullable final String aux = System.getProperty("queryj.sqlXmlFile");

        if (aux == null)
        {
            result = immutableGetSqlXmlFile();
        }
        else
        {
            result = new File(aux);
        }

        return result;
    }

    /**
     * Specifies the header file.
     * @param file such file.
     */
    protected final void immutableSetHeaderFile(@NotNull final File file)
    {
        m__HeaderFile = file;
    }

    /**
     * Specifies the header file.
     * @param file such file.
     */
    public void setHeaderFile(@NotNull final File file)
    {
        immutableSetHeaderFile(file);
    }

    /**
     * Returns the header file.
     * @return such file.
     */
    @Nullable
    protected final File immutableGetHeaderFile()
    {
        return m__HeaderFile;
    }

    /**
     * Returns the header file.
     * @return such file.
     */
    @Nullable
    protected File getHeaderFile()
    {
        final File result;

        final String aux = System.getProperty("queryj.headerFile");

        if (aux == null)
        {
            result = immutableGetHeaderFile();
        }
        else
        {
            result = new File(aux);
        }

        return result;
    }

    /**
     * Specifies the externally managed fields.
     * @param fields such fields.
     */
    protected final void immutableSetExternallyManagedFields(
        @NotNull final ExternallyManagedField[] fields)
    {
        externallyManagedFields = fields;
    }

    /**
     * Specifies the externally managed fields.
     * @param fields such fields.
     */
    public void setExternallyManagedFields(@NotNull final ExternallyManagedField[] fields)
    {
        immutableSetExternallyManagedFields(fields);
    }

    /**
     * Returns the externally managed fields.
     * @return such fields.
     */
    @NotNull
    protected final ExternallyManagedField[] immutableGetExternallyManagedFields()
    {
//        return m__aExternallyManagedFields;
        return externallyManagedFields;
    }

    /**
     * Returns the externally managed fields.
     * @return such fields.
     */
    @NotNull
    protected ExternallyManagedField[] getExternallyManagedFields()
    {
        return immutableGetExternallyManagedFields();
    }

    /**
     * Specifies the grammar folder.
     * @param folder such folder.
     */
    protected final void immutableSetGrammarFolder(@NotNull final File folder)
    {
        m__GrammarFolder = folder;
    }

    /**
     * Specifies the grammar folder.
     * @param folder such folder.
     */
    @SuppressWarnings("unused")
    public void setGrammarFolder(@NotNull final File folder)
    {
        immutableSetGrammarFolder(folder);
    }

    /**
     * Returns the grammar folder.
     * @return such folder.
     */
    @Nullable
    protected final File immutableGetGrammarFolder()
    {
        return m__GrammarFolder;
    }

    /**
     * Returns the grammar bundle.
     * @return such resource.
     */
    @Nullable
    protected File getGrammarFolder()
    {
        final File result;

        @Nullable final String aux = System.getProperty("queryj.grammarFolder");

        if (aux == null)
        {
            result = immutableGetGrammarFolder();
        }
        else
        {
            result = new File(aux);
        }

        return result;
    }

    /**
     * Specifies the grammar bundle.
     * @param bundle such bundle.
     */
    protected final void immutableSetGrammarName(@NotNull final String bundle)
    {
        m__strGrammarName = bundle;
    }

    /**
     * Specifies the grammar bundle.
     * @param bundle such bundle.
     */
    @SuppressWarnings("unused")
    public void setGrammarName(@NotNull final String bundle)
    {
        immutableSetGrammarName(bundle);
    }

    /**
     * Returns the grammar bundle.
     * @return such resource.
     */
    @Nullable
    protected final String immutableGetGrammarName()
    {
        return m__strGrammarName;
    }

    /**
     * Returns the grammar bundle.
     * @return such resource.
     */
    @Nullable
    protected String getGrammarName()
    {
        String result = System.getProperty("queryj.grammarName");

        if (result == null)
        {
            result = immutableGetGrammarName();
        }

        return result;
    }

    /**
     * Specifies the grammar suffix.
     * @param suffix such suffix.
     */
    protected final void immutableSetGrammarSuffix(@NotNull final String suffix)
    {
        m__strGrammarSuffix = suffix;
    }

    /**
     * Specifies the grammar suffix.
     * @param suffix such suffix.
     */
    @SuppressWarnings("unused")
    public void setGrammarSuffix(@NotNull final String suffix)
    {
        immutableSetGrammarSuffix(suffix);
    }

    /**
     * Returns the grammar suffix.
     * @return such resource.
     */
    @Nullable
    protected final String immutableGetGrammarSuffix()
    {
        return m__strGrammarSuffix;
    }

    /**
     * Returns the grammar suffix.
     * @return such resource.
     */
    @Nullable
    protected String getGrammarSuffix()
    {
        String result = System.getProperty("queryj.grammarSuffix");

        if (result == null)
        {
            result = immutableGetGrammarSuffix();
        }

        return result;
    }

    /**
     * Specifies the tables.
     * @param tables such information.
     */
    protected final void immutableSetTables(@NotNull final Table[] tables)
    {
        m__aTables = tables;
    }

    /**
     * Specifies the tables.
     * @param tables such information.
     */
    public void setTables(@NotNull final Table[] tables)
    {
        immutableSetTables(tables);
    }

    /**
     * Returns the tables.
     * @return such information.
     */
    @NotNull
    protected final Table[] immutableGetTables()
    {
        return m__aTables;
    }

    /**
     * Returns the tables.
     * @return such information.
     */
    @NotNull
    protected Table[] getTables()
    {
        return immutableGetTables();
    }

    /**
     * Specifies the encoding.
     * @param encoding the encoding.
     */
    protected final void immutableSetEncoding(@NotNull final String encoding)
    {
        m__strEncoding = encoding;
    }

    /**
     * Specifies the encoding.
     * @param encoding the encoding.
     */
    public void setEncoding(@NotNull final String encoding)
    {
        immutableSetEncoding(encoding);
    }

    /**
     * Retrieves the encoding.
     * @return such information.
     */
    @Nullable
    protected final String immutableGetEncoding()
    {
        return m__strEncoding;
    }

    /**
     * Retrieves the encoding.
     * @return such information.
     */
    @Nullable
    public String getEncoding()
    {
        String result = System.getProperty("queryj.enconding");

        if (result == null)
        {
            result = immutableGetEncoding();
        }

        return result;
    }

    /**
     * Specifies whether to use generation timestamps.
     * @param flag the choice.
     */
    protected final void immutableSetDisableGenerationTimestamps(@NotNull final Boolean flag)
    {
        m__bDisableGenerationTimestamps = flag;
    }

    /**
     * Specifies whether to use generation timestamps.
     * @param flag the choice.
     */
    public void setDisableGenerationTimestamps(@NotNull final Boolean flag)
    {
        immutableSetDisableGenerationTimestamps(flag);
    }

    /**
     * Retrieves whether to use generation timestamps.
     * @return such setting.
     */
    @Nullable
    protected final Boolean immutableGetDisableGenerationTimestamps()
    {
        return m__bDisableGenerationTimestamps;
    }

    /**
     * Retrieves whether to use generation timestamps.
     * @return such setting.
     */
    @NotNull
    public Boolean getDisableGenerationTimestamps()
    {
        Boolean result = null;

        @Nullable final String aux = System.getProperty("queryj.disableTimestamps");

        if (aux == null)
        {
            result = immutableGetDisableGenerationTimestamps();
        }

        if (result == null)
        {
            result = Boolean.FALSE;
        }

        return result;
    }

    /**
     * Specifies whether to use NotNull annotations in the generated code.
     * @param flag such choice.
     */
    protected final void immutableSetDisableNotNullAnnotations(@NotNull final Boolean flag)
    {
        m__bDisableNotNullAnnotations = flag;
    }

    /**
     * Specifies whether to use NotNull annotations in the generated code.
     * @param flag such choice.
     */
    public void setDisableNotNullAnnotations(@NotNull final Boolean flag)
    {
        immutableSetDisableNotNullAnnotations(flag);
    }

    /**
     * Retrieves whether to use NotNull annotations in the generated code.
     * @return the current setting.
     */
    @Nullable
    protected final Boolean immutableGetDisableNotNullAnnotations()
    {
        return m__bDisableNotNullAnnotations;
    }

    /**
     * Retrieves whether to use NotNull annotations in the generated code.
     * @return the current setting.
     */
    @NotNull
    public Boolean getDisableNotNullAnnotations()
    {
        Boolean result = null;

        @Nullable final String aux = System.getProperty("queryj.disableNotNullAnnotations");

        if (aux == null)
        {
            result = immutableGetDisableNotNullAnnotations();
        }

        if (result == null)
        {
            result = Boolean.FALSE;
        }

        return result;
    }

    /**
     * Specifies whether to use Checkthread.org annotations in the generated code.
     * @param flag such choice.
     */
    protected final void immutableSetDisableCheckthreadAnnotations(@NotNull final Boolean flag)
    {
        m__bDisableCheckthreadAnnotations = flag;
    }

    /**
     * Specifies whether to use Checkthread.org annotations in the generated code.
     * @param flag such choice.
     */
    public void setDisableCheckthreadAnnotations(@NotNull final Boolean flag)
    {
        immutableSetDisableCheckthreadAnnotations(flag);
    }

    /**
     * Retrieves whether to use Checkthread annotations in the generated code.
     * @return the current setting.
     */
    @Nullable
    protected final Boolean immutableGetDisableCheckthreadAnnotations()
    {
        return m__bDisableCheckthreadAnnotations;
    }

    /**
     * Retrieves whether to use Checkthread annotations in the generated code.
     * @return the current setting.
     */
    @NotNull
    public Boolean getDisableCheckthreadAnnotations()
    {
        Boolean result = null;

        @Nullable final String aux = System.getProperty("queryj.disableCheckthreadAnnotations");

        if (aux == null)
        {
            result = immutableGetDisableCheckthreadAnnotations();
        }

        if (result == null)
        {
            result = Boolean.FALSE;
        }

        return result;
    }

    /**
     * Executes QueryJ via Maven2.
     */
    @Override
    public void execute()
        throws MojoExecutionException
    {
        execute(getLog());
    }

    /**
     * Executes QueryJ via Maven2.
     * @param log the Maven log.
     */
    protected void execute(@NotNull final Log log)
        throws MojoExecutionException
    {
        execute(log, retrieveVersion(retrievePomProperties(log)));
    }

    /**
     * Retrieves the version of QueryJ currently running.
     * @param properties the pom.properties information.
     * @return the version entry.
     */
    protected String retrieveVersion(@Nullable final Properties properties)
    {
        String result = UNKNOWN_LITERAL;

        if (   (properties != null)
            && (properties.containsKey(VERSION_LITERAL)))
        {
            result = properties.getProperty(VERSION_LITERAL);
        }

        return result;
    }

    /**
     * Executes QueryJ via Maven2.
     * @param log the Maven log.
     * @param version the QueryJ version.
     */
    protected void execute(@NotNull final Log log, final String version)
        throws MojoExecutionException
    {
        boolean running = false;

        @Nullable final File outputDirPath = getOutputDir();

        @Nullable final QueryJTask task;

        if  (outputDirPath != null)
        {
            //initialize directories
            @NotNull final File outputDir = outputDirPath.getAbsoluteFile();

            if (   (!outputDir.exists())
                && (!outputDir.mkdirs()))
            {
                log.warn("Cannot create output folder: " + outputDir);
            }

            //execute task
            task = buildTask(log);

            log.info("Running QueryJ " + version);

            task.execute();

            running = true;
        }
        else
        {
            log.error("outputDir is null");
        }

        if (!running)
        {
            log.error("NOT running QueryJ " + version);
            throw new MojoExecutionException("QueryJ could not start");
        }
    }

    /**
     * Retrieves the pom.properties bundled within the QueryJ jar.
     * @param log the Maven log.
     * @return such information.
     */
    @Nullable
    protected Properties retrievePomProperties(@NotNull final Log log)
    {
        @Nullable Properties result = null;

        try
        {
            @Nullable final InputStream pomProperties =
                getClass().getClassLoader().getResourceAsStream(POM_PROPERTIES_LOCATION);

            if (pomProperties != null)
            {
                result = new Properties();

                result.load(pomProperties);
            }
        }
        catch (@NotNull final IOException ioException)
        {
            log.warn(
                CANNOT_READ_MY_OWN_POM + POM_PROPERTIES_LOCATION,
                ioException);
        }

        return result;
    }

    /**
     * Initializes the logging.
     * @param commonsLoggingLog such log.
     */
    protected void initLogging(@NotNull final org.apache.commons.logging.Log commonsLoggingLog)
    {
        UniqueLogFactory.initializeInstance(commonsLoggingLog);
    }

    /**
     * Builds the QueryJ task.
     * @param log the Maven log.
     * @return such info.
     */
    @NotNull
    protected QueryJTask buildTask(@NotNull final Log log)
    {
        @NotNull final CommonsLoggingMavenLogAdapter t_Log = new CommonsLoggingMavenLogAdapter(log);

        @NotNull final QueryJTask result = new QueryJTask(t_Log);

        initLogging(t_Log);

        @NotNull final Project project = new AntProjectAdapter(new Project(), log);

        result.setProject(project);

        @NotNull final Path path = new Path(project);
        result.setClasspath(path);

        t_Log.debug("Catalog: " + getCatalog());
        result.setCatalog(getCatalog());

        t_Log.debug("Driver: " + getDriver());
        result.setDriver(getDriver());

        t_Log.debug("JNDI DataSource: " + getJndiDataSource());
        result.setJndiDataSource(getJndiDataSource());

        t_Log.debug("Output dir: " + getOutputDir());
        result.setOutputdir(getOutputDir());

        t_Log.debug("Package name: " + getPackageName());
        result.setPackage(getPackageName());

        t_Log.debug("Repository: " + getRepository());
        result.setRepository(getRepository());

        t_Log.debug("Schema: " + getSchema());
        result.setSchema(getSchema());

        t_Log.debug("Url: " + getUrl());
        result.setUrl(getUrl());

        t_Log.debug("Username: " + getUsername());
        result.setUsername(getUsername());

        t_Log.debug("Password specified: " + (getPassword() != null));
        result.setPassword(getPassword());

        t_Log.debug("SQL XML file: " + getSqlXmlFile());
        result.setSqlXmlFile(getSqlXmlFile());

        t_Log.debug("Header file: " + getHeaderFile());
        result.setHeaderfile(getHeaderFile());

        t_Log.debug(
            "Grammar bundle: " + getGrammarFolder() + File.separator
            + getGrammarName() + "(_" + Locale.US.getLanguage().toLowerCase(Locale.US)
            + ")" + getGrammarSuffix());

        result.setGrammarFolder(getGrammarFolder());
        result.setGrammarName(getGrammarName());
        result.setGrammarSuffix(getGrammarSuffix());

        buildExternallyManagedFields(result);
        buildTables(result);

        @Nullable final String encoding = getEncoding();

        if (encoding == null)
        {
            t_Log.warn("Using default (platform-dependent) encoding to generate QueryJ sources");
        }
        else
        {
            t_Log.info("Using encoding: \"" + encoding + "\" to generate QueryJ sources");
        }
        result.setEncoding(encoding);

        final boolean caching = true;

        final int threadCount = getRequestThreadCount();

        t_Log.info("Using " + threadCount + " threads");
        result.setThreadCount(threadCount);

        final boolean disableGenerationTimestamps = getDisableGenerationTimestamps();

        result.setDisableGenerationTimestamps(disableGenerationTimestamps);

        final boolean disableNotNullAnnotations = getDisableNotNullAnnotations();

        result.setDisableNotNullAnnotations(disableNotNullAnnotations);

        final boolean disableCheckthreadAnnotations = getDisableCheckthreadAnnotations();

        result.setDisableCheckthreadAnnotations(disableCheckthreadAnnotations);

        return result;
    }

    /**
     * Builds the external managed fields list.
     * @param task the task.
     */
    @SuppressWarnings("unchecked")
    protected void buildExternallyManagedFields(
        @NotNull final QueryJTask task)
    {
        @NotNull final ExternallyManagedField[] array = getExternallyManagedFields();

        final int count = array.length;
        @Nullable final AntExternallyManagedFieldsElement element;
        ExternallyManagedField field;
        @Nullable AntFieldElement fieldElement;

        if  (count > 0)
        {
            element =
                (AntExternallyManagedFieldsElement) task.createDynamicElement(
                    QueryJTask.EXTERNALLY_MANAGED_FIELDS);

            if (element != null)
            {
                for (@Nullable final ExternallyManagedField anArray : array)
                {
                    field = anArray;

                    if (field != null)
                    {
                        fieldElement =
                            (AntFieldElement)
                                element.createDynamicElement(
                                    AntExternallyManagedFieldsElement.FIELD_LITERAL);

                        if (fieldElement != null)
                        {
                            fieldElement.setDynamicAttribute("name", field.getName());

                            fieldElement.setDynamicAttribute(
                                AntFieldElement.TABLE_NAME_LITERAL, field.getTableName());

                            fieldElement.setDynamicAttribute(
                                AntFieldElement.KEYWORD_LITERAL, field.getKeyword());

                            fieldElement.setDynamicAttribute(
                                AntFieldElement.RETRIEVAL_QUERY_LITERAL, field.getRetrievalQuery());
                        }
                    }
                }

                task.setExternallyManagedFields(element);
            }
        }
    }

    /**
     * Builds the table list.
     * @param task the task.
     */
    protected void buildTables(@NotNull final QueryJTask task)
    {
        @NotNull final Table[] array = getTables();
        Table table;
        @Nullable final AntTablesElement element;
        @Nullable AntTableElement tableElement;
        List<Field> fields;
        int fieldCount;
        Field field;
        @Nullable AntFieldElement fieldElement;

        final int count =  array.length;

        if  (count > 0)
        {
            element =
                (AntTablesElement) task.createDynamicElement(ParameterValidationHandler.TABLES);

            if (element != null)
            {
                for (@Nullable final Table anArray : array)
                {
                    table = anArray;

                    tableElement =
                        (AntTableElement) element.createDynamicElement(AntTablesElement.TABLE);

                    if (   (table != null)
                        && (tableElement != null))
                    {
                        @Nullable final String name = table.getName();

                        if (name != null)
                        {
                            tableElement.setDynamicAttribute("name", name);
                        }

                        fields = table.getFields();

                        fieldCount = (fields == null) ? 0 : fields.size();

                        if (fields != null)
                        {
                            for (int fieldIndex = 0; fieldIndex < fieldCount; fieldIndex++)
                            {
                                field = fields.get(fieldIndex);

                                if (field != null)
                                {
                                    fieldElement =
                                        (AntFieldElement) tableElement.createDynamicElement(
                                            AntExternallyManagedFieldsElement.FIELD_LITERAL);

                                    if (fieldElement != null)
                                    {
                                        fieldElement.setDynamicAttribute(
                                            "name", field.getName());
                                        fieldElement.setDynamicAttribute(
                                            "type", field.getType());
                                        fieldElement.setDynamicAttribute(
                                            "pk", field.getPk());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Tries to get thread count if a Maven 3 build, using reflection as the plugin must not be maven3 api dependant
     *
     * @return number of thread for this build or 1 if not multi-thread build
     */
    protected int getRequestThreadCount()
    {
        int result = getRequestThreadCountFromSystemProperties();

        if (result < 1)
        {
            result = getRequestThreadCountFromMaven();
        }

        if (result < 1)
        {
            result = getRequestThreadCountFromRuntime();
        }

        if (result < 1)
        {
            result = 1;
        }

        return result;
    }

    /**
     * Tries to get thread count if a Maven 3 build, using reflection as the plugin must not be maven3 api dependant
     *
     * @return number of thread for this build or 1 if not multi-thread build
     */
    protected int getRequestThreadCountFromMaven()
    {
        int result = 0;

        try
        {
            final Method getRequestMethod = this.session.getClass().getMethod("getRequest");
            final Object mavenExecutionRequest = getRequestMethod.invoke(this.session);
            final Method getThreadCountMethod = mavenExecutionRequest.getClass().getMethod("getThreadCount");
            final String threadCount = (String) getThreadCountMethod.invoke(mavenExecutionRequest);
            result  = Integer.valueOf(threadCount);
        }
        catch (@NotNull final Throwable unexpectedError)
        {
            getLog().debug( "unable to get thread count for the current build: " + unexpectedError.getMessage());
        }

//        if (   (result == 1)
//            && (isMultithreadEnabled()))
//        {
//            result = Runtime.getRuntime().availableProcessors();
//        }

        return result;
    }

    /**
     * Retrieves the thread count, from Runtime.
     * @return such information.
     */
    protected int getRequestThreadCountFromRuntime()
    {
        return Runtime.getRuntime().availableProcessors();
    }

    /**
     * Checks whether multi-threading is enabled.
     * @return {@code true} in such case.
     */
    @SuppressWarnings("unchecked")
    protected boolean isMultithreadEnabled()
    {
        @NotNull final Set<Map.Entry<?, ?>> entrySet = (Set<Map.Entry<?, ?>>) super.getPluginContext().entrySet();

        for (@NotNull final Map.Entry<?, ?> item : entrySet)
        {
            getLog().info(item.getKey() + " -> " + item.getValue());
        }

        return true;
    }

    /**
     * Retrieves the thread count from system properties (queryj.threadCount).
     * @return such value.
     */
    public int getRequestThreadCountFromSystemProperties()
    {
        int result = 0;

        @Nullable final String aux = System.getProperty("queryj.threadCount");

        if (aux != null)
        {
            result = Integer.parseInt(aux);
        }

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public String toString()
    {
        return "{ \"class\": \"" + QueryJMojo.class.getName() + '"' +
               ", \"catalog\": \"" + catalog + '"' +
               ", \"driver\": \"" + m__strDriver + '"' +
               ", \"url\": \"" + m__strUrl + '"' +
               ", \"username\": \"" + m__strUsername + '"' +
               ", \"password\": \"" + m__strPassword + '"' +
               ", \"schema\": \"" + schema + '"' +
               ", \"repository\": \"" + m__strRepository + '"' +
               Literals.PACKAGE_NAME + m__strPackageName + '"' +
               Literals.OUTPUT_DIR + m__OutputDir + '"' +
               ", \"jndiDataSource\": \"" + m__strJndiDataSource + '"' +
               ", \"sqlXmlFile\": \"" + m__SqlXmlFile + '"' +
               ", \"headerFile\": \"" + m__HeaderFile + '"' +
               ", \"externallyManagedFields\": \"" + Arrays.toString(externallyManagedFields) + '"' +
               ", \"grammarFolder\": \"" + m__GrammarFolder + '"' +
               ", \"grammarName\": \"" + m__strGrammarName + '"' +
               ", \"grammarSuffix\": \"" + m__strGrammarSuffix + '"' +
               ", \"tables\": " + Arrays.toString(m__aTables) + '"' +
               ", \"encoding\": \"" + m__strEncoding + '"' +
               ", \"disableGenerationTimestamps\": \"" + m__bDisableGenerationTimestamps + '"' +
               ", \"disableNotNullAnnotations\": \"" + m__bDisableNotNullAnnotations + '"' +
               ", \"disableCheckthreadAnnotations\": \"" + m__bDisableCheckthreadAnnotations + '"' +
               ", \"session\": \"" + session + "\" }";
    }
}
