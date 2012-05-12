package bim;

/**
 * @version 1.0
 * @author hanynowsky 
 * CLass to compute the Body Mass Index using the
 * international Formula
 */
public class Computer {

    String healthy = "Healthy";
    String nhealthy = "Normal";
    String ill = "Ill";
    String fat = "Overweight";
    String obese = "Obese";
    String skinny = "Underweight";
    String extreme = "Not Healthy";
    /**
     * Text Strings for Health
     */
    String healthyT = "You're in a good but suspicious shape. \nYou do martial arts?";
    String nhealthyT = "You're in a normal & healthy shape";
    String illT = "You're underweight! Eat something";
    String fatT = "Overweight! Let's Jogg \n & stop swallowing everything";
    String obeseT = "Obese. I think you know it";
    String skinnyT = "Severe UW! Are you a Skeleton?";

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
            return extreme;
        }
    }
/**
 * 
 * @return a String - Detailed text corresponding to BMI details
 */
    public String getHealthText() {


        if (getHealth().equalsIgnoreCase(healthy)) {
            return healthyT;
        } else if (getHealth().equalsIgnoreCase(fat)) {
            return fatT;
        } else if (getHealth().equalsIgnoreCase(nhealthy)) {
            return nhealthyT;
        } else if (getHealth().equalsIgnoreCase(ill)) {
            return illT;
        } else if (getHealth().equalsIgnoreCase(obese)) {
            return obeseT;
        } else if (getHealth().equalsIgnoreCase(skinny)) {
            return skinnyT;
        } else {
            return "You might be living somwhere in US. "
                    + "\nCheck The Doctor for Aliens' Diet";
        }
    }
} // END OF CLASS
