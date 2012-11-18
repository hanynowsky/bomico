/*
 * License
 * .
 */
package bim;

import java.awt.Color;
import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Map;
import junit.framework.TestCase;

/**
 *
 * @author hanine
 */
public class UtilitiesTest extends TestCase {
    
    public UtilitiesTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of setPreferences method, of class Utilities.
     */
    public void testSetPreferences() {
        System.out.println("setPreferences");
        String PREF = "";
        Object value = null;
        Utilities instance = new Utilities();
        instance.setPreferences(PREF, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIbmirange method, of class Utilities.
     */
    public void testGetIbmirange() {
        System.out.println("getIbmirange");
        Utilities instance = new Utilities();
        String expResult = "";
        String result = instance.getIbmirange();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIbmirange method, of class Utilities.
     */
    public void testSetIbmirange() {
        System.out.println("setIbmirange");
        String ibmirange = "";
        Utilities instance = new Utilities();
        instance.setIbmirange(ibmirange);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getManMap method, of class Utilities.
     */
    public void testGetManMap() {
        System.out.println("getManMap");
        Utilities instance = new Utilities();
        Map expResult = null;
        Map result = instance.getManMap();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setManMap method, of class Utilities.
     */
    public void testSetManMap() {
        System.out.println("setManMap");
        Map manMap = null;
        Utilities instance = new Utilities();
        instance.setManMap(manMap);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWomanMap method, of class Utilities.
     */
    public void testGetWomanMap() {
        System.out.println("getWomanMap");
        Utilities instance = new Utilities();
        Map expResult = null;
        Map result = instance.getWomanMap();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWomanMap method, of class Utilities.
     */
    public void testSetWomanMap() {
        System.out.println("setWomanMap");
        Map womanMap = null;
        Utilities instance = new Utilities();
        instance.setWomanMap(womanMap);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLocalpath method, of class Utilities.
     */
    public void testGetLocalpath() {
        System.out.println("getLocalpath");
        String expResult = "";
        String result = Utilities.getLocalpath();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getXmlFile method, of class Utilities.
     */
    public void testGetXmlFile() {
        System.out.println("getXmlFile");
        File expResult = null;
        File result = Utilities.getXmlFile();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMotiflaf method, of class Utilities.
     */
    public void testGetMotiflaf() {
        System.out.println("getMotiflaf");
        String expResult = "";
        String result = Utilities.getMotiflaf();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMotiflaf method, of class Utilities.
     */
    public void testSetMotiflaf() {
        System.out.println("setMotiflaf");
        String motiflaf = "";
        Utilities.setMotiflaf(motiflaf);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNimbuslaf method, of class Utilities.
     */
    public void testGetNimbuslaf() {
        System.out.println("getNimbuslaf");
        String expResult = "";
        String result = Utilities.getNimbuslaf();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNimbuslaf method, of class Utilities.
     */
    public void testSetNimbuslaf() {
        System.out.println("setNimbuslaf");
        String nimbuslaf = "";
        Utilities.setNimbuslaf(nimbuslaf);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLaf method, of class Utilities.
     */
    public void testGetLaf() {
        System.out.println("getLaf");
        String expResult = "";
        String result = Utilities.getLaf();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLaf method, of class Utilities.
     */
    public void testSetLaf() {
        System.out.println("setLaf");
        String laf = "";
        Utilities.setLaf(laf);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVendor method, of class Utilities.
     */
    public void testGetVendor() {
        System.out.println("getVendor");
        Utilities instance = new Utilities();
        String expResult = "";
        String result = instance.getVendor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBuild method, of class Utilities.
     */
    public void testGetBuild() {
        System.out.println("getBuild");
        Utilities instance = new Utilities();
        String expResult = "";
        String result = instance.getBuild();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTitle method, of class Utilities.
     */
    public void testGetTitle() {
        System.out.println("getTitle");
        Utilities instance = new Utilities();
        String expResult = "";
        String result = instance.getTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVersion method, of class Utilities.
     */
    public void testGetVersion() {
        System.out.println("getVersion");
        Utilities instance = new Utilities();
        String expResult = "";
        String result = instance.getVersion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDefaultLaf method, of class Utilities.
     */
    public void testGetDefaultLaf() {
        System.out.println("getDefaultLaf");
        Utilities instance = new Utilities();
        String expResult = "";
        String result = instance.getDefaultLaf();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGtklaf method, of class Utilities.
     */
    public void testGetGtklaf() {
        System.out.println("getGtklaf");
        Utilities instance = new Utilities();
        String expResult = "";
        String result = instance.getGtklaf();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGtklaf method, of class Utilities.
     */
    public void testSetGtklaf() {
        System.out.println("setGtklaf");
        String gtklaf = "";
        Utilities instance = new Utilities();
        instance.setGtklaf(gtklaf);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMetallaf method, of class Utilities.
     */
    public void testGetMetallaf() {
        System.out.println("getMetallaf");
        Utilities instance = new Utilities();
        String expResult = "";
        String result = instance.getMetallaf();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMetallaf method, of class Utilities.
     */
    public void testSetMetallaf() {
        System.out.println("setMetallaf");
        String metallaf = "";
        Utilities instance = new Utilities();
        instance.setMetallaf(metallaf);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAppInfos method, of class Utilities.
     */
    public void testGetAppInfos() {
        System.out.println("getAppInfos");
        Utilities instance = new Utilities();
        String expResult = "";
        String result = instance.getAppInfos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createFile method, of class Utilities.
     */
    public void testCreateFile() {
        System.out.println("createFile");
        Utilities instance = new Utilities();
        instance.createFile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of appendInXML method, of class Utilities.
     */
    public void testAppendInXML() {
        System.out.println("appendInXML");
        String bmival = "";
        Utilities instance = new Utilities();
        instance.appendInXML(bmival);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readXML method, of class Utilities.
     */
    public void testReadXML() {
        System.out.println("readXML");
        String v = "";
        String y = "";
        String m = "";
        String d = "";
        String t = "";
        Utilities instance = new Utilities();
        instance.readXML(v, y, m, d, t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pasteSplashFile method, of class Utilities.
     */
    public void testPasteSplashFile() {
        System.out.println("pasteSplashFile");
        Utilities instance = new Utilities();
        instance.pasteSplashFile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pasteSynthFile method, of class Utilities.
     */
    public void testPasteSynthFile() {
        System.out.println("pasteSynthFile");
        Utilities instance = new Utilities();
        instance.pasteSynthFile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readIBMITABLE method, of class Utilities.
     */
    public void testReadIBMITABLE() {
        System.out.println("readIBMITABLE");
        int gender = 0;
        double height = 0.0;
        Utilities instance = new Utilities();
        instance.readIBMITABLE(gender, height);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of centerOnScreen method, of class Utilities.
     */
    public void testCenterOnScreen() {
        System.out.println("centerOnScreen");
        Component c = null;
        boolean absolute = false;
        Utilities instance = new Utilities();
        instance.centerOnScreen(c, absolute);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of centerOnParent method, of class Utilities.
     */
    public void testCenterOnParent() {
        System.out.println("centerOnParent");
        Window child = null;
        boolean absolute = false;
        Utilities instance = new Utilities();
        instance.centerOnParent(child, absolute);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertHeight method, of class Utilities.
     */
    public void testConvertHeight() {
        System.out.println("convertHeight");
        double height = 0.0;
        String expResult = "";
        String result = Utilities.convertHeight(height);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertWeight method, of class Utilities.
     */
    public void testConvertWeight() {
        System.out.println("convertWeight");
        double weight = 0.0;
        double expResult = 0.0;
        double result = Utilities.convertWeight(weight);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertCMtoINCH method, of class Utilities.
     */
    public void testConvertCMtoINCH() {
        System.out.println("convertCMtoINCH");
        double cm = 0.0;
        double expResult = 0.0;
        double result = Utilities.convertCMtoINCH(cm);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of playAudio method, of class Utilities.
     */
    public void testPlayAudio() {
        System.out.println("playAudio");
        String status = "";
        boolean soundEnabled = false;
        Utilities instance = new Utilities();
        instance.playAudio(status, soundEnabled);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actionPerformed method, of class Utilities.
     */
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        Utilities instance = new Utilities();
        instance.actionPerformed(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setColor method, of class Utilities.
     */
    public void testSetColor() {
        System.out.println("setColor");
        double weight = 0.0;
        double iweight = 0.0;
        Color expResult = null;
        Color result = Utilities.setColor(weight, iweight);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showSystemPath method, of class Utilities.
     */
    public void testShowSystemPath() {
        System.out.println("showSystemPath");
        String expResult = "";
        String result = Utilities.showSystemPath();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of restartApplication method, of class Utilities.
     */
    public void testRestartApplication() {
        System.out.println("restartApplication");
        Utilities.restartApplication();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeLocale method, of class Utilities.
     */
    public void testChangeLocale() {
        System.out.println("changeLocale");
        String locale = "";
        Utilities.changeLocale(locale);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDesktopHint method, of class Utilities.
     */
    public void testGetDesktopHint() {
        System.out.println("getDesktopHint");
        Object expResult = null;
        Object result = Utilities.getDesktopHint();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
