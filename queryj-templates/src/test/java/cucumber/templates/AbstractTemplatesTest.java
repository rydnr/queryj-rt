/*
                        QueryJ Templates

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
 * Filename: AbstractTemplatesTest.java
 *
 * Author: Jose San Leandro Armendariz (chous)
 *
 * Description: Generic stuff for template tests.
 *
 * Date: 2013/05/05
 * Time: 17:25
 *
 */
package cucumber.templates;

/*
 * Importing QueryJ Core classes.
 */
import cucumber.templates.sql.CucumberSqlDAO;
import cucumber.templates.sql.CucumberSqlParameterDAO;

/*
 * Importing QueryJ Core classes.
 */
import org.acmsl.queryj.Literals;
import org.acmsl.queryj.api.TemplateContext;
import org.acmsl.queryj.metadata.engines.UndefinedJdbcEngine;
import org.acmsl.queryj.metadata.vo.Attribute;
import org.acmsl.queryj.metadata.vo.Row;
import org.acmsl.queryj.templates.antlr.JavaLexer;
import org.acmsl.queryj.templates.antlr.JavaPackageVisitor;
import org.acmsl.queryj.templates.antlr.JavaParser;
import org.acmsl.queryj.templates.antlr.JavaRootClassNameVisitor;

/*
 * Importing QueryJ-Core classes.
 */
import org.acmsl.queryj.customsql.CustomSqlProvider;
import org.acmsl.queryj.customsql.Parameter;
import org.acmsl.queryj.customsql.Sql;
import org.acmsl.queryj.customsql.xml.SqlXmlParserImpl;
import org.acmsl.queryj.metadata.DecoratorFactory;

/*
 * Importing Java-Commons classes.
 */
import org.acmsl.commons.utils.io.FileUtils;

/*
 * Importing ANTLR classes.
 */
import org.acmsl.queryj.metadata.MetadataExtractionLogger;
import org.acmsl.queryj.metadata.MetadataManager;
import org.acmsl.queryj.metadata.SqlDAO;
import org.acmsl.queryj.metadata.SqlParameterDAO;
import org.acmsl.queryj.metadata.engines.JdbcMetadataManager;
import org.acmsl.queryj.metadata.vo.ForeignKey;
import org.acmsl.queryj.metadata.vo.Table;

/*
 * Importing ANTLR classes.
 */
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTree;

/*
 * Importing Jetbrains annotations.
 */
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Importing JUnit classes.
 */
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

/*
 * Importing JDK classes.
 */
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Generic stuff for template tests.
 * @author <a href="chous@acm-sl.org">Jose San Leandro</a>
 * @since 2013/05/05
 * @param <G> the generator class.
 * @param <F> the factory class.
 */
@SuppressWarnings("unused")
public abstract class AbstractTemplatesTest<G, F>
{
    /**
     * String literal: "Parser error: ".
     */
    public static final String PARSER_ERROR = "Parser error: ";

    /**
     * String literal: "Cannot read file: ".
     */
    public static final String CANNOT_READ_FILE = "Cannot read file: ";

    /**
     * A simple mapping between template names and generators.
     */
    @NotNull protected final Map<String, G> GENERATOR_MAPPINGS = new HashMap<>();

    /**
     * A simple mapping between template names and factories.
     */
    @NotNull protected final Map<String, F> FACTORY_MAPPINGS = new HashMap<>();

    /**
     * A simple mapping between template names and packages.
     */
    @NotNull protected final Map<String, String> PACKAGE_MAPPINGS = new HashMap<>();

    /**
     * The package name.
     */
    public static final String BASE_PACKAGE_NAME = "com.foo.bar";

    /**
     * A temporary folder for generated files.
     */
    @Rule
    public TemporaryFolder rootFolder = new TemporaryFolder();

    /**
     * The output file.
     */
    private Map<String, File> m__mOutputFiles;

    /**
     * The tables.
     */
    private Map<String, Table<String, Attribute<String>, List<Attribute<String>>>> m__mTables;

    /**
     * The foreign keys.
     */
    private List<ForeignKey<String>> m__lForeignKeys;

    /**
     * The list of SQL queries.
     */
    private List<Sql<String>> m__lSql;

    /**
     * The SQL query parameters.
     */
    private Map<String, List<Parameter<String, ?>>> m__mParameters;

    /**
     * The static rows.
     */
    private Map<String, List<Row<String>>> m__mRows;

    /**
     * The engine name.
     */
    private String m__strEngineName;

