package com.example.fahadcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private String currentNumber = "";
    private String operator = "";
    private double firstNumber = 0;
    private double secondNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);

        // Number buttons
        findViewById(R.id.button0).setOnClickListener(numberClickListener);
        findViewById(R.id.button1).setOnClickListener(numberClickListener);
        findViewById(R.id.button2).setOnClickListener(numberClickListener);
        findViewById(R.id.button3).setOnClickListener(numberClickListener);
        findViewById(R.id.button4).setOnClickListener(numberClickListener);
        findViewById(R.id.button5).setOnClickListener(numberClickListener);
        findViewById(R.id.button6).setOnClickListener(numberClickListener);
        findViewById(R.id.button7).setOnClickListener(numberClickListener);
        findViewById(R.id.button8).setOnClickListener(numberClickListener);
        findViewById(R.id.button9).setOnClickListener(numberClickListener);

        // Operator buttons
        findViewById(R.id.buttonAdd).setOnClickListener(operatorClickListener);
        findViewById(R.id.buttonSubtract).setOnClickListener(operatorClickListener);
        findViewById(R.id.buttonMultiply).setOnClickListener(operatorClickListener);
        findViewById(R.id.buttonDivide).setOnClickListener(operatorClickListener);

        // Equal button
        findViewById(R.id.buttonEqual).setOnClickListener(v -> calculateResult());

        // Clear button
        findViewById(R.id.buttonClear).setOnClickListener(v -> clearCalculator());
    }

    private final View.OnClickListener numberClickListener = v -> {
        Button button = (Button) v;
        currentNumber += button.getText().toString();
        updateResultText();
    };

    private final View.OnClickListener operatorClickListener = v -> {
        Button button = (Button) v;
        operator = button.getText().toString();
        firstNumber = Double.parseDouble(currentNumber);
        currentNumber = "";
    };

    private void calculateResult() {
        if (!currentNumber.isEmpty() && !operator.isEmpty()) {
            secondNumber = Double.parseDouble(currentNumber);
            double result = 0;

            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    result = firstNumber / secondNumber;
                    break;
            }

            currentNumber = String.valueOf(result);
            updateResultText();
            operator = "";
            firstNumber = result;
            secondNumber = 0;
        }
    }

    private void clearCalculator() {
        currentNumber = "";
        operator = "";
        firstNumber = 0;
        secondNumber = 0;
        updateResultText();
    }

    private void updateResultText() {
        resultTextView.setText(currentNumber);
    }
}
