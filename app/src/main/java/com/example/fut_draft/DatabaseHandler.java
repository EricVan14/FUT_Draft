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
    public static final String PLAYER_COL_RATING = "rating"; //First column name (drawable names)

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
        super(context, "players.db", null, 13);
    }

    public DatabaseHandler(Context context, String name, int version) {
        super(context, name, null, version);
    }

    @Override //"CREATE TABLE" Creates a table automatically when constructor is called
    public void onCreate(SQLiteDatabase db) {
        //Users table
        String createPlayers = "CREATE TABLE " + PLAYER_TABLE_NAME
                + "("
                + PLAYER_PRIMARY_KEY + " INTEGER " + "PRIMARY KEY,"
                + PLAYER_COL_RATING + " STRING, "
                + PLAYER_COL_DRAWABLE_NAME + " STRING, "
                + PLAYER_COL_POSITION + " STRING, "
                + PLAYER_COL_CLUB + " STRING,"
                + PLAYER_COL_COUNTRY + " STRING,"
                + PLAYER_COL_LEAGUE + " STRING,"
                + PLAYER_COL_FULL_NAME + " STRING"
                + ")";


        db.execSQL(createPlayers);

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

    public void addPlayer(String rating, String drawableName, String position, String club, String country, String league, String fullName){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PLAYER_COL_RATING, rating);
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
        this.addPlayer("79","abdoulaye_doucoure", "MID", "Everton", "France", "Premier League", "Abdoulaye Doucoure");
        this.addPlayer("78","abraham", "ST", "Roma", "England", "SERIE A", "Tammy Abraham");
        this.addPlayer("83","acerbi", "CB", "Lazio", "Italy", "SERIE A", "Francesco Acerbi");
        this.addPlayer("76","adam_armstrong", "ST", "Southampton", "England", "Premier League", "Adam Armstrong");
        this.addPlayer("78","adama_traore", "RW", "Wolverhampton Wanderers", "Spain", "Premier League", "Adama Traore");
        this.addPlayer("77","adams", "MID", "Leeds United", "USA", "Premier League", "Tyler Adams");
        this.addPlayer("75","adli", "MID", "Milan", "France", "SERIE A", "Yacine Adli");
        this.addPlayer("75","aebischer", "MID", "Bologna", "Switzerland", "SERIE A", "Michel Aebischer");
        this.addPlayer("76","aguerd", "CB", "West Ham", "Morocco", "Premier League", "Naif Aguerd");
        this.addPlayer("75","ajer", "CB", "Brentford", "Norway", "Premier League", "kristoffer Ajer");
        this.addPlayer("78","ake", "CB", "Manchester City", "Netherlands", "Premier League", "Nathan Ake");
        this.addPlayer("75","akpa_akpro", "MID", "Lazio", "Ivory Coast", "SERIE A", "Jean-Daniel Akpa Akpro");
        this.addPlayer("76","albrighton", "RW", "Leicester City", "England", "Premier League", "Marc Albrighton");
        this.addPlayer("83","alex_sandro", "LB", "Juventus", "Brazil", "SERIE A", "Alex Sandro");
        this.addPlayer("82","alex_telles", "LB", "Manchester United", "Brazil", "Premier League", "Alex Telles");
        this.addPlayer("87","alexander_arnold", "RB", "Liverpool", "England", "Premier League", "Trent Alexander-Arnold");
        this.addPlayer("89","alisson", "GK", "Liverpool", "Brazil", "Premier League", "Alisson Becker");
        this.addPlayer("83","allan", "MID", "Everton", "Brazil", "Premier League", "Allan");
        this.addPlayer("80","alli", "MID", "Everton", "England", "Premier League", "Dele Alli");
        this.addPlayer("77","almiron", "MID", "Newcastle", "Paraguay", "Premier League", "Miguel Almiron");
        this.addPlayer("75","alvarez", "ST", "Manchester City", "Argentina", "Premier League", "Julian Alvarez");
        this.addPlayer("76","amrabat", "MID", "Fiorentina", "Morocco", "SERIE A", "Sofyan Amrabat");
        this.addPlayer("77","andersen", "CB", "Crystal Palace", "Denmark", "Premier League", "Joachim Andersen");
        this.addPlayer("77","andre_gomes", "MID", "Everton", "Portugal", "Premier League", "Andre Gomes");
        this.addPlayer("79","antonio", "ST", "West Ham", "Jamaica", "Premier League", "Michail Antonio");
        this.addPlayer("82","areola", "GK", "West Ham", "France", "Premier League", "Alphonse Areola");
        this.addPlayer("77","armstrong", "RW", "Southampton", "Scotland", "Premier League", "Stuart Armstrong");
        this.addPlayer("81","arnautovic", "ST", "Bologna", "Austria", "SERIE A", "Marko Arnautovic");
        this.addPlayer("83","arthur", "MID", "Juventus", "Brazil", "SERIE A", "Arthur");
        this.addPlayer("76","arthur_cabral", "ST", "Fiorentina", "Brazil", "SERIE A", "Arthur Cabral");
        this.addPlayer("78","audero", "GK", "Sampdoria", "Italy", "SERIE A", "Emil Audero");
        this.addPlayer("76","augustinsson", "LB", "Aston Villa", "Sweden", "Premier League", "Ludwig Augustinsson");
        this.addPlayer("75","ayew", "ST", "Crystal Palace", "Ghana", "Premier League", "Jordan Ayew");
        this.addPlayer("75","ayhan", "CB", "Sassuolo", "Turkey", "SERIE A", "Kaan Ayhan");
        this.addPlayer("76","ayling", "RB", "Leeds United", "England", "Premier League", "Luke Ayling");
        this.addPlayer("78","ayoze_perez", "RW", "Leicester City", "Spain", "Premier League", "Ayoze Perez");
        this.addPlayer("83","azpilicueta", "CB", "Chelsea", "Spain", "Premier League", "Cesar Azpilicueta");
        this.addPlayer("82","bailey", "RW", "Aston Villa", "Jamaica", "Premier League", "Leon Bailey");
        this.addPlayer("79","bailly", "CB", "Manchester United", "Ivory Coast", "Premier League", "Eric Bailly");
        this.addPlayer("79","bakayoko", "MID", "Milan", "France", "SERIE A", "Tiemoue Bakayoko");
        this.addPlayer("78","bamford", "ST", "Leeds United", "England", "Premier League", "Patrick Bamford");
        this.addPlayer("78","barak", "MID", "Hellas Verona", "Czech Republic", "SERIE A", "Antonin Barak");
        this.addPlayer("84","barella", "MID", "Inter Milan", "Italy", "SERIE A", "Nicolo Barella");
        this.addPlayer("78","barkley", "MID", "Chelsea", "England", "Premier League", "Ross Barkley");
        this.addPlayer("81","barnes", "LW", "Leicester City", "England", "Premier League", "Harvey Barnes");
        this.addPlayer("76","barrow", "MID", "Bologna", "Gambia", "SERIE A", "Musa Barrow");
        this.addPlayer("80","bastoni", "CB", "Inter Milan", "Italy", "SERIE A", "Alessandro Bastoni");
        this.addPlayer("76","batshuayi", "ST", "Chelsea", "Belgium", "Premier League", "Michy Batshuayi");
        this.addPlayer("76","bednarek", "CB", "Southampton", "Poland", "Premier League", "Jan Bednarek");
        this.addPlayer("76","begovic", "GK", "Everton", "Bosnia and Herzegovina", "Premier League", "Asmir Begovic");
        this.addPlayer("79","ben_davies", "LB", "Tottenham", "Wales", "Premier League", "Ben Davies");
        this.addPlayer("80","bennacer", "MID", "Milan", "Algeria", "SERIE A", "Ismael Bennacer");
        this.addPlayer("77","benrahma", "MID", "West Ham", "Algeria", "Premier League", "Said Benrahma");
        this.addPlayer("78","bentancur", "MID", "Tottenham", "Uruguay", "Premier League", "Rodrigo Bentancur");
        this.addPlayer("75","benteke", "ST", "Crystal Palace", "Belgium", "Premier League", "Christian Benteke");
        this.addPlayer("82","berardi", "RW", "Sassuolo", "Italy", "SERIE A", "Domenico Berardi");
        this.addPlayer("76","berisha", "GK", "Torino", "Albania", "SERIE A", "Etrit Berisha");
        this.addPlayer("86","bernardo_silva", "MID", "Manchester City", "Portugal", "Premier League", "Bernardo Silva");
        this.addPlayer("76","bertrand", "LB", "Leicester City", "England", "Premier League", "Ryan Bertrand");
        this.addPlayer("76","biraghi", "LB", "Fiorentina", "Italy", "SERIE A", "Cristiano Biraghi");
        this.addPlayer("79","bissouma", "MID", "Tottenham", "Mali", "Premier League", "Yves Bissouma");
        this.addPlayer("77","boga", "LW", "Atalanta", "Ivory Coast", "SERIE A", "Jeremie Boga");
        this.addPlayer("79","boly", "CB", "Wolverhampton Wanderers", "Ivory Coast", "Premier League", "Willy Boly");
        this.addPlayer("78","bonaventura", "MID", "Fiorentina", "Italy", "SERIE A", "Giacomo Bonaventura");
        this.addPlayer("85","bonucci", "CB", "Juventus", "Italy", "SERIE A", "Leonardo Bonucci");
        this.addPlayer("79","botman", "CB", "Newcastle", "Netherlands", "Premier League", "Sven Botman");
        this.addPlayer("78","bowen", "RW", "West Ham", "England", "Premier League", "Jarrod Bowen");
        this.addPlayer("75","bradaric", "LB", "Salernitana", "Croatia", "SERIE A", "Domagoj Bradaric");
        this.addPlayer("76","bremer", "CB", "Juventus", "Brazil", "SERIE A", "Gleison Bremer");
        this.addPlayer("75","bronn", "CB", "Salernitana", "Tunisia", "SERIE A", "Dylan Bronn");
        this.addPlayer("76","brooks", "RW", "Bournemouth", "Wales", "Premier League", "David Brooks");
        this.addPlayer("84","brozovic", "MID", "Inter Milan", "Croatia", "SERIE A", "Marcelo Brozovic");
        this.addPlayer("88","bruno_fernandes", "MID", "Manchester United", "Portugal", "Premier League", "Bruno Fernandes");
        this.addPlayer("79","bruno_guimaraes", "MID", "Newcastle", "Brazil", "Premier League", "Bruno Guimaraes");
        this.addPlayer("76","bryan_gil", "LW", "Tottenham", "Spain", "Premier League", "Bryan Gil");
        this.addPlayer("79","buendia", "RW", "Aston Villa", "Argentina", "Premier League", "Emiliano Buendia");
        this.addPlayer("75","burn", "CB", "Newcastle", "England", "Premier League", "Daniel Burn");
        this.addPlayer("75","cairney", "MID", "Fulham", "Scotland", "Premier League", "Tom Cairney");
        this.addPlayer("78","calabria", "RB", "Milan", "Italy", "SERIE A", "Davide Calabria");
        this.addPlayer("76","caldara", "CB", "Spezia", "Italy", "SERIE A", "Mattia Caldara");
        this.addPlayer("82","calhanoglu", "MID", "Inter Milan", "Turkey", "SERIE A", "Hakan Calhanoglu");
        this.addPlayer("79","callum_wilson", "ST", "Newcastle", "England", "Premier League", "Callum Wilson");
        this.addPlayer("81","calvert_lewin", "ST", "Everton", "England", "Premier League", "Dominic Calvert-Lewin");
        this.addPlayer("79","candreva", "RW", "Salernitana", "Italy", "SERIE A", "Antonio Candreva");
        this.addPlayer("75","caprari", "ST", "Monza", "Italy", "SERIE A", "Gianluca Caprari");
        this.addPlayer("78","caputo", "ST", "Sampdoria", "Italy", "SERIE A", "Francesco Caputo");
        this.addPlayer("78","cash", "RB", "Aston Villa", "England", "Premier League", "Matty cash");
        this.addPlayer("79","castagne", "RB", "Leicester City", "Belgium", "Premier League", "Timothy Castagne");
        this.addPlayer("77","castrovilli", "MID", "Fiorentina", "Italy", "SERIE A", "Gaetano Castrovilli");
        this.addPlayer("76","cedric", "RB", "Arsenal", "Portugal", "Premier League", "Cedric Soares");
        this.addPlayer("79","celik", "RB", "Roma", "Turkey", "SERIE A", "Mehmet Zeki Celik");
        this.addPlayer("75","chambers", "RB", "Aston Villa", "England", "Premier League", "Callum Chambers");
        this.addPlayer("76","che_adams", "ST", "Southampton", "Scotland", "Premier League", "Che Adams");
        this.addPlayer("83","chiesa", "RW", "Juventus", "Italy", "SERIE A", "Federico Chiesa");
        this.addPlayer("82","chilwell", "LB", "Chelsea", "England", "Premier League", "Ben Chilwell");
        this.addPlayer("75","clyne", "RB", "Crystal Palace", "England", "Premier League", "Nathaniel Clyne");
        this.addPlayer("79","coady", "CB", "Wolverhampton Wanderers", "England", "Premier League", "Conor Coady");
        this.addPlayer("78","coleman", "RB", "Everton", "Ireland", "Premier League", "Seamus Coleman");
        this.addPlayer("81","consigli", "GK", "Sassuolo", "Italy", "SERIE A", "Andrea Consigli");
        this.addPlayer("76","conti", "RB", "Sampdoria", "Italy", "SERIE A", "Andrea Conti");
        this.addPlayer("75","cook", "MID", "Bournemouth", "England", "Premier League", "Lewis Cook");
        this.addPlayer("75","cooper", "CB", "Leeds United", "Scotland", "Premier League", "Liam Cooper");
        this.addPlayer("81","correa", "ST", "Inter Milan", "Argentina", "SERIE A", "Joaquin Correa");
        this.addPlayer("80","coufal", "RB", "West Ham", "Czech Republic", "Premier League", "Vladimir Coufal");
        this.addPlayer("82","coutinho", "MID", "Aston Villa", "Brazil", "Premier League", "Philippe Coutinho");
        this.addPlayer("81","cragno", "GK", "Monza", "Italy", "SERIE A", "Alessio Cragno");
        this.addPlayer("79","cresswell", "LB", "West Ham", "England", "Premier League", "Aaron Cresswell");
        this.addPlayer("78","cristante", "MID", "Roma", "Italy", "SERIE A", "Bryan Cristante");
        this.addPlayer("91","cristiano_ronaldo", "ST", "Manchester United", "Portugal", "Premier League", "Cristiano Ronaldo");
        this.addPlayer("83","cuadrado", "RB", "Juventus", "Columbia", "SERIE A", "Juan Cuadrado");
        this.addPlayer("81","cucurella", "LW", "Brighton", "Spain", "Premier League", "Marc Cucurella");
        this.addPlayer("79","d_ambrosio", "CB", "Inter Milan", "Italy", "SERIE A", "Danilo D'Ambrosio");
        this.addPlayer("77","daka", "ST", "Leicester City", "Zambia", "Premier League", "Patson Daka");
        this.addPlayer("75","dallas", "LB", "Leeds United", "Northern Ireland", "Premier League", "Stuart Dallas");
        this.addPlayer("77","daniel_james", "RW", "Leeds United", "Wales", "Premier League", "Daniel James");
        this.addPlayer("78","daniel_podence", "LW", "Wolverhampton Wanderers", "Portugal", "Premier League", "Daniel Podence");
        this.addPlayer("81","danilo", "RB", "Juventus", "Brazil", "SERIE A", "Danilo");
        this.addPlayer("76","darlow", "GK", "Newcastle", "England", "Premier League", "Karl Darlow");
        this.addPlayer("78","darmian", "RB", "Inter Milan", "Italy", "SERIE A", "Matteo Darmian");
        this.addPlayer("75","dawidowicz", "CB", "Hellas Verona", "Poland", "SERIE A", "Pawel Dwidowicz");
        this.addPlayer("77","dawson", "CB", "West Ham", "England", "Premier League", "Craig Dawson");
        this.addPlayer("91","de_bruyne", "MID", "Manchester City", "Belgium", "Premier League", "Kevin De Bruyne");
        this.addPlayer("84","de_gea", "GK", "Manchester United", "Spain", "Premier League", "David De Gea");
        this.addPlayer("75","de_ketelaere", "LW", "Milan", "Belgium", "SERIE A", "Charles De Ketelaere");
        this.addPlayer("82","de_roon", "MID", "Atalanta", "Netherlands", "SERIE A", "Marten De Roon");
        this.addPlayer("76","de_sciglio", "RB", "Juventus", "Italy", "SERIE A", "Mattia De Sciglio");
        this.addPlayer("76","de_silvestri", "RB", "Bologna", "Italy", "SERIE A", "Lorenzo De Silvestri");
        this.addPlayer("85","de_vrij", "CB", "Inter Milan", "Netherlands", "SERIE A", "Stefan De Vrij");
        this.addPlayer("80","dean_henderson", "GK", "Nottingham Forrest", "England", "Premier League", "Dean Henderson");
        this.addPlayer("77","defrel", "MID", "Sassuolo", "France", "SERIE A", "Gregoire Defrel");
        this.addPlayer("77","demiral", "CB", "Atalanta", "Turkey", "SERIE A", "Merih Demiral");
        this.addPlayer("80","demme", "MID", "Napoli", "Germany", "SERIE A", "Diego Demme");
        this.addPlayer("77","dendoncker", "MID", "Wolverhampton Wanderers", "Belgium", "Premier League", "Leander Dendoncker");
        this.addPlayer("79","deulofeu", "LW", "Udinese", "Spain", "SERIE A", "Gerard Deulofeu");





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

    public String getPositionFromDrawable(String drawableName){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT " + PLAYER_COL_POSITION+ " FROM " + PLAYER_TABLE_NAME + " WHERE " + PLAYER_COL_DRAWABLE_NAME + " = \"" + drawableName + "\"";
        String foundPlayer = null;
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            foundPlayer = cursor.getString(0);

        }
        cursor.close();

        return foundPlayer;

    }

    public String getRatingFromDrawable(String drawableName){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT " + PLAYER_COL_RATING + " FROM " + PLAYER_TABLE_NAME + " WHERE " + PLAYER_COL_DRAWABLE_NAME + " = \"" + drawableName + "\"";
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

    public String getLinkBetweenPlayers(String drawableName1, String drawableName2){
        String nation1 = this.getNationFromDrawable(drawableName1);
        String nation2 = this.getNationFromDrawable(drawableName2);
        String league1 = this.getLeagueFromDrawable(drawableName1);
        String league2 = this.getLeagueFromDrawable(drawableName2);
        String club1 = this.getClubFromDrawable(drawableName1);
        String club2 = this.getClubFromDrawable(drawableName2);



        if(league1.equals(league2)){
            if(nation1.equals(nation2)){
                return "GREEN";
            }
            if(club1.equals(club2)){
                return "GREEN";
            }
            return "YELLOW";
        }
        if(nation1.equals(nation2)){
            return "YELLOW";
        }
        return "RED";

    }




}