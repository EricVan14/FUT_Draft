package com.example.fut_draft;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class finish_screen extends AppCompatActivity {
    public TextView ratingValue, chemValue;
    public String rating, chem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_screen);

        ratingValue = findViewById(R.id.rating_value);
        chemValue = findViewById(R.id.chem_value);
        rating = getIntent().getStringExtra("RATING");
        chem = getIntent().getStringExtra("CHEM");
        ratingValue.setText(rating);
        chemValue.setText(chem);

    }
}