    /**
     * The JDBC driver for validating queries.
     */
    private String m__strJdbcDriver;

    /**
     * The JDBC url for validating queries.
     */
    private String m__strJdbcUrl;

    /**
     * The JDBC user name for validating queries.
     */
    private String m__strJdbcUserName;

    /**
     * The JDBC password for validating queries.
     */
    private String m__strJdbcPassword;

    /**
     * Creates an empty instance.
     */
    protected AbstractTemplatesTest()
    {
        immutableSetOutputFiles(new HashMap<>());
        immutableSetTables(new HashMap<>());
        immutableSetForeignKeys(new ArrayList<>());
        immutableSetSqlList(new ArrayList<>());
        immutableSetParameters(new HashMap<>());
        immutableSetRows(new HashMap<>());
    }

    /**
     * Specifies the output file.
     * @param files such files.
     */
    @SuppressWarnings("unused")
    protected void immutableSetOutputFiles(@NotNull final Map<String, File> files)
    {
        m__mOutputFiles = files;
    }

    /**
     * Specifies the output files.
     * @param files such files.
     */
    @SuppressWarnings("unused")
    protected void setOutputFiles(@NotNull final Map<String, File> files)
    {
        immutableSetOutputFiles(files);
    }

    /**
     * Retrieves the output file.
     * @return such file.
     */
    @NotNull
    public Map<String, File> getOutputFiles()
    {
        return m__mOutputFiles;
    }

    /**
     * Specifies the tables.
     * @param tables the tables.
     */
    protected final void immutableSetTables(@NotNull final Map<String, Table<String, Attribute<String>, List<Attribute<String>>>> tables)
    {
        m__mTables = tables;
    }

    /**
     * Specifies the tables.
     * @param tables the tables.
     */
    @SuppressWarnings("unused")
    protected void setTables(@NotNull final Map<String, Table<String, Attribute<String>, List<Attribute<String>>>> tables)
    {
        immutableSetTables(tables);
    }

    /**
     * Retrieves the tables.
     * @return such information.
     */
    @NotNull
    protected Map<String, Table<String, Attribute<String>, List<Attribute<String>>>> getTables()
    {
        return m__mTables;
    }

    /**
     * Specifies the foreign keys.
     * @param foreignKeys the foreign keys.
     */
    protected final void immutableSetForeignKeys(@NotNull final List<ForeignKey<String>> foreignKeys)
    {
        m__lForeignKeys = foreignKeys;
    }

    /**
     * Specifies the foreign keys.
     * @param foreignKeys the foreign keys.
     */
    @SuppressWarnings("unused")
    protected void setForeignKeys(@NotNull final List<ForeignKey<String>> foreignKeys)
    {
        immutableSetForeignKeys(foreignKeys);
    }

    /**
     * Retrieves the foreign keys.
     * @return such collection.
     */
    @NotNull
    protected List<ForeignKey<String>> getForeignKeys()
    {
        return m__lForeignKeys;
    }

    /**
     * Specifies the {@link Sql} list.
     * @param sqlList such list.
     */
    protected final void immutableSetSqlList(@NotNull final List<Sql<String>> sqlList)
    {
        this.m__lSql = sqlList;
    }

    /**
     * Specifies the {@link Sql} list.
     * @param sqlList such list.
     */
    @SuppressWarnings("unused")
    protected void setSqlList(@NotNull final List<Sql<String>> sqlList)
    {
        immutableSetSqlList(sqlList);
    }

    /**
     * Retrieves the list of {@link Sql}.
     * @return such table.
     */
    @SuppressWarnings("unused")
    @NotNull
    protected List<Sql<String>> getSqlList()
    {
        return this.m__lSql;
    }

    /**
     * Specifies the SQL queries' parameters.
     * @param parameters such map.
     */
    protected final void immutableSetParameters(@NotNull final Map<String, List<Parameter<String, ?>>> parameters)
    {
        this.m__mParameters = parameters;
    }

    /**
     * Specifies the SQL queries' parameters.
     * @param parameters such map.
     */
    @SuppressWarnings("unused")
    protected void setParameters(@NotNull final Map<String, List<Parameter<String, ?>>> parameters)
    {
        immutableSetParameters(parameters);
    }

    /**
     * Retrieves the SQL queries parameters.
     * @return such parameters.
     */
    @SuppressWarnings("unused")
    @NotNull
    protected final Map<String, List<Parameter<String, ?>>> getParameters()
    {
        return m__mParameters;
    }

