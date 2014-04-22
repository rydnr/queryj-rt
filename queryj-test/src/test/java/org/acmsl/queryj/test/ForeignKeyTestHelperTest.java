/*
                        QueryJ Test

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
 * Filename: ForeignKeyTestHelperTest.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Tests for ForeignKeyTestHelper.
 *
 * Date: 2014/04/22
 * Time: 06:13
 *
 */
package org.acmsl.queryj.test;

/*
 * Importing JetBrains annotations.
 */
import cucumber.api.DataTable;
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Tests for {@link ForeignKeyTestHelper}.
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/04/22 06:13
 */
@RunWith(JUnit4.class)
public class ForeignKeyTestHelperTest
{
    /**
     * Tests whether defineInputForeignKeys() adds new foreign keys to
     * the list passed.
     */
    @Test
    public void defineInputForeignKeys_builds_the_foreign_key_list()
    {
        @NotNull final ForeignKeyTestHelper instance = ForeignKeyTestHelper.getInstance();

        @NotNull final List<?> data = new ArrayList<>();
        @NotNull final String[] columnNames = { " " };

        @NotNull final DataTable dataTable = DataTable.create(data, Locale.getDefault(), columnNames);
        instance.defineInputForeignKeys(dataTable, );
    }
}
