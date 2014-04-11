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
 * Filename: JdbcMetadataTypeManagerTest.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Tests for JdbcMetadataTypeManager.
 *
 * Date: 2014/04/05
 * Time: 06:53
 *
 */
package org.acmsl.queryj.metadata.engines;

/*
 * Importing QueryJ Core classes.
 */
import org.acmsl.queryj.Literals;

/*
 * Importing JetBrains annotations.
 */
import org.jetbrains.annotations.NotNull;

/*
 * Importing JUnit classes.
 */
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/*
 * Importing JDK classes.
 */
import java.sql.Types;

/**
 * Tests for {@link JdbcMetadataTypeManager}.
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/04/05 06:53
 */
@RunWith(JUnit4.class)
public class JdbcMetadataTypeManagerTest
{
    /**
     * Tests toJdbcType works for VARCHAR2.
     */
    @Test
    public void toJdbcType_works_for_VARCHAR2()
    {
        @NotNull final JdbcMetadataTypeManager instance = new JdbcMetadataTypeManager();

        Assert.assertEquals(Types.VARCHAR, instance.toJdbcType(Literals.VARCHAR2, 10, 0));
    }

    /**
     * Tests isString() works for {@code Types.CLOB}.
     */
    @Test
    public void isString_works_for_CLOB()
    {
        @NotNull final JdbcMetadataTypeManager instance = new JdbcMetadataTypeManager();

        Assert.assertTrue(instance.isString(Types.CLOB));
    }

    /**
     * Tests whether isPrimitiveWrapper() knows about Integer class.
     */
    @Test
    public void isPrimitiveWrapper_works_for_Integer()
    {
        @NotNull final JdbcMetadataTypeManager instance = new JdbcMetadataTypeManager();

        Assert.assertTrue(instance.isPrimitiveWrapper(Integer.class.getSimpleName()));
    }

    /**
     * Tests whether isPrimitiveWrapper() knows about Long class.
     */
    @Test
    public void isPrimitiveWrapper_works_for_Long()
    {
        @NotNull final JdbcMetadataTypeManager instance = new JdbcMetadataTypeManager();

        Assert.assertTrue(instance.isPrimitiveWrapper(Long.class.getSimpleName()));
    }

    /**
     * Tests whether isPrimitiveWrapper() knows about Double class.
     */
    @Test
    public void isPrimitiveWrapper_works_for_Double()
    {
        @NotNull final JdbcMetadataTypeManager instance = new JdbcMetadataTypeManager();

        Assert.assertTrue(instance.isPrimitiveWrapper(Double.class.getSimpleName()));
    }

    /**
     * Tests whether isPrimitiveWrapper() knows about Float class.
     */
    @Test
    public void isPrimitiveWrapper_works_for_Float()
    {
        @NotNull final JdbcMetadataTypeManager instance = new JdbcMetadataTypeManager();

        Assert.assertTrue(instance.isPrimitiveWrapper(Float.class.getSimpleName()));
    }

    /**
     * Checks whether getConstantName() works for ARRAYs.
     */
    @Test
    public void getConstantName_retrieves_the_correct_constant_for_ARRAYs()
    {
        @NotNull final JdbcMetadataTypeManager instance = new JdbcMetadataTypeManager();

        Assert.assertEquals("ARRAY", instance.getConstantName(Types.ARRAY));
    }

    /**
     * Checks whether getConstantName() works for BIGINTs.
     */
    @Test
    public void getConstantName_retrieves_the_correct_constant_for_BIGINTs()
    {
        @NotNull final JdbcMetadataTypeManager instance = new JdbcMetadataTypeManager();

        Assert.assertEquals("BIGINT", instance.getConstantName(Types.BIGINT));
    }
}
