/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bim;

import static org.junit.Assert.*;
import org.junit.*;

/**
 *
 * @author Hanynowsky <hanynowsky@gmail.com>
 */
public class ComputerTest {
    
    public ComputerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getIweight method, of class Computer.
     */
    @Test
    public void testGetIweight() {
        System.out.println("getIweight");
        Computer instance = new Computer();
        double expResult = 0.0;
        double result = instance.getIweight();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdeal method, of class Computer.
     */
    @Test
    public void testGetIdeal() {
        System.out.println("getIdeal");
        Computer instance = new Computer();
        double expResult = 0.0;
        double result = instance.getIdeal();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdeal method, of class Computer.
     */
    @Test
    public void testSetIdeal() {
        System.out.println("setIdeal");
        double ideal = 0.0;
        Computer instance = new Computer();
        instance.setIdeal(ideal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResult method, of class Computer.
     */
    @Test
    public void testGetResult() {
        System.out.println("getResult");
        Computer instance = new Computer();
        double expResult = 0.0;
        double result = instance.getResult();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setResult method, of class Computer.
     */
    @Test
    public void testSetResult() {
        System.out.println("setResult");
        float result_2 = 0.0F;
        Computer instance = new Computer();
        instance.setResult(result_2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of computer method, of class Computer.
     */
    @Test
    public void testComputer() {
        System.out.println("computer");
        double h = 0.0;
        double w = 0.0;
        Computer instance = new Computer();
        double expResult = 0.0;
        double result = instance.computer(h, w);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of computeIdealWeight method, of class Computer.
     */
    @Test
    public void testComputeIdealWeight() {
        System.out.println("computeIdealWeight");
        double hei = 0.0;
        Computer instance = new Computer();
        double expResult = 0.0;
        double result = instance.computeIdealWeight(hei);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of computePeopleIdeal method, of class Computer.
     */
    @Test
    public void testComputePeopleIdeal() {
        System.out.println("computePeopleIdeal");
        int age = 0;
        String gender = "";
        double bmival = 0.0;
        Computer instance = new Computer();
        double expResult = 0.0;
        double result = instance.computePeopleIdeal(age, gender, bmival);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHealth method, of class Computer.
     */
    @Test
    public void testGetHealth() {
        System.out.println("getHealth");
        Computer instance = new Computer();
        String expResult = "";
        String result = instance.getHealth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHealthText method, of class Computer.
     */
    @Test
    public void testGetHealthText() {
        System.out.println("getHealthText");
        Computer instance = new Computer();
        String expResult = "";
        String result = instance.getHealthText();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
