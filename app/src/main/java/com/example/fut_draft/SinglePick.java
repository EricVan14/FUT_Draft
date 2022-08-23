package com.example.fut_draft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

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

        ///////////           RANDOMLY SELECT 5 PLAYERS IN THIS POSITION       ////////////////////////

        if(currentPosition.equals("LW")){

        }

        if(currentPosition.equals("ST")){

        }

        if(currentPosition.equals("RW")){

        }

        if(currentPosition.equals("LCM")){

        }

        if(currentPosition.equals("CAM")){

        }

        if(currentPosition.equals("RCM")){

        }

        if(currentPosition.equals("LB")){

        }

        if(currentPosition.equals("LCB")){

        }

        if(currentPosition.equals("RCB")){

        }

        if(currentPosition.equals("RB")){

        }

        if(currentPosition.equals("GK")){

        }

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