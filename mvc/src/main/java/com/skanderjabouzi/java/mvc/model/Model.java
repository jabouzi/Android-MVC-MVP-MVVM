package com.skanderjabouzi.java.mvc.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Model {

    public static final List<String> operators = new ArrayList<>(Arrays.asList("+", "-", "x", "÷", "="));

    public String doCalculation(String oldStr, String newStr, String operator) {
        Double oldDouble = Double.parseDouble(oldStr);
        Double newDouble = Double.parseDouble(newStr);
        Double res;

        switch (operator) {
            case "+":
                res = oldDouble + newDouble;
                break;
            case "-":
                res = oldDouble - newDouble;
                break;
            case "x":
                res = oldDouble * newDouble;
                break;
            case "÷":
                res = oldDouble / newDouble;
                break;
            default:
                res = oldDouble;
                break;
        }

        Log.e("CALC", String.valueOf(res));
        return formatDoubleWithZeroDecimals(String.valueOf(res));
    }

    private boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static String formatDoubleWithZeroDecimals(String value) {
        String[] splittedStr = value.split("\\.");
        Log.e("CALC", Arrays.toString(splittedStr));
        if (Double.parseDouble(splittedStr[1]) == 0.0) {
            return splittedStr[0];
        } else {
            return value;
        }
    }

}
