package com.example.fut_draft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class finish_screen extends AppCompatActivity {
    public TextView ratingValue, chemValue, squadRatingValue;
    public String rating, chem, squadRating;
    public Integer ratingInt, chemInt, squadRatingInt;
    public ProgressBar chemProgress, ratingProgress, squadRatingProgress;
    public Button finish;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_screen);
        finish = findViewById(R.id.finishButton);

        ratingValue = findViewById(R.id.rating_value);
        chemValue = findViewById(R.id.chem_value);
        squadRatingValue = findViewById(R.id.squad_rating_value);

        chemProgress = findViewById(R.id.chemProgressBar);
        ratingProgress = findViewById(R.id.ratingProgressBar);
        squadRatingProgress = findViewById(R.id.squadRatingProgressBar);

        rating = getIntent().getStringExtra("RATING");
        chem = getIntent().getStringExtra("CHEM");
        ratingInt = Integer.parseInt(rating);
        chemInt = Integer.parseInt(chem);
        squadRatingInt = chemInt + ratingInt;
        squadRating = Integer.toString(squadRatingInt);


        ratingValue.setText(rating);
        chemValue.setText(chem);
        squadRatingValue.setText(squadRating);

        chemProgress.setProgress(chemInt);
        ratingProgress.setProgress(ratingInt);
        squadRatingProgress.setProgress(squadRatingInt);

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(finish_screen.this, MainActivity.class);
                finish_screen.this.startActivity(myIntent);
            }
        });


    }
}