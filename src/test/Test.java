package test;

import bim.Utilities;
import java.net.URISyntaxException;
import javax.swing.UIManager;

/**
 *
 * @author Hanynowsky <hanynowsky@gmail.com>
 */
public class Test {

    public static void main(String[] args) throws URISyntaxException {
        System.out.println("Testing executed");
        System.out.println(UIManager.getDefaults().getFont("Button.font"));
        // UIManager.put("TextField.font", new FontUIResource( yourFontHere ));
        

        // new Utilities().appendInXML("19");
        //new Utilities().pasteSplashFile();
        /**
         * Package[] allPackages = Package.getPackages();
         * System.out.println("All loaded packages:"); 
         * for (int i = 0; i <
         * allPackages.length; i++) { System.out.println("" + (i + 1) + ": " +
         * allPackages[i].getName() + ": " +
         * allPackages[i].getImplementationTitle() + ", version: " +
         * allPackages[i].getImplementationVersion()); }
         * System.out.println("Vendor is " + new Utilities().getVendor());
         */
        

    } // END OF MAIN
} // END OF CLASS
