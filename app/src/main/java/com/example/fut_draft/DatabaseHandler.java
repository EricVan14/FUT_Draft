package com.example.fut_draft;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

//This class handles the database
public class DatabaseHandler extends SQLiteOpenHelper {

    //Initializations for players table
    public static final String PLAYER_TABLE_NAME = "players"; //Table name
    public static final String PLAYER_PRIMARY_KEY = "playersID"; //Primary Key
    public static final String PLAYER_COL_DRAWABLE_NAME = "drawable_name"; //First column name (drawable names)
    public static final String PLAYER_COL_POSITION = "position"; //Second column name (positions)
    public static final String PLAYER_COL_CLUB = "club"; //Third column name (club)
    public static final String PLAYER_COL_COUNTRY = "country"; //Fourth column name (country)
    public static final String PLAYER_COL_LEAGUE = "league"; //Fifth column name (league)
    public static final String PLAYER_COL_FULL_NAME = "fullName"; //sixth column name (full name)

    public Integer first;
    public Integer second;
    public Integer third;
    public Integer fourth;
    public Integer fifth;



    public DatabaseHandler(Context context) {
        super(context, "users.db", null, 13);
    }

    public DatabaseHandler(Context context, String name, int version) {
        super(context, name, null, version);
    }

    @Override //"CREATE TABLE" Creates a table automagically when constructor is called
    public void onCreate(SQLiteDatabase db) {
        //Users table
        String createUsers = "CREATE TABLE " + PLAYER_TABLE_NAME
                + "("
                + PLAYER_PRIMARY_KEY + " INTEGER " + "PRIMARY KEY,"

                + PLAYER_COL_DRAWABLE_NAME + " STRING, "
                + PLAYER_COL_POSITION + " STRING, "
                + PLAYER_COL_CLUB + " STRING,"
                + PLAYER_COL_COUNTRY + " STRING,"
                + PLAYER_COL_LEAGUE + " STRING,"
                + PLAYER_COL_FULL_NAME + " STRING"
                + ")";


        db.execSQL(createUsers);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String upgrade = "DROP TABLE IF EXISTS " + PLAYER_TABLE_NAME;
        db.execSQL(upgrade);
    }

    public void clearDatabase() {
        SQLiteDatabase db = this.getWritableDatabase();
        String clearDBQuery = "DELETE FROM "+PLAYER_TABLE_NAME;
        db.execSQL(clearDBQuery);
    }

    public void addPlayer(String drawableName, String position, String club, String country, String league, String fullName){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(PLAYER_COL_DRAWABLE_NAME, drawableName);
        values.put(PLAYER_COL_POSITION, position);
        values.put(PLAYER_COL_CLUB, club);
        values.put(PLAYER_COL_COUNTRY, country);
        values.put(PLAYER_COL_LEAGUE, league);
        values.put(PLAYER_COL_FULL_NAME, fullName);
        db.insert(PLAYER_TABLE_NAME, null, values);
    }

    public void addDefaults() {
        //Add preset players to the database
        this.addPlayer("abdoulaye_doucoure", "MID", "Everton", "France", "Premier_league", "Abdoulaye Doucoure");
        this.addPlayer("abraham", "ST", "Roma", "England", "SERIE_A", "Tammy Abraham");
        this.addPlayer("acerbi", "CB", "Lazio", "Italy", "SERIE_A", "Francesco Acerbi");
        this.addPlayer("adam_armstrong", "ST", "Southampton", "England", "Premier_league", "Adam Armstrong");
        this.addPlayer("adama_traore", "RW", "Wolverhampton_Wanderers", "Spain", "Premier_league", "Adama Traore");
        this.addPlayer("adli", "MID", "Milan", "France", "SERIE_A", "Yacine Adli");
        this.addPlayer("aebischer", "MID", "Bologna", "Switzerland", "SERIE_A", "Michel Aebischer");
        this.addPlayer("aguerd", "CB", "West_Ham", "Morocco", "Premier_league", "Naif Aguerd");
        this.addPlayer("ajer", "CB", "Brentford", "Norway", "Premier_league", "kristoffer Ajer");
        this.addPlayer("ake", "CB", "Manchester_City", "Netherlands", "Premier_league", "Nathan Ake");
        this.addPlayer("akpa_akpro", "MID", "Lazio", "Ivory_Coast", "SERIE_A", "Jean-Daniel Akpa Akpro");
        this.addPlayer("albrighton", "RW", "Leicester_City", "England", "Premier_league", "Marc Albrighton");
        this.addPlayer("alex_sandro", "LB", "Juventus", "Brazil", "SERIE_A", "Alex Sandro");
        this.addPlayer("alex_telles", "LB", "Manchester_United", "Brazil", "Premier_league", "Alex Telles");
        this.addPlayer("alexander_arnold", "RB", "Liverpool", "England", "Premier_league", "Trent Alexander-Arnold");
        this.addPlayer("alisson", "GK", "Liverpool", "Brazil", "Premier_league", "Alisson Becker");
        this.addPlayer("allan", "MID", "Everton", "Brazil", "Premier_league", "Allan");
        this.addPlayer("alli", "MID", "Everton", "England", "Premier_league", "Dele Alli");
        this.addPlayer("almiron", "MID", "Newcastle", "Paraguay", "Premier_league", "Miguel Almiron");
        this.addPlayer("alvarez", "ST", "Manchester_City", "Argentina", "Premier_league", "Julian Alvarez");
        this.addPlayer("amrabat", "MID", "Fiorentina", "Morocco", "SERIE_A", "Sofyan Amrabat");
        this.addPlayer("andersen", "CB", "Crystal_Palace", "Denmark", "Premier_league", "Joachim Andersen");
        this.addPlayer("andre_gomes", "MID", "Everton", "Portugal", "Premier_league", "Andre Gomes");


    }

