package com.skanderjabouzi.java.mvc.model;

public class Calculator {

    private boolean initial = true;
    private boolean newSign = false;
    private String oldVal = "";
    private String newVal = "";
    private String sign = "";

    public boolean isInitial() {
        return initial;
    }

    public void setInitial(boolean initial) {
        this.initial = initial;
    }

    public boolean isNewSign() {
        return newSign;
    }

    public void setNewSign(boolean newSign) {
        this.newSign = newSign;
    }

    public String getOldVal() {
        return oldVal;
    }

    public void setOldVal(String oldVal) {
        this.oldVal = oldVal;
    }

    public String getNewVal() {
        return newVal;
    }

    public void setNewVal(String newVal) {
        this.newVal = newVal;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
