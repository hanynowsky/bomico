package bim;

import java.text.DecimalFormat;

/**
 * @version 1.0
 * @author hanynowsky CLass to compute the Body Mass Index using the
 * international Formula
 */
public class Computer {

    String health = "";
    String healthy = java.util.ResourceBundle.getBundle("bim/Bundle").getString("HEALTHY");
    String nhealthy = java.util.ResourceBundle.getBundle("bim/Bundle").getString("NORMAL");
    String ill = java.util.ResourceBundle.getBundle("bim/Bundle").getString("UNDERWEIGHT");
    String fat = java.util.ResourceBundle.getBundle("bim/Bundle").getString("OVERWEIGHT");
    String obese = java.util.ResourceBundle.getBundle("bim/Bundle").getString("OBESE");
    String skinny = java.util.ResourceBundle.getBundle("bim/Bundle").getString("SKINNY");
    String extreme = java.util.ResourceBundle.getBundle("bim/Bundle").getString("EXTREME");
    String sthinness = java.util.ResourceBundle.getBundle("bim/Bundle").getString("SEVERE_THINNESS");
    String modthinness = java.util.ResourceBundle.getBundle("bim/Bundle").getString("MODERATE_THINNESS");
    String mildthinness = java.util.ResourceBundle.getBundle("bim/Bundle").getString("MILD_THINNESS");
    String obese1 = java.util.ResourceBundle.getBundle("bim/Bundle").getString("OBESE_CLASS_I");
    String obese2 = java.util.ResourceBundle.getBundle("bim/Bundle").getString("OBESE_CLASS_II");
    String obese3 = java.util.ResourceBundle.getBundle("bim/Bundle").getString("OBESE_CLASS_III");
    String preobese = java.util.ResourceBundle.getBundle("bim/Bundle").getString("FATNESS");
    /**
     *
     */
    public String nomeasure_F = java.util.ResourceBundle.getBundle("bim/Bundle").getString("MEASURE_F");
    public String nomeasure_M = java.util.ResourceBundle.getBundle("bim/Bundle").getString("MEASURE_M");
    String small = java.util.ResourceBundle.getBundle("bim/Bundle").getString("SMALL");
    String medium = java.util.ResourceBundle.getBundle("bim/Bundle").getString("MEDIUM");
    String large = java.util.ResourceBundle.getBundle("bim/Bundle").getString("LARGE");
    String useElbow = java.util.ResourceBundle.getBundle("bim/Bundle").getString("USE_ELBOW");
    String unknown = java.util.ResourceBundle.getBundle("bim/Bundle").getString("UNKNOWN");
    /**
     * Text Strings for Health
     */
    String healthyT = java.util.ResourceBundle.getBundle("bim/Bundle").getString("HEALTHY_TEXT");
    String nhealthyT = java.util.ResourceBundle.getBundle("bim/Bundle").getString("NHEALTHY_TEXT");
    String illT = java.util.ResourceBundle.getBundle("bim/Bundle").getString("ILL_TEXT");
    String fatT = java.util.ResourceBundle.getBundle("bim/Bundle").getString("FAT_TEXT");
    String obeseT = java.util.ResourceBundle.getBundle("bim/Bundle").getString("OBESE_TEXT");
    String skinnyT = java.util.ResourceBundle.getBundle("bim/Bundle").getString("SKINNY_TEXT");
    String HealthText = "";
    double result = 0;
    double ideal = 0;
    double iweight;
    double EER;
    double PA;
    double BMRA;
    double BMR;
    double TDEE;
    double BF;
    String essFat = java.util.ResourceBundle.getBundle("bim/Bundle").getString("ESSENTIAL_FAT");
    String athlete = java.util.ResourceBundle.getBundle("bim/Bundle").getString("ATHLETE");
    String fitness = java.util.ResourceBundle.getBundle("bim/Bundle").getString("FITNESS");
    String acceptable = java.util.ResourceBundle.getBundle("bim/Bundle").getString("ACCEPTABLE");
    String ob = java.util.ResourceBundle.getBundle("bim/Bundle").getString("OBESE_BODYTYPE");
    String[] BFS = {essFat, athlete, fitness, acceptable, ob, "N/A"};
    String BFString = ""; // Receives the value of BFS when BF is calculated
    String[] bodytype = {small, medium, large, useElbow, nomeasure_M, nomeasure_F, unknown};
    String btmsg = "";
    static String soundStatus = "normal";

    //Constructor
    public Computer() {
    }

    public static String getSoundStatus() {
        return soundStatus;
    }

    public static void setSoundStatus(String soundStatus) {
        Computer.soundStatus = soundStatus;
    }

    public String getHealthText() {
        //  HealthText = "Health Text here";
        return HealthText;
    }

