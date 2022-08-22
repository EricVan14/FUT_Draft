package com.example.fut_draft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SinglePlayer extends AppCompatActivity {

    public ImageView lw, st, rw, lcm, cam, rcm, lb, lcb, rcb, rb, gk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);
        lw = findViewById(R.id.LW);
        rw = findViewById(R.id.RW);
        st = findViewById(R.id.ST);
        lcm = findViewById(R.id.LCM);
        cam = findViewById(R.id.CAM);
        rcm = findViewById(R.id.RCM);
        lb = findViewById(R.id.LB);
        lcb = findViewById(R.id.LCB);
        rcb = findViewById(R.id.RCB);
        rb = findViewById(R.id.RB);
        gk = findViewById(R.id.GK);

        lw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(SinglePlayer.this, SinglePickLW.class);
                SinglePlayer.this.startActivity(myIntent);


            }
        });

    }
}