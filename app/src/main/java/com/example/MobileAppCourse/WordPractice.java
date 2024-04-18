package com.example.MobileAppCourse;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.languageapp.R;

public class WordPractice extends AppCompatActivity {
    private void clearOrangeColor(Button button) {
        button.setSelected(false);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_word_practice);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button buttonGuess = findViewById(R.id.buttonGuessGardener);

        final boolean[] buttonClicked = {false};

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button flyButton = findViewById(R.id.buttonGuessFly);
        flyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear the orange color from all buttons
                clearOrangeColor(findViewById(R.id.buttonGuessGardener));
                clearOrangeColor(findViewById(R.id.buttonGuessGladious));
                clearOrangeColor(findViewById(R.id.buttonGuessDog));

                // Set the orange color to the pressed button
                flyButton.setSelected(true);
                buttonClicked[0] = false;
            }
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button gardenerButton = findViewById(R.id.buttonGuessGardener);
        gardenerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear the orange color from all buttons
                clearOrangeColor(findViewById(R.id.buttonGuessFly));
                clearOrangeColor(findViewById(R.id.buttonGuessGladious));
                clearOrangeColor(findViewById(R.id.buttonGuessDog));

                // Set the orange color to the pressed button
                gardenerButton.setSelected(true);

                buttonClicked[0] = true;
            }
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button gladiousButton = findViewById(R.id.buttonGuessGladious);
        gladiousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear the orange color from all buttons
                clearOrangeColor(findViewById(R.id.buttonGuessFly));
                clearOrangeColor(findViewById(R.id.buttonGuessGardener));
                clearOrangeColor(findViewById(R.id.buttonGuessDog));

                // Set the orange color to the pressed button
                gladiousButton.setSelected(true);
                buttonClicked[0] = false;
            }
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button dogButton = findViewById(R.id.buttonGuessDog);
        dogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear the orange color from all buttons
                clearOrangeColor(findViewById(R.id.buttonGuessFly));
                clearOrangeColor(findViewById(R.id.buttonGuessGardener));
                clearOrangeColor(findViewById(R.id.buttonGuessGladious));

                // Set the orange color to the pressed button
                dogButton.setSelected(true);
                buttonClicked[0] = false;
            }
        });



        Button buttonTest = findViewById(R.id.buttonGuess6);
        buttonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonClicked[0])
                    startActivity(new Intent(WordPractice.this, GuessSuccess.class));
                else
                    startActivity(new Intent(WordPractice.this, GuessError.class));
            }
        });
    }
}