    public void setHealthText(String HealthText) {
        this.HealthText = HealthText;
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
     * Beware: Formula Strings are case sensitive (First Letter is Capital).
     *
     * @param hei Height in centimeters
     * @param formula Ideal Weight Formula
     * @param gender Gender (Male or Female)
     * @param morph Morphology (Ectomorph | Mesomorph | Endomorph)
     * @return Ideal Weight
     */
    public double computeIdealWeight(double hei, String formula, int gender, int morph) {
        double height = hei * 0.01; // Convert centimeters to Meters
        //1 centimeter = 0.393700787 inch
        // 1 inch = 2.54 cms
        // 1 foot = 30.48 centimeters
        double i = (hei - 152.4) * 0.393700787; // 
        if (gender == 0) { // 0 for male and 1 for female

            switch (formula) {
                case "Robinson":
                    iweight = 52 + (1.9 * i);
                    break;
                case "Miller":
                    iweight = 56.2 + (1.41 * i);
                    break;
                case "Hamwi":
                    if (morph == 0) { // ectomorph 0
                        iweight = (48 + (2.7 * i)) - ((48 + (2.7 * i)) * 10 / 100);
                    }
                    if (morph == 1) { // mesomorph 1
                        iweight = 48 + (2.7 * i);
                    }
                    if (morph == 2) { // endomorph 2
                        iweight = (48 + (2.7 * i)) + ((48 + (2.7 * i)) * 10 / 100);
                    }
                    if (morph == -1) {
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


        } else if (gender == 1) {

            switch (formula) {
                case "Robinson":
                    iweight = 49 + (1.7 * i);
                    break;
                case "Miller":
                    iweight = 53.1 + (1.36 * i);
                    break;
                case "Hamwi":
                    if (morph > 2 || morph == -1) {
                        iweight = 45 + (2.2 * i);
                    }
                    if (morph == 0) { //0 for ecto
                        iweight = (45 + (2.2 * i)) - ((45 + (2.2 * i)) * 10 / 100);
                    }
                    if (morph == 1) { // 1 for meso
                        iweight = 45 + (2.2 * i);
                    }
                    if (morph == 2) { // 2 for endo
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
        setIweight(iweight);
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
    public String getHealth(int origin) {

        if (origin == 0) { // 0 for caucasian
            if (18.5 <= this.result & this.result <= 20) {
                health = healthy;
                setHealthText(healthyT);
                setSoundStatus("Healthy");
            } else if (25 < this.result & this.result < 27.5) {
                health = fat;
                setHealthText(fat);
                setSoundStatus("Overweight");
            } else if (27.5 <= this.result & this.result < 30) {
                health = preobese;
                setHealthText(fat);
                setSoundStatus("Fatness");
            } else if (20 < this.result & this.result < 25) {
                health = nhealthy;
                setHealthText(nhealthyT);
                setSoundStatus("Normal");
            } else if (this.result < 18.5 & this.result >= 16) {
                health = ill;
                setHealthText(illT);
                setSoundStatus("Underweight");
            } else if (this.result > 30 & this.result < 35) {
                health = obese1;
                setHealthText(obeseT);
                setSoundStatus("Obese Class I");
            } else if (this.result >= 35 & this.result < 40) {
                health = obese2;
                setHealthText(obeseT);
                setSoundStatus("Obese Class II");
            } else if (this.result >= 40 & this.result < 50) {
                health = obese3;
                setHealthText(obeseT);
                setSoundStatus("Obese Class III");
            } else if (this.result > 5 & this.result < 16) {
                health = sthinness;
                setHealthText(skinnyT);
                setSoundStatus("Severe Thinness");
            } else {
                health = extreme;
                setHealthText("Alien!");
                setSoundStatus("Extreme");
            }
        } else if (origin == 1) { // 1 for asian
            if (18.5 <= this.result & this.result <= 22.9) {
                health = nhealthy;
                setHealthText(nhealthyT);
                setSoundStatus("Normal");
            } else if (22.9 < this.result & this.result < 25) {
                health = fat;
                setHealthText(fatT);
                setSoundStatus("Overweight");
            } else if (25 <= this.result & this.result < 30) {
                health = obese;
                setHealthText(obeseT);
                setSoundStatus("Obese");
            } else if (this.result < 18.5 & this.result > 16) {
                health = ill;
                setHealthText(illT);
                setSoundStatus("Underweight");
            } else if (this.result > 30 & this.result < 40) {
                health = obese;
                setHealthText(obeseT);
                setSoundStatus("Obese Class II");
            } else if (this.result > 4.6 & this.result < 16) {
                health = skinny;
                setHealthText(skinnyT);
                setSoundStatus("Skinny");
            } else {
                health = extreme;
                setHealthText("For Real? Check The Doctor for Aliens' Diet");
                setSoundStatus("Extreme");
            }
        }

        return health;
    } // End of Method

    /**
     *
     * @return a String - Detailed text corresponding to BMI details
     */
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
    public double computeEER(int age, int activity, double height, double weit, int gender) {

        if (activity == 0) { // 0 sedentary
            setPA(1.00);
        } else if (activity == 1) { // 1 low
            setPA(1.12);
        } else if (activity == 2) { // 2 active
            setPA(1.27);
        } else if (activity == 3) { // 3 very active
            setPA(1.45);
        } else if (activity == 4) { // 4 extreme
            setPA(1.66);
        } else {
            setPA(1.27);
        }

        double heit = height / 100; // Height from Centimeters to Meters
        if (gender == 0) { // 0 corresponds to male and 1 to female
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
/**
 * Calculates the TDEE
 * @param activity Physical Activity
 * @return TDEE
 */
    public double computeTDEE(int activity) {
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
        if (activity == 0) { // 0 for sedentary
            a = 1.2;
        } else if (activity == 1) { // 1 low
            a = 1.375;
        } else if (activity == 2) { // 2 very active
            a = 1.725;
        } else if (activity == 3) { // 3 active
            a = 1.55;
        } else if (activity == 4) { // 4 extreme
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
    public double computeBodyFat(double height, double waist, double neck, double hip, int gender) {
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

        if (gender == 0) { // 0 for male
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

        } else if (gender == 1) { // 1 for female
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
        System.out.println("Hip is " + p + " inches");
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
    public String computeBodyType(int gender, double height, double wrist, double elbow, boolean choice) {
        int i = 0;
        double h = height / 100;

        if (gender == 0) { // 0 for male and 1 for female
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
                    setBtmsg(nomeasure_F);
                }
            }
        }
        return bodytype[i];
    }
} // END OF CLASS

