package com.example.fut_draft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class SinglePick extends AppCompatActivity {

    public String currentPosition;
    public String currentPlayerDrawableName;
    public ImageView first, second, third, fourth, fifth;
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

    public String firstPlayerDrawableName;
    public String secondPlayerDrawableName;
    public String thirdPlayerDrawableName;
    public String fourthPlayerDrawableName;
    public String fifthPlayerDrawableName;

    public String position;

    public Context c;
    public Integer id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_pick);
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

        first = findViewById(R.id.playerCard1);
        second = findViewById(R.id.playerCard2);
        third = findViewById(R.id.playerCard3);
        fourth = findViewById(R.id.playerCard4);
        fifth = findViewById(R.id.playerCard5);
        c = getApplicationContext();


        ///////////           RANDOMLY SELECT 5 PLAYERS IN THIS POSITION       ////////////////////////
        ArrayList<String> alreadyPicked = new ArrayList<>();
        alreadyPicked.add(lwCurrentPlayerDrawableName);
        alreadyPicked.add(stCurrentPlayerDrawableName);
        alreadyPicked.add(rwCurrentPlayerDrawableName);
        alreadyPicked.add(rcmCurrentPlayerDrawableName);
        alreadyPicked.add(camCurrentPlayerDrawableName);
        alreadyPicked.add(lcmCurrentPlayerDrawableName);
        alreadyPicked.add(lbCurrentPlayerDrawableName);
        alreadyPicked.add(lcbCurrentPlayerDrawableName);
        alreadyPicked.add(rcbCurrentPlayerDrawableName);
        alreadyPicked.add(rbCurrentPlayerDrawableName);
        alreadyPicked.add(gkCurrentPlayerDrawableName);

        if(currentPosition.equals("LW")){
            position = "LW";
        }
        if(currentPosition.equals("ST")){
            position = "ST";
        }
        if(currentPosition.equals("RW")){
            position = "RW";
        }
        if(currentPosition.equals("LCM")){
            position = "MID";
        }
        if(currentPosition.equals("CAM")){
            position = "MID";
        }
        if(currentPosition.equals("RCM")){
            position = "MID";
        }
        if(currentPosition.equals("LB")){
            position = "LB";
        }
        if(currentPosition.equals("LCB")){
            position = "CB";
        }
        if(currentPosition.equals("RCB")){
            position = "CB";
        }
        if(currentPosition.equals("RB")){
            position = "RB";
        }
        if(currentPosition.equals("GK")){
            position = "GK";
        }

        ArrayList<String> drawableNamesArrayList = MainActivity.db.findDrawableNamesFromPosition(position, alreadyPicked);

        firstPlayerDrawableName = drawableNamesArrayList.get(0);
        secondPlayerDrawableName = drawableNamesArrayList.get(1);
        thirdPlayerDrawableName = drawableNamesArrayList.get(2);
        fourthPlayerDrawableName = drawableNamesArrayList.get(3);
        fifthPlayerDrawableName = drawableNamesArrayList.get(4);

        ///////////           SET ALL PLAYER IMAGES                   ////////////////////////


        id = c.getResources().getIdentifier("drawable/" + firstPlayerDrawableName, null, c.getPackageName());
        first.setImageResource(id);
        id = c.getResources().getIdentifier("drawable/" + secondPlayerDrawableName, null, c.getPackageName());
        second.setImageResource(id);
        id = c.getResources().getIdentifier("drawable/" + thirdPlayerDrawableName, null, c.getPackageName());
        third.setImageResource(id);
        id = c.getResources().getIdentifier("drawable/" + fourthPlayerDrawableName, null, c.getPackageName());
        fourth.setImageResource(id);
        id = c.getResources().getIdentifier("drawable/" + fifthPlayerDrawableName, null, c.getPackageName());
        fifth.setImageResource(id);





        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //playerName = players name not done yet we need to know who they pick
                currentPlayerDrawableName = firstPlayerDrawableName;
                Intent myIntent = new Intent(SinglePick.this, SinglePlayer.class);
                myIntent.putExtra("CURRENT_PLAYER_DRAWABLE_NAME", currentPlayerDrawableName);
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
                SinglePick.this.startActivity(myIntent);


            }
        });

        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //playerName = players name not done yet we need to know who they pick
                currentPlayerDrawableName = secondPlayerDrawableName;
                Intent myIntent = new Intent(SinglePick.this, SinglePlayer.class);
                myIntent.putExtra("CURRENT_PLAYER_DRAWABLE_NAME", currentPlayerDrawableName);
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
                SinglePick.this.startActivity(myIntent);


            }
        });

        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //playerName = players name not done yet we need to know who they pick
                currentPlayerDrawableName = thirdPlayerDrawableName;
                Intent myIntent = new Intent(SinglePick.this, SinglePlayer.class);
                myIntent.putExtra("CURRENT_PLAYER_DRAWABLE_NAME", currentPlayerDrawableName);
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
                SinglePick.this.startActivity(myIntent);


            }
        });

        fourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //playerName = players name not done yet we need to know who they pick
                currentPlayerDrawableName = fourthPlayerDrawableName;
                Intent myIntent = new Intent(SinglePick.this, SinglePlayer.class);
                myIntent.putExtra("CURRENT_PLAYER_DRAWABLE_NAME", currentPlayerDrawableName);
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
                SinglePick.this.startActivity(myIntent);


            }
        });

        fifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //playerName = players name not done yet we need to know who they pick
                currentPlayerDrawableName = fifthPlayerDrawableName;
                Intent myIntent = new Intent(SinglePick.this, SinglePlayer.class);
                myIntent.putExtra("CURRENT_PLAYER_DRAWABLE_NAME", currentPlayerDrawableName);
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
                SinglePick.this.startActivity(myIntent);


            }
        });

    }


}