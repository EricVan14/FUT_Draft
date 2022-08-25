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
        this.addPlayer("abdoulaye_doucoure", "MID", "Everton", "France", "Premier League", "Abdoulaye Doucoure");
        this.addPlayer("abraham", "ST", "Roma", "England", "SERIE A", "Tammy Abraham");
        this.addPlayer("acerbi", "CB", "Lazio", "Italy", "SERIE A", "Francesco Acerbi");
        this.addPlayer("adam_armstrong", "ST", "Southampton", "England", "Premier League", "Adam Armstrong");
        this.addPlayer("adama_traore", "RW", "Wolverhampton Wanderers", "Spain", "Premier League", "Adama Traore");
        this.addPlayer("adli", "MID", "Milan", "France", "SERIE_A", "Yacine Adli");
        this.addPlayer("aebischer", "MID", "Bologna", "Switzerland", "SERIE A", "Michel Aebischer");
        this.addPlayer("aguerd", "CB", "West Ham", "Morocco", "Premier League", "Naif Aguerd");
        this.addPlayer("ajer", "CB", "Brentford", "Norway", "Premier League", "kristoffer Ajer");
        this.addPlayer("ake", "CB", "Manchester City", "Netherlands", "Premier League", "Nathan Ake");
        this.addPlayer("akpa_akpro", "MID", "Lazio", "Ivory_Coast", "SERIE A", "Jean-Daniel Akpa Akpro");
        this.addPlayer("albrighton", "RW", "Leicester City", "England", "Premier League", "Marc Albrighton");
        this.addPlayer("alex_sandro", "LB", "Juventus", "Brazil", "SERIE A", "Alex Sandro");
        this.addPlayer("alex_telles", "LB", "Manchester United", "Brazil", "Premier League", "Alex Telles");
        this.addPlayer("alexander_arnold", "RB", "Liverpool", "England", "Premier League", "Trent Alexander-Arnold");
        this.addPlayer("alisson", "GK", "Liverpool", "Brazil", "Premier League", "Alisson Becker");
        this.addPlayer("allan", "MID", "Everton", "Brazil", "Premier League", "Allan");
        this.addPlayer("alli", "MID", "Everton", "England", "Premier League", "Dele Alli");
        this.addPlayer("almiron", "MID", "Newcastle", "Paraguay", "Premier League", "Miguel Almiron");
        this.addPlayer("alvarez", "ST", "Manchester City", "Argentina", "Premier League", "Julian Alvarez");
        this.addPlayer("amrabat", "MID", "Fiorentina", "Morocco", "SERIE A", "Sofyan Amrabat");
        this.addPlayer("andersen", "CB", "Crystal Palace", "Denmark", "Premier League", "Joachim Andersen");
        this.addPlayer("andre_gomes", "MID", "Everton", "Portugal", "Premier League", "Andre Gomes");
        this.addPlayer("antonio", "ST", "West Ham", "Jamaica", "Premier League", "Michail Antonio");
        this.addPlayer("areola", "GK", "West Ham", "France", "Premier League", "Alphonse Areola");
        this.addPlayer("armstrong", "RW", "Southampton", "Scotland", "Premier League", "Stuart Armstrong");
        this.addPlayer("arnautovic", "ST", "Bologna", "Austria", "SERIE A", "Marko Arnautovic");
        this.addPlayer("arthur", "MID", "Juventus", "Brazil", "SERIE A", "Arthur");
        this.addPlayer("arthur_cabral", "ST", "Fiorentina", "Brazil", "SERIE A", "Arthur Cabral");
        this.addPlayer("audero", "GK", "Sampdoria", "Italy", "SERIE A", "Emil Audero");
        this.addPlayer("augustinsson", "LB", "Aston Villa", "Sweden", "Premier League", "Ludwig Augustinsson");
        this.addPlayer("ayew", "ST", "Crystal Palace", "Ghana", "Premier League", "Jordan Ayew");
        this.addPlayer("ayhan", "CB", "Sassuolo", "Turkey", "SERIE A", "Kaan Ayhan");
        this.addPlayer("ayling", "RB", "Leeds United", "England", "Premier League", "Luke Ayling");
        this.addPlayer("ayoze_perez", "RW", "Leicester City", "Spain", "Premier League", "Ayoze Perez");
        this.addPlayer("azpilicueta", "CB", "Chelsea", "Spain", "Premier League", "Cesar Azpilicueta");


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