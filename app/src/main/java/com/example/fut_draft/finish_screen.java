package com.example.fut_draft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class finish_screen extends AppCompatActivity {
    public TextView ratingValue, chemValue, squadRatingValue, leaguesValue, nationsValue, skillRatingValue, draftRatingValue;
    public TextView topPlayer1, topPlayer2, topPlayer3, topPlayer4, topPlayer5, topPlayer6, topPlayer7, topPlayer8, topPlayer9, topPlayer10;
    public TextView topPlayer1Rating, topPlayer2Rating, topPlayer3Rating, topPlayer4Rating, topPlayer5Rating, topPlayer6Rating, topPlayer7Rating, topPlayer8Rating, topPlayer9Rating, topPlayer10Rating;
    public String rating, chem, squadRating, name, placeHolder;
    public ImageView tp1, tp2, tp3;
    public Integer ratingInt, id, chemInt, squadRatingInt, p1Rating, p2Rating, p3Rating, p4Rating, p5Rating, p6Rating, p7Rating, p8Rating, p9Rating, p10Rating;
    public ProgressBar chemProgress, ratingProgress, squadRatingProgress, draftRatingProgress;
    public Button finish;
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
    public ArrayList<String> playerDrawableNames, topPlayers, topThree;
    public String numberOfNations;
    public String numberOfLeagues;
    public Integer numberOfNationsInt;
    public Integer numberOfLeaguesInt;
    public Integer skillratingInt;
    public Integer draftratingInt;
    public String skillrating;
    public String draftrating;
    public Context c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_screen);
        finish = findViewById(R.id.finishButton);
        c = getApplicationContext();
        ratingValue = findViewById(R.id.rating_value);
        chemValue = findViewById(R.id.chem_value);
        squadRatingValue = findViewById(R.id.squad_rating_value);
        nationsValue = findViewById(R.id.nations_value);
        leaguesValue = findViewById(R.id.leagues_value);
        skillRatingValue = findViewById(R.id.skill_rating_value);
        draftRatingValue = findViewById(R.id.draft_rating_value);

        chemProgress = findViewById(R.id.chemProgressBar);
        ratingProgress = findViewById(R.id.ratingProgressBar);
        squadRatingProgress = findViewById(R.id.squadRatingProgressBar);
        draftRatingProgress = findViewById(R.id.draftRatingProgressBar);
        playerDrawableNames = new ArrayList<>();
        tp1 = findViewById(R.id.topPlayer1);
        tp2 = findViewById(R.id.topPlayer2);
        tp3 = findViewById(R.id.topPlayer3);
        topPlayer1 = findViewById(R.id.p1_player);
        topPlayer2 = findViewById(R.id.p2_player);
        topPlayer3 = findViewById(R.id.p3_player);
        topPlayer4 = findViewById(R.id.p4_player);
        topPlayer5 = findViewById(R.id.p5_player);
        topPlayer6 = findViewById(R.id.p6_player);
        topPlayer7 = findViewById(R.id.p7_player);
        topPlayer8 = findViewById(R.id.p8_player);
        topPlayer9 = findViewById(R.id.p9_player);
        topPlayer10 = findViewById(R.id.p10_player);

        topPlayer1Rating = findViewById(R.id.p1_playerRating);
        topPlayer2Rating = findViewById(R.id.p2_playerRating);
        topPlayer3Rating = findViewById(R.id.p3_playerRating);
        topPlayer4Rating = findViewById(R.id.p4_playerRating);
        topPlayer5Rating = findViewById(R.id.p5_playerRating);
        topPlayer6Rating = findViewById(R.id.p6_playerRating);
        topPlayer7Rating = findViewById(R.id.p7_playerRating);
        topPlayer8Rating = findViewById(R.id.p8_playerRating);
        topPlayer9Rating = findViewById(R.id.p9_playerRating);
        topPlayer10Rating = findViewById(R.id.p10_playerRating);

        topPlayers = new ArrayList<>();
        rating = getIntent().getStringExtra("RATING");
        chem = getIntent().getStringExtra("CHEM");
        name = getIntent().getStringExtra("NAME");

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

        if((lwCurrentPlayerDrawableName != null) && (stCurrentPlayerDrawableName != null) && (rwCurrentPlayerDrawableName != null) && (lcmCurrentPlayerDrawableName != null) && (camCurrentPlayerDrawableName != null) && (rcmCurrentPlayerDrawableName != null) && (lbCurrentPlayerDrawableName != null) && (lcbCurrentPlayerDrawableName != null) && (rcbCurrentPlayerDrawableName != null) && (rbCurrentPlayerDrawableName != null) && (gkCurrentPlayerDrawableName != null)){
            playerDrawableNames.add(lwCurrentPlayerDrawableName);
            playerDrawableNames.add(stCurrentPlayerDrawableName);
            playerDrawableNames.add(rwCurrentPlayerDrawableName);
            playerDrawableNames.add(rcmCurrentPlayerDrawableName);
            playerDrawableNames.add(camCurrentPlayerDrawableName);
            playerDrawableNames.add(lcmCurrentPlayerDrawableName);
            playerDrawableNames.add(lbCurrentPlayerDrawableName);
            playerDrawableNames.add(lcbCurrentPlayerDrawableName);
            playerDrawableNames.add(rcbCurrentPlayerDrawableName);
            playerDrawableNames.add(rbCurrentPlayerDrawableName);
            playerDrawableNames.add(gkCurrentPlayerDrawableName);
            topThree = new ArrayList<>();
            topThree = MainActivity.db.getTopThreePlayers(playerDrawableNames);
            id = c.getResources().getIdentifier("drawable/" + topThree.get(0), null, c.getPackageName());
            tp1.setImageResource(id);
            id = c.getResources().getIdentifier("drawable/" + topThree.get(1), null, c.getPackageName());
            tp2.setImageResource(id);
            id = c.getResources().getIdentifier("drawable/" + topThree.get(2), null, c.getPackageName());
            tp3.setImageResource(id);
            numberOfNations = MainActivity.db.getNumberOfNations(playerDrawableNames);
            numberOfLeagues = MainActivity.db.getNumberOfLeagues(playerDrawableNames);
            numberOfNationsInt = Integer.parseInt(numberOfNations);
            numberOfLeaguesInt = Integer.parseInt(numberOfLeagues);
            skillratingInt = numberOfLeaguesInt + numberOfNationsInt;
            skillrating = Integer.toString(skillratingInt);
            ratingInt = Integer.parseInt(rating);
            chemInt = Integer.parseInt(chem);
            squadRatingInt = chemInt + ratingInt;
            squadRating = Integer.toString(squadRatingInt);
            draftratingInt = squadRatingInt + skillratingInt;
            draftrating = Integer.toString(draftratingInt);

            ratingValue.setText(rating);
            chemValue.setText(chem);
            squadRatingValue.setText(squadRating);
            nationsValue.setText(numberOfNations);
            leaguesValue.setText(numberOfLeagues);
            skillRatingValue.setText(skillrating);
            draftRatingValue.setText(draftrating);

            chemProgress.setProgress(chemInt);
            ratingProgress.setProgress(ratingInt);
            squadRatingProgress.setProgress(squadRatingInt);
            draftRatingProgress.setProgress(draftratingInt);

            topPlayers = MainActivity.db.addTopPlayer(name, draftratingInt);
            topPlayer1.setText("1.  " + topPlayers.get(0));
            topPlayer2.setText("2.  " + topPlayers.get(1));
            topPlayer3.setText("3.  " + topPlayers.get(2));
            topPlayer4.setText("4.  " + topPlayers.get(3));
            topPlayer5.setText("5.  " + topPlayers.get(4));
            topPlayer6.setText("6.  " + topPlayers.get(5));
            topPlayer7.setText("7.  " + topPlayers.get(6));
            topPlayer8.setText("8.  " + topPlayers.get(7));
            topPlayer9.setText("9.  " + topPlayers.get(8));
            topPlayer10.setText("10.  " + topPlayers.get(9));

            p1Rating = MainActivity.db.getRatingFromName(topPlayers.get(0));
            p2Rating = MainActivity.db.getRatingFromName(topPlayers.get(1));
            p3Rating = MainActivity.db.getRatingFromName(topPlayers.get(2));
            p4Rating = MainActivity.db.getRatingFromName(topPlayers.get(3));
            p5Rating = MainActivity.db.getRatingFromName(topPlayers.get(4));
            p6Rating = MainActivity.db.getRatingFromName(topPlayers.get(5));
            p7Rating = MainActivity.db.getRatingFromName(topPlayers.get(6));
            p8Rating = MainActivity.db.getRatingFromName(topPlayers.get(7));
            p9Rating = MainActivity.db.getRatingFromName(topPlayers.get(8));
            p10Rating = MainActivity.db.getRatingFromName(topPlayers.get(9));

            placeHolder = Integer.toString(p1Rating);
            topPlayer1Rating.setText(placeHolder);
            placeHolder = Integer.toString(p2Rating);
            topPlayer2Rating.setText(placeHolder);
            placeHolder = Integer.toString(p3Rating);
            topPlayer3Rating.setText(placeHolder);
            placeHolder = Integer.toString(p4Rating);
            topPlayer4Rating.setText(placeHolder);
            placeHolder = Integer.toString(p5Rating);
            topPlayer5Rating.setText(placeHolder);
            placeHolder = Integer.toString(p6Rating);
            topPlayer6Rating.setText(placeHolder);
            placeHolder = Integer.toString(p7Rating);
            topPlayer7Rating.setText(placeHolder);
            placeHolder = Integer.toString(p8Rating);
            topPlayer8Rating.setText(placeHolder);
            placeHolder = Integer.toString(p9Rating);
            topPlayer9Rating.setText(placeHolder);
            placeHolder = Integer.toString(p10Rating);
            topPlayer10Rating.setText(placeHolder);

        }




        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(finish_screen.this, MainActivity.class);
                finish_screen.this.startActivity(myIntent);
            }
        });


    }
}