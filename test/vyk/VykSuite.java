/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vyk;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author ilkka
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({vyk.PathBasedTest.class, vyk.VYKTest.class, vyk.TarjanTest.class, vyk.KosurajuTest.class})
public class VykSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
