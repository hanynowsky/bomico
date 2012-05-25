package test;

import bim.Utilities;
import javax.swing.UIManager;

/**
 *
 * @author Hanynowsky <hanynowsky@gmail.com>
 */
public class Test {

    Utilities util = new Utilities();

    public static void main(String[] args) {
        System.out.println(UIManager.getLookAndFeelDefaults().entrySet());
        // Utilities util = new Utilities();
        // System.out.println("Testing executed");
        //util.readIBMITABLE("Male", 1.49);
        Test test = new Test();
        //test.calculateRange();
        // util.readIBMITABLE("Male", 1.50);
        // System.out.println("Here is Range: " + util.getIbmirange());
    } // END OF MAIN

    public void calculateRange() {
    }
} // END OF CLASS
