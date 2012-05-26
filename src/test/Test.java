package test;

import bim.Computer;
import bim.Utilities;
import javax.swing.UIManager;

/**
 *
 * @author Hanynowsky <hanynowsky@gmail.com>
 */
public class Test {

    Utilities util = new Utilities();

    public static void main(String[] args) {
        Computer c = new Computer();
        // System.out.println(UIManager.getLookAndFeelDefaults().entrySet());
        // Utilities util = new Utilities();
        // System.out.println("Testing executed");
        //util.readIBMITABLE("Male", 1.49);
        // Test test = new Test();
        //test.calculateRange();
        // util.readIBMITABLE("Male", 1.50);
        // System.out.println("Here is Range: " + util.getIbmirange());
      //  c.computeBMR(58, 178, 31, "male");
       // c.computeTDEE("sedentary");
       // c.computeIdealWeight(178, "Hamwi", "female","mesomorph");
        Utilities utility = new Utilities();
        String slaf = UIManager.getLookAndFeel().getName();
        System.out.println(utility.prefs.get(utility.LAF_PREF, UIManager.getSystemLookAndFeelClassName()));
        System.out.println(UIManager.getSystemLookAndFeelClassName());

    } // END OF MAIN

    public void calculateRange() {
    }
} // END OF CLASS
