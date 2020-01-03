package gen_algoritm.implementation;

import gen_algoritm.AlelInterface;
import gen_algoritm.CalcResultInterface;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
public class FuncItemTest {

    public FuncItemTest() {
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
     * Test of calc method, of class FuncItem.
     */
    @Test
    public void testCalc_Double_AlelInterfaceArr() {
        System.out.println("calc");
        Double x = null;

        List<AlelInterface<Double>> alelList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            GraphicAlel alel = new GraphicAlel("p" + i, (i * 0.1));
            alelList.add(alel);
        }
        FuncItem instance = new FuncItem();
        CalcResultInterface expResult = null;
        AlelInterface<Double>[] test = alelList.stream().map((t) -> {
            return t;
        }).toArray(AlelInterface[]::new);

        CalcResultInterface result = instance.calc(3d, test);
        System.out.println("result = " + result);
        assertNotNull(result);

    }

    /**
     * Test of calc method, of class FuncItem.
     */
    @Test
    @Ignore
    public void testCalc_Double() {
        System.out.println("calc");
        Double x = null;
        FuncItem instance = new FuncItem();
        CalcResultInterface<Double, Double> expResult = null;
        CalcResultInterface<Double, Double> result = instance.calc(x);
        assertEquals(expResult, result);
    }

}
