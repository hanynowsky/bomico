package bim;

import java.text.DecimalFormat;

/**
 * @version 1.0
 * @author hanynowsky CLass to compute the Body Mass Index using the
 * international Formula
 */
public class Computer {

    String health = "";
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
    double BF;
    String[] BFS = {"Essential Fat", "Athletes", "Fitness", "Acceptable", "Obese", "N/A"};
    String BFString = ""; // Receives the value of BFS when BF is calculated
    String[] bodytype = {"Small", "Medium", "Large",
        "Please use the elbow measure for male heights below 1.63m (5\'5)",
        "There is no measure for males below 1.55m (5\'2)",
        "There is no measure for females below 1.46m (4\'10) or above 1.90m (6\'4)", "UNKNOWN"};
    String btmsg = "";

    //Constructor
    public Computer() {
    }

    public double getBF() {
        return BF;
    }

    public void setBF(double BF) {
        this.BF = BF;
    }

    public String getBFString() {
        return BFString;
    }

    public void setBFString(String BDString) {
        this.BFString = BDString;
    }

    public String getBtmsg() {
        return btmsg;
    }

    public void setBtmsg(String btmsg) {
        this.btmsg = btmsg;
    }

    public double getTDEE() {
        return TDEE;
    }

    public double getBMR() {
        return BMR;
    }

    public String[] getBodytype() {
        return bodytype;
    }

