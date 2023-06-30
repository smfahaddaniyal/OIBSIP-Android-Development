package com.example.fahadquizapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView questionTextView, scoreTextView;
    private RadioGroup optionsRadioGroup;
    private RadioButton option1RadioButton, option2RadioButton, option3RadioButton, option4RadioButton;
    private Button nextButton;

    private final String[] questions = {
            "Question 1: Who won the FIFA World Cup 2022?",
            "Question 2: Who is the current highest goalscorer in the world?",
            "Question 3: Mohamed Salah plays for which football club?",
            "Question 4: Which football club has won the most number of UEFA Champions League trophies?"
    };

    private final String[][] options = {
            {"France", "Portugal", "Argentina", "Brazil"},
            {"Lionel Messi", "Cristiano Ronaldo", "Karim Benzema", "Pele"},
            {"PSG", "Al Nassr", "Galatasaray", "Liverpool"},
            {"Real Madrid", "FC Barcelona", "Bayern Munich", "AC Milan"}
    };

    private final int[] correctAnswers = {3, 2, 4, 1};
    private int currentQuestion = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTextView = findViewById(R.id.questionTextView);
        scoreTextView = findViewById(R.id.scoreTextView);
        optionsRadioGroup = findViewById(R.id.optionsRadioGroup);
        option1RadioButton = findViewById(R.id.option1RadioButton);
        option2RadioButton = findViewById(R.id.option2RadioButton);
        option3RadioButton = findViewById(R.id.option3RadioButton);
        option4RadioButton = findViewById(R.id.option4RadioButton);
        nextButton = findViewById(R.id.nextButton);

        showQuestion();

        nextButton.setOnClickListener(v -> checkAnswer());
    }

    private void showQuestion() {
        questionTextView.setText(questions[currentQuestion]);
        option1RadioButton.setText(options[currentQuestion][0]);
        option2RadioButton.setText(options[currentQuestion][1]);
        option3RadioButton.setText(options[currentQuestion][2]);
        option4RadioButton.setText(options[currentQuestion][3]);

        optionsRadioGroup.clearCheck();
    }

    private void checkAnswer() {
        int selectedOption = optionsRadioGroup.getCheckedRadioButtonId();

        if (selectedOption != -1) {
            RadioButton selectedRadioButton = findViewById(selectedOption);
            int selectedAnswer = optionsRadioGroup.indexOfChild(selectedRadioButton) + 1;

            if (selectedAnswer == correctAnswers[currentQuestion]) {
                score++;
            }

            currentQuestion++;

            if (currentQuestion < questions.length) {
                showQuestion();
            } else {
                showScore();
            }
        } else {
            Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressLint("SetTextI18n")
    private void showScore() {
        questionTextView.setVisibility(View.GONE);
        optionsRadioGroup.setVisibility(View.GONE);
        nextButton.setVisibility(View.GONE);

        scoreTextView.setText("Your score: " + score + " out of " + questions.length);
        scoreTextView.setVisibility(View.VISIBLE);
    }
}
