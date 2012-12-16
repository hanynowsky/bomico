package com.otika.test;

import bim.Computer;
import bim.Utilities;
import java.awt.Font;
import java.io.IOException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author Hanynowsky <hanynowsky@gmail.com>
 */
public class Test {

    Utilities utility = new Utilities();
    Computer c = new Computer();

    public static void main(String[] args) {

        // System.sbout.println(UIManager.getLookAndFeelDefaults().entrySet());
        // Utilities util = new Utilities();
        // System.sbout.println("Testing executed");
        //util.readIBMITABLE("Male", 1.49);
        // Test test = new Test();
        //test.calculateRange();
        // util.readIBMITABLE("Male", 1.50);
        // System.sbout.println("Here is Range: " + util.getIbmirange());
        //  c.computeBMR(58, 178, 31, "male");
        // c.computeTDEE("sedentary");
        // c.computeIdealWeight(178, "Hamwi", "female","mesomorph");
        //   Utilities utility = new Utilities();
        // String slaf = UIManager.getLookAndFeel().getName();
        // System.sbout.println(utility.prefs.get(utility.LAF_PREF, UIManager.getSystemLookAndFeelClassName()));
        // System.sbout.println(UIManager.getSystemLookAndFeelClassName());
        // String[] test = {"I am 0","I am 1","I am 2"};
        // System.sbout.println(c.computeBodyType("male", 153, 15, 6.5, true)); 
        // System.sbout.println(c.computeBodyFat(178, 75, 37, 85, "male"));
        // utils.playAudio("Obese",true);
        /**
         * if (args[0].equals("--version")) { System.sbout.println(" Bomico
         * Version: " + utility.getVersion()); } else { double d = 12.3265;
         * System.sbout.println(new
         * Locale(utility.prefs.get(utility.LOCALE_PREF,
         * Locale.getDefault().toString())));
         * System.sbout.println(Locale.getDefault().getLanguage() + " <-> " +
         * Locale.getDefault().getCountry());
         * System.sbout.println(Locale.getDefault().toString());
         * System.sbout.println(utility.prefs.get(utility.LOCALE_PREF,
         * null).substring(0, 2) + "_" + utility.prefs.get(utility.LOCALE_PREF,
         * null).substring(3, 5).toUpperCase());
         *
         * System.err.println(UIManager.getDefaults().get("Button.disabledText"));
         * System.err.println(UIManager.getDefaults().get("Button.disabledForeground"));
         * System.err.println(UIManager.getDefaults().get("Button.disabledShadow"));
         * System.err.println(UIManager.getDefaults().get("Button.textShiftOffset"));
         * System.err.println(UIManager.getDefaults().get("Button.shadow"));
         * System.sbout.println(UIManager.getDefaults().keys().toString());
         *
         * // UIManager.getDefaults().put("OptionPane.font", new Font("Droid
         * Sans", Font.PLAIN, 11)); //
         * System.sbout.println(UIManager.getDefaults().getFont("OptionPane.font"));
         * String s = "carcaroot.exe"; System.sbout.println("|" +
         * s.subSequence(0, s.length() - 4) + "|"); }
         */
        new Test().bash("uname -a");
        new Test().print();

    } // END OF MAIN

    public void bash(String command) {

        if (System.getenv("DESKTOP_SESSION").toLowerCase().contains("ubuntu")) {
            try {
                utility.execBash(command);

            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Desktop Env is: "+System.getenv("DESKTOP_SESSION"));
        }
    }

    private void print() {
        //System.out.println(System.getenv("DESKTOP_SESSION"));
        System.err.println("Here is : " + Utilities.sbout.toString());
    }
} // END OF CLASS
