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
    public static final String USER_TABLE_NAME = "users"; //Table name
    public static final String USER_PRIMARY_KEY = "usersID"; //Primary Key
    public static final String PLAYER_PRIMARY_KEY = "playersID"; //Primary Key
    public static final String PLAYER_COL_RATING = "rating"; //First column name (drawable names)
    public static final String PLAYER_COL_DRAWABLE_NAME = "drawable_name"; //First column name (drawable names)
    public static final String PLAYER_COL_POSITION = "position"; //Second column name (positions)
    public static final String PLAYER_COL_CLUB = "club"; //Third column name (club)
    public static final String PLAYER_COL_COUNTRY = "country"; //Fourth column name (country)
    public static final String PLAYER_COL_LEAGUE = "league"; //Fifth column name (league)
    public static final String PLAYER_COL_FULL_NAME = "fullName"; //sixth column name (full name)
    public static final String USER_COL_TOP_PLAYERS = "topPlayers"; //sixth column name (full name)
    public static final String USER_COL_DRAFT_RATING= "draftRating"; //sixth column name (full name)



    public Integer first;
    public Integer second;
    public Integer third;
    public Integer fourth;
    public Integer fifth;



    public DatabaseHandler(Context context) {
        super(context, "playersAndUsers.db", null, 1);
    }

    public DatabaseHandler(Context context, String name, int version) {
        super(context, name, null, version);
    }

    @Override //"CREATE TABLE" Creates a table automatically when constructor is called
    public void onCreate(SQLiteDatabase db) {

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

        String createUsers = "CREATE TABLE " + USER_TABLE_NAME + "(" + USER_PRIMARY_KEY + " INTEGER " + "PRIMARY KEY," + USER_COL_TOP_PLAYERS + " STRING, " + USER_COL_DRAFT_RATING + " INTEGER" + ")";

        db.execSQL(createPlayers);
        db.execSQL(createUsers);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String upgrade = "DROP TABLE IF EXISTS " + PLAYER_TABLE_NAME;
        db.execSQL(upgrade);
        String upgrade1 = "DROP TABLE IF EXISTS " + USER_TABLE_NAME;
        db.execSQL(upgrade1);
    }

    public void clearDatabase() {
        SQLiteDatabase db = this.getWritableDatabase();
        String clearDBQuery = "DELETE FROM "+PLAYER_TABLE_NAME;
        String clearDBQuery1 = "DELETE FROM "+USER_TABLE_NAME;
        db.execSQL(clearDBQuery);
        db.execSQL(clearDBQuery1);

    }

    public void clearUserDatabase() {
        SQLiteDatabase db = this.getWritableDatabase();
        String clearDBQuery1 = "DELETE FROM "+USER_TABLE_NAME;
        db.execSQL(clearDBQuery1);

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

    public void addSingleTopPlayer(String name, Integer rating){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USER_COL_TOP_PLAYERS, name);
        values.put(USER_COL_DRAFT_RATING, rating);
        db.insert(USER_TABLE_NAME, null, values);
    }

    public ArrayList<String> addTopPlayer(String name, Integer rating){
        ArrayList<String> topPlayers = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String one = null, two = null, three = null, four = null, five = null, six = null, seven = null, eight = null, nine = null, ten = null, placeHolderstr = null;
        Integer oneRating = 0, twoRating = 0, threeRating = 0, fourRating = 0, fiveRating = 0, sixRating = 0, sevenRating = 0, eightRating = 0, nineRating = 0, tenRating = 0, placeHolderint = 0;
        String query = "SELECT " + USER_COL_TOP_PLAYERS + " FROM " + USER_TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            one = cursor.getString(0);
        }
        if(cursor.moveToNext()){
            two = cursor.getString(0);
        }
        if(cursor.moveToNext()){
            three = cursor.getString(0);
        }
        if(cursor.moveToNext()){
            four = cursor.getString(0);
        }
        if(cursor.moveToNext()){
            five = cursor.getString(0);
        }
        if(cursor.moveToNext()){
            six = cursor.getString(0);
        }
        if(cursor.moveToNext()){
            seven = cursor.getString(0);
        }
        if(cursor.moveToNext()){
            eight = cursor.getString(0);
        }
        if(cursor.moveToNext()){
            nine = cursor.getString(0);
        }
        if(cursor.moveToNext()){
            ten = cursor.getString(0);
        }

        query = "SELECT " + USER_COL_DRAFT_RATING + " FROM " + USER_TABLE_NAME;
        cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            oneRating = cursor.getInt(0);
        }
        if(cursor.moveToNext()){
            twoRating = cursor.getInt(0);
        }
        if(cursor.moveToNext()){
            threeRating = cursor.getInt(0);
        }
        if(cursor.moveToNext()){
            fourRating = cursor.getInt(0);
        }
        if(cursor.moveToNext()){
            fiveRating = cursor.getInt(0);
        }
        if(cursor.moveToNext()){
            sixRating = cursor.getInt(0);
        }
        if(cursor.moveToNext()){
            sevenRating = cursor.getInt(0);
        }
        if(cursor.moveToNext()){
            eightRating = cursor.getInt(0);
        }
        if(cursor.moveToNext()){
            nineRating = cursor.getInt(0);
        }
        if(cursor.moveToNext()){
            tenRating = cursor.getInt(0);
        }

        if(rating > tenRating){
            tenRating = rating;
            ten = name;
        }

        if(rating > nineRating){
            tenRating = nineRating;
            ten = nine;
            nineRating = rating;
            nine = name;
        }

        if(rating > eightRating){
            nineRating = eightRating;
            nine = eight;
            eightRating = rating;
            eight = name;
        }

        if(rating > sevenRating){
            eightRating = sevenRating;
            eight = seven;
            sevenRating = rating;
            seven = name;
        }

        if(rating > sixRating){
            sevenRating = sixRating;
            seven = six;
            sixRating = rating;
            six = name;
        }

        if(rating > fiveRating){
            sixRating = fiveRating;
            six = five;
            fiveRating = rating;
            five = name;
        }

        if(rating > fourRating){
            fiveRating = fourRating;
            five = four;
            fourRating = rating;
            four = name;
        }

        if(rating > threeRating){
            fourRating = threeRating;
            four = three;
            threeRating = rating;
            three = name;
        }

        if(rating > twoRating){
            threeRating = twoRating;
            three = two;
            twoRating = rating;
            two = name;
        }

        if(rating > oneRating){
            twoRating = oneRating;
            two = one;
            oneRating = rating;
            one = name;
        }

        this.clearUserDatabase();
        addSingleTopPlayer(one, oneRating);
        addSingleTopPlayer(two, twoRating);
        addSingleTopPlayer(three, threeRating);
        addSingleTopPlayer(four, fourRating);
        addSingleTopPlayer(five, fiveRating);
        addSingleTopPlayer(six, sixRating);
        addSingleTopPlayer(seven, sevenRating);
        addSingleTopPlayer(eight, eightRating);
        addSingleTopPlayer(nine, nineRating);
        addSingleTopPlayer(ten, tenRating);
        topPlayers.add(0,one);
        topPlayers.add(1,two);
        topPlayers.add(2,three);
        topPlayers.add(3,four);
        topPlayers.add(4,five);
        topPlayers.add(5,six);
        topPlayers.add(6,seven);
        topPlayers.add(7,eight);
        topPlayers.add(8,nine);
        topPlayers.add(9,ten);
        return topPlayers;
    }


    public Integer getRatingFromName(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT " + USER_COL_DRAFT_RATING + " FROM " + USER_TABLE_NAME + " WHERE " + USER_COL_TOP_PLAYERS + " = \"" + name + "\"";
        Integer foundPlayer = null;
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            foundPlayer = cursor.getInt(0);
        }
        cursor.close();

        return foundPlayer;

    }



    public void addDefaults() {
        //Add preset players to the database
        this.addSingleTopPlayer("Position 1", 0);
        this.addSingleTopPlayer("Position 2", 0);
        this.addSingleTopPlayer("Position 3", 0);
        this.addSingleTopPlayer("Position 4", 0);
        this.addSingleTopPlayer("Position 5", 0);
        this.addSingleTopPlayer("Position 6", 0);
        this.addSingleTopPlayer("Position 7", 0);
        this.addSingleTopPlayer("Position 8", 0);
        this.addSingleTopPlayer("Position 9", 0);
        this.addSingleTopPlayer("Position 10", 0);

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
        this.addPlayer("80","di_lorenzo", "RB", "Napoli", "Italy", "SERIE A", "Giovanni Di Lorenzo");
        this.addPlayer("87","di_maria", "RW", "Juventus", "Argentina", "SERIE A", "Angel Di Maria");
        this.addPlayer("80","diaz", "LW", "Liverpool", "Columbia", "Premier League", "Luis Diaz");
        this.addPlayer("82","diego_carlos", "CB", "Aston Villa", "Brazil", "Premier League", "Diego Carlos");
        this.addPlayer("77","diego_llorente", "CB", "Leeds United", "Spain", "Premier League", "Diego Llorente");
        this.addPlayer("79","dier", "CB", "Tottenham", "England", "Premier League", "Eric Dier");
        this.addPlayer("75","difrancesco", "ST", "Lecce", "Italy", "SERIE A", "Federico Di Francesco");
        this.addPlayer("84","digne", "LB", "Aston Villa", "France", "Premier League", "Lucas Digne");
        this.addPlayer("76","dimarco", "LB", "Inter Milan", "Italy", "SERIE A", "federico Dimarco");
        this.addPlayer("76","doigo_dalot", "RB", "Manchester United", "Portugal", "Premier League", "Diogo Dalot");
        this.addPlayer("82","doigo_jota", "LW", "liverpool", "Portugal", "Premier League", "Diogo Jota");
        this.addPlayer("77","diop", "CB", "West Ham", "France", "Premier League", "Issa Diop");
        this.addPlayer("79","djimsiti", "CB", "Atalanta", "Albania", "SERIE A", "Berat Djimsiti");
        this.addPlayer("78","doherty", "RB", "Tottenham", "Ireland", "Premier League", "Matt Doherty");
        this.addPlayer("75","dominguez", "MID", "Bologna", "Argentina", "SERIE A", "Nicolas Dominguez");
        this.addPlayer("75","doucoure", "MID", "Crystal Palace", "Mali", "Premier League", "Cheick Doucoure");
        this.addPlayer("77","douglas_luiz", "MID", "Aston Villa", "Brazil", "Premier League", "Douglas Luiz");
        this.addPlayer("77","dragowski", "GK", "Spezia", "Poland", "SERIE A", "Bartlomiej Dragowski");
        this.addPlayer("81","dubravka", "GK", "Newcastle", "Slovakia", "Premier League", "Martin Dubravka");
        this.addPlayer("82","dumfries", "RB", "Inter Milan", "Netherlands", "SERIE A", "Denzel Dumfries");
        this.addPlayer("78","dunk", "CB", "Brighton", "England", "Premier League", "Lewis Dunk");
        this.addPlayer("87","dybala", "ST", "Roma", "Argentina", "SERIE A", "Paulo Dybala");
        this.addPlayer("83","dzeko", "ST", "Inter Milan", "Bosnia and Herzegovina", "SERIE A", "Edin Dzeko");
        this.addPlayer("89","ederson", "GK", "Manchester City", "Brazil", "Premier League", "Ederson Moraes");
        this.addPlayer("75","edouard", "ST", "Crystal Palace", "France", "Premier League", "Odsonne Edouard");
        this.addPlayer("83","edouard_mendy", "GK", "Chelsea", "Senegal", "Premier League", "Edouard Mendy");
        this.addPlayer("76","ekdal", "MID", "Spezia", "Sweden", "SERIE A", "Albin Ekdal");
        this.addPlayer("76","el_ghazi", "LW", "Aston Villa", "Netherlands", "Premier League", "Anwar El-Ghazi");
        this.addPlayer("79","el_shaarawy", "LW", "Roma", "Italy", "SERIE A", "Stephan El Shaarawy");
        this.addPlayer("77","eleneny", "MID", "Arsenal", "Egypt", "Premier League", "Mohamed Elneny");
        this.addPlayer("75","elyounoussi", "LW", "Southampton", "Norway", "Premier League", "Mohamed Elyounoussi");
        this.addPlayer("78","emerson", "LB", "Chelsea", "Italy", "Premier League", "Emerson");
        this.addPlayer("79","emerson_royal", "RB", "Tottenham", "Brazil", "Premier League", "Emerson Royal");
        this.addPlayer("82","eriksen", "MID", "Manchester United", "Denmark", "Premier League", "Christian Eriksen");
        this.addPlayer("80","evans", "CB", "Leicester City", "Northern Ireland", "Premier League", "Jonny Evans");
        this.addPlayer("77","eze", "LW", "Crystal Palace", "England", "Premier League", "Eberechi Eze");
        this.addPlayer("82","fabian", "MID", "Napoli", "Spain", "SERIE A", "Fabian");




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

    public String getNumberOfNations(ArrayList<String> players){
        ArrayList <String> alreadyCounted = new ArrayList<>();
        Integer numberOfNations = 0;
        String player;
        String playerNation;
        String strNumber;
        for(int i = 0; i < 11; i++){
            player = players.get(i);
            playerNation = this.getNationFromDrawable(player);
            if(!alreadyCounted.contains(playerNation)){
                alreadyCounted.add(playerNation);
                numberOfNations++;
            }
        }
        strNumber = Integer.toString(numberOfNations);
        return strNumber;

    }

    public ArrayList<String> getTopThreePlayers(ArrayList<String> players){
        ArrayList <String> topThree = new ArrayList<>();
        String player;
        Integer playerRating;
        Integer playerRating1;
        for(int i = 0; i < 11; i++){
            for(int y= i+1; y < 11; y++){
                playerRating = Integer.parseInt(getRatingFromDrawable(players.get(i)));
                playerRating1 = Integer.parseInt(getRatingFromDrawable(players.get(y)));
                if(playerRating1 > playerRating){
                    player = players.get(i);
                    players.set(i, players.get(y));
                    players.set(y, player);
                }
            }
        }
        topThree.add(players.get(0));
        topThree.add(players.get(1));
        topThree.add(players.get(2));


        return topThree;

    }

    public String getNumberOfLeagues(ArrayList<String> players){
        ArrayList <String> alreadyCounted = new ArrayList<>();
        Integer numberOfLeagues = 0;
        String player;
        String playerLeague;
        String strNumber;
        for(int i = 0; i < 11; i++){
            player = players.get(i);
            playerLeague = this.getLeagueFromDrawable(player);
            if(!alreadyCounted.contains(playerLeague)){
                alreadyCounted.add(playerLeague);
                numberOfLeagues++;
            }
        }
        strNumber = Integer.toString(numberOfLeagues);
        return strNumber;

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