package bim;

/**
 * @version 1.0
 * @author hanynowsky CLass to compute the Body Mass Index using the
 * international Formula
 */
public class Computer {

    String healthy = "Healthy";
    String nhealthy = "Normal";
    String ill = "Underweight";
    String fat = "Overweight";
    String obese = "Obese";
    String skinny = "X-Underweight";
    String extreme = "Not Healthy";
    /**
     * Text Strings for Health
     */
    String healthyT = "You're in a good but suspicious shape. \nDo you practice martial arts?";
    String nhealthyT = "You're in a normal & healthy shape";
    String illT = "You're underweight! Eat something";
    String fatT = "Overweight! Let's Jogg \n & stop swallowing everything";
    String obeseT = "Obese. I think you know it";
    String skinnyT = "Severe Underweight! Are you a Skeleton?";
    double result = 0;
    double ideal = 0;
    double iweight;
    double EER;
    double PA;
    double BMRA;
    double BMR;
    double TDEE;

    //Constructor
    public Computer() {
    }

    public double getTDEE() {
        return TDEE;
    }

    public double getBMR() {
        return BMR;
    }

    public double getBMRA() {
        return BMRA;
    }

    public void setBMRA(double BMRA) {
        this.BMRA = BMRA;
    }

    public double getEER() {
        return EER;
    }

    public void setEER(double EER) {
        this.EER = EER;
    }

    public double getPA() {
        return PA;
    }

    public void setPA(double PA) {
        this.PA = PA;
    }

    public double getIweight() {
        return iweight;
    }

    public void setIweight(double iweight) {
        this.iweight = iweight;
    }

    public double getIdeal() {
        return ideal;
    }

    public void setIdeal(double ideal) {
        this.ideal = ideal;
    }

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
     * Compute the Ideal weight using the specified formulas.
     *
     * @param hei Height in centimeters
     * @param formula Ideal Weight Formula
     * @param gender Gender (Male or Female)
     * @param morph Morphology (Ectomorph | Mesomorph | Endomorph)
     * @return Ideal Weight
     */
    public double computeIdealWeight(double hei, String formula, String gender, String morph) {
        double height = hei * 0.01; // Convert centimeters to Meters
        //1 centimeter = 0.393700787 inch
        // 1 inch = 2.54 cms
        // 1 foot = 30.48 centimeters
        double i = (hei - 152.4) * 0.393700787; // 
        if (gender.equalsIgnoreCase("male")) {

            switch (formula) {
                case "Robinson":
                    iweight = 52 + (1.9 * i);
                    break;
                case "Miller":
                    iweight = 56.2 + (1.41 * i);
                    break;
                case "Hamwi":
                    if (morph.equalsIgnoreCase("ectomorph")) {
                        iweight = (48 + (2.7 * i)) - ((48 + (2.7 * i)) * 10 / 100);
                    }
                    if (morph.equalsIgnoreCase("mesomorph")) {
                        iweight = 48 + (2.7 * i);
                    }
                    if (morph.equalsIgnoreCase("endomorph")) {
                        iweight = (48 + (2.7 * i)) + ((48 + (2.7 * i)) * 10 / 100);
                    }
                    if (morph.equalsIgnoreCase("")) {
                        iweight = 48 + (2.7 * i);
                    }
                    break;

                case "Devine":
                    iweight = 50 + (2.3 * i);
                    break;
                case "Social":
                    iweight = getIdeal() * (Math.pow(height, 2));
                    break;
                case "":
                    iweight = getIdeal() * (Math.pow(height, 2));
                    break;
            }


        } else if (gender.equalsIgnoreCase("female")) {

            switch (formula) {
                case "Robinson":
                    iweight = 49 + (1.7 * i);
                    break;
                case "Miller":
                    iweight = 53.1 + (1.36 * i);
                    break;
                case "Hamwi":
                    if (morph.equalsIgnoreCase("")) {
                        iweight = 45 + (2.2 * i);
                    }
                    if (morph.equalsIgnoreCase("ectomorph")) {
                        iweight = (45 + (2.2 * i)) - ((45 + (2.2 * i)) * 10 / 100);
                    }
                    if (morph.equalsIgnoreCase("mesomorph")) {
                        iweight = 45 + (2.2 * i);
                    }
                    if (morph.equalsIgnoreCase("endomorph")) {
                        iweight = (45 + (2.2 * i)) + ((45 + (2.2 * i)) * 10 / 100);
                    }
                    ;
                    break;

                case "Devine":
                    iweight = 45.5 + (2.3 * i);
                    break;
                case "Social":
                    iweight = getIdeal() * (Math.pow(height, 2));
                    break;
                case "":
                    iweight = getIdeal() * (Math.pow(height, 2));
                    break;
            }
        }

        return iweight;
    }

