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
 * Filename: SerializableConfiguration.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: 
 *
 * Date: 2014/04/30
 * Time: 12:54
 *
 */
package org.acmsl.queryj;

/*
 * Importing JetBrains annotations.
 */
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;

import java.io.File;
import java.io.Serializable;

/**
 *
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/04/30 12:54
 */
@ThreadSafe
public class SerializableConfiguration
    extends PropertiesConfiguration
    implements Serializable
{
    /**
     * Creates an empty PropertyConfiguration object which can be
     * used to synthesize a new Properties file by adding values and
     * then saving().
     */
    public SerializableConfiguration()
    {
    }

    /**
     * Creates and loads the extended properties from the specified file.
     * The specified file can contain "include = " properties which then
     * are loaded and merged into the properties.
     *
     * @param fileName The name of the properties file to load.
     * @throws org.apache.commons.configuration.ConfigurationException
     *          Error while loading the properties file
     */
    public SerializableConfiguration(final String fileName) throws ConfigurationException
    {
        super(fileName);
    }

    /**
     * Creates and loads the extended properties from the specified file.
     * The specified file can contain "include = " properties which then
     * are loaded and merged into the properties. If the file does not exist,
     * an empty configuration will be created. Later the {@code save()}
     * method can be called to save the properties to the specified file.
     *
     * @param file The properties file to load.
     * @throws org.apache.commons.configuration.ConfigurationException
     *          Error while loading the properties file
     */
    public SerializableConfiguration(final File file) throws ConfigurationException
    {
        super(file);
    }
}
