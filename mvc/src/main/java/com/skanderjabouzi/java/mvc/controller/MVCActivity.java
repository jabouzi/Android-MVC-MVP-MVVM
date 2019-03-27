package com.skanderjabouzi.java.mvc.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.skanderjabouzi.java.mvc.R;
import com.skanderjabouzi.java.mvc.model.Calculator;
import com.skanderjabouzi.java.mvc.model.Model;


public class MVCActivity extends AppCompatActivity {

    private TextView resultLabel;
    private static final String TAG = MVCActivity.class.getName();
    private Model model;
    private Calculator calculator;
    private static final String EQUAL = "=";
    private static final String DOT = ".";
    private static final String RESET = "c";
    private static final String ZERO = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        resultLabel = findViewById(R.id.resultLabel);
        model = new Model();
        calculator = new Calculator();
    }

    public void onCellClicked(View view) {
        Button button = (Button) view;
        String calcKey = button.getText().toString();
        Log.i("CALC", "Click Button: [" + calcKey + "] " + TAG);

        if (Model.operators.contains(calcKey)) {
            doOperation(calcKey);
            resultLabel.setText(calculator.getNewVal());
            return;
        }

        if (calcKey.equals(EQUAL)) {
            doEqual();
            resultLabel.setText(calculator.getNewVal());
            return;
        }

        if (calcKey.equals(RESET)) {
            reset();
            return;
        }

        doRegularTape(calcKey);
        resultLabel.setText(calculator.getNewVal());
    }

    private void doOperation(String calcKey) {
        if (calculator.isInitial()) {
            calculator.setOldVal(calculator.getNewVal());
            calculator.setNewSign(true);
            calculator.setSign(calcKey);
            calculator.setInitial(false);
        } else {
            calculator.setNewSign(true);
            calculator.setNewVal(model.doCalculation(calculator.getOldVal(), calculator.getNewVal(), calculator.getSign()));
            calculator.setOldVal(calculator.getNewVal());
            calculator.setSign(calcKey);
        }
    }

    private void doEqual() {
        calculator.setNewSign(true);
        calculator.setNewVal(model.doCalculation(calculator.getOldVal(), calculator.getNewVal(), calculator.getSign()));
        calculator.setOldVal(calculator.getNewVal());
    }

    private void reset() {
        resultLabel.setText("");
        calculator.setInitial(true);
        calculator.setOldVal("");
        calculator.setNewVal("");
        calculator.setSign("");
    }

    private void doRegularTape(String calcKey) {
        if (calculator.getNewVal().length() == 1 && calculator.getNewVal().equals(ZERO)) {
            calculator.setNewVal(calcKey);
        } else if (calcKey.equals(DOT)) {
            if (calculator.isNewSign() || calculator.getNewVal().length() == 0) {
                calculator.setNewVal(ZERO + calcKey);
            } else if (!calculator.getNewVal().contains(DOT)) {
                calculator.setNewVal(calculator.getNewVal() + calcKey);
            }
        } else {
            if (calculator.isNewSign()) calculator.setNewVal(calcKey);
            else calculator.setNewVal(calculator.getNewVal() + calcKey);
        }
        calculator.setNewSign(false);
    }
}
