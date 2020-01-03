package gen_algoritm.implementation;

import gen_algoritm.CalcResultInterface;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author admin
 */
public class BaseFuncItemTest {

    public BaseFuncItemTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of calc method, of class BaseFuncItem.
     */
    @Test
    public void testCalc_Double() {
        System.out.println("calc");
        Double x = 0d;
        BaseFuncItem instance = new BaseFuncItem();
        Double expResult = 0d;
        CalcResultInterface<Double, Double> result = instance.calc(x);
        assertEquals(expResult, result.getY());

    }

    /**
     * Test of calc method, of class BaseFuncItem.
     */
    @Test
    @Ignore
    public void testCalc_Double_DoubleArr() {
        System.out.println("calc");
        Double x = null;
        Double[] param = null;
        BaseFuncItem instance = new BaseFuncItem();
        CalcResultInterface<Double, Double> expResult = null;
        CalcResultInterface<Double, Double> result = instance.calc(x, param);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
