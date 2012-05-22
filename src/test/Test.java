package test;

import bim.Computer;
import java.net.URISyntaxException;
import java.text.DecimalFormat;

/**
 *
 * @author Hanynowsky <hanynowsky@gmail.com>
 */
public class Test {

    public static void main(String[] args) throws URISyntaxException {
        System.out.println("Testing executed");
        Computer c = new Computer();
        c.computeEER(30, "active", 178, 58, "male");
        System.out.println(new DecimalFormat("#").format(c.getEER()));
        // new Utilities().readXML("Value is ", "Year is ", "Month is ", "Day is ", "Time is ");

        // UIManager.put("TextField.font", new FontUIResource( yourFontHere ));


        // new Utilities().appendInXML("19");
//        new Utilities().pasteSplashFile();

        /**
         * Package[] allPackages = Package.getPackages();
         * System.out.println("All loaded packages:"); for (int i = 0; i <
         * allPackages.length; i++) { System.out.println("" + (i + 1) + ": " +
         * allPackages[i].getName() + ": " +
         * allPackages[i].getImplementationTitle() + ", version: " +
         * allPackages[i].getImplementationVersion()); }
         * System.out.println("Vendor is " + new Utilities().getVendor());
         */
    } // END OF MAIN
} // END OF CLASS