    public Boolean isEmpty() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor mCursor = db.rawQuery("SELECT * FROM " + PLAYER_TABLE_NAME, null);
        if (mCursor.moveToFirst()){
            return true;
        }else{
            return false;
        }


    }

    public ArrayList<String> findDrawableNamesFromPosition(String position, ArrayList<String> alreadyPicked){
        SQLiteDatabase db = this.getReadableDatabase();
        //SELECT "drawableName" FROM "players" WHERE "position" = position
        String query = "SELECT " + PLAYER_COL_DRAWABLE_NAME + " FROM " + PLAYER_TABLE_NAME + " WHERE " + PLAYER_COL_POSITION + " = \"" + position + "\"";
        //String query = "SELECT " + PLAYER_COL_DRAWABLE_NAME + " FROM " + PLAYER_TABLE_NAME;
        ArrayList<String> drawableNamesArrayList = new ArrayList<>();
        String foundPlayer = null;

        ////////////////          First Player is selected        ////////////////////////

        while(foundPlayer == null) {
            first = this.getRandomNumber(0,9);
            Cursor cursor = db.rawQuery(query, null);
            if(cursor.moveToPosition(first)){
                foundPlayer = cursor.getString(0);
                if(alreadyPicked.contains(foundPlayer)){
                    foundPlayer = null;
                }
            }
            cursor.close();
        }
        drawableNamesArrayList.add(foundPlayer);
        foundPlayer = null;


        ////////////////          Second Player is selected        ////////////////////////

        while(foundPlayer == null) {
            second = this.getRandomNumber(0,9);
            Cursor cursor = db.rawQuery(query, null);
            if(cursor.moveToPosition(second)){
                foundPlayer = cursor.getString(0);
                if(alreadyPicked.contains(foundPlayer)){
                    foundPlayer = null;
                }
            }
            cursor.close();
        }
        drawableNamesArrayList.add(foundPlayer);
        foundPlayer = null;



        ////////////////          Third Player is selected        ////////////////////////

        while(foundPlayer == null) {
            third = this.getRandomNumber(0,9);
            Cursor cursor = db.rawQuery(query, null);
            if(cursor.moveToPosition(third)){
                foundPlayer = cursor.getString(0);
                if(alreadyPicked.contains(foundPlayer)){
                    foundPlayer = null;
                }
            }
            cursor.close();
        }
        drawableNamesArrayList.add(foundPlayer);
        foundPlayer = null;

        ////////////////          Fourth Player is selected        ////////////////////////

        while(foundPlayer == null) {
            fourth = this.getRandomNumber(0,9);
            Cursor cursor = db.rawQuery(query, null);
            if(cursor.moveToPosition(fourth)){
                foundPlayer = cursor.getString(0);
                if(alreadyPicked.contains(foundPlayer)){
                    foundPlayer = null;
                }
            }
            cursor.close();
        }
        drawableNamesArrayList.add(foundPlayer);
        foundPlayer = null;


        ////////////////          Fifth Player is selected        ////////////////////////

        while(foundPlayer == null) {
            fifth = this.getRandomNumber(0,9);
            Cursor cursor = db.rawQuery(query, null);
            if(cursor.moveToPosition(fifth)){
                foundPlayer = cursor.getString(0);
                if(alreadyPicked.contains(foundPlayer)){
                    foundPlayer = null;
                }
            }
            cursor.close();
        }
        drawableNamesArrayList.add(foundPlayer);

        return drawableNamesArrayList;
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }


}