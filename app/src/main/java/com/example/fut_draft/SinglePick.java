package com.example.fut_draft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SinglePick extends AppCompatActivity {

    public String currentPosition;
    public ImageView first, second, third, fourth, fifth;
    public TextView name1, name2, name3, name4, name5, club1, club2, club3, club4, club5, league1, league2, league3, league4, league5, nation1, nation2, nation3, nation4, nation5;
    public TextView rating1, rating2, rating3, rating4, rating5, position1, position2, position3, position4, position5;
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

    public String firstPlayerName;
    public String secondPlayerName;
    public String thirdPlayerName;
    public String fourthPlayerName;
    public String fifthPlayerName;

    public String firstPlayerClub;
    public String secondPlayerClub;
    public String thirdPlayerClub;
    public String fourthPlayerClub;
    public String fifthPlayerClub;

    public String firstPlayerLeague;
    public String secondPlayerLeague;
    public String thirdPlayerLeague;
    public String fourthPlayerLeague;
    public String fifthPlayerLeague;

    public String firstPlayerNation;
    public String secondPlayerNation;
    public String thirdPlayerNation;
    public String fourthPlayerNation;
    public String fifthPlayerNation;

    public String firstPlayerRating;
    public String secondPlayerRating;
    public String thirdPlayerRating;
    public String fourthPlayerRating;
    public String fifthPlayerRating;

    public String firstPlayerPosition;
    public String secondPlayerPosition;
    public String thirdPlayerPosition;
    public String fourthPlayerPosition;
    public String fifthPlayerPosition;

    public String position, name;

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
        name = getIntent().getStringExtra("NAME");


        first = findViewById(R.id.playerCard1);
        second = findViewById(R.id.playerCard2);
        third = findViewById(R.id.playerCard3);
        fourth = findViewById(R.id.playerCard4);
        fifth = findViewById(R.id.playerCard5);

        rating1 = findViewById(R.id.playerRating1);
        rating2 = findViewById(R.id.playerRating2);
        rating3 = findViewById(R.id.playerRating3);
        rating4 = findViewById(R.id.playerRating4);
        rating5 = findViewById(R.id.playerRating5);

        position1 = findViewById(R.id.playerPosition1);
        position2 = findViewById(R.id.playerPosition2);
        position3 = findViewById(R.id.playerPosition3);
        position4 = findViewById(R.id.playerPosition4);
        position5 = findViewById(R.id.playerPosition5);

        name1 = findViewById(R.id.player1Name);
        name2 = findViewById(R.id.player2Name);
        name3 = findViewById(R.id.player3Name);
        name4 = findViewById(R.id.player4Name);
        name5 = findViewById(R.id.player5Name);

        club1 = findViewById(R.id.playerClub1);
        club2 = findViewById(R.id.playerClub2);
        club3 = findViewById(R.id.playerClub3);
        club4 = findViewById(R.id.playerClub4);
        club5 = findViewById(R.id.playerClub5);

        league1 = findViewById(R.id.playerLeague1);
        league2 = findViewById(R.id.playerLeague2);
        league3 = findViewById(R.id.playerLeague3);
        league4 = findViewById(R.id.playerLeague4);
        league5 = findViewById(R.id.playerLeague5);

        nation1 = findViewById(R.id.playerNation1);
        nation2 = findViewById(R.id.playerNation2);
        nation3 = findViewById(R.id.playerNation3);
        nation4 = findViewById(R.id.playerNation4);
        nation5 = findViewById(R.id.playerNation5);



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

        firstPlayerRating = MainActivity.db.getRatingFromDrawable(firstPlayerDrawableName);
        secondPlayerRating = MainActivity.db.getRatingFromDrawable(secondPlayerDrawableName);
        thirdPlayerRating = MainActivity.db.getRatingFromDrawable(thirdPlayerDrawableName);
        fourthPlayerRating = MainActivity.db.getRatingFromDrawable(fourthPlayerDrawableName);
        fifthPlayerRating = MainActivity.db.getRatingFromDrawable(fifthPlayerDrawableName);


        firstPlayerPosition = MainActivity.db.getPositionFromDrawable(firstPlayerDrawableName);
        secondPlayerPosition = MainActivity.db.getPositionFromDrawable(secondPlayerDrawableName);
        thirdPlayerPosition = MainActivity.db.getPositionFromDrawable(thirdPlayerDrawableName);
        fourthPlayerPosition = MainActivity.db.getPositionFromDrawable(fourthPlayerDrawableName);
        fifthPlayerPosition = MainActivity.db.getPositionFromDrawable(fifthPlayerDrawableName);

        firstPlayerName = MainActivity.db.getNameFromDrawable(firstPlayerDrawableName);
        secondPlayerName = MainActivity.db.getNameFromDrawable(secondPlayerDrawableName);
        thirdPlayerName = MainActivity.db.getNameFromDrawable(thirdPlayerDrawableName);
        fourthPlayerName = MainActivity.db.getNameFromDrawable(fourthPlayerDrawableName);
        fifthPlayerName = MainActivity.db.getNameFromDrawable(fifthPlayerDrawableName);

        firstPlayerClub = MainActivity.db.getClubFromDrawable(firstPlayerDrawableName);
        secondPlayerClub = MainActivity.db.getClubFromDrawable(secondPlayerDrawableName);
        thirdPlayerClub = MainActivity.db.getClubFromDrawable(thirdPlayerDrawableName);
        fourthPlayerClub = MainActivity.db.getClubFromDrawable(fourthPlayerDrawableName);
        fifthPlayerClub = MainActivity.db.getClubFromDrawable(fifthPlayerDrawableName);

        firstPlayerLeague = MainActivity.db.getLeagueFromDrawable(firstPlayerDrawableName);
        secondPlayerLeague = MainActivity.db.getLeagueFromDrawable(secondPlayerDrawableName);
        thirdPlayerLeague = MainActivity.db.getLeagueFromDrawable(thirdPlayerDrawableName);
        fourthPlayerLeague = MainActivity.db.getLeagueFromDrawable(fourthPlayerDrawableName);
        fifthPlayerLeague = MainActivity.db.getLeagueFromDrawable(fifthPlayerDrawableName);

        firstPlayerNation = MainActivity.db.getNationFromDrawable(firstPlayerDrawableName);
        secondPlayerNation = MainActivity.db.getNationFromDrawable(secondPlayerDrawableName);
        thirdPlayerNation = MainActivity.db.getNationFromDrawable(thirdPlayerDrawableName);
        fourthPlayerNation = MainActivity.db.getNationFromDrawable(fourthPlayerDrawableName);
        fifthPlayerNation = MainActivity.db.getNationFromDrawable(fifthPlayerDrawableName);



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




        ///////////           SET ALL PLAYER INFO                   ////////////////////////
        name1.setText(firstPlayerName);
        name2.setText(secondPlayerName);
        name3.setText(thirdPlayerName);
        name4.setText(fourthPlayerName);
        name5.setText(fifthPlayerName);

        club1.setText(firstPlayerClub);
        club2.setText(secondPlayerClub);
        club3.setText(thirdPlayerClub);
        club4.setText(fourthPlayerClub);
        club5.setText(fifthPlayerClub);

        league1.setText(firstPlayerLeague);
        league2.setText(secondPlayerLeague);
        league3.setText(thirdPlayerLeague);
        league4.setText(fourthPlayerLeague);
        league5.setText(fifthPlayerLeague);

        nation1.setText(firstPlayerNation);
        nation2.setText(secondPlayerNation);
        nation3.setText(thirdPlayerNation);
        nation4.setText(fourthPlayerNation);
        nation5.setText(fifthPlayerNation);

        rating1.setText(firstPlayerRating);
        rating2.setText(secondPlayerRating);
        rating3.setText(thirdPlayerRating);
        rating4.setText(fourthPlayerRating);
        rating5.setText(fifthPlayerRating);

        position1.setText(firstPlayerPosition);
        position2.setText(secondPlayerPosition);
        position3.setText(thirdPlayerPosition);
        position4.setText(fourthPlayerPosition);
        position5.setText(fifthPlayerPosition);





        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //playerName = players name not done yet we need to know who they pick
                if(currentPosition.equals("LW")){
                    lwCurrentPlayerDrawableName = firstPlayerDrawableName;
                }
                if(currentPosition.equals("RW")){
                    rwCurrentPlayerDrawableName = firstPlayerDrawableName;
                }if(currentPosition.equals("ST")){
                    stCurrentPlayerDrawableName = firstPlayerDrawableName;
                }if(currentPosition.equals("LCM")){
                    lcmCurrentPlayerDrawableName = firstPlayerDrawableName;
                }if(currentPosition.equals("CAM")){
                    camCurrentPlayerDrawableName = firstPlayerDrawableName;
                }if(currentPosition.equals("RCM")){
                    rcmCurrentPlayerDrawableName = firstPlayerDrawableName;
                }if(currentPosition.equals("LB")){
                    lbCurrentPlayerDrawableName = firstPlayerDrawableName;
                }if(currentPosition.equals("LCB")){
                    lcbCurrentPlayerDrawableName = firstPlayerDrawableName;
                }if(currentPosition.equals("RCB")){
                    rcbCurrentPlayerDrawableName = firstPlayerDrawableName;
                }if(currentPosition.equals("RB")){
                    rbCurrentPlayerDrawableName = firstPlayerDrawableName;
                }if(currentPosition.equals("GK")){
                    gkCurrentPlayerDrawableName = firstPlayerDrawableName;
                }
                Intent myIntent = new Intent(SinglePick.this, SinglePlayer.class);
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
                myIntent.putExtra("NAME", name);

                SinglePick.this.startActivity(myIntent);


            }
        });

        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //playerName = players name not done yet we need to know who they pick
                if(currentPosition.equals("LW")){
                    lwCurrentPlayerDrawableName = secondPlayerDrawableName;
                }
                if(currentPosition.equals("RW")){
                    rwCurrentPlayerDrawableName = secondPlayerDrawableName;
                }if(currentPosition.equals("ST")){
                    stCurrentPlayerDrawableName = secondPlayerDrawableName;
                }if(currentPosition.equals("LCM")){
                    lcmCurrentPlayerDrawableName = secondPlayerDrawableName;
                }if(currentPosition.equals("CAM")){
                    camCurrentPlayerDrawableName = secondPlayerDrawableName;
                }if(currentPosition.equals("RCM")){
                    rcmCurrentPlayerDrawableName = secondPlayerDrawableName;
                }if(currentPosition.equals("LB")){
                    lbCurrentPlayerDrawableName = secondPlayerDrawableName;
                }if(currentPosition.equals("LCB")){
                    lcbCurrentPlayerDrawableName = secondPlayerDrawableName;
                }if(currentPosition.equals("RCB")){
                    rcbCurrentPlayerDrawableName = secondPlayerDrawableName;
                }if(currentPosition.equals("RB")){
                    rbCurrentPlayerDrawableName = secondPlayerDrawableName;
                }if(currentPosition.equals("GK")){
                    gkCurrentPlayerDrawableName = secondPlayerDrawableName;
                }
                Intent myIntent = new Intent(SinglePick.this, SinglePlayer.class);
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
                myIntent.putExtra("NAME", name);

                SinglePick.this.startActivity(myIntent);


            }
        });

        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //playerName = players name not done yet we need to know who they pick
                if(currentPosition.equals("LW")){
                    lwCurrentPlayerDrawableName = thirdPlayerDrawableName;
                }
                if(currentPosition.equals("RW")){
                    rwCurrentPlayerDrawableName = thirdPlayerDrawableName;
                }if(currentPosition.equals("ST")){
                    stCurrentPlayerDrawableName = thirdPlayerDrawableName;
                }if(currentPosition.equals("LCM")){
                    lcmCurrentPlayerDrawableName = thirdPlayerDrawableName;
                }if(currentPosition.equals("CAM")){
                    camCurrentPlayerDrawableName = thirdPlayerDrawableName;
                }if(currentPosition.equals("RCM")){
                    rcmCurrentPlayerDrawableName = thirdPlayerDrawableName;
                }if(currentPosition.equals("LB")){
                    lbCurrentPlayerDrawableName = thirdPlayerDrawableName;
                }if(currentPosition.equals("LCB")){
                    lcbCurrentPlayerDrawableName = thirdPlayerDrawableName;
                }if(currentPosition.equals("RCB")){
                    rcbCurrentPlayerDrawableName = thirdPlayerDrawableName;
                }if(currentPosition.equals("RB")){
                    rbCurrentPlayerDrawableName = thirdPlayerDrawableName;
                }if(currentPosition.equals("GK")){
                    gkCurrentPlayerDrawableName = thirdPlayerDrawableName;
                }
                Intent myIntent = new Intent(SinglePick.this, SinglePlayer.class);
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
                myIntent.putExtra("NAME", name);

                SinglePick.this.startActivity(myIntent);


            }
        });

        fourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //playerName = players name not done yet we need to know who they pick
                if(currentPosition.equals("LW")){
                    lwCurrentPlayerDrawableName = fourthPlayerDrawableName;
                }
                if(currentPosition.equals("RW")){
                    rwCurrentPlayerDrawableName = fourthPlayerDrawableName;
                }if(currentPosition.equals("ST")){
                    stCurrentPlayerDrawableName = fourthPlayerDrawableName;
                }if(currentPosition.equals("LCM")){
                    lcmCurrentPlayerDrawableName = fourthPlayerDrawableName;
                }if(currentPosition.equals("CAM")){
                    camCurrentPlayerDrawableName = fourthPlayerDrawableName;
                }if(currentPosition.equals("RCM")){
                    rcmCurrentPlayerDrawableName = fourthPlayerDrawableName;
                }if(currentPosition.equals("LB")){
                    lbCurrentPlayerDrawableName = fourthPlayerDrawableName;
                }if(currentPosition.equals("LCB")){
                    lcbCurrentPlayerDrawableName = fourthPlayerDrawableName;
                }if(currentPosition.equals("RCB")){
                    rcbCurrentPlayerDrawableName = fourthPlayerDrawableName;
                }if(currentPosition.equals("RB")){
                    rbCurrentPlayerDrawableName = fourthPlayerDrawableName;
                }if(currentPosition.equals("GK")){
                    gkCurrentPlayerDrawableName = fourthPlayerDrawableName;
                }
                Intent myIntent = new Intent(SinglePick.this, SinglePlayer.class);
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
                myIntent.putExtra("NAME", name);

                SinglePick.this.startActivity(myIntent);


            }
        });

        fifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //playerName = players name not done yet we need to know who they pick
                if(currentPosition.equals("LW")){
                    lwCurrentPlayerDrawableName = fifthPlayerDrawableName;
                }
                if(currentPosition.equals("RW")){
                    rwCurrentPlayerDrawableName = fifthPlayerDrawableName;
                }if(currentPosition.equals("ST")){
                    stCurrentPlayerDrawableName = fifthPlayerDrawableName;
                }if(currentPosition.equals("LCM")){
                    lcmCurrentPlayerDrawableName = fifthPlayerDrawableName;
                }if(currentPosition.equals("CAM")){
                    camCurrentPlayerDrawableName = fifthPlayerDrawableName;
                }if(currentPosition.equals("RCM")){
                    rcmCurrentPlayerDrawableName = fifthPlayerDrawableName;
                }if(currentPosition.equals("LB")){
                    lbCurrentPlayerDrawableName = fifthPlayerDrawableName;
                }if(currentPosition.equals("LCB")){
                    lcbCurrentPlayerDrawableName = fifthPlayerDrawableName;
                }if(currentPosition.equals("RCB")){
                    rcbCurrentPlayerDrawableName = fifthPlayerDrawableName;
                }if(currentPosition.equals("RB")){
                    rbCurrentPlayerDrawableName = fifthPlayerDrawableName;
                }if(currentPosition.equals("GK")){
                    gkCurrentPlayerDrawableName = fifthPlayerDrawableName;
                }
                Intent myIntent = new Intent(SinglePick.this, SinglePlayer.class);
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
                myIntent.putExtra("NAME", name);

                SinglePick.this.startActivity(myIntent);


            }
        });

    }


}