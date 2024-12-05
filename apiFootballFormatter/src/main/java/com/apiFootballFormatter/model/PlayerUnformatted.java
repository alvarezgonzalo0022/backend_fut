package com.apiFootballFormatter.model;

public class PlayerUnformatted {

    private String fullName;
    private String position;
    private String birth_date;
    private String playerImg;
    private String team;
    private String nationality;

    public PlayerUnformatted() {
    }

    public PlayerUnformatted(String fullName, String position, String birth_date, String playerImg, String team, String nationality) {
        this.fullName = fullName;
        this.position = position;
        this.birth_date = birth_date;
        this.playerImg = playerImg;
        this.team = team;
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPlayerImg() {
        return playerImg;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public void setPlayerImg(String playerImg) {
        this.playerImg = playerImg;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
