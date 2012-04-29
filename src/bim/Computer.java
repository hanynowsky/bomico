package bim;

/**
 * @version 1.0
 * @author hanynowsky
 * CLass to compute the Body Mass Index using the international Formula
 */
public class Computer {

    //Constructor
    public Computer() {
    }
    /**
     * The result to be computed (double type)
     */
    double result = 0;

    public double getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
    }

    /**
     *
     * @param h is Height
     * @param w is Weight
     * @return the BIM
     */
    public double computer(double h, double w) {
        Double dw = new Double(Double.valueOf(w));
        Double dh = new Double(Double.valueOf(h * 0.01)); // Height/100 to convert Cm to Meters
        result = dw / (dh * dh);
        return result;
    }

    /**
     *
     * @return Explanation of BIM value
     */
    public String getHealth() {

        String healthy = "You're in a good but suspicious shape. \nYou do martial arts?";
        String nhealthy = "You're in a normal & healthy shape";
        String ill = "You're underweight! Eat something";
        String fat = "Overweight! Let's Jogg \n & stop swallowing everything";
        String obese = "Obese. I think you know it";
        String skinny = "Severe UW! Are you a Skeleton?";
        //       double bimv = this.result;

        if (18.5 < this.result & this.result < 20) {
            return healthy;
        } else if (25 < this.result & this.result < 30) {
            return fat;
        } else if (20 < this.result & this.result < 25) {
            return nhealthy;
        } else if (this.result < 18.5 & this.result > 16) {
            return ill;
        } else if (this.result > 30 & this.result < 40) {
            return obese;
        } else if (this.result < 16) {
            return skinny;
        } else {
            return "You might be living in US. \nCheck The Doctor for Aliens' Diet";
        }
    }
} // END OF CLASS