    /**
     * Specifies the row map (table name -&gt; static rows).
     * @param map such map.
     */
    protected final void immutableSetRows(@NotNull final Map<String, List<Row<String>>> map)
    {
        this.m__mRows = map;
    }

    /**
     * Specifies the row map (table name -&gt; static rows).
     * @param map such map.
     */
    @SuppressWarnings("unused")
    protected void setRows(@NotNull final Map<String, List<Row<String>>> map)
    {
        immutableSetRows(map);
    }

    /**
     * Retrieves the row map (table name &gt; static rows).
     * @return such map.
     */
    @NotNull
    protected Map<String, List<Row<String>>> getRows()
    {
        return this.m__mRows;
    }

    /**
     * Specifies the engine name.
     * @param name such name.
     */
    protected final void immutableSetEngineName(@NotNull final String name)
    {
        this.m__strEngineName = name;
    }

    /**
     * Specifies the engine name.
     * @param name such name.
     */
    protected void setEngineName(@NotNull final String name)
    {
        immutableSetEngineName(name);
    }

    /**
     * Retrieves the engine name.
     * @return such name.
     */
    @Nullable
    public String getEngineName()
    {
        return this.m__strEngineName;
    }

    /**
     * Specifies the JDBC driver.
     * @param driver such driver.
     */
    protected final void immutableSetJdbcDriver(@NotNull final String driver)
    {
        this.m__strJdbcDriver = driver;
    }

    /**
     * Specifies the JDBC driver.
     * @param driver such driver.
     */
    protected void setJdbcDriver(@NotNull final String driver)
    {
        immutableSetJdbcDriver(driver);
    }

    /**
     * Retrieves the JDBC driver.
     * @return such driver.
     */
    @Nullable
    public String getJdbcDriver()
    {
        return this.m__strJdbcDriver;
    }

    /**
     * Specifies the JDBC URL.
     * @param url such url.
     */
    protected final void immutableSetJdbcUrl(@NotNull final String url)
    {
        this.m__strJdbcUrl = url;
    }

    /**
     * Specifies the JDBC URL.
     * @param url such url.
     */
    protected void setJdbcUrl(@NotNull final String url)
    {
        immutableSetJdbcUrl(url);
    }

    /**
     * Retrieves the JDBC URL.
     * @return such url.
     */
    @Nullable
    public String getJdbcUrl()
    {
        return this.m__strJdbcUrl;
    }

    /**
     * Specifies the JDBC user name.
     * @param userName such user name.
     */
    protected final void immutableSetJdbcUserName(@NotNull final String userName)
    {
        this.m__strJdbcUserName = userName;
    }

    /**
     * Specifies the JDBC user name.
     * @param userName such user name.
     */
    protected void setJdbcUserName(@NotNull final String userName)
    {
        immutableSetJdbcUserName(userName);
    }

    /**
     * Retrieves the JDBC user name.
     * @return such user name.
     */
    @Nullable
    public String getJdbcUserName()
    {
        return this.m__strJdbcUserName;
    }

    /**
     * Specifies the JDBC password.
     * @param password such password.
     */
    protected final void immutableSetJdbcPassword(@NotNull final String password)
    {
        this.m__strJdbcPassword = password;
    }

    /**
     * Specifies the JDBC password.
     * @param password such password.
     */
    protected void setJdbcPassword(@NotNull final String password)
    {
        immutableSetJdbcPassword(password);
    }

    /**
     * Retrieves the JDBC password.
     * @return such password.
     */
    @Nullable
    public String getJdbcPassword()
    {
        return this.m__strJdbcPassword;
    }

    /**
     * Retrieves a {@link org.acmsl.queryj.customsql.CustomSqlProvider} instance adapted for given result.
     * @param sqlList the list of {@link Sql}.
     * @param parameters the {@link Parameter} map.
     * @return such instance.
     */
    @NotNull
    protected CustomSqlProvider retrieveCustomSqlProvider(
        @NotNull final List<Sql<String>> sqlList,
        @NotNull final Map<String, List<Parameter<String, ?>>> parameters)
    {
        return
            new SqlXmlParserImpl(new ByteArrayInputStream("".getBytes()))
            {
                @Override
                @NotNull
                public SqlDAO getSqlDAO()
                {
                    return new CucumberSqlDAO(sqlList);
                }

                /**
                 * Retrieves the {@link org.acmsl.queryj.metadata.SqlParameterDAO} instance.
                 *
                 * @return such instance.
                 */
                @NotNull
                @Override
                public SqlParameterDAO getSqlParameterDAO()
                {
                    return new CucumberSqlParameterDAO(parameters);
                }
            };
    }

