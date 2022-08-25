package com.example.fut_draft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SinglePlayer extends AppCompatActivity {

    public ImageView lw, st, rw, lcm, cam, rcm, lb, lcb, rcb, rb, gk;
    public String currentPosition;
    public String currentPlayerDrawableName;
    public String lwCurrentPlayerDrawableName;
    public String stCurrentPlayerDrawableName;
    public String rwCurrentPlayerDrawableName;
    public String lcmCurrentPlayerDrawableName;
    public String camCurrentPlayerDrawableName;
    public String rcmCurrentPlayerDrawableName;
    public String lbCurrentPlayerDrawableName;
    public String lcbCurrentPlayerDrawableName;
    public String rcbCurrentPlayerDrawableName;
    public String rbCurrentPlayerDrawableName;
    public String gkCurrentPlayerDrawableName;
    public Context c;
    public Integer id;

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
        c = getApplicationContext();




        ///////////                  PREVIOUS SELECTIONS             ////////////////////////

        Bundle extras = getIntent().getExtras();
        currentPlayerDrawableName = getIntent().getStringExtra("CURRENT_PLAYER_DRAWABLE_NAME");
        currentPosition = getIntent().getStringExtra("POSITION");
        lwCurrentPlayerDrawableName = getIntent().getStringExtra("POSITION_LW");
        stCurrentPlayerDrawableName = getIntent().getStringExtra("POSITION_ST");
        rwCurrentPlayerDrawableName = getIntent().getStringExtra("POSITION_RW");
        rcmCurrentPlayerDrawableName = getIntent().getStringExtra("POSITION_RCM");
        camCurrentPlayerDrawableName = getIntent().getStringExtra("POSITION_CAM");
        lcmCurrentPlayerDrawableName = getIntent().getStringExtra("POSITION_LCM");
        lbCurrentPlayerDrawableName = getIntent().getStringExtra("POSITION_LB");
        lcbCurrentPlayerDrawableName = getIntent().getStringExtra("POSITION_LCB");
        rcbCurrentPlayerDrawableName = getIntent().getStringExtra("POSITION_RCB");
        rbCurrentPlayerDrawableName = getIntent().getStringExtra("POSITION_RB");
        gkCurrentPlayerDrawableName = getIntent().getStringExtra("POSITION_GK");

        if(lwCurrentPlayerDrawableName != null){
            id = c.getResources().getIdentifier("drawable/" + lwCurrentPlayerDrawableName, null, c.getPackageName());
            lw.setImageResource(id);
        }

        if(stCurrentPlayerDrawableName != null){
            id = c.getResources().getIdentifier("drawable/" + stCurrentPlayerDrawableName, null, c.getPackageName());
            st.setImageResource(id);
        }

        if(rwCurrentPlayerDrawableName != null){
            id = c.getResources().getIdentifier("drawable/" + rwCurrentPlayerDrawableName, null, c.getPackageName());
            rw.setImageResource(id);
        }

        if(lcmCurrentPlayerDrawableName != null){
            id = c.getResources().getIdentifier("drawable/" + lcmCurrentPlayerDrawableName, null, c.getPackageName());
            lcm.setImageResource(id);
        }

        if(camCurrentPlayerDrawableName != null){
            id = c.getResources().getIdentifier("drawable/" + camCurrentPlayerDrawableName, null, c.getPackageName());
            cam.setImageResource(id);
        }

        if(rcmCurrentPlayerDrawableName != null){
            id = c.getResources().getIdentifier("drawable/" + rcmCurrentPlayerDrawableName, null, c.getPackageName());
            rcm.setImageResource(id);
        }

        if(lbCurrentPlayerDrawableName != null){
            id = c.getResources().getIdentifier("drawable/" + lbCurrentPlayerDrawableName, null, c.getPackageName());
            lb.setImageResource(id);
        }

        if(lcbCurrentPlayerDrawableName != null){
            id = c.getResources().getIdentifier("drawable/" + lcbCurrentPlayerDrawableName, null, c.getPackageName());
            lcb.setImageResource(id);
        }

        if(rcbCurrentPlayerDrawableName != null){
            id = c.getResources().getIdentifier("drawable/" + rcbCurrentPlayerDrawableName, null, c.getPackageName());
            rcb.setImageResource(id);
        }

        if(rbCurrentPlayerDrawableName != null){
            id = c.getResources().getIdentifier("drawable/" + rbCurrentPlayerDrawableName, null, c.getPackageName());
            rb.setImageResource(id);
        }

        if(gkCurrentPlayerDrawableName != null){
            id = c.getResources().getIdentifier("drawable/" + gkCurrentPlayerDrawableName, null, c.getPackageName());
            gk.setImageResource(id);
        }

        ///////////                  MOST RECENT SELECTION             ////////////////////////



        if(currentPosition != null) {
            if (currentPosition.equals("LW")) {
                id = c.getResources().getIdentifier("drawable/" + currentPlayerDrawableName, null, c.getPackageName());
                lw.setImageResource(id);
                lwCurrentPlayerDrawableName = currentPlayerDrawableName;
            }
            if (currentPosition.equals("ST")) {
                id = c.getResources().getIdentifier("drawable/" + currentPlayerDrawableName, null, c.getPackageName());
                st.setImageResource(id);
                stCurrentPlayerDrawableName = currentPlayerDrawableName;
            }
            if (currentPosition.equals("RW")) {
                id = c.getResources().getIdentifier("drawable/" + currentPlayerDrawableName, null, c.getPackageName());
                rw.setImageResource(id);
                rwCurrentPlayerDrawableName = currentPlayerDrawableName;
            }
            if (currentPosition.equals("LCM")) {
                id = c.getResources().getIdentifier("drawable/" + currentPlayerDrawableName, null, c.getPackageName());
                lcm.setImageResource(id);
                lcmCurrentPlayerDrawableName = currentPlayerDrawableName;
            }
            if (currentPosition.equals("CAM")) {
                id = c.getResources().getIdentifier("drawable/" + currentPlayerDrawableName, null, c.getPackageName());
                cam.setImageResource(id);
                camCurrentPlayerDrawableName = currentPlayerDrawableName;
            }
            if (currentPosition.equals("RCM")) {
                id = c.getResources().getIdentifier("drawable/" + currentPlayerDrawableName, null, c.getPackageName());
                rcm.setImageResource(id);
                rcmCurrentPlayerDrawableName = currentPlayerDrawableName;
            }
            if (currentPosition.equals("LB")) {
                id = c.getResources().getIdentifier("drawable/" + currentPlayerDrawableName, null, c.getPackageName());
                lb.setImageResource(id);
                lbCurrentPlayerDrawableName = currentPlayerDrawableName;
            }
            if (currentPosition.equals("LCB")) {
                id = c.getResources().getIdentifier("drawable/" + currentPlayerDrawableName, null, c.getPackageName());
                lcb.setImageResource(id);
                lcbCurrentPlayerDrawableName = currentPlayerDrawableName;
            }
            if (currentPosition.equals("RCB")) {
                id = c.getResources().getIdentifier("drawable/" + currentPlayerDrawableName, null, c.getPackageName());
                rcb.setImageResource(id);
                rcbCurrentPlayerDrawableName = currentPlayerDrawableName;
            }
            if (currentPosition.equals("RB")) {
                id = c.getResources().getIdentifier("drawable/" + currentPlayerDrawableName, null, c.getPackageName());
                rb.setImageResource(id);
                rbCurrentPlayerDrawableName = currentPlayerDrawableName;
            }
            if (currentPosition.equals("GK")) {
                id = c.getResources().getIdentifier("drawable/" + currentPlayerDrawableName, null, c.getPackageName());
                gk.setImageResource(id);
                gkCurrentPlayerDrawableName = currentPlayerDrawableName;
            }
        }




        ///////////                  ALL ON CLICK LISTENERS             ////////////////////////


        lw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPosition = "LW";
                Intent myIntent = new Intent(SinglePlayer.this, SinglePick.class);
                myIntent.putExtra("POSITION", currentPosition);
                myIntent.putExtra("POSITION_LW", lwCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_ST", stCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RW", rwCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RCM", rcmCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_CAM", camCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_LCM", lcmCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_LB", lbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_LCB", lcbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RCB", rcbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RB", rbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_GK", gkCurrentPlayerDrawableName);
                SinglePlayer.this.startActivity(myIntent);


            }
        });

        st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPosition = "ST";
                Intent myIntent = new Intent(SinglePlayer.this, SinglePick.class);
                myIntent.putExtra("POSITION", currentPosition);
                myIntent.putExtra("POSITION_LW", lwCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_ST", stCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RW", rwCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RCM", rcmCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_CAM", camCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_LCM", lcmCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_LB", lbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_LCB", lcbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RCB", rcbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RB", rbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_GK", gkCurrentPlayerDrawableName);
                SinglePlayer.this.startActivity(myIntent);


            }
        });

        rw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPosition = "RW";
                Intent myIntent = new Intent(SinglePlayer.this, SinglePick.class);
                myIntent.putExtra("POSITION", currentPosition);
                myIntent.putExtra("POSITION_LW", lwCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_ST", stCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RW", rwCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RCM", rcmCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_CAM", camCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_LCM", lcmCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_LB", lbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_LCB", lcbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RCB", rcbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RB", rbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_GK", gkCurrentPlayerDrawableName);
                SinglePlayer.this.startActivity(myIntent);


            }
        });

        lcm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPosition = "LCM";
                Intent myIntent = new Intent(SinglePlayer.this, SinglePick.class);
                myIntent.putExtra("POSITION", currentPosition);
                myIntent.putExtra("POSITION_LW", lwCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_ST", stCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RW", rwCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RCM", rcmCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_CAM", camCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_LCM", lcmCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_LB", lbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_LCB", lcbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RCB", rcbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RB", rbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_GK", gkCurrentPlayerDrawableName);
                SinglePlayer.this.startActivity(myIntent);


            }
        });

        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPosition = "CAM";
                Intent myIntent = new Intent(SinglePlayer.this, SinglePick.class);
                myIntent.putExtra("POSITION", currentPosition);
                myIntent.putExtra("POSITION_LW", lwCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_ST", stCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RW", rwCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RCM", rcmCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_CAM", camCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_LCM", lcmCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_LB", lbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_LCB", lcbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RCB", rcbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RB", rbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_GK", gkCurrentPlayerDrawableName);
                SinglePlayer.this.startActivity(myIntent);


            }
        });

        rcm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPosition = "RCM";
                Intent myIntent = new Intent(SinglePlayer.this, SinglePick.class);
                myIntent.putExtra("POSITION", currentPosition);
                myIntent.putExtra("POSITION_LW", lwCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_ST", stCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RW", rwCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RCM", rcmCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_CAM", camCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_LCM", lcmCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_LB", lbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_LCB", lcbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RCB", rcbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RB", rbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_GK", gkCurrentPlayerDrawableName);
                SinglePlayer.this.startActivity(myIntent);


            }
        });

        lb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPosition = "LB";
                Intent myIntent = new Intent(SinglePlayer.this, SinglePick.class);
                myIntent.putExtra("POSITION", currentPosition);
                myIntent.putExtra("POSITION_LW", lwCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_ST", stCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RW", rwCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RCM", rcmCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_CAM", camCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_LCM", lcmCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_LB", lbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_LCB", lcbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RCB", rcbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RB", rbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_GK", gkCurrentPlayerDrawableName);
                SinglePlayer.this.startActivity(myIntent);


            }
        });

        lcb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPosition = "LCB";
                Intent myIntent = new Intent(SinglePlayer.this, SinglePick.class);
                myIntent.putExtra("POSITION", currentPosition);
                myIntent.putExtra("POSITION_LW", lwCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_ST", stCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RW", rwCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RCM", rcmCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_CAM", camCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_LCM", lcmCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_LB", lbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_LCB", lcbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RCB", rcbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RB", rbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_GK", gkCurrentPlayerDrawableName);
                SinglePlayer.this.startActivity(myIntent);


            }
        });

        rcb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPosition = "RCB";
                Intent myIntent = new Intent(SinglePlayer.this, SinglePick.class);
                myIntent.putExtra("POSITION", currentPosition);
                myIntent.putExtra("POSITION_LW", lwCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_ST", stCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RW", rwCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RCM", rcmCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_CAM", camCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_LCM", lcmCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_LB", lbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_LCB", lcbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RCB", rcbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RB", rbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_GK", gkCurrentPlayerDrawableName);
                SinglePlayer.this.startActivity(myIntent);


            }
        });

        rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPosition = "RB";
                Intent myIntent = new Intent(SinglePlayer.this, SinglePick.class);
                myIntent.putExtra("POSITION", currentPosition);
                myIntent.putExtra("POSITION_LW", lwCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_ST", stCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RW", rwCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RCM", rcmCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_CAM", camCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_LCM", lcmCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_LB", lbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_LCB", lcbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RCB", rcbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RB", rbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_GK", gkCurrentPlayerDrawableName);
                SinglePlayer.this.startActivity(myIntent);


            }
        });

        gk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPosition = "GK";
                Intent myIntent = new Intent(SinglePlayer.this, SinglePick.class);
                myIntent.putExtra("POSITION", currentPosition);
                myIntent.putExtra("POSITION_LW", lwCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_ST", stCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RW", rwCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RCM", rcmCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_CAM", camCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_LCM", lcmCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_LB", lbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_LCB", lcbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RCB", rcbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_RB", rbCurrentPlayerDrawableName);
                myIntent.putExtra("POSITION_GK", gkCurrentPlayerDrawableName);
                SinglePlayer.this.startActivity(myIntent);


            }
        });



    }
}