package com.example.fut_draft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SinglePlayer extends AppCompatActivity {

    public ImageView lw, st, rw, lcm, cam, rcm, lb, lcb, rcb, rb, gk;
    public Button quit, finish;
    public Integer lwChem, stChem, rwChem, lcmChem, camChem, rcmChem, lbChem, lcbChem, rcbChem, rbChem, gkChem, totalChem;
    public ImageView lwTost, rwTost, rcmTorw, lcmTolw, camTost, rcmTocam, lcmTocam, lbTolcm, rbTorcm, rcbTorb, lcbTolb, lcbTorcb, gkTolcb, gkTorcb;
    public String currentPosition;
    public String currentSwitchPosition;
    public String nextSwitchPosition;
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
    public Integer lwRating;
    public Integer stRating;
    public Integer rwRating;
    public Integer lcmRating;
    public Integer camRating;
    public Integer rcmRating;
    public Integer lbRating;
    public Integer lcbRating;
    public Integer rcbRating;
    public Integer rbRating;
    public Integer gkRating;
    public Integer totalRating;

    public Context c;
    public Integer id;
    public String str;
    public String stringRating;
    public String stringChem;

    public String lwtostLink;
    public String rwtostLink;
    public String lcmtolwLink;
    public String rcmtorwLink;
    public String camtostLink;
    public String lcmtocamLink;
    public String rcmtocamLink;
    public String lbtolcmLink;
    public String rbtorcmLink;
    public String lcbtolbLink;
    public String lcbtorcbLink;
    public String rcbtorbLink;
    public String gktolcbLink;
    public String gktorcbLink;

    public TextView ratingValue, chemValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);

        quit = findViewById(R.id.quitButton);
        finish = findViewById(R.id.finishButton);


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

        lwTost = findViewById(R.id.lwTost);
        rwTost = findViewById(R.id.rwTost);
        rcmTorw = findViewById(R.id.rcmTorw);
        lcmTolw = findViewById(R.id.lcmTolw);
        camTost = findViewById(R.id.camTost);
        rcmTocam = findViewById(R.id.rcmTocam);
        lcmTocam = findViewById(R.id.lcmTocam);
        lbTolcm = findViewById(R.id.lbTolcm);
        rbTorcm = findViewById(R.id.rbTorcm);
        rcbTorb = findViewById(R.id.rcbTorb);
        lcbTolb = findViewById(R.id.lcbTolb);
        lcbTorcb = findViewById(R.id.lcbTorcb);
        gkTolcb = findViewById(R.id.gkTolcb);
        gkTorcb = findViewById(R.id.gkTorcb);

        ratingValue = findViewById(R.id.rating_value);
        chemValue = findViewById(R.id.chem_value);

        c = getApplicationContext();




        ///////////                  PREVIOUS SELECTIONS             ////////////////////////

        Bundle extras = getIntent().getExtras();
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
        lwRating = 0;
        stRating = 0;
        rwRating = 0;
        lcmRating = 0;
        camRating = 0;
        rcmRating = 0;
        lbRating = 0;
        lcbRating = 0;
        rcbRating = 0;
        rbRating = 0;
        gkRating = 0;
        totalRating = 0;
        setUpPlayers();
        setUpLinks();
        setUpChem();
        setUpRating();


        ///////////                  ALL ON CLICK LISTENERS             ////////////////////////



        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(SinglePlayer.this, MainActivity.class);
                SinglePlayer.this.startActivity(myIntent);
            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(SinglePlayer.this, finish_screen.class);
                myIntent.putExtra("RATING", stringRating);
                myIntent.putExtra("CHEM", stringChem);
                SinglePlayer.this.startActivity(myIntent);
            }
        });


        lw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPosition = "LW";
                if(lwCurrentPlayerDrawableName != null){
                    if(currentSwitchPosition != null){
                        nextSwitchPosition = currentPosition;
                        if(currentSwitchPosition.equals(nextSwitchPosition)){
                            currentSwitchPosition = null;
                            nextSwitchPosition = null;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("ST")){
                            String placeholder = lwCurrentPlayerDrawableName;
                            lwCurrentPlayerDrawableName = stCurrentPlayerDrawableName;
                            stCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RW")){
                            String placeholder = lwCurrentPlayerDrawableName;
                            lwCurrentPlayerDrawableName = rwCurrentPlayerDrawableName;
                            rwCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LCM")){
                            String placeholder = lwCurrentPlayerDrawableName;
                            lwCurrentPlayerDrawableName = lcmCurrentPlayerDrawableName;
                            lcmCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RCM")){
                            String placeholder = lwCurrentPlayerDrawableName;
                            lwCurrentPlayerDrawableName = rcmCurrentPlayerDrawableName;
                            rcmCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("CAM")){
                            String placeholder = lwCurrentPlayerDrawableName;
                            lwCurrentPlayerDrawableName = camCurrentPlayerDrawableName;
                            camCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LB")){
                            String placeholder = lwCurrentPlayerDrawableName;
                            lwCurrentPlayerDrawableName = lbCurrentPlayerDrawableName;
                            lbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LCB")){
                            String placeholder = lwCurrentPlayerDrawableName;
                            lwCurrentPlayerDrawableName = lcbCurrentPlayerDrawableName;
                            lcbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RCB")){
                            String placeholder = lwCurrentPlayerDrawableName;
                            lwCurrentPlayerDrawableName = rcbCurrentPlayerDrawableName;
                            rcbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RB")){
                            String placeholder = lwCurrentPlayerDrawableName;
                            lwCurrentPlayerDrawableName = rbCurrentPlayerDrawableName;
                            rbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("GK")){
                            String placeholder = lwCurrentPlayerDrawableName;
                            lwCurrentPlayerDrawableName = gkCurrentPlayerDrawableName;
                            gkCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        currentSwitchPosition = null;
                        nextSwitchPosition = null;

                    }else{
                        currentSwitchPosition = currentPosition;
                    }
                }else{
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
            }
        });

        st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPosition = "ST";
                if(stCurrentPlayerDrawableName != null){
                    if(currentSwitchPosition != null){
                        nextSwitchPosition = currentPosition;
                        if(currentSwitchPosition.equals(nextSwitchPosition)){
                            currentSwitchPosition = null;
                            nextSwitchPosition = null;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LW")){
                            String placeholder = stCurrentPlayerDrawableName;
                            stCurrentPlayerDrawableName = lwCurrentPlayerDrawableName;
                            lwCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RW")){
                            String placeholder = stCurrentPlayerDrawableName;
                            stCurrentPlayerDrawableName = rwCurrentPlayerDrawableName;
                            rwCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LCM")){
                            String placeholder = stCurrentPlayerDrawableName;
                            stCurrentPlayerDrawableName = lcmCurrentPlayerDrawableName;
                            lcmCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RCM")){
                            String placeholder = stCurrentPlayerDrawableName;
                            stCurrentPlayerDrawableName = rcmCurrentPlayerDrawableName;
                            rcmCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("CAM")){
                            String placeholder = stCurrentPlayerDrawableName;
                            stCurrentPlayerDrawableName = camCurrentPlayerDrawableName;
                            camCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LB")){
                            String placeholder = stCurrentPlayerDrawableName;
                            stCurrentPlayerDrawableName = lbCurrentPlayerDrawableName;
                            lbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LCB")){
                            String placeholder = stCurrentPlayerDrawableName;
                            stCurrentPlayerDrawableName = lcbCurrentPlayerDrawableName;
                            lcbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RCB")){
                            String placeholder = stCurrentPlayerDrawableName;
                            stCurrentPlayerDrawableName = rcbCurrentPlayerDrawableName;
                            rcbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RB")){
                            String placeholder = stCurrentPlayerDrawableName;
                            stCurrentPlayerDrawableName = rbCurrentPlayerDrawableName;
                            rbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("GK")){
                            String placeholder = stCurrentPlayerDrawableName;
                            stCurrentPlayerDrawableName = gkCurrentPlayerDrawableName;
                            gkCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        currentSwitchPosition = null;
                        nextSwitchPosition = null;

                    }else{
                        currentSwitchPosition = currentPosition;
                    }
                }else{
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


            }
        });

        rw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPosition = "RW";
                if(rwCurrentPlayerDrawableName != null){
                    if(currentSwitchPosition != null){
                        nextSwitchPosition = currentPosition;
                        if(currentSwitchPosition.equals(nextSwitchPosition)){
                            currentSwitchPosition = null;
                            nextSwitchPosition = null;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("ST")){
                            String placeholder = rwCurrentPlayerDrawableName;
                            rwCurrentPlayerDrawableName = stCurrentPlayerDrawableName;
                            stCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LW")){
                            String placeholder = rwCurrentPlayerDrawableName;
                            rwCurrentPlayerDrawableName = lwCurrentPlayerDrawableName;
                            lwCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LCM")){
                            String placeholder = rwCurrentPlayerDrawableName;
                            rwCurrentPlayerDrawableName = lcmCurrentPlayerDrawableName;
                            lcmCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RCM")){
                            String placeholder = rwCurrentPlayerDrawableName;
                            rwCurrentPlayerDrawableName = rcmCurrentPlayerDrawableName;
                            rcmCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("CAM")){
                            String placeholder = rwCurrentPlayerDrawableName;
                            rwCurrentPlayerDrawableName = camCurrentPlayerDrawableName;
                            camCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LB")){
                            String placeholder = rwCurrentPlayerDrawableName;
                            rwCurrentPlayerDrawableName = lbCurrentPlayerDrawableName;
                            lbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LCB")){
                            String placeholder = rwCurrentPlayerDrawableName;
                            rwCurrentPlayerDrawableName = lcbCurrentPlayerDrawableName;
                            lcbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RCB")){
                            String placeholder = rwCurrentPlayerDrawableName;
                            rwCurrentPlayerDrawableName = rcbCurrentPlayerDrawableName;
                            rcbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RB")){
                            String placeholder = rwCurrentPlayerDrawableName;
                            rwCurrentPlayerDrawableName = rbCurrentPlayerDrawableName;
                            rbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("GK")){
                            String placeholder = rwCurrentPlayerDrawableName;
                            rwCurrentPlayerDrawableName = gkCurrentPlayerDrawableName;
                            gkCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        currentSwitchPosition = null;
                        nextSwitchPosition = null;

                    }else{
                        currentSwitchPosition = currentPosition;
                    }
                }else{
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


            }
        });

        lcm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPosition = "LCM";
                if(lcmCurrentPlayerDrawableName != null){
                    if(currentSwitchPosition != null){
                        nextSwitchPosition = currentPosition;
                        if(currentSwitchPosition.equals(nextSwitchPosition)){
                            currentSwitchPosition = null;
                            nextSwitchPosition = null;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("ST")){
                            String placeholder = lcmCurrentPlayerDrawableName;
                            lcmCurrentPlayerDrawableName = stCurrentPlayerDrawableName;
                            stCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LW")){
                            String placeholder = lcmCurrentPlayerDrawableName;
                            lcmCurrentPlayerDrawableName = lwCurrentPlayerDrawableName;
                            lwCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RW")){
                            String placeholder = lcmCurrentPlayerDrawableName;
                            lcmCurrentPlayerDrawableName = rwCurrentPlayerDrawableName;
                            rwCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RCM")){
                            String placeholder = lcmCurrentPlayerDrawableName;
                            lcmCurrentPlayerDrawableName = rcmCurrentPlayerDrawableName;
                            rcmCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("CAM")){
                            String placeholder = lcmCurrentPlayerDrawableName;
                            lcmCurrentPlayerDrawableName = camCurrentPlayerDrawableName;
                            camCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LB")){
                            String placeholder = lcmCurrentPlayerDrawableName;
                            lcmCurrentPlayerDrawableName = lbCurrentPlayerDrawableName;
                            lbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LCB")){
                            String placeholder = lcmCurrentPlayerDrawableName;
                            lcmCurrentPlayerDrawableName = lcbCurrentPlayerDrawableName;
                            lcbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RCB")){
                            String placeholder = lcmCurrentPlayerDrawableName;
                            lcmCurrentPlayerDrawableName = rcbCurrentPlayerDrawableName;
                            rcbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RB")){
                            String placeholder = lcmCurrentPlayerDrawableName;
                            lcmCurrentPlayerDrawableName = rbCurrentPlayerDrawableName;
                            rbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("GK")){
                            String placeholder = lcmCurrentPlayerDrawableName;
                            lcmCurrentPlayerDrawableName = gkCurrentPlayerDrawableName;
                            gkCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        currentSwitchPosition = null;
                        nextSwitchPosition = null;

                    }else{
                        currentSwitchPosition = currentPosition;
                    }
                }else{
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


            }
        });

        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPosition = "CAM";
                if(camCurrentPlayerDrawableName != null){
                    if(currentSwitchPosition != null){
                        nextSwitchPosition = currentPosition;
                        if(currentSwitchPosition.equals(nextSwitchPosition)){
                            currentSwitchPosition = null;
                            nextSwitchPosition = null;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("ST")){
                            String placeholder = camCurrentPlayerDrawableName;
                            camCurrentPlayerDrawableName = stCurrentPlayerDrawableName;
                            stCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LW")){
                            String placeholder = camCurrentPlayerDrawableName;
                            camCurrentPlayerDrawableName = lwCurrentPlayerDrawableName;
                            lwCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RW")){
                            String placeholder = camCurrentPlayerDrawableName;
                            camCurrentPlayerDrawableName = rwCurrentPlayerDrawableName;
                            rwCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RCM")){
                            String placeholder = camCurrentPlayerDrawableName;
                            camCurrentPlayerDrawableName = rcmCurrentPlayerDrawableName;
                            rcmCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LCM")){
                            String placeholder = camCurrentPlayerDrawableName;
                            camCurrentPlayerDrawableName = lcmCurrentPlayerDrawableName;
                            lcmCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LB")){
                            String placeholder = camCurrentPlayerDrawableName;
                            camCurrentPlayerDrawableName = lbCurrentPlayerDrawableName;
                            lbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LCB")){
                            String placeholder = camCurrentPlayerDrawableName;
                            camCurrentPlayerDrawableName = lcbCurrentPlayerDrawableName;
                            lcbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RCB")){
                            String placeholder = camCurrentPlayerDrawableName;
                            camCurrentPlayerDrawableName = rcbCurrentPlayerDrawableName;
                            rcbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RB")){
                            String placeholder = camCurrentPlayerDrawableName;
                            camCurrentPlayerDrawableName = rbCurrentPlayerDrawableName;
                            rbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("GK")){
                            String placeholder = camCurrentPlayerDrawableName;
                            camCurrentPlayerDrawableName = gkCurrentPlayerDrawableName;
                            gkCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        currentSwitchPosition = null;
                        nextSwitchPosition = null;

                    }else{
                        currentSwitchPosition = currentPosition;
                    }
                }else{
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


            }
        });

        rcm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPosition = "RCM";
                if(rcmCurrentPlayerDrawableName != null){
                    if(currentSwitchPosition != null){
                        nextSwitchPosition = currentPosition;
                        if(currentSwitchPosition.equals(nextSwitchPosition)){
                            currentSwitchPosition = null;
                            nextSwitchPosition = null;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("ST")){
                            String placeholder = rcmCurrentPlayerDrawableName;
                            rcmCurrentPlayerDrawableName = stCurrentPlayerDrawableName;
                            stCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LW")){
                            String placeholder = rcmCurrentPlayerDrawableName;
                            rcmCurrentPlayerDrawableName = lwCurrentPlayerDrawableName;
                            lwCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RW")){
                            String placeholder = rcmCurrentPlayerDrawableName;
                            rcmCurrentPlayerDrawableName = rwCurrentPlayerDrawableName;
                            rwCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("CAM")){
                            String placeholder = rcmCurrentPlayerDrawableName;
                            rcmCurrentPlayerDrawableName = camCurrentPlayerDrawableName;
                            camCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LCM")){
                            String placeholder = rcmCurrentPlayerDrawableName;
                            rcmCurrentPlayerDrawableName = lcmCurrentPlayerDrawableName;
                            lcmCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LB")){
                            String placeholder = rcmCurrentPlayerDrawableName;
                            rcmCurrentPlayerDrawableName = lbCurrentPlayerDrawableName;
                            lbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LCB")){
                            String placeholder = rcmCurrentPlayerDrawableName;
                            rcmCurrentPlayerDrawableName = lcbCurrentPlayerDrawableName;
                            lcbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RCB")){
                            String placeholder = rcmCurrentPlayerDrawableName;
                            rcmCurrentPlayerDrawableName = rcbCurrentPlayerDrawableName;
                            rcbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RB")){
                            String placeholder = rcmCurrentPlayerDrawableName;
                            rcmCurrentPlayerDrawableName = rbCurrentPlayerDrawableName;
                            rbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("GK")){
                            String placeholder = rcmCurrentPlayerDrawableName;
                            rcmCurrentPlayerDrawableName = gkCurrentPlayerDrawableName;
                            gkCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        currentSwitchPosition = null;
                        nextSwitchPosition = null;

                    }else{
                        currentSwitchPosition = currentPosition;
                    }
                }else{
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


            }
        });

        lb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPosition = "LB";
                if(lbCurrentPlayerDrawableName != null){
                    if(currentSwitchPosition != null){
                        nextSwitchPosition = currentPosition;
                        if(currentSwitchPosition.equals(nextSwitchPosition)){
                            currentSwitchPosition = null;
                            nextSwitchPosition = null;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("ST")){
                            String placeholder = lbCurrentPlayerDrawableName;
                            lbCurrentPlayerDrawableName = stCurrentPlayerDrawableName;
                            stCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LW")){
                            String placeholder = lbCurrentPlayerDrawableName;
                            lbCurrentPlayerDrawableName = lwCurrentPlayerDrawableName;
                            lwCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RW")){
                            String placeholder = lbCurrentPlayerDrawableName;
                            lbCurrentPlayerDrawableName = rwCurrentPlayerDrawableName;
                            rwCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("CAM")){
                            String placeholder = lbCurrentPlayerDrawableName;
                            lbCurrentPlayerDrawableName = camCurrentPlayerDrawableName;
                            camCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LCM")){
                            String placeholder = lbCurrentPlayerDrawableName;
                            lbCurrentPlayerDrawableName = lcmCurrentPlayerDrawableName;
                            lcmCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RCM")){
                            String placeholder = lbCurrentPlayerDrawableName;
                            lbCurrentPlayerDrawableName = rcmCurrentPlayerDrawableName;
                            rcmCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LCB")){
                            String placeholder = lbCurrentPlayerDrawableName;
                            lbCurrentPlayerDrawableName = lcbCurrentPlayerDrawableName;
                            lcbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RCB")){
                            String placeholder = lbCurrentPlayerDrawableName;
                            lbCurrentPlayerDrawableName = rcbCurrentPlayerDrawableName;
                            rcbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RB")){
                            String placeholder = lbCurrentPlayerDrawableName;
                            lbCurrentPlayerDrawableName = rbCurrentPlayerDrawableName;
                            rbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("GK")){
                            String placeholder = lbCurrentPlayerDrawableName;
                            lbCurrentPlayerDrawableName = gkCurrentPlayerDrawableName;
                            gkCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        currentSwitchPosition = null;
                        nextSwitchPosition = null;

                    }else{
                        currentSwitchPosition = currentPosition;
                    }
                }else{
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


            }
        });

        lcb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPosition = "LCB";
                if(lcbCurrentPlayerDrawableName != null){
                    if(currentSwitchPosition != null){
                        nextSwitchPosition = currentPosition;
                        if(currentSwitchPosition.equals(nextSwitchPosition)){
                            currentSwitchPosition = null;
                            nextSwitchPosition = null;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("ST")){
                            String placeholder = lcbCurrentPlayerDrawableName;
                            lcbCurrentPlayerDrawableName = stCurrentPlayerDrawableName;
                            stCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LW")){
                            String placeholder = lcbCurrentPlayerDrawableName;
                            lcbCurrentPlayerDrawableName = lwCurrentPlayerDrawableName;
                            lwCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RW")){
                            String placeholder = lcbCurrentPlayerDrawableName;
                            lcbCurrentPlayerDrawableName = rwCurrentPlayerDrawableName;
                            rwCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("CAM")){
                            String placeholder = lcbCurrentPlayerDrawableName;
                            lcbCurrentPlayerDrawableName = camCurrentPlayerDrawableName;
                            camCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LCM")){
                            String placeholder = lcbCurrentPlayerDrawableName;
                            lcbCurrentPlayerDrawableName = lcmCurrentPlayerDrawableName;
                            lcmCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RCM")){
                            String placeholder = lcbCurrentPlayerDrawableName;
                            lcbCurrentPlayerDrawableName = rcmCurrentPlayerDrawableName;
                            rcmCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LB")){
                            String placeholder = lcbCurrentPlayerDrawableName;
                            lcbCurrentPlayerDrawableName = lbCurrentPlayerDrawableName;
                            lbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RCB")){
                            String placeholder = lcbCurrentPlayerDrawableName;
                            lcbCurrentPlayerDrawableName = rcbCurrentPlayerDrawableName;
                            rcbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RB")){
                            String placeholder = lcbCurrentPlayerDrawableName;
                            lcbCurrentPlayerDrawableName = rbCurrentPlayerDrawableName;
                            rbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("GK")){
                            String placeholder = lcbCurrentPlayerDrawableName;
                            lcbCurrentPlayerDrawableName = gkCurrentPlayerDrawableName;
                            gkCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        currentSwitchPosition = null;
                        nextSwitchPosition = null;

                    }else{
                        currentSwitchPosition = currentPosition;
                    }
                }else{
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


            }
        });

        rcb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPosition = "RCB";
                if(rcbCurrentPlayerDrawableName != null){
                    if(currentSwitchPosition != null){
                        nextSwitchPosition = currentPosition;
                        if(currentSwitchPosition.equals(nextSwitchPosition)){
                            currentSwitchPosition = null;
                            nextSwitchPosition = null;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("ST")){
                            String placeholder = rcbCurrentPlayerDrawableName;
                            rcbCurrentPlayerDrawableName = stCurrentPlayerDrawableName;
                            stCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LW")){
                            String placeholder = rcbCurrentPlayerDrawableName;
                            rcbCurrentPlayerDrawableName = lwCurrentPlayerDrawableName;
                            lwCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RW")){
                            String placeholder = rcbCurrentPlayerDrawableName;
                            rcbCurrentPlayerDrawableName = rwCurrentPlayerDrawableName;
                            rwCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("CAM")){
                            String placeholder = rcbCurrentPlayerDrawableName;
                            rcbCurrentPlayerDrawableName = camCurrentPlayerDrawableName;
                            camCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LCM")){
                            String placeholder = rcbCurrentPlayerDrawableName;
                            rcbCurrentPlayerDrawableName = lcmCurrentPlayerDrawableName;
                            lcmCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RCM")){
                            String placeholder = rcbCurrentPlayerDrawableName;
                            rcbCurrentPlayerDrawableName = rcmCurrentPlayerDrawableName;
                            rcmCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LB")){
                            String placeholder = rcbCurrentPlayerDrawableName;
                            rcbCurrentPlayerDrawableName = lbCurrentPlayerDrawableName;
                            lbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LCB")){
                            String placeholder = rcbCurrentPlayerDrawableName;
                            rcbCurrentPlayerDrawableName = lcbCurrentPlayerDrawableName;
                            lcbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RB")){
                            String placeholder = rcbCurrentPlayerDrawableName;
                            rcbCurrentPlayerDrawableName = rbCurrentPlayerDrawableName;
                            rbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("GK")){
                            String placeholder = rcbCurrentPlayerDrawableName;
                            rcbCurrentPlayerDrawableName = gkCurrentPlayerDrawableName;
                            gkCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        currentSwitchPosition = null;
                        nextSwitchPosition = null;

                    }else{
                        currentSwitchPosition = currentPosition;
                    }
                }else{
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


            }
        });

        rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPosition = "RB";
                if(rbCurrentPlayerDrawableName != null){
                    if(currentSwitchPosition != null){
                        nextSwitchPosition = currentPosition;
                        if(currentSwitchPosition.equals(nextSwitchPosition)){
                            currentSwitchPosition = null;
                            nextSwitchPosition = null;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("ST")){
                            String placeholder = rbCurrentPlayerDrawableName;
                            rbCurrentPlayerDrawableName = stCurrentPlayerDrawableName;
                            stCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LW")){
                            String placeholder = rbCurrentPlayerDrawableName;
                            rbCurrentPlayerDrawableName = lwCurrentPlayerDrawableName;
                            lwCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RW")){
                            String placeholder = rbCurrentPlayerDrawableName;
                            rbCurrentPlayerDrawableName = rwCurrentPlayerDrawableName;
                            rwCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("CAM")){
                            String placeholder = rbCurrentPlayerDrawableName;
                            rbCurrentPlayerDrawableName = camCurrentPlayerDrawableName;
                            camCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LCM")){
                            String placeholder = rbCurrentPlayerDrawableName;
                            rbCurrentPlayerDrawableName = lcmCurrentPlayerDrawableName;
                            lcmCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RCM")){
                            String placeholder = rbCurrentPlayerDrawableName;
                            rbCurrentPlayerDrawableName = rcmCurrentPlayerDrawableName;
                            rcmCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LB")){
                            String placeholder = rbCurrentPlayerDrawableName;
                            rbCurrentPlayerDrawableName = lbCurrentPlayerDrawableName;
                            lbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LCB")){
                            String placeholder = rbCurrentPlayerDrawableName;
                            rbCurrentPlayerDrawableName = lcbCurrentPlayerDrawableName;
                            lcbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RCB")){
                            String placeholder = rbCurrentPlayerDrawableName;
                            rbCurrentPlayerDrawableName = rcbCurrentPlayerDrawableName;
                            rcbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("GK")){
                            String placeholder = rbCurrentPlayerDrawableName;
                            rbCurrentPlayerDrawableName = gkCurrentPlayerDrawableName;
                            gkCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        currentSwitchPosition = null;
                        nextSwitchPosition = null;

                    }else{
                        currentSwitchPosition = currentPosition;
                    }
                }else{
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


            }
        });

        gk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPosition = "GK";
                if(gkCurrentPlayerDrawableName != null){
                    if(currentSwitchPosition != null){
                        nextSwitchPosition = currentPosition;
                        if(currentSwitchPosition.equals(nextSwitchPosition)){
                            currentSwitchPosition = null;
                            nextSwitchPosition = null;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("ST")){
                            String placeholder = gkCurrentPlayerDrawableName;
                            gkCurrentPlayerDrawableName = stCurrentPlayerDrawableName;
                            stCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LW")){
                            String placeholder = gkCurrentPlayerDrawableName;
                            gkCurrentPlayerDrawableName = lwCurrentPlayerDrawableName;
                            lwCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RW")){
                            String placeholder = gkCurrentPlayerDrawableName;
                            gkCurrentPlayerDrawableName = rwCurrentPlayerDrawableName;
                            rwCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("CAM")){
                            String placeholder = gkCurrentPlayerDrawableName;
                            gkCurrentPlayerDrawableName = camCurrentPlayerDrawableName;
                            camCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LCM")){
                            String placeholder = gkCurrentPlayerDrawableName;
                            gkCurrentPlayerDrawableName = lcmCurrentPlayerDrawableName;
                            lcmCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RCM")){
                            String placeholder = gkCurrentPlayerDrawableName;
                            gkCurrentPlayerDrawableName = rcmCurrentPlayerDrawableName;
                            rcmCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LB")){
                            String placeholder = gkCurrentPlayerDrawableName;
                            gkCurrentPlayerDrawableName = lbCurrentPlayerDrawableName;
                            lbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("LCB")){
                            String placeholder = gkCurrentPlayerDrawableName;
                            gkCurrentPlayerDrawableName = lcbCurrentPlayerDrawableName;
                            lcbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RCB")){
                            String placeholder = gkCurrentPlayerDrawableName;
                            gkCurrentPlayerDrawableName = rcbCurrentPlayerDrawableName;
                            rcbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        if(currentSwitchPosition.equals("RB")){
                            String placeholder = gkCurrentPlayerDrawableName;
                            gkCurrentPlayerDrawableName = rbCurrentPlayerDrawableName;
                            rbCurrentPlayerDrawableName = placeholder;
                            setUpPlayers();
                            setUpLinks();
                            setUpChem();
                            setUpRating();
                        }
                        currentSwitchPosition = null;
                        nextSwitchPosition = null;

                    }else{
                        currentSwitchPosition = currentPosition;
                    }
                }else{
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


            }
        });



    }

    public void setUpLinks(){
        //////////////////             SETTING UP ALL LINKS           ///////////////////////////////////


        if((lwCurrentPlayerDrawableName != null) && (stCurrentPlayerDrawableName != null)){
            lwtostLink = MainActivity.db.getLinkBetweenPlayers(lwCurrentPlayerDrawableName,stCurrentPlayerDrawableName);
            if(lwtostLink.equals("RED")){
                id = c.getResources().getIdentifier("drawable/" + "red_bar", null, c.getPackageName());
                lwTost.setImageResource(id);
            }
            if(lwtostLink.equals("GREEN")){
                id = c.getResources().getIdentifier("drawable/" + "green_bar", null, c.getPackageName());
                lwTost.setImageResource(id);
            }if(lwtostLink.equals("YELLOW")){
                id = c.getResources().getIdentifier("drawable/" + "yellow_bar", null, c.getPackageName());
                lwTost.setImageResource(id);
            }


        }

        if((rwCurrentPlayerDrawableName != null) && (stCurrentPlayerDrawableName != null)){
            rwtostLink = MainActivity.db.getLinkBetweenPlayers(rwCurrentPlayerDrawableName,stCurrentPlayerDrawableName);
            if(rwtostLink.equals("RED")){
                id = c.getResources().getIdentifier("drawable/" + "red_bar", null, c.getPackageName());
                rwTost.setImageResource(id);
            }
            if(rwtostLink.equals("GREEN")){
                id = c.getResources().getIdentifier("drawable/" + "green_bar", null, c.getPackageName());
                rwTost.setImageResource(id);
            }if(rwtostLink.equals("YELLOW")){
                id = c.getResources().getIdentifier("drawable/" + "yellow_bar", null, c.getPackageName());
                rwTost.setImageResource(id);
            }
        }

        if((lwCurrentPlayerDrawableName != null) && (lcmCurrentPlayerDrawableName != null)){
            lcmtolwLink = MainActivity.db.getLinkBetweenPlayers(lwCurrentPlayerDrawableName,lcmCurrentPlayerDrawableName);
            if(lcmtolwLink.equals("RED")){
                id = c.getResources().getIdentifier("drawable/" + "red_bar", null, c.getPackageName());
                lcmTolw.setImageResource(id);
            }
            if(lcmtolwLink.equals("GREEN")){
                id = c.getResources().getIdentifier("drawable/" + "green_bar", null, c.getPackageName());
                lcmTolw.setImageResource(id);
            }if(lcmtolwLink.equals("YELLOW")){
                id = c.getResources().getIdentifier("drawable/" + "yellow_bar", null, c.getPackageName());
                lcmTolw.setImageResource(id);
            }
        }

        if((rwCurrentPlayerDrawableName != null) && (rcmCurrentPlayerDrawableName != null)){
            rcmtorwLink = MainActivity.db.getLinkBetweenPlayers(rwCurrentPlayerDrawableName,rcmCurrentPlayerDrawableName);
            if(rcmtorwLink.equals("RED")){
                id = c.getResources().getIdentifier("drawable/" + "red_bar", null, c.getPackageName());
                rcmTorw.setImageResource(id);
            }
            if(rcmtorwLink.equals("GREEN")){
                id = c.getResources().getIdentifier("drawable/" + "green_bar", null, c.getPackageName());
                rcmTorw.setImageResource(id);
            }if(rcmtorwLink.equals("YELLOW")){
                id = c.getResources().getIdentifier("drawable/" + "yellow_bar", null, c.getPackageName());
                rcmTorw.setImageResource(id);
            }
        }

        if((camCurrentPlayerDrawableName != null) && (stCurrentPlayerDrawableName != null)){
            camtostLink = MainActivity.db.getLinkBetweenPlayers(camCurrentPlayerDrawableName,stCurrentPlayerDrawableName);
            if(camtostLink.equals("RED")){
                id = c.getResources().getIdentifier("drawable/" + "red_bar", null, c.getPackageName());
                camTost.setImageResource(id);
            }
            if(camtostLink.equals("GREEN")){
                id = c.getResources().getIdentifier("drawable/" + "green_bar", null, c.getPackageName());
                camTost.setImageResource(id);
            }if(camtostLink.equals("YELLOW")){
                id = c.getResources().getIdentifier("drawable/" + "yellow_bar", null, c.getPackageName());
                camTost.setImageResource(id);
            }
        }

        if((camCurrentPlayerDrawableName != null) && (lcmCurrentPlayerDrawableName != null)){
            lcmtocamLink = MainActivity.db.getLinkBetweenPlayers(camCurrentPlayerDrawableName,lcmCurrentPlayerDrawableName);
            if(lcmtocamLink.equals("RED")){
                id = c.getResources().getIdentifier("drawable/" + "red_bar", null, c.getPackageName());
                lcmTocam.setImageResource(id);
            }
            if(lcmtocamLink.equals("GREEN")){
                id = c.getResources().getIdentifier("drawable/" + "green_bar", null, c.getPackageName());
                lcmTocam.setImageResource(id);
            }if(lcmtocamLink.equals("YELLOW")){
                id = c.getResources().getIdentifier("drawable/" + "yellow_bar", null, c.getPackageName());
                lcmTocam.setImageResource(id);
            }
        }

        if((camCurrentPlayerDrawableName != null) && (rcmCurrentPlayerDrawableName != null)){
            rcmtocamLink = MainActivity.db.getLinkBetweenPlayers(camCurrentPlayerDrawableName,rcmCurrentPlayerDrawableName);
            if(rcmtocamLink.equals("RED")){
                id = c.getResources().getIdentifier("drawable/" + "red_bar", null, c.getPackageName());
                rcmTocam.setImageResource(id);
            }
            if(rcmtocamLink.equals("GREEN")){
                id = c.getResources().getIdentifier("drawable/" + "green_bar", null, c.getPackageName());
                rcmTocam.setImageResource(id);
            }if(rcmtocamLink.equals("YELLOW")){
                id = c.getResources().getIdentifier("drawable/" + "yellow_bar", null, c.getPackageName());
                rcmTocam.setImageResource(id);
            }
        }

        if((lbCurrentPlayerDrawableName != null) && (lcmCurrentPlayerDrawableName != null)){
            lbtolcmLink = MainActivity.db.getLinkBetweenPlayers(lbCurrentPlayerDrawableName,lcmCurrentPlayerDrawableName);
            if(lbtolcmLink.equals("RED")){
                id = c.getResources().getIdentifier("drawable/" + "red_bar", null, c.getPackageName());
                lbTolcm.setImageResource(id);
            }
            if(lbtolcmLink.equals("GREEN")){
                id = c.getResources().getIdentifier("drawable/" + "green_bar", null, c.getPackageName());
                lbTolcm.setImageResource(id);
            }if(lbtolcmLink.equals("YELLOW")){
                id = c.getResources().getIdentifier("drawable/" + "yellow_bar", null, c.getPackageName());
                lbTolcm.setImageResource(id);
            }
        }

        if((rbCurrentPlayerDrawableName != null) && (rcmCurrentPlayerDrawableName != null)){
            rbtorcmLink = MainActivity.db.getLinkBetweenPlayers(rbCurrentPlayerDrawableName,rcmCurrentPlayerDrawableName);
            if(rbtorcmLink.equals("RED")){
                id = c.getResources().getIdentifier("drawable/" + "red_bar", null, c.getPackageName());
                rbTorcm.setImageResource(id);
            }
            if(rbtorcmLink.equals("GREEN")){
                id = c.getResources().getIdentifier("drawable/" + "green_bar", null, c.getPackageName());
                rbTorcm.setImageResource(id);
            }if(rbtorcmLink.equals("YELLOW")){
                id = c.getResources().getIdentifier("drawable/" + "yellow_bar", null, c.getPackageName());
                rbTorcm.setImageResource(id);
            }
        }

        if((lcbCurrentPlayerDrawableName != null) && (lbCurrentPlayerDrawableName != null)){
            lcbtolbLink = MainActivity.db.getLinkBetweenPlayers(lcbCurrentPlayerDrawableName,lbCurrentPlayerDrawableName);
            if(lcbtolbLink.equals("RED")){
                id = c.getResources().getIdentifier("drawable/" + "red_bar", null, c.getPackageName());
                lcbTolb.setImageResource(id);
            }
            if(lcbtolbLink.equals("GREEN")){
                id = c.getResources().getIdentifier("drawable/" + "green_bar", null, c.getPackageName());
                lcbTolb.setImageResource(id);
            }if(lcbtolbLink.equals("YELLOW")){
                id = c.getResources().getIdentifier("drawable/" + "yellow_bar", null, c.getPackageName());
                lcbTolb.setImageResource(id);
            }
        }

        if((lcbCurrentPlayerDrawableName != null) && (rcbCurrentPlayerDrawableName != null)){
            lcbtorcbLink = MainActivity.db.getLinkBetweenPlayers(lcbCurrentPlayerDrawableName,rcbCurrentPlayerDrawableName);
            if(lcbtorcbLink.equals("RED")){
                id = c.getResources().getIdentifier("drawable/" + "red_bar", null, c.getPackageName());
                lcbTorcb.setImageResource(id);
            }
            if(lcbtorcbLink.equals("GREEN")){
                id = c.getResources().getIdentifier("drawable/" + "green_bar", null, c.getPackageName());
                lcbTorcb.setImageResource(id);
            }if(lcbtorcbLink.equals("YELLOW")){
                id = c.getResources().getIdentifier("drawable/" + "yellow_bar", null, c.getPackageName());
                lcbTorcb.setImageResource(id);
            }
        }

        if((rcbCurrentPlayerDrawableName != null) && (rbCurrentPlayerDrawableName != null)){
            rcbtorbLink = MainActivity.db.getLinkBetweenPlayers(rcbCurrentPlayerDrawableName,rbCurrentPlayerDrawableName);
            if(rcbtorbLink.equals("RED")){
                id = c.getResources().getIdentifier("drawable/" + "red_bar", null, c.getPackageName());
                rcbTorb.setImageResource(id);
            }
            if(rcbtorbLink.equals("GREEN")){
                id = c.getResources().getIdentifier("drawable/" + "green_bar", null, c.getPackageName());
                rcbTorb.setImageResource(id);
            }if(rcbtorbLink.equals("YELLOW")){
                id = c.getResources().getIdentifier("drawable/" + "yellow_bar", null, c.getPackageName());
                rcbTorb.setImageResource(id);
            }
        }

        if((gkCurrentPlayerDrawableName != null) && (lcbCurrentPlayerDrawableName != null)){
            gktolcbLink = MainActivity.db.getLinkBetweenPlayers(gkCurrentPlayerDrawableName,lcbCurrentPlayerDrawableName);
            if(gktolcbLink.equals("RED")){
                id = c.getResources().getIdentifier("drawable/" + "red_bar", null, c.getPackageName());
                gkTolcb.setImageResource(id);
            }
            if(gktolcbLink.equals("GREEN")){
                id = c.getResources().getIdentifier("drawable/" + "green_bar", null, c.getPackageName());
                gkTolcb.setImageResource(id);
            }if(gktolcbLink.equals("YELLOW")){
                id = c.getResources().getIdentifier("drawable/" + "yellow_bar", null, c.getPackageName());
                gkTolcb.setImageResource(id);
            }
        }

        if((gkCurrentPlayerDrawableName != null) && (rcbCurrentPlayerDrawableName != null)){
            gktorcbLink = MainActivity.db.getLinkBetweenPlayers(gkCurrentPlayerDrawableName,rcbCurrentPlayerDrawableName);
            if(gktorcbLink.equals("RED")){
                id = c.getResources().getIdentifier("drawable/" + "red_bar", null, c.getPackageName());
                gkTorcb.setImageResource(id);
            }
            if(gktorcbLink.equals("GREEN")){
                id = c.getResources().getIdentifier("drawable/" + "green_bar", null, c.getPackageName());
                gkTorcb.setImageResource(id);
            }if(gktorcbLink.equals("YELLOW")){
                id = c.getResources().getIdentifier("drawable/" + "yellow_bar", null, c.getPackageName());
                gkTorcb.setImageResource(id);
            }
        }
    }

    public void setUpPlayers(){
        if(lwCurrentPlayerDrawableName != null){
            id = c.getResources().getIdentifier("drawable/" + lwCurrentPlayerDrawableName, null, c.getPackageName());
            stringRating = MainActivity.db.getRatingFromDrawable(lwCurrentPlayerDrawableName);
            lwRating = Integer.parseInt(stringRating);
            lw.setImageResource(id);
        }

        if(stCurrentPlayerDrawableName != null){
            id = c.getResources().getIdentifier("drawable/" + stCurrentPlayerDrawableName, null, c.getPackageName());
            stringRating = MainActivity.db.getRatingFromDrawable(stCurrentPlayerDrawableName);
            stRating = Integer.parseInt(stringRating);
            st.setImageResource(id);
        }

        if(rwCurrentPlayerDrawableName != null){
            id = c.getResources().getIdentifier("drawable/" + rwCurrentPlayerDrawableName, null, c.getPackageName());
            stringRating = MainActivity.db.getRatingFromDrawable(rwCurrentPlayerDrawableName);
            rwRating = Integer.parseInt(stringRating);
            rw.setImageResource(id);
        }

        if(lcmCurrentPlayerDrawableName != null){
            id = c.getResources().getIdentifier("drawable/" + lcmCurrentPlayerDrawableName, null, c.getPackageName());
            stringRating = MainActivity.db.getRatingFromDrawable(lcmCurrentPlayerDrawableName);
            lcmRating = Integer.parseInt(stringRating);
            lcm.setImageResource(id);
        }

        if(camCurrentPlayerDrawableName != null){
            id = c.getResources().getIdentifier("drawable/" + camCurrentPlayerDrawableName, null, c.getPackageName());
            stringRating = MainActivity.db.getRatingFromDrawable(camCurrentPlayerDrawableName);
            camRating = Integer.parseInt(stringRating);
            cam.setImageResource(id);
        }

        if(rcmCurrentPlayerDrawableName != null){
            id = c.getResources().getIdentifier("drawable/" + rcmCurrentPlayerDrawableName, null, c.getPackageName());
            stringRating = MainActivity.db.getRatingFromDrawable(rcmCurrentPlayerDrawableName);
            rcmRating = Integer.parseInt(stringRating);
            rcm.setImageResource(id);
        }

        if(lbCurrentPlayerDrawableName != null){
            id = c.getResources().getIdentifier("drawable/" + lbCurrentPlayerDrawableName, null, c.getPackageName());
            stringRating = MainActivity.db.getRatingFromDrawable(lbCurrentPlayerDrawableName);
            lbRating = Integer.parseInt(stringRating);
            lb.setImageResource(id);
        }

        if(lcbCurrentPlayerDrawableName != null){
            id = c.getResources().getIdentifier("drawable/" + lcbCurrentPlayerDrawableName, null, c.getPackageName());
            stringRating = MainActivity.db.getRatingFromDrawable(lcbCurrentPlayerDrawableName);
            lcbRating = Integer.parseInt(stringRating);
            lcb.setImageResource(id);
        }

        if(rcbCurrentPlayerDrawableName != null){
            id = c.getResources().getIdentifier("drawable/" + rcbCurrentPlayerDrawableName, null, c.getPackageName());
            stringRating = MainActivity.db.getRatingFromDrawable(rcbCurrentPlayerDrawableName);
            rcbRating = Integer.parseInt(stringRating);
            rcb.setImageResource(id);
        }

        if(rbCurrentPlayerDrawableName != null){
            id = c.getResources().getIdentifier("drawable/" + rbCurrentPlayerDrawableName, null, c.getPackageName());
            stringRating = MainActivity.db.getRatingFromDrawable(rbCurrentPlayerDrawableName);
            rbRating = Integer.parseInt(stringRating);
            rb.setImageResource(id);
        }

        if(gkCurrentPlayerDrawableName != null){
            id = c.getResources().getIdentifier("drawable/" + gkCurrentPlayerDrawableName, null, c.getPackageName());
            stringRating = MainActivity.db.getRatingFromDrawable(gkCurrentPlayerDrawableName);
            gkRating = Integer.parseInt(stringRating);
            gk.setImageResource(id);
        }
    }

    public void setUpChem(){

        ////////////////                  SET UP CHEM           ////////////////////////


        lwChem = 0;
        if(lwtostLink != null && lcmtolwLink != null){
            if(lwtostLink.equals("GREEN") || lcmtolwLink.equals("GREEN")){
                lwChem = 10;
            }else{
                if(lwtostLink.equals("YELLOW") && lcmtolwLink.equals("YELLOW")){
                    lwChem = 10;
                }else{
                    if(lwtostLink.equals("YELLOW") || lcmtolwLink.equals("YELLOW")){
                        lwChem = 7;
                    }else{
                        lwChem = 3;
                    }
                }
            }
        }

        rwChem = 0;
        if(rwtostLink != null && rcmtorwLink != null){
            if(rwtostLink.equals("GREEN") || rcmtorwLink.equals("GREEN")){
                rwChem = 10;
            }else{
                if(rwtostLink.equals("YELLOW") && rcmtorwLink.equals("YELLOW")){
                    rwChem = 10;
                }else{
                    if(rwtostLink.equals("YELLOW") || rcmtorwLink.equals("YELLOW")){
                        rwChem = 7;
                    }else{
                        rwChem = 3;
                    }
                }
            }
        }

        stChem = 0;
        if(rwtostLink != null && lwtostLink != null && camtostLink != null){
            if((rwtostLink.equals("GREEN") && lwtostLink.equals("GREEN")) || (rwtostLink.equals("GREEN") && camtostLink.equals("GREEN")) || (camtostLink.equals("GREEN") && lwtostLink.equals("GREEN"))){
                stChem = 10;
            }
            if(rwtostLink.equals("GREEN") || lwtostLink.equals("GREEN")  || camtostLink.equals("GREEN")){
                if(rwtostLink.equals("YELLOW") || lwtostLink.equals("YELLOW")  || camtostLink.equals("YELLOW")){
                    stChem = 10;
                }
            }
            if(rwtostLink.equals("YELLOW") && lwtostLink.equals("YELLOW") && camtostLink.equals("YELLOW")){
                stChem = 10;
            }else{
                if((rwtostLink.equals("YELLOW") && lwtostLink.equals("YELLOW")) || (rwtostLink.equals("YELLOW") && camtostLink.equals("YELLOW")) || (camtostLink.equals("YELLOW") && lwtostLink.equals("YELLOW"))){
                    stChem = 7;
                }else{
                    if(rwtostLink.equals("YELLOW") || lwtostLink.equals("YELLOW")  || camtostLink.equals("YELLOW")){
                        stChem = 3;
                    }
                }
            }

        }

        lcmChem = 0;
        if(lcmtolwLink != null && lcmtocamLink != null && lbtolcmLink != null){
            if((lcmtolwLink.equals("GREEN") && lcmtocamLink.equals("GREEN")) || (lcmtolwLink.equals("GREEN") && lbtolcmLink.equals("GREEN")) || (lbtolcmLink.equals("GREEN") && lcmtocamLink.equals("GREEN"))){
                lcmChem = 10;
            }
            if(lcmtolwLink.equals("GREEN") || lcmtocamLink.equals("GREEN")  || lbtolcmLink.equals("GREEN")){
                if(lcmtolwLink.equals("YELLOW") || lcmtocamLink.equals("YELLOW")  || lbtolcmLink.equals("YELLOW")){
                    lcmChem = 10;
                }
            }
            if(lcmtolwLink.equals("YELLOW") && lcmtocamLink.equals("YELLOW") && lbtolcmLink.equals("YELLOW")){
                lcmChem = 10;
            }else{
                if((lcmtolwLink.equals("YELLOW") && lcmtocamLink.equals("YELLOW")) || (lcmtolwLink.equals("YELLOW") && lbtolcmLink.equals("YELLOW")) || (lbtolcmLink.equals("YELLOW") && lcmtocamLink.equals("YELLOW"))){
                    lcmChem = 7;
                }else{
                    if(lcmtolwLink.equals("YELLOW") || lcmtocamLink.equals("YELLOW")  || lbtolcmLink.equals("YELLOW")){
                        lcmChem = 3;
                    }
                }
            }

        }

        camChem = 0;
        if(camtostLink != null && lcmtocamLink != null && rcmtocamLink != null){
            if((camtostLink.equals("GREEN") && lcmtocamLink.equals("GREEN")) || (camtostLink.equals("GREEN") && rcmtocamLink.equals("GREEN")) || (rcmtocamLink.equals("GREEN") && lcmtocamLink.equals("GREEN"))){
                camChem = 10;
            }
            if(camtostLink.equals("GREEN") || lcmtocamLink.equals("GREEN")  || rcmtocamLink.equals("GREEN")){
                if(camtostLink.equals("YELLOW") || lcmtocamLink.equals("YELLOW")  || rcmtocamLink.equals("YELLOW")){
                    camChem = 10;
                }
            }
            if(camtostLink.equals("YELLOW") && lcmtocamLink.equals("YELLOW") && rcmtocamLink.equals("YELLOW")){
                camChem = 10;
            }else{
                if((camtostLink.equals("YELLOW") && lcmtocamLink.equals("YELLOW")) || (camtostLink.equals("YELLOW") && rcmtocamLink.equals("YELLOW")) || (rcmtocamLink.equals("YELLOW") && lcmtocamLink.equals("YELLOW"))){
                    camChem = 7;
                }else{
                    if(camtostLink.equals("YELLOW") || lcmtocamLink.equals("YELLOW")  || rcmtocamLink.equals("YELLOW")){
                        camChem = 3;
                    }
                }
            }

        }

        rcmChem = 0;
        if(rcmtorwLink != null && rbtorcmLink != null && rcmtocamLink != null){
            if((rcmtorwLink.equals("GREEN") && rbtorcmLink.equals("GREEN")) || (rcmtorwLink.equals("GREEN") && rcmtocamLink.equals("GREEN")) || (rcmtocamLink.equals("GREEN") && rbtorcmLink.equals("GREEN"))){
                rcmChem = 10;
            }
            if(rcmtorwLink.equals("GREEN") || rbtorcmLink.equals("GREEN")  || rcmtocamLink.equals("GREEN")){
                if(rcmtorwLink.equals("YELLOW") || rbtorcmLink.equals("YELLOW")  || rcmtocamLink.equals("YELLOW")){
                    rcmChem = 10;
                }
            }
            if(rcmtorwLink.equals("YELLOW") && rbtorcmLink.equals("YELLOW") && rcmtocamLink.equals("YELLOW")){
                rcmChem = 10;
            }else{
                if((rcmtorwLink.equals("YELLOW") && rbtorcmLink.equals("YELLOW")) || (rcmtorwLink.equals("YELLOW") && rcmtocamLink.equals("YELLOW")) || (rcmtocamLink.equals("YELLOW") && rbtorcmLink.equals("YELLOW"))){
                    rcmChem = 7;
                }else{
                    if(rcmtorwLink.equals("YELLOW") || rbtorcmLink.equals("YELLOW")  || rcmtocamLink.equals("YELLOW")){
                        rcmChem = 3;
                    }
                }
            }

        }

        lbChem = 0;
        if(lbtolcmLink != null && lcbtolbLink != null){
            if(lbtolcmLink.equals("GREEN") || lcbtolbLink.equals("GREEN")){
                lbChem = 10;
            }else{
                if(lbtolcmLink.equals("YELLOW") && lcbtolbLink.equals("YELLOW")){
                    lbChem = 10;
                }else{
                    if(lbtolcmLink.equals("YELLOW") || lcbtolbLink.equals("YELLOW")){
                        lbChem = 7;
                    }else{
                        lbChem = 3;
                    }
                }
            }
        }

        lcbChem = 0;
        if(lcbtolbLink != null && lcbtorcbLink != null && gktolcbLink != null){
            if((lcbtolbLink.equals("GREEN") && lcbtorcbLink.equals("GREEN")) || (lcbtolbLink.equals("GREEN") && gktolcbLink.equals("GREEN")) || (gktolcbLink.equals("GREEN") && lcbtorcbLink.equals("GREEN"))){
                lcbChem = 10;
            }
            if(lcbtolbLink.equals("GREEN") || lcbtorcbLink.equals("GREEN")  || gktolcbLink.equals("GREEN")){
                if(lcbtolbLink.equals("YELLOW") || lcbtorcbLink.equals("YELLOW")  || gktolcbLink.equals("YELLOW")){
                    lcbChem = 10;
                }
            }
            if(lcbtolbLink.equals("YELLOW") && lcbtorcbLink.equals("YELLOW") && gktolcbLink.equals("YELLOW")){
                lcbChem = 10;
            }else{
                if((lcbtolbLink.equals("YELLOW") && lcbtorcbLink.equals("YELLOW")) || (lcbtolbLink.equals("YELLOW") && gktolcbLink.equals("YELLOW")) || (gktolcbLink.equals("YELLOW") && lcbtorcbLink.equals("YELLOW"))){
                    lcbChem = 7;
                }else{
                    if(lcbtolbLink.equals("YELLOW") || lcbtorcbLink.equals("YELLOW")  || gktolcbLink.equals("YELLOW")){
                        lcbChem = 3;
                    }
                }
            }

        }

        rcbChem = 0;
        if(rcbtorbLink != null && lcbtorcbLink != null && gktorcbLink != null){
            if((rcbtorbLink.equals("GREEN") && lcbtorcbLink.equals("GREEN")) || (rcbtorbLink.equals("GREEN") && gktorcbLink.equals("GREEN")) || (gktorcbLink.equals("GREEN") && lcbtorcbLink.equals("GREEN"))){
                rcbChem = 10;
            }
            if(rcbtorbLink.equals("GREEN") || lcbtorcbLink.equals("GREEN")  || gktorcbLink.equals("GREEN")){
                if(rcbtorbLink.equals("YELLOW") || lcbtorcbLink.equals("YELLOW")  || gktorcbLink.equals("YELLOW")){
                    rcbChem = 10;
                }
            }
            if(rcbtorbLink.equals("YELLOW") && lcbtorcbLink.equals("YELLOW") && gktorcbLink.equals("YELLOW")){
                rcbChem = 10;
            }else{
                if((rcbtorbLink.equals("YELLOW") && lcbtorcbLink.equals("YELLOW")) || (rcbtorbLink.equals("YELLOW") && gktorcbLink.equals("YELLOW")) || (gktorcbLink.equals("YELLOW") && lcbtorcbLink.equals("YELLOW"))){
                    rcbChem = 7;
                }else{
                    if(rcbtorbLink.equals("YELLOW") || lcbtorcbLink.equals("YELLOW")  || gktorcbLink.equals("YELLOW")){
                        rcbChem = 3;
                    }
                }
            }

        }

        rbChem = 0;
        if(rbtorcmLink != null && rcbtorbLink != null){
            if(rbtorcmLink.equals("GREEN") || rcbtorbLink.equals("GREEN")){
                rbChem = 10;
            }else{
                if(rbtorcmLink.equals("YELLOW") && rcbtorbLink.equals("YELLOW")){
                    rbChem = 10;
                }else{
                    if(rbtorcmLink.equals("YELLOW") || rcbtorbLink.equals("YELLOW")){
                        rbChem = 7;
                    }else{
                        rbChem = 3;
                    }
                }
            }
        }

        gkChem = 0;
        if(gktolcbLink != null && gktorcbLink != null){
            if(gktolcbLink.equals("GREEN") || gktorcbLink.equals("GREEN")){
                gkChem = 10;
            }else{
                if(gktolcbLink.equals("YELLOW") && gktorcbLink.equals("YELLOW")){
                    gkChem = 10;
                }else{
                    if(gktolcbLink.equals("YELLOW") || gktorcbLink.equals("YELLOW")){
                        gkChem = 7;
                    }else{
                        gkChem = 3;
                    }
                }
            }
        }

        totalChem = stChem+lwChem+rwChem+lcmChem+camChem+rcmChem+lbChem+lcbChem+rcbChem+rbChem+gkChem;
        if(totalChem >= 100){
            stringChem = "100";
        }else{
            stringChem = Integer.toString(totalChem);
        }
        chemValue.setText(stringChem);
    }

    public void setUpRating(){


        /////////////////              SET UP RATING                 ////////////////////////////

        totalRating = (gkRating + rbRating + rcbRating + lcbRating + lbRating + rcmRating + camRating + lcmRating + rwRating + stRating + lwRating)/11;
        stringRating = Integer.toString(totalRating);
        ratingValue.setText(stringRating);
    }
}