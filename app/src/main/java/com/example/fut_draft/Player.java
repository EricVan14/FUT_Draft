package com.example.fut_draft;

public class Player {

    private String name;
    private String position;
    private Integer rating;
    private String nation;
    private String league;
    private String club;
    private String drawableCardName;


    public Player(String name, String position, Integer rating, String nation, String league, String club, String drawableCardName){
        this.position = position;
        this.rating = rating;
        this.nation = nation;
        this.league = league;
        this.club = club;
        this.name = name;
        this.drawableCardName = drawableCardName;

    }

    public Boolean isPlayerOnTeam(String team){
        if(this.club.equals(team)){
            return true;
        }
        else{
            return false;
        }
    }

    public Boolean isPlayerInLeague(String league){
        if(this.league.equals(league)){
            return true;
        }
        else{
            return false;
        }
    }

    public Boolean isPlayerInNation(String nation){
        if(this.nation.equals(nation)){
            return true;
        }
        else{
            return false;
        }
    }







///////////////////////////ALL GETTERS AND SETTERS///////////////////////////////////////////
    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getDrawableCardName() {
        return drawableCardName;
    }

    public void setDrawableCardName(String drawableCardName) {
        this.drawableCardName = drawableCardName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
