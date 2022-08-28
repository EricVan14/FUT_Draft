package com.example.fut_draft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SinglePlayer extends AppCompatActivity {

    public ImageView lw, st, rw, lcm, cam, rcm, lb, lcb, rcb, rb, gk;
    public ImageView lwTost, rwTost, rcmTorw, lcmTolw, camTost, rcmTocam, lcmTocam, lbTolcm, rbTorcm, rcbTorb, lcbTolb, lcbTorcb, gkTolcb, gkTorcb;
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

        //////////////////             SETTING UP ALL LINKS           ///////////////////////////////////


        if((lwCurrentPlayerDrawableName != null) && (stCurrentPlayerDrawableName != null)){
            lwtostLink = MainActivity.db.getLinkBetweenPlayers(lwCurrentPlayerDrawableName,stCurrentPlayerDrawableName);
            if(lwtostLink.equals("RED")){
                id = c.getResources().getIdentifier("drawable/" + "red_bar", null, c.getPackageName());
                lwTost.setImageResource(id);
            }
            if(lwtostLink.equals("GREEN") || lwtostLink.equals("GREEN1") || lwtostLink.equals("GREEN2")){
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
            if(rwtostLink.equals("GREEN") || rwtostLink.equals("GREEN1") || rwtostLink.equals("GREEN2")){
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
            if(lcmtolwLink.equals("GREEN") || lcmtolwLink.equals("GREEN1") || lcmtolwLink.equals("GREEN2")){
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
            if(rcmtorwLink.equals("GREEN") || rcmtorwLink.equals("GREEN1") || rcmtorwLink.equals("GREEN2")){
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
            if(camtostLink.equals("GREEN") || camtostLink.equals("GREEN1") || camtostLink.equals("GREEN2")){
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
            if(lcmtocamLink.equals("GREEN") || lcmtocamLink.equals("GREEN1") || lcmtocamLink.equals("GREEN2")){
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
            if(rcmtocamLink.equals("GREEN") || rcmtocamLink.equals("GREEN1") || rcmtocamLink.equals("GREEN2")){
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
            if(lbtolcmLink.equals("GREEN") || lbtolcmLink.equals("GREEN1") || lbtolcmLink.equals("GREEN2")){
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
            if(rbtorcmLink.equals("GREEN") || rbtorcmLink.equals("GREEN1") || rbtorcmLink.equals("GREEN2")){
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
            if(lcbtolbLink.equals("GREEN") || lcbtolbLink.equals("GREEN1") || lcbtolbLink.equals("GREEN2")){
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
            if(lcbtorcbLink.equals("GREEN") || lcbtorcbLink.equals("GREEN1") || lcbtorcbLink.equals("GREEN2")){
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
            if(rcbtorbLink.equals("GREEN") || rcbtorbLink.equals("GREEN1") || rcbtorbLink.equals("GREEN2")){
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
            if(gktolcbLink.equals("GREEN") || gktolcbLink.equals("GREEN1") || gktolcbLink.equals("GREEN2")){
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
            if(gktorcbLink.equals("GREEN") || gktorcbLink.equals("GREEN1") || gktorcbLink.equals("GREEN2")){
                id = c.getResources().getIdentifier("drawable/" + "green_bar", null, c.getPackageName());
                gkTorcb.setImageResource(id);
            }if(gktorcbLink.equals("YELLOW")){
                id = c.getResources().getIdentifier("drawable/" + "yellow_bar", null, c.getPackageName());
                gkTorcb.setImageResource(id);
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