    /**
     * Sets up the Java parser.
     * @param javaFile the Java contents to parse.
     * @return the {@link JavaParser} instance.
     */
    @SuppressWarnings("unchecked")
    @NotNull
    protected JavaParser setUpParser(@NotNull final File javaFile)
        throws RecognitionException,
               IOException
    {
        @NotNull final JavaParser result;

        @NotNull final JavaLexer t_Lexer =
            new JavaLexer(new ANTLRFileStream(javaFile.getAbsolutePath()));

        @NotNull final CommonTokenStream t_Tokens = new CommonTokenStream(t_Lexer);

        result = new JavaParser(t_Tokens);

        return result;
    }

    /**
     * Checks the generated files compile.
     * @param outputName the name of the output file.
     * @param outputFiles the output files.
     */
    protected void checkGeneratedFilesCompile(
        @NotNull final String outputName, @NotNull final Map<String, File> outputFiles)
    {
        for (@NotNull final File outputFile : outputFiles.values())
        {
            FileUtils.getInstance().copyIfPossible(
                outputFile, new File(outputFile.getName()), Charset.defaultCharset());

            if (   (outputFile.getAbsolutePath().endsWith(outputName))
                && (isJava(outputFile)))
            {
                @Nullable JavaParser t_Parser = null;

                try
                {
                    t_Parser = setUpParser(outputFile);
                }
                catch (final IOException missingFile)
                {
                    Assert.fail("Missing file: " + missingFile.getMessage());
                }

                @Nullable ParseTree tree = null;

                try
                {
                    tree = t_Parser.compilationUnit();
                }
                catch (@NotNull final Throwable invalidClass)
                {
                    Assert.fail(PARSER_ERROR + invalidClass.getMessage());
                }

                @NotNull final JavaPackageVisitor packageVisitor = new JavaPackageVisitor();

                @Nullable String packageName = null;

                try
                {
                    packageVisitor.visit(tree);

                    packageName = packageVisitor.getPackageName();
                }
                catch (@NotNull final Throwable invalidClass)
                {
                    Assert.fail(PARSER_ERROR + invalidClass.getMessage());
                }

                Assert.assertNotNull(
                    "Missing package in file " + outputFile.getAbsolutePath(), packageName);
                Assert.assertEquals(
                    "Invalid package in file " + outputFile.getAbsolutePath(),
                    "com.foo.bar.dao",
                    packageName);

                @NotNull final JavaRootClassNameVisitor rootClassVisitor = new JavaRootClassNameVisitor();

                @Nullable String rootClass = null;

                try
                {
                    rootClassVisitor.visit(tree);

                    rootClass = rootClassVisitor.getRootClass();
                }
                catch (@NotNull final Throwable invalidClass)
                {
                    Assert.fail(PARSER_ERROR + invalidClass.getMessage());
                }

                Assert.assertNotNull("Missing class in file " + outputFile.getAbsolutePath(), rootClass);
            }
        }
    }

    /**
     * Checks if the output file is Java or not.
     * @param outputFile the output file.
     * @return <code>true</code> in such case.
     */
    protected boolean isJava(@NotNull final File outputFile)
    {
        return outputFile.getAbsolutePath().endsWith(".java");
    }

    /**
     * Checks if the output file is a properties or not.
     * @param outputFile the output file.
     * @return <code>true</code> in such case.
     */
    protected boolean isProperties(@NotNull final File outputFile)
    {
        return outputFile.getAbsolutePath().endsWith(org.acmsl.commons.Literals.PROPERTIES);
    }

    /**
     * Creates a temporary directory.
     * @param prefix the prefix to use (optional).
     * @return the temporary folder.
     */
    @SuppressWarnings("unused")
    @NotNull
    protected File createTempFolder(@Nullable final String prefix)
        throws IOException
    {
        @Nullable File result = null;

        @NotNull final String folderPrefix = (prefix != null) ? prefix : "cucumber";

        @Nullable IOException exceptionToThrow = null;

        try
        {
            result = File.createTempFile(folderPrefix, Long.toString(System.nanoTime()));
        }
        catch (@NotNull final IOException ioException)
        {
            exceptionToThrow = ioException;
        }

        if (   (exceptionToThrow == null)
            && (result != null)
            && (!result.delete()))
        {
            exceptionToThrow =
                new IOException("Could not delete temporary file: " + result.getAbsolutePath());
        }

        if (   (exceptionToThrow == null)
            && (result != null)
            && (!result.mkdirs()))
        {
            exceptionToThrow =
                new IOException("Could not create temporary file: " + result.getAbsolutePath());
        }

        if (   (exceptionToThrow != null)
            || (result == null))
        {
            throw exceptionToThrow;
        }

        return result;
    }


