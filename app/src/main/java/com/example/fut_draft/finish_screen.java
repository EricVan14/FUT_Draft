package com.example.fut_draft;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class finish_screen extends AppCompatActivity {
    public TextView ratingValue, chemValue;
    public String rating, chem;
    public Integer ratingInt, chemInt;
    public ProgressBar chemProgress, ratingProgress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_screen);

        ratingValue = findViewById(R.id.rating_value);
        chemValue = findViewById(R.id.chem_value);
        chemProgress = findViewById(R.id.chemProgressBar);
        ratingProgress = findViewById(R.id.ratingProgressBar);

        rating = getIntent().getStringExtra("RATING");
        chem = getIntent().getStringExtra("CHEM");
        ratingInt = Integer.parseInt(rating);
        chemInt = Integer.parseInt(chem);

        ratingValue.setText(rating);
        chemValue.setText(chem);
        chemProgress.setProgress(chemInt);
        ratingProgress.setProgress(ratingInt);

    }
}