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

    public ArrayList<String> findDrawableNamesFromPosition(String position){
        SQLiteDatabase db = this.getReadableDatabase();
        //SELECT "drawableName" FROM "players" WHERE "position" = position
        String query = "SELECT " + PLAYER_COL_DRAWABLE_NAME + " FROM " + PLAYER_TABLE_NAME + " WHERE " + PLAYER_COL_POSITION + " = \"" + position + "\"";
        ArrayList<String> drawableNamesArrayList = new ArrayList<>();
        String foundPlayer = null;

        ////////////////          First Player is selected        ////////////////////////

        while(foundPlayer == null) {
            first = this.getRandomNumber(0,100);
            Cursor cursor = db.rawQuery(query, null);
            for (int i = 0; i < first; i++) {
                if (cursor.moveToFirst()) {
                    continue;
                }
            }

            if (cursor.moveToFirst()) {
                foundPlayer = cursor.getString(0);
            }
            cursor.close();
        }
        drawableNamesArrayList.add(foundPlayer);
        foundPlayer = null;


        ////////////////          Second Player is selected        ////////////////////////

        while(foundPlayer == null) {
            second = this.getRandomNumber(0,100);
            Cursor cursor = db.rawQuery(query, null);
            for (int i = 0; i < second; i++) {
                if (cursor.moveToFirst()) {
                    continue;
                }
            }

            if (cursor.moveToFirst() && second != first) {
                foundPlayer = cursor.getString(0);
            }
            cursor.close();
        }
        drawableNamesArrayList.add(foundPlayer);
        foundPlayer = null;



        ////////////////          Third Player is selected        ////////////////////////

        while(foundPlayer == null) {
            third = this.getRandomNumber(0,100);
            Cursor cursor = db.rawQuery(query, null);
            for (int i = 0; i < third; i++) {
                if (cursor.moveToFirst()) {
                    cursor.moveToNext();
                }
            }

            if (cursor.moveToFirst() && (second != third)  && (first != third)) {
                foundPlayer = cursor.getString(0);
            }
            cursor.close();
        }
        drawableNamesArrayList.add(foundPlayer);
        foundPlayer = null;

        ////////////////          Fourth Player is selected        ////////////////////////

        while(foundPlayer == null) {
            fourth = this.getRandomNumber(0,100);
            Cursor cursor = db.rawQuery(query, null);
            for (int i = 0; i < fourth; i++) {
                if (cursor.moveToFirst()) {
                    cursor.moveToNext();
                }
            }

            if (cursor.moveToFirst() && (second != fourth)  && (first != fourth) && (third != fourth)) {
                foundPlayer = cursor.getString(0);
            }
            cursor.close();
        }
        drawableNamesArrayList.add(foundPlayer);
        foundPlayer = null;


        ////////////////          Fifth Player is selected        ////////////////////////

        while(foundPlayer == null) {
            fifth = this.getRandomNumber(0,100);
            Cursor cursor = db.rawQuery(query, null);
            for (int i = 0; i < fifth; i++) {
                if (cursor.moveToFirst()) {
                    cursor.moveToNext();
                }
            }

            if (cursor.moveToFirst() && (second != fifth)  && (first != fifth) && (third != fifth) && (fourth != fifth)) {
                foundPlayer = cursor.getString(0);
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