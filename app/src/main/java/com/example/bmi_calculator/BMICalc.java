package com.example.bmi_calculator;

import com.google.gson.Gson;

/**
 * Model - Generates a BMI and group for a given height in inches and weight in pounds
 */
public class BMICalc
{
    private double height, weight;
    public int mCalculationsDone;

    public BMICalc ()
    {
        this.height = 0;
        this.weight = 0;
        this.mCalculationsDone = 0;

    }

    public BMICalc (double height, double weight)
    {
        this.weight = checkAndGetGreaterThanZero(weight, "Weight");
        this.height = checkAndGetGreaterThanZero(height, "Height");
    }

    public void setHeight (double height)
    {
        this.height = checkAndGetGreaterThanZero(height, "Height");
    }

    public void setWeight (double weight)
    {
        this.weight = checkAndGetGreaterThanZero(weight, "Weight");
    }

    private double checkAndGetGreaterThanZero (double value, String description)
    {
        if (value >0)
            return value;
        else
            throw new IllegalArgumentException (description + " must be greater than zero.");
    }

    public double getHeight ()
    {
        return height;
    }

    public double getWeight ()
    {
        return weight;
    }

    public void setCalc(int mCalculationsDone) {
        System.out.println("in the method." + mCalculationsDone);
        this.mCalculationsDone = mCalculationsDone;
    }

    public int getCalc(){return mCalculationsDone;}

    public double getBMI()
    {
        if (height > 0 && weight > 0) {
            return 703 * (weight / (height * height));
        }
        else
            throw new IllegalStateException ("Cannot get BMI before setting weight and height.");
    }

    public String getBmiGroup ()
    {
        String bmiGroup;
        double bmi = getBMI();

        if (bmi < 18.5)
            bmiGroup = "Underweight";
        else if (bmi < 25)
            bmiGroup = "Normal Weight";
        else if (bmi < 30)
            bmiGroup = "Overweight";
        else
            bmiGroup = "Obese";

        return bmiGroup;
    }

    public static BMICalc getObjectFromJSONString (String json)
    {
        Gson gson = new Gson ();
        return gson.fromJson (json, BMICalc.class);
    }

    public static String getJSONStringFromObject (BMICalc object)
    {
        Gson gson = new Gson ();
        return gson.toJson (object);
    }

    public String getJSONStringFromThis()
    {
        return BMICalc.getJSONStringFromObject (this);
    }
}
//TODO delete. if by accident I leave it here: I used it as reference when calling the BMI methods
//    public static ThirteenStones getGameFromJSON (String json)
//    {
//        Gson gson = new Gson ();
//        return gson.fromJson (json, ThirteenStones.class);
//    }
//
//    public static String getJSONFromGame (ThirteenStones obj)
//    {
//        Gson gson = new Gson ();
//        return gson.toJson (obj);
//    }
//
//    public String getJSONFromCurrentGame()
//    {
//        return getJSONFromGame(this);
//    }
