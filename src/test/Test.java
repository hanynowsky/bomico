package test;

import bim.Utilities;
import java.util.Iterator;

/**
 *
 * @author Hanynowsky <hanynowsky@gmail.com>
 */
public class Test {

    public static void main(String[] args) {

        



        System.out.println("Testing executed");
        // Computer c = new Computer();
        Utilities util = new Utilities();
        util.readIBMITABLE("male", 1.74);
        System.out.println("range is " + util.getIbmirange());
        double j = 0;
        double e = 0;
        double s;
        double arg = 1.78;
        double diff;
        double dim;
        double ah = 0;
        Iterator kset = util.manMap.keySet().iterator();
        for (int k = 0; k < util.manMap.keySet().size(); k++) {
            while (kset.hasNext()) {
                //  System.err.println(kset.next() + " size= " + util.manMap.keySet().size());
                s = Double.parseDouble(kset.next().toString());
                diff = Math.max(s, arg);
                dim = Math.min(s, arg);
// 0.013 is the maximum difference between two ordered height values
                //  System.out.println(" here is FIRST  diff: " + diff);
                if (diff - arg <= 0.013 && diff != arg) {
                    // diff - arg
                    j = diff;
                    System.out.println("here is diff: " + diff);

                    // break;
                }

                if (arg - dim <= 0.013 && dim != arg) {
                    e = dim;
                    System.out.println("here is dim: " + dim);
                }
            }
        }
        if ((arg - e) < (j - arg)) {
            ah = e;
        }
        if ((arg - e) > (j - arg)) {
            ah = j;
        }
        System.err.println(j + " " + (j - arg));
        System.err.println(e + " " + (arg - e));
        System.err.println("And here is final ah: " + ah);

        // UIManager.put("TextField.font", new FontUIResource( yourFontHere ));


    } // END OF MAIN
} // END OF CLASS
