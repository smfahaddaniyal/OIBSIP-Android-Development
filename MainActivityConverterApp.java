package com.example.fahadconvertorapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText meterInput;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        meterInput = findViewById(R.id.meterInput);
        Button convertToCmButton = findViewById(R.id.convertToCmButton);
        Button convertToKmButton = findViewById(R.id.convertToKmButton);
        Button convertToFtButton = findViewById(R.id.convertToFtButton);
        resultTextView = findViewById(R.id.resultTextView);

        convertToCmButton.setOnClickListener(v -> convertToCentimeters());

        convertToKmButton.setOnClickListener(v -> convertToKilometers());

        convertToFtButton.setOnClickListener(v -> convertToFeet());
    }

    @SuppressLint("SetTextI18n")
    private void convertToCentimeters() {
        double meters = Double.parseDouble(meterInput.getText().toString());
        double centimeters = meters * 100;
        resultTextView.setText(meters + " meters = " + centimeters + " centimeters");
    }

    @SuppressLint("SetTextI18n")
    private void convertToKilometers() {
        double meters = Double.parseDouble(meterInput.getText().toString());
        double kilometers = meters / 1000;
        resultTextView.setText(meters + " meters = " + kilometers + " kilometers");
    }

    @SuppressLint("SetTextI18n")
    private void convertToFeet() {
        double meters = Double.parseDouble(meterInput.getText().toString());
        double feet = meters * 3.281;
        resultTextView.setText(meters + " meters = " + feet + " feet");
    }
}


