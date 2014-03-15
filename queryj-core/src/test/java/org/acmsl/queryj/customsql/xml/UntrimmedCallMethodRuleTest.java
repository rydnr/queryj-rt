/*
                      Project tests

Copyright (C) 2003  Jose San Leandro Armend?riz
chous@acm-sl.org

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public
License as published by the Free Software Foundation; either
version 2 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
General Public License for more details.

You should have received a copy of the GNU General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

Thanks to ACM S.L. for distributing this library under the GPL license.
Contact info: pepe@acm-sl.com
Postal Address: c/Playa de Lagoa, 1
Urb. Valdecaba?as
Boadilla del monte
28660 Madrid
Spain

******************************************************************************
*
* Filename: $RCSfile$
*
* Author: Jose San Leandro Armend?riz
*
* Description: Executes all tests defined for package
*              org.acmsl.queryj.customsql.xml.
*
*/
package org.acmsl.queryj.customsql.xml;

/*
* Importing project classes.
*/
// JUnitDoclet begin import
import org.acmsl.commons.Literals;
import org.acmsl.queryj.customsql.xml.UntrimmedCallMethodRule;
// JUnitDoclet end import

/*
* Importing JUnit classes.
*/
import junit.framework.TestCase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
This file is part of  JUnitDoclet, a project to generate basic
test cases  from source code and  helping to keep them in sync
during refactoring.

Copyright (C) 2002-2005  ObjectFab GmbH  (http://www.objectfab.de/)

This library is  free software; you can redistribute it and/or
modify  it under the  terms of  the  GNU Lesser General Public
License as published  by the  Free Software Foundation; either
version 2.1  of the  License, or  (at your option)  any  later
version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or  FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Lesser General Public License for more details.

You  should  have  received a  copy of the  GNU Lesser General
Public License along with this  library; if not, write  to the
Free  Software  Foundation, Inc.,  59 Temple Place,  Suite 330,
Boston, MA  02111-1307  USA
*/


/**
* Tests UntrimmedCallMethodRuleTest class.
* @see org.acmsl.queryj.customsql.xml.UntrimmedCallMethodRule
*/
public class UntrimmedCallMethodRuleTest
// JUnitDoclet begin extends_implements
extends TestCase
// JUnitDoclet end extends_implements
{
  // JUnitDoclet begin class
  @Nullable
  org.acmsl.queryj.customsql.xml.UntrimmedCallMethodRule untrimmedcallmethodrule = null;
  // JUnitDoclet end class
  
  /**
  * Creates a UntrimmedCallMethodRuleTest with given name.
  * @param name such name.
  */
  public UntrimmedCallMethodRuleTest(String name)
  {
    // JUnitDoclet begin method UntrimmedCallMethodRuleTest
    super(name);
    // JUnitDoclet end method UntrimmedCallMethodRuleTest
  }
  
  /**
  * Creates an instance of the tested class.
  * @return such instance.
  
  */
  @NotNull
  public org.acmsl.queryj.customsql.xml.UntrimmedCallMethodRule createInstance()
  throws Exception
  {
    // JUnitDoclet begin method testcase.createInstance
    return new org.acmsl.queryj.customsql.xml.UntrimmedCallMethodRule(Literals.TO_STRING);
    // JUnitDoclet end method testcase.createInstance
  }
  
  /**
  * Performs any required steps before each test.
  * @throws Exception if an unexpected situation occurs.
  */
  protected void setUp()
  throws Exception
  {
    // JUnitDoclet begin method testcase.setUp
    super.setUp();
    untrimmedcallmethodrule = createInstance();
    // JUnitDoclet end method testcase.setUp
  }
  
  /**
  * Performs any required steps after each test.
  * @throws Exception if an unexpected situation occurs.
  */
  protected void tearDown()
  throws Exception
  {
    // JUnitDoclet begin method testcase.tearDown
    untrimmedcallmethodrule = null;
    super.tearDown();
    // JUnitDoclet end method testcase.tearDown
  }
  
  /**
  * Tests UntrimmedCallMethodRuleTestgetParamCount()
  * @throws Exception if an unexpected situation occurs.
  * @see org.acmsl.queryj.customsql.xml.UntrimmedCallMethodRule#getParamCount()
  */
  public void testGetParamCount()
  throws Exception
  {
    // JUnitDoclet begin method getParamCount
    // JUnitDoclet end method getParamCount
  }
  
  /**
  * Tests UntrimmedCallMethodRuleTestgetBodyText()
  * @throws Exception if an unexpected situation occurs.
  * @see org.acmsl.queryj.customsql.xml.UntrimmedCallMethodRule#getBodyText()
  */
  public void testGetBodyText()
  throws Exception
  {
    // JUnitDoclet begin method getBodyText
    // JUnitDoclet end method getBodyText
  }
  
  /**
  * Tests UntrimmedCallMethodRuleTestbody()
  * @throws Exception if an unexpected situation occurs.
  * @see org.acmsl.queryj.customsql.xml.UntrimmedCallMethodRule#body(java.lang.String)
  */
  public void testBody()
  throws Exception
  {
    // JUnitDoclet begin method body
    // JUnitDoclet end method body
  }
  
  
  
  /**
  * JUnitDoclet moves marker to this method, if there is not match
  * for them in the regenerated code and if the marker is not empty.
  * This way, no test gets lost when regenerating after renaming.
  * Method testVault is supposed to be empty.
  * @throws Exception if an unexpected situation occurs.
  */
  public void testVault()
  throws Exception
  {
    // JUnitDoclet begin method testcase.testVault
    // JUnitDoclet end method testcase.testVault
  }
  
  public static void main(String[] args)
  {
    // JUnitDoclet begin method testcase.main
    junit.textui.TestRunner.run(UntrimmedCallMethodRuleTest.class);
    // JUnitDoclet end method testcase.main
  }
}