    public void setBodytype(String[] bodytype) {
        this.bodytype = bodytype;
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
    public String getHealth(String origin) {
        if (origin.equalsIgnoreCase("caucasian")) {
            if (18.5 <= this.result & this.result <= 20) {
                health = healthy;
            } else if (25 < this.result & this.result < 30) {
                health = fat;
            } else if (20 < this.result & this.result < 25) {
                health = nhealthy;
            } else if (this.result < 18.5 & this.result > 16) {
                health = ill;
            } else if (this.result > 30 & this.result < 40) {
                health = obese;
            } else if (this.result <= 16) {
                health = skinny;
            } else {
                health = extreme;
            }
        }
        if (origin.equalsIgnoreCase("asian")) {
            if (18.5 <= this.result & this.result <= 22.9) {
                health = nhealthy;
            } else if (22.9 < this.result & this.result < 25) {
                health = fat;
            } else if (25 <= this.result & this.result < 30) {
                health = obese;
            } else if (this.result < 18.5 & this.result > 16) {
                health = ill;
            } else if (this.result > 30 & this.result < 40) {
                health = obese;
            } else if (this.result < 16) {
                health = skinny;
            } else {
                health = extreme;
            }
        }
        return health;
    } // End of Method

    /**
     *
     * @return a String - Detailed text corresponding to BMI details
     */
    public String getHealthText() {

        if (health.equalsIgnoreCase(healthy)) {
            return healthyT;
        } else if (health.equalsIgnoreCase(fat)) {
            return fatT;
        } else if (health.equalsIgnoreCase(nhealthy)) {
            return nhealthyT;
        } else if (health.equalsIgnoreCase(ill)) {
            return illT;
        } else if (health.equalsIgnoreCase(obese)) {
            return obeseT;
        } else if (health.equalsIgnoreCase(skinny)) {
            return skinnyT;
        } else {
            return "For Real? "
                    + "\nCheck The Doctor for Aliens' Diet";
        }
    }

    /**
     ** The official formulas for the calculation of daily estimated energy
     * requirements (EER) are provided by the Food and Nutrition Board of the
     * Institute of Medicine of the National Academies (Trumbo et al. 2002).
     *
     * EER Male = (662 - (9.53 x Age)) + (PA x ((15.91 x Weight) + (539.6 x
     * Height))).
     *
     * EER Female = (354 - (6.91 x Age)) + (PA x ((9.36 x Weight) + (726 x
     * Height))).
     *
     * PA indicates Activity Level and is equal to 1.0 for Sedentary, 1.12 for
     * Low Active, 1.27 for Active and 1.45 for Very Active. Weight is measured
     * in kilograms and height in meters.
     *
     * @param age Age
     * @param activity Activity
     * @param heit Height
     * @param weit Weight
     * @param gender gender
     * @return EER
     */
    public double computeEER(int age, String activity, double height, double weit, String gender) {

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

        double heit = height / 100; // Height from Centimeters to Meters
        if (gender.equalsIgnoreCase("male")) {
            if (age >= 0 && age <= 2) {
                EER = (89 * weit - 100) + 20;
            }
            if (age >= 3 && age <= 8) {
                EER = 88.5 - (61.9 * age) + getPA() * (26.7 * weit + 903 * heit) + 20;
            }
            if (age >= 9 && age <= 18) {
                EER = 88.5 - (61.9 * age) + getPA() * (26.7 * weit + 903 * heit) + 25;
            } else {
                EER = 662 - (9.53 * age) + getPA() * (15.91 * weit + 539.6 * heit);
            }
        } else {
            if (age >= 0 && age <= 2) {
                EER = (89 * weit - 100) + 20;
            }
            if (age >= 3 && age <= 8) {
                EER = 135.3 - (30.8 * age) + getPA() * (10 * weit + 934 * heit) + 20;
            }
            if (age >= 9 && age <= 18) {
                EER = 135.3 - (30.8 * age) + getPA() * (10 * heit + 934 * heit) + 25;
            } else {
                EER = (354 - (6.91 * age)) + (getPA() * ((9.36 * weit) + (726 * heit)));
            }
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

    /**
     * US Naval Army Formula for calculating the Body Fat Percentage. The
     * resulting Body fat is compared then to a classification table by The
     * American Council on Exercise.
     *
     * <table border="1"> <thead> <tr> <th>----</th> <th>Women</th> <th>Men</th>
     * </tr> </thead> <tbody> <tr> <td>--------</td> <td>----------</td>
     * <td>-----------</td> </tr> <tr> <td>Essential Fat</td> <td>12-15%</td>
     * <td>2-5%</td> </tr> <tr> <td>Athletes</td> <td>16-20% </td>
     * <td>6-13%</td> </tr> <tr> <td>Fitness</td> <td>21-24%</td>
     * <td>14-17%</td> </tr> <tr> <td>Acceptable</td> <td>25-31%</td>
     * <td>18-25%</td> </tr> <tr> <td>Obese</td> <td>32%+</td> <td>25%+</td>
     * </tr> </tbody> </table>
     *
     * @param height Height in centimeters
     * @param waist Waist in centimeters
     * @param neck Neck in centimeters
     * @param hip Hip in centimeters
     * @param gender Gender (Male / Female)
     * @return Body Fat as a percentage
     */
    public double computeBodyFat(double height, double waist, double neck, double hip, String gender) {
        /**
         * //man =
         * 495/(1.0324-0.19077(LOG(waist-neck))+0.15456(LOG(height)))-450
         * //woman =
         * 495/(1.29579-0.35004*(LOG(waist+hip-neck))+0.22100*(LOG(height)))-450
         */
        // 1 centimeter = 0.393700787 inches
        double h = Utilities.convertCMtoINCH(height);
        double n = Utilities.convertCMtoINCH(neck);
        double w = Utilities.convertCMtoINCH(waist);
        double p = Utilities.convertCMtoINCH(hip);

        if (gender.equalsIgnoreCase("male")) {
            BF = 495 / (1.0324 - (0.19077 * (Math.log(waist - neck)) / Math.log(10)) + (0.15456 * (Math.log(height))) / Math.log(10)) - 450;
            setBF(BF);
            //BF = 495/(1.0324-0.19077*(Math.log(w-n))+0.15456*(Math.log(h)))-450;

            if (BF >= 2 && BF <= 5) {
                setBFString(BFS[0]);
            } else if (getBF() >= 6 && getBF() <= 13) {
                setBFString(BFS[1]);
            } else if (BF >= 14 && BF <= 17) {
                setBFString(BFS[2]);
            } else if (BF >= 18 && BF <= 25) {
                setBFString(BFS[3]);
            } else if (BF >= 25 && BF <= 90) {
                setBFString(BFS[4]);
            } else {
                setBFString(BFS[5]);
            }

        } else if (gender.equalsIgnoreCase("female")) {
            BF = 495 / (1.29579 - 0.35004 * (Math.log(waist + hip - neck) / Math.log(10)) + 0.22100 * (Math.log(height)) / Math.log(10)) - 450;
            if (BF >= 12 && BF <= 15) {
                setBFString(BFS[0]);
            } else if (BF >= 16 && BF <= 20) {
                setBFString(BFS[1]);
            } else if (BF >= 21 && BF <= 24) {
                setBFString(BFS[2]);
            } else if (BF >= 25 && BF <= 31) {
                setBFString(BFS[3]);
            } else if (BF >= 32 && BF <= 90) {
                setBFString(BFS[4]);
            } else {
                setBFString(BFS[5]);
            }
        }
        System.out.println("Height is " + h + " inches");
        System.out.println("Height is " + p + " inches");
        System.out.println("Neck is " + n + " inches");
        System.out.println("Waist is " + w + " inches");
        System.out.println("Body Fat Percentage is " + new DecimalFormat("#.##").format(BF) + " %");
        System.out.println(getBFString());
        return BF;

    }

    /**
     * Determines the body type (Small, medium or large frame).
     *
     * @param gender Gender (Male or Female)
     * @param height Height length in meters
     * @param wrist Wrist length in centimeters
     * @param elbow Elbow length in centimeters
     * @param choice Boolean (True if Elbow measure, false if Wrist).
     * @return Body Type (Small, Medium or Large)
     */
    public String computeBodyType(String gender, double height, double wrist, double elbow, boolean choice) {
        int i = 0;
        double h = height / 100;

        if (gender.equalsIgnoreCase("male")) {
            // male wrist 

            if (!choice) {
                if (h >= 1.63) {
                    if (wrist <= 16.5) {
                        i = 0;
                    } else if (wrist <= 19.1) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                } else if (h < 1.63) {
                    i = 3;
                    setBtmsg("Body Type: Please use the elbow measure for male heights below 1.63m (5\'5)");
                    System.err.println("Body Type: Please use the elbow measure for male heights below 1.63m (5'5)");
                }
            } else if (choice) {
                // male elbow breadth
                if (h <= 1.54) {
                    i = 4;
                    System.err.println("Body Type: There is no measure for males below 1.55m (5'2");
                    setBtmsg("Body Type: There is no measure for males below 1.55m (5'2");
                } else if (h >= 1.55 && h < 1.58) {
                    if (elbow < 6.4) {
                        i = 0;
                    } else if (elbow < 7.3) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                } else if (h < 1.68) {
                    if (elbow < 6.7) {
                        i = 0;
                    } else if (elbow < 7.3) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                } else if (h < 1.78) {
                    if (elbow < 7.0) {
                        i = 0;
                    } else if (elbow < 7.5) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                } else if (h < 1.88) {
                    if (elbow < 7.0) {
                        i = 0;
                    } else if (elbow < 7.9) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                } else if (h < 1.98) {
                    if (elbow < 7.3) {
                        i = 0;
                    } else if (elbow < 8.3) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                } else if (h >= 1.98) {
                    // very tall people are considered large frame
                    i = 2; // Skeptic
                } else {
                    System.err.println("Unknown Body Type");
                    setBtmsg("Unknown Body Type");
                    i = 6;
                }
            }

        } else {
            // female wrist 
            if (!choice) {
                if (h < 1.55) {
                    if (wrist < 14.0) {
                        i = 0;
                    } else if (wrist < 14.6) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                } else if (h < 1.63) {
                    if (wrist < 15.2) {
                        i = 0;
                    } else if (wrist < 15.9) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                } else {
                    if (wrist < 15.9) {
                        i = 0;
                    } else if (wrist < 16.5) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                }
            } else if (choice) {
                // female elbow
                if (h < 1.48 && h >= 1.46) {
                    if (elbow < 5.7) {
                        i = 0;
                    } else if (elbow < 6.4) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                } else if (h < 1.58) {
                    if (elbow < 5.7) {
                        i = 0;
                    } else if (elbow < 6.4) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                } else if (h < 1.68) {
                    if (elbow < 6.0) {
                        i = 0;
                    } else if (elbow < 6.7) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                } else if (h < 1.78) {
                    if (elbow < 6.0) {
                        i = 0;
                    } else if (elbow < 6.7) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                } else if (h < 1.90) {
                    if (elbow < 6.3) {
                        i = 0;
                    } else if (elbow < 7.0) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                } else {
                    i = 5;
                    System.err.println("Body Type: There is no measure for females below 1.46m (4'10) or above 1.90m (6'4");
                    setBtmsg("Body Type: There is no measure for females below 1.46m (4'10) or above 1.90m (6'4");
                }
            }
        }
        return bodytype[i];
    }
} // END OF CLASS

