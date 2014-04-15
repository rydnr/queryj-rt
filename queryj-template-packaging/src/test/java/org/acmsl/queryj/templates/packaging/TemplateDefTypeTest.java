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
 * Filename: TemplateDefTypeTest.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Tests for TemplateDefType.
 *
 * Date: 2014/04/15
 * Time: 07:33
 *
 */
package org.acmsl.queryj.templates.packaging;

/*
 * Importing JUnit classes.
 */
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for {@link TemplateDefType}.
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/04/15 07:33
 */
@RunWith(JUnit4.class)
public class TemplateDefTypeTest
{
    /**
     * Tests isPerTable() for all types.
     */
    @Test
    public void isPerTable_is_correct_for_all_types()
    {
        Assert.assertTrue(TemplateDefType.PER_TABLE.isPerTable());
        Assert.assertFalse(TemplateDefType.PER_REPOSITORY.isPerTable());
        Assert.assertFalse(TemplateDefType.PER_SQL.isPerTable());
        Assert.assertFalse(TemplateDefType.PER_FOREIGN_KEY.isPerTable());
        Assert.assertFalse(TemplateDefType.PER_CUSTOM_RESULT.isPerTable());
    }

    /**
     * Tests isPerRepository() for all types.
     */
    @Test
    public void isPerRepository_is_correct_for_all_types()
    {
        Assert.assertFalse(TemplateDefType.PER_TABLE.isPerTable());
        Assert.assertTrue(TemplateDefType.PER_REPOSITORY.isPerTable());
        Assert.assertFalse(TemplateDefType.PER_SQL.isPerTable());
        Assert.assertFalse(TemplateDefType.PER_FOREIGN_KEY.isPerTable());
        Assert.assertFalse(TemplateDefType.PER_CUSTOM_RESULT.isPerTable());
    }
}