    /**
     * Retrieves the template generator from given template name.
     * @param template the template.
     * @return such generator.
     */
    @Nullable
    protected G retrieveTemplateGenerator(@NotNull final String template)
    {
        return GENERATOR_MAPPINGS.get(template);
    }

    /**
     * Retrieves the template from given template name.
     * @param template the template.
     * @return such template.
     */
    @Nullable
    protected F retrieveTemplateFactory(@NotNull final String template)
    {
        return FACTORY_MAPPINGS.get(template);
    }

    /**
     * Retrieves the {@link org.acmsl.queryj.metadata.DecoratorFactory} instance using given generator.
     * @param generator the generator to use.
     * @return the decorator factory.
     */
    @NotNull
    protected abstract DecoratorFactory retrieveDecoratorFactory(@NotNull final G generator);

    /**
     * Retrieves a {@link org.acmsl.queryj.metadata.MetadataManager} instance.
     * @param engineName the name of the engine.
     * @param table the {@link org.acmsl.queryj.metadata.vo.Table}.
     * @return such instance.
     */
    @NotNull
    protected MetadataManager retrieveMetadataManager(
        @NotNull final String engineName,
	    @NotNull final Table<String, Attribute<String>, List<Attribute<String>>> table)
    {
        @NotNull final List<String> tableNames = new ArrayList<>(1);
        tableNames.add(table.getName());
        @NotNull final List<Table<String, Attribute<String>, List<Attribute<String>>>> tables =
	        new ArrayList<>(1);
        tables.add(table);

        return retrieveMetadataManager(engineName, tableNames, tables);
    }

    /**
     * Retrieves a {@link org.acmsl.queryj.metadata.MetadataManager} instance.
     * @param engineName the name of the engine.
     * @param table the {@link Table}.
     * @return such instance.
     */
    @SuppressWarnings("unused")
    @NotNull
    protected MetadataManager retrieveMetadataManager(@NotNull final String engineName, @NotNull final String table)
    {
        @NotNull final List<String> tableNames = new ArrayList<>(1);
        tableNames.add(table);
        @NotNull final List<Table<String, Attribute<String>, List<Attribute<String>>>> tables =
	    new ArrayList<>(0);

        return retrieveMetadataManager(engineName, tableNames, tables);
    }

    /**
     * Retrieves a {@link org.acmsl.queryj.metadata.MetadataManager} instance.
     * @param engineName the name of the engine.
     * @return such instance.
     */
    @SuppressWarnings("unused")
    @NotNull
    protected MetadataManager retrieveMetadataManager(@NotNull final String engineName)
    {
        @NotNull final List<String> tableNames = new ArrayList<>(0);
        @NotNull final List<Table<String, Attribute<String>, List<Attribute<String>>>> tables =
	    new ArrayList<>(0);

        return retrieveMetadataManager(engineName, tableNames, tables);
    }

    /**
     * Retrieves a {@link MetadataManager} instance.
     * @param engineName the name of the engine.
     * @param tables the tables.
     * @return such instance.
     */
    @NotNull
    protected MetadataManager retrieveMetadataManager(
        @NotNull final String engineName, @NotNull final List<Table<String, Attribute<String>, List<Attribute<String>>>> tables)
    {
        @NotNull final List<String> tableNames = new ArrayList<>(tables.size());

        for (@Nullable final Table<String, Attribute<String>, List<Attribute<String>>> table : tables)
        {
            if (table != null)
            {
                tableNames.add(table.getName());
            }
        }

        return retrieveMetadataManager(engineName, tableNames, tables);
    }

    /**
     * Retrieves a {@link MetadataManager} instance.
     * @param engineName the name of the engine.
     * @param tableNames the table names.
     * @param tables the tables.
     * @return such instance.
     */
    @NotNull
    protected MetadataManager retrieveMetadataManager(
        @NotNull final String engineName, @NotNull final List<String> tableNames,
        @NotNull final List<Table<String, Attribute<String>, List<Attribute<String>>>> tables)
    {
        return
            new JdbcMetadataManager(
                "fake manager",
                null, // database metadata
                new MetadataExtractionLogger(), // extraction listener
                Literals.CATALOG,
                Literals.SCHEMA,
                tableNames,
                tables,
                true, // disable table extraction
                true, // lazy table extraction
                false, // case sensitive
                new UndefinedJdbcEngine(engineName, "11")); // engine version
    }