    /**
     *
     * @param age Age
     * @param gender Gender
     * @param bmival value of medical BMI
     * @return
     */
    public double computePeopleIdeal(int age, String gender, double bmival) {
        if (gender.equalsIgnoreCase("male")) {
            ideal = 0.5 * bmival + 11.5;
        } else {
            ideal = 0.4 * bmival + 0.03 * age + 11;
        }


        //

        /*
         * Men	Social Ideal BMI	= 0.5 * bmi + 11.5
         *
         * Women	Social Ideal BMI	= 0.4 * bmi + 0.03*Age + 11
         */

        return ideal;
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

    /**
     *  * The official formulas for the calculation of your daily estimated
     * energy requirements (EER) are provided by the Food and Nutrition Board of
     * the Institute of Medicine of the National Academies. (Trumbo et al. 2002)
     *
     * EER Male = (662 - (9.53 x Age)) + (PA x ((15.91 x Weight) + (539.6 x
     * Height))).
     *
     * EER Female = (354 - (6.91 x Age)) + (PA x ((9.36 x Weight) + (726 x
     * Height))).
     *
     * PA indicates your Activity Level and is equal to 1.0 for Sedentary, 1.12
     * for Low Active, 1.27 for Active and 1.45 for Very Active. Weight is
     * measured in kilograms and height in meters.
     *
     * @param age Age
     * @param activity Activity
     * @param heit Height
     * @param weit Weight
     * @param gender gender
     * @return EER
     */
    public double computeEER(int age, String activity, double heit, double weit, String gender) {

        if (activity.equalsIgnoreCase("sedentary")) {
            setPA(1.00);
        } else if (activity.contains("ow")) {
            setPA(1.12);
        } else if (activity.equalsIgnoreCase("active")) {
            setPA(1.27);
        } else if (activity.contains("ery")) {
            setPA(1.45);
        } else if (activity.contains("xtreme")) {
            setPA(1.66);
        } else if (activity.equals("") || activity == null) {
            setPA(1.27);
        }

        if (gender.equalsIgnoreCase("male")) {
            EER = (662 - (9.53 * age)) + (getPA() * ((15.91 * weit) + (539.6 * heit)));
        } else {
            EER = (354 - (6.91 * age)) + (getPA() * ((9.36 * weit) + (726 * heit)));
        }
        return EER;
    }

    /**
     * Compute the Basal Metabolic Rate
     *
     * @param w Weight as double
     * @param h Height as double
     * @param a Age as integer
     * @param g Gender as String
     * @return BMR Basal Metabolic Rate
     */
    public double computeBMR(double w, double h, int a, String g) {

        if (g.equalsIgnoreCase("female")) {     // Women BMR = 655 +(9.6*w)+(1.8*h)-(4.7*a)
            BMR = 655 + (9.6 * w) + (1.8 * h) - (4.7 * a);
        } else {
            BMR = 66 + (13.7 * w) + (5 * h) - (6.8 * a);
        }
        return BMR;
    }

    public double computeTDEE(String activity) {
        /**
         * Total Daily Energy Expenditure (TDEE) = Caloric requirements to
         * maintain weight.
         *
         * TDEE = BMR * Activity Factor
         *
         * Sedentary = Little or no exercise/desk job = 1.2 Lightly active = 1-3
         * sport/week = 1.375 Moderately active = 3-5 sport week = 1.55 Very
         * active = 6-7 sport/week = 1.725 extremely active = 2sports/day = 1.9
         */
        double a = 0;
        if (activity.equalsIgnoreCase("sedentary")) {
            a = 1.2;
        } else if (activity.contains("ow")) {
            a = 1.375;
        } else if (activity.contains("ery")) {
            a = 1.725;
        } else if (activity.equalsIgnoreCase("active")) {
            a = 1.55;
        } else if (activity.contains("xtreme")) {
            a = 1.9;
        }

        TDEE = BMR * a;
        return TDEE;
    }
} // END OF CLASS
