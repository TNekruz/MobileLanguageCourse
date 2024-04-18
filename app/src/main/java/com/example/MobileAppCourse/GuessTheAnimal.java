package com.example.MobileAppCourse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.languageapp.R;

public class GuessTheAnimal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_guess_the_animal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button buttonGuess = findViewById(R.id.buttonGuess);
        EditText textGuess = findViewById(R.id.editTextGuess);
        buttonGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textGuess.getText().toString().toLowerCase().equals("racoon"))
                    startActivity(new Intent(GuessTheAnimal.this, GuessSuccess.class));
                else
                    startActivity(new Intent(GuessTheAnimal.this, GuessError.class));
            }
        });
    }
}