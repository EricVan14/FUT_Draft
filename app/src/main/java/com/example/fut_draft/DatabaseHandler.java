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
        this.addPlayer("adli", "MID", "Milan", "France", "SERIE A", "Yacine Adli");
        this.addPlayer("aebischer", "MID", "Bologna", "Switzerland", "SERIE A", "Michel Aebischer");
        this.addPlayer("aguerd", "CB", "West Ham", "Morocco", "Premier League", "Naif Aguerd");
        this.addPlayer("ajer", "CB", "Brentford", "Norway", "Premier League", "kristoffer Ajer");
        this.addPlayer("ake", "CB", "Manchester City", "Netherlands", "Premier League", "Nathan Ake");
        this.addPlayer("akpa_akpro", "MID", "Lazio", "Ivory Coast", "SERIE A", "Jean-Daniel Akpa Akpro");
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
        this.addPlayer("bailey", "RW", "Aston Villa", "Jamaica", "Premier League", "Leon Bailey");
        this.addPlayer("bailly", "CB", "Manchester United", "Ivory Coast", "Premier League", "Eric Bailly");
        this.addPlayer("bakayoko", "MID", "Milan", "France", "SERIE A", "Tiemoue Bakayoko");
        this.addPlayer("bamford", "ST", "Leeds United", "England", "Premier League", "Patrick Bamford");
        this.addPlayer("barak", "MID", "Hellas Verona", "Czech Republic", "SERIE A", "Antonin Barak");
        this.addPlayer("barella", "MID", "Inter Milan", "Italy", "SERIE A", "Nicolo Barella");
        this.addPlayer("barkley", "MID", "Chelsea", "England", "Premier League", "Ross Barkley");
        this.addPlayer("barnes", "LW", "Leicester City", "England", "Premier League", "Harvey Barnes");
        this.addPlayer("barrow", "MID", "Bologna", "Gambia", "SERIE A", "Musa Barrow");
        this.addPlayer("bastoni", "CB", "Inter Milan", "Italy", "SERIE A", "Alessandro Bastoni");
        this.addPlayer("batshuayi", "ST", "Chelsea", "Belgium", "Premier League", "Michy Batshuayi");
        this.addPlayer("bednarek", "CB", "Southampton", "Poland", "Premier League", "Jan Bednarek");
        this.addPlayer("begovic", "GK", "Everton", "Bosnia and Herzegovina", "Premier League", "Asmir Begovic");
        this.addPlayer("ben_davies", "LB", "Tottenham", "Wales", "Premier League", "Ben Davies");
        this.addPlayer("bennacer", "MID", "Milan", "Algeria", "SERIE A", "Ismael Bennacer");
        this.addPlayer("benrahma", "MID", "West Ham", "Algeria", "Premier League", "Said Benrahma");
        this.addPlayer("bentancur", "MID", "Tottenham", "Uruguay", "Premier League", "Rodrigo Bentancur");
        this.addPlayer("benteke", "ST", "Crystal Palace", "Belgium", "Premier League", "Christian Benteke");
        this.addPlayer("berardi", "RW", "Sassuolo", "Italy", "SERIE A", "Domenico Berardi");
        this.addPlayer("berisha", "GK", "Torino", "Albania", "SERIE A", "Etrit Berisha");
        this.addPlayer("bernardo_silva", "MID", "Manchester City", "Portugal", "Premier League", "Bernardo Silva");
        this.addPlayer("bertrand", "LB", "Leicester City", "England", "Premier League", "Ryan Bertrand");
        this.addPlayer("biraghi", "LB", "Fiorentina", "Italy", "SERIE A", "Cristiano Biraghi");
        this.addPlayer("bissouma", "MID", "Tottenham", "Mali", "Premier League", "Yves Bissouma");
        this.addPlayer("boga", "LW", "Atalanta", "Ivory Coast", "SERIE A", "Jeremie Boga");
        this.addPlayer("boly", "CB", "Wolverhampton Wanderers", "Ivory Coast", "Premier League", "Willy Boly");
        this.addPlayer("bonaventura", "MID", "Fiorentina", "Italy", "SERIE A", "Giacomo Bonaventura");
        this.addPlayer("bonucci", "CB", "Juventus", "Italy", "SERIE A", "Leonardo Bonucci");
        this.addPlayer("botman", "CB", "Newcastle", "Netherlands", "Premier League", "Sven Botman");
        this.addPlayer("bowen", "RW", "West Ham", "England", "Premier League", "Jarrod Bowen");
        this.addPlayer("bradaric", "LB", "Salernitana", "Croatia", "SERIE A", "Domagoj Bradaric");
        this.addPlayer("bremer", "CB", "Juventus", "Brazil", "SERIE A", "Gleison Bremer");
        this.addPlayer("bronn", "CB", "Salernitana", "Tunisia", "SERIE A", "Dylan Bronn");
        this.addPlayer("brooks", "RW", "Bournemouth", "Wales", "Premier League", "David Brooks");
        this.addPlayer("brozovic", "MID", "Inter Milan", "Croatia", "SERIE A", "Marcelo Brozovic");
        this.addPlayer("bruno_fernandes", "MID", "Manchester United", "Portugal", "Premier League", "Bruno Fernandes");
        this.addPlayer("bruno_guimaraes", "MID", "Newcastle", "Brazil", "Premier League", "Bruno Guimaraes");
        this.addPlayer("bryan_gil", "LW", "Tottenham", "Spain", "Premier League", "Bryan Gil");
        this.addPlayer("buendia", "RW", "Aston Villa", "Argentina", "Premier League", "Emiliano Buendia");
        this.addPlayer("burn", "CB", "Newcastle", "England", "Premier League", "Daniel Burn");
        this.addPlayer("cairney", "MID", "Fulham", "Scotland", "Premier League", "Tom Cairney");
        this.addPlayer("calabria", "RB", "Milan", "Italy", "SERIE A", "Davide Calabria");
        this.addPlayer("caldara", "CB", "Spezia", "Italy", "SERIE A", "Mattia Caldara");
        this.addPlayer("calhanoglu", "MID", "Inter Milan", "Turkey", "SERIE A", "Hakan Calhanoglu");
        this.addPlayer("callum_wilson", "ST", "Newcastle", "England", "Premier League", "Callum Wilson");
        this.addPlayer("calvert_lewin", "ST", "Everton", "England", "Premier League", "Dominic Calvert-Lewin");
        this.addPlayer("candreva", "RW", "Salernitana", "Italy", "SERIE A", "Antonio Candreva");
        this.addPlayer("caprari", "ST", "Monza", "Italy", "SERIE A", "Gianluca Caprari");
        this.addPlayer("caputo", "ST", "Sampdoria", "Italy", "SERIE A", "Francesco Caputo");
        this.addPlayer("cash", "RB", "Aston Villa", "England", "Premier League", "Matty cash");
        this.addPlayer("castagne", "RB", "Leicester City", "Belgium", "Premier League", "Timothy Castagne");
        this.addPlayer("castrovilli", "MID", "Fiorentina", "Italy", "SERIE A", "Gaetano Castrovilli");
        this.addPlayer("cedric", "RB", "Arsenal", "Portugal", "Premier League", "Cedric Soares");
        this.addPlayer("celik", "RB", "Roma", "Turkey", "SERIE A", "Mehmet Zeki Celik");
        this.addPlayer("chambers", "RB", "Aston Villa", "England", "Premier League", "Callum Chambers");
        this.addPlayer("che_adams", "ST", "Southampton", "Scotland", "Premier League", "Che Adams");
        this.addPlayer("chiesa", "RW", "Juventus", "Italy", "SERIE A", "Federico Chiesa");
        this.addPlayer("chilwell", "LB", "Chelsea", "England", "Premier League", "Ben Chilwell");
        this.addPlayer("clyne", "RB", "Crystal Palace", "England", "Premier League", "Nathaniel Clyne");
        this.addPlayer("coady", "CB", "Wolverhampton Wanderers", "England", "Premier League", "Conor Coady");
        this.addPlayer("coleman", "RB", "Everton", "Ireland", "Premier League", "Seamus Coleman");
        this.addPlayer("consigli", "GK", "Sassuolo", "Italy", "SERIE A", "Andrea Consigli");
        this.addPlayer("conti", "RB", "Sampdoria", "Italy", "SERIE A", "Andrea Conti");
        this.addPlayer("cook", "MID", "Bournemouth", "England", "Premier League", "Lewis Cook");
        this.addPlayer("cooper", "CB", "Leeds United", "Scotland", "Premier League", "Liam Cooper");
        this.addPlayer("correa", "ST", "Inter Milan", "Argentina", "SERIE A", "Joaquin Correa");
        this.addPlayer("coufal", "RB", "West Ham", "Czech Republic", "Premier League", "Vladimir Coufal");
        this.addPlayer("coutinho", "MID", "Aston Villa", "Brazil", "Premier League", "Philippe Coutinho");
        this.addPlayer("cragno", "GK", "Monza", "Italy", "SERIE A", "Alessio Cragno");
        this.addPlayer("cresswell", "LB", "West Ham", "England", "Premier League", "Aaron Cresswell");
        this.addPlayer("cristante", "MID", "Roma", "Italy", "SERIE A", "Bryan Cristante");
        this.addPlayer("cristiano_ronaldo", "ST", "Manchester United", "Portugal", "Premier League", "Cristiano Ronaldo");
        this.addPlayer("cuadrado", "RB", "Juventus", "Columbia", "SERIE A", "Juan Cuadrado");
        this.addPlayer("cucurella", "LW", "Brighton", "Spain", "Premier League", "Marc Cucurella");
        this.addPlayer("d_ambrosio", "CB", "Inter Milan", "Italy", "SERIE A", "Danilo D'Ambrosio");
        this.addPlayer("daka", "ST", "Leicester City", "Zambia", "Premier League", "Patson Daka");
        this.addPlayer("dallas", "LB", "Leeds United", "Northern Ireland", "Premier League", "Stuart Dallas");
        this.addPlayer("daniel_james", "RW", "Leeds United", "Wales", "Premier League", "Daniel James");
        this.addPlayer("daniel_podence", "LW", "Wolverhampton Wanderers", "Portugal", "Premier League", "Daniel Podence");
        this.addPlayer("danilo", "RB", "Juventus", "Brazil", "SERIE A", "Danilo");
        this.addPlayer("darlow", "GK", "Newcastle", "England", "Premier League", "Karl Darlow");
        this.addPlayer("darmian", "RB", "Inter Milan", "Italy", "SERIE A", "Matteo Darmian");
        this.addPlayer("dawidowicz", "CB", "Hellas Verona", "Poland", "SERIE A", "Pawel Dwidowicz");
        this.addPlayer("dawson", "CB", "West Ham", "England", "Premier League", "Craig Dawson");
        this.addPlayer("de_bruyne", "MID", "Manchester City", "Belgium", "Premier League", "Kevin De Bruyne");
        this.addPlayer("de_gea", "GK", "Manchester United", "Spain", "Premier League", "David De Gea");
        this.addPlayer("de_ketelaere", "LW", "Milan", "Belgium", "SERIE A", "Charles De Ketelaere");
        this.addPlayer("de_roon", "MID", "Atalanta", "Netherlands", "SERIE A", "Marten De Roon");
        this.addPlayer("de_sciglio", "RB", "Juventus", "Italy", "SERIE A", "Mattia De Sciglio");
        this.addPlayer("de_silvestri", "RB", "Bologna", "Italy", "SERIE A", "Lorenzo De Silvestri");
        this.addPlayer("de_vrij", "CB", "Inter Milan", "Netherlands", "SERIE A", "Stefan De Vrij");
        this.addPlayer("dean_henderson", "GK", "Nottingham Forrest", "England", "Premier League", "Dean Henderson");
        this.addPlayer("defrel", "MID", "Sassuolo", "France", "SERIE A", "Gregoire Defrel");
        this.addPlayer("demiral", "CB", "Atalanta", "Turkey", "SERIE A", "Merih Demiral");
        this.addPlayer("demme", "MID", "Napoli", "Germany", "SERIE A", "Diego Demme");
        this.addPlayer("dendoncker", "MID", "Wolverhampton Wanderers", "Belgium", "Premier League", "Leander Dendoncker");
        this.addPlayer("deulofeu", "LW", "Udinese", "Spain", "SERIE A", "Gerard Deulofeu");





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
        ArrayList<String> alreadyShowing = new ArrayList<>();
        String foundPlayer = null;

        ////////////////          First Player is selected        ////////////////////////

        while(foundPlayer == null) {
            first = this.getRandomNumber(0,50);
            Cursor cursor = db.rawQuery(query, null);
            if(cursor.moveToPosition(first)){
                foundPlayer = cursor.getString(0);
                if(alreadyPicked.contains(foundPlayer)){
                    foundPlayer = null;
                }
                if(alreadyShowing.contains(foundPlayer)){
                    foundPlayer = null;
                }
            }
            cursor.close();
        }
        drawableNamesArrayList.add(foundPlayer);
        alreadyShowing.add(foundPlayer);
        foundPlayer = null;


        ////////////////          Second Player is selected        ////////////////////////

        while(foundPlayer == null) {
            second = this.getRandomNumber(0,50);
            Cursor cursor = db.rawQuery(query, null);
            if(cursor.moveToPosition(second)){
                foundPlayer = cursor.getString(0);
                if(alreadyPicked.contains(foundPlayer)){
                    foundPlayer = null;
                }
                if(alreadyShowing.contains(foundPlayer)){
                    foundPlayer = null;
                }
            }
            cursor.close();
        }
        drawableNamesArrayList.add(foundPlayer);
        alreadyShowing.add(foundPlayer);
        foundPlayer = null;



        ////////////////          Third Player is selected        ////////////////////////

        while(foundPlayer == null) {
            third = this.getRandomNumber(0,50);
            Cursor cursor = db.rawQuery(query, null);
            if(cursor.moveToPosition(third)){
                foundPlayer = cursor.getString(0);
                if(alreadyPicked.contains(foundPlayer)){
                    foundPlayer = null;
                }
                if(alreadyShowing.contains(foundPlayer)){
                    foundPlayer = null;
                }
            }
            cursor.close();
        }
        drawableNamesArrayList.add(foundPlayer);
        alreadyShowing.add(foundPlayer);
        foundPlayer = null;

        ////////////////          Fourth Player is selected        ////////////////////////

        while(foundPlayer == null) {
            fourth = this.getRandomNumber(0,50);
            Cursor cursor = db.rawQuery(query, null);
            if(cursor.moveToPosition(fourth)){
                foundPlayer = cursor.getString(0);
                if(alreadyPicked.contains(foundPlayer)){
                    foundPlayer = null;
                }
                if(alreadyShowing.contains(foundPlayer)){
                    foundPlayer = null;
                }
            }
            cursor.close();
        }
        drawableNamesArrayList.add(foundPlayer);
        alreadyShowing.add(foundPlayer);
        foundPlayer = null;


        ////////////////          Fifth Player is selected        ////////////////////////

        while(foundPlayer == null) {
            fifth = this.getRandomNumber(0,50);
            Cursor cursor = db.rawQuery(query, null);
            if(cursor.moveToPosition(fifth)){
                foundPlayer = cursor.getString(0);
                if(alreadyPicked.contains(foundPlayer)){
                    foundPlayer = null;
                }
                if(alreadyShowing.contains(foundPlayer)){
                    foundPlayer = null;
                }
            }
            cursor.close();
        }
        drawableNamesArrayList.add(foundPlayer);
        alreadyShowing.add(foundPlayer);

        return drawableNamesArrayList;
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public String getNameFromDrawable(String drawableName){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT " + PLAYER_COL_FULL_NAME + " FROM " + PLAYER_TABLE_NAME + " WHERE " + PLAYER_COL_DRAWABLE_NAME + " = \"" + drawableName + "\"";
        String foundPlayer = null;
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            foundPlayer = cursor.getString(0);

        }
        cursor.close();

        return foundPlayer;

    }

    public String getClubFromDrawable(String drawableName){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT " + PLAYER_COL_CLUB + " FROM " + PLAYER_TABLE_NAME + " WHERE " + PLAYER_COL_DRAWABLE_NAME + " = \"" + drawableName + "\"";
        String foundPlayer = null;
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            foundPlayer = cursor.getString(0);

        }
        cursor.close();

        return foundPlayer;

    }

    public String getLeagueFromDrawable(String drawableName){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT " + PLAYER_COL_LEAGUE + " FROM " + PLAYER_TABLE_NAME + " WHERE " + PLAYER_COL_DRAWABLE_NAME + " = \"" + drawableName + "\"";
        String foundPlayer = null;
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            foundPlayer = cursor.getString(0);

        }
        cursor.close();

        return foundPlayer;

    }

    public String getNationFromDrawable(String drawableName){
        SQLiteDatabase db = this.getReadableDatabase();
        //SELECT "drawableName" FROM "players" WHERE "position" = position
        String query = "SELECT " + PLAYER_COL_COUNTRY + " FROM " + PLAYER_TABLE_NAME + " WHERE " + PLAYER_COL_DRAWABLE_NAME + " = \"" + drawableName + "\"";
        String foundPlayer = null;
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            foundPlayer = cursor.getString(0);

        }
        cursor.close();

        return foundPlayer;

    }




}