    /**
     * Checks the generated properties files are valid.
     * @param outputName the name of the output file.
     * @param outputFiles the output files.
     */
    @SuppressWarnings("unused")
    protected void checkPropertiesFiles(
        @NotNull final String outputName, @NotNull final Map<String, File> outputFiles)
    {
        for (@NotNull final File outputFile : outputFiles.values())
        {
            FileUtils.getInstance().copyIfPossible(outputFile, new File(outputFile.getName()), Charset.defaultCharset());

            if (   (outputFile.getAbsolutePath().endsWith(outputName))
                && (isProperties(outputFile)))
            {
                final Properties properties = new Properties();

                FileInputStream stream = null;

                try
                {
                    stream = new FileInputStream(outputFile);
                    properties.load(stream);
                }
                catch (final IOException e)
                {
                    Assert.fail(CANNOT_READ_FILE + e.getMessage());
                }
                finally
                {
                    if (stream != null)
                    {
                        try
                        {
                            stream.close();
                        }
                        catch (IOException e)
                        {
                            Assert.fail(CANNOT_READ_FILE +  e.getMessage());
                        }
                    }
                }
            }
        }
    }

    /**
     * Retrieves the output file matching the name given.
     * @param fileName the file name.
     * @return the output file.
     */
    @SuppressWarnings("unused")
    @Nullable
    protected File retrieveOutputFile(@NotNull final String fileName)
    {
        @Nullable File result = null;

        for (@NotNull final File file : getOutputFiles().values())
        {
            if (file.getAbsolutePath().endsWith(fileName))
            {
                result = file;
                break;
            }
        }

        return result;
    }

    /**
     * Reads a properties file.
     * @param file the name of the properties file.
     * @return the properties.
     */
    @SuppressWarnings("unused")
    @Nullable
    protected Properties readPropertiesFile(@NotNull final File file)
    {
        Properties result = null;

        FileInputStream stream = null;
        try
        {
            stream = new FileInputStream(file);
            result = new Properties();
            result.load(stream);
        }
        catch (final IOException e)
        {
            Assert.fail(CANNOT_READ_FILE + e.getMessage());
        }
        finally
        {
            if (stream != null)
            {
                try
                {
                    stream.close();
                }
                catch (IOException e)
                {
                    Assert.fail(CANNOT_READ_FILE +  e.getMessage());
                }
            }
        }

        return result;
    }

    /**
     * Builds the template name.
     * @param context the template context.
     * @return such name.
     */
    protected String buildTemplateName(@NotNull final TemplateContext context)
    {
        @NotNull final String result;

        @NotNull final String aux = context.getTemplateName();

        final int t_iPosition = aux.indexOf('(');

        if (t_iPosition > -1)
        {
            result = aux.substring(0, t_iPosition);
        }
        else
        {
            result = aux;
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
        @NotNull final StringBuilder result =
            new StringBuilder("AbstractTemplatesTest{ FACTORY_MAPPINGS=");

        result.append(FACTORY_MAPPINGS);
        result.append(", GENERATOR_MAPPINGS=");
        result.append(GENERATOR_MAPPINGS);
        result.append(", PACKAGE_MAPPINGS=");
        result.append(PACKAGE_MAPPINGS);
        result.append(", rootFolder=");
        result.append(rootFolder);
        result.append(", outputFiles=");
        result.append(m__mOutputFiles);
        result.append(", tables=");
        result.append(m__mTables);
        result.append(", foreignKeys=");
        result.append(m__lForeignKeys);
        result.append(", sqlList=");
        result.append(m__lSql);
        result.append(", sqlParameters=");
        result.append(m__mParameters);
        result.append(", rows=");
        result.append(m__mRows);
        result.append(", engineName=");
        result.append(m__strEngineName);
        result.append(", jdbcDriver=");
        result.append(m__strJdbcDriver);
        result.append(", jdbcUrl=");
        result.append(m__strJdbcUrl);
        result.append(", jdbcUserName=");
        result.append(m__strJdbcUserName);
        result.append(", jdbcPassword=");
        result.append(m__strJdbcPassword);
        result.append("}");

        return result.toString();
    }
}
