package com.apiFootballFormatter.model.dto;


import java.util.Date;
import java.util.List;

public class PlayerDto {


    private String name;
    private String position;
    private Date birthdate;
    private String playerImg;
    private List<String> teams;

    private CountryDto country;

    public PlayerDto() {

    }

    public PlayerDto(String name, String position, Date birthdate, String playerImg, List<String> teams, CountryDto country) {
        this.name = name;
        this.position = position;
        this.birthdate = birthdate;
        this.playerImg = playerImg;
        this.teams = teams;
        this.country = country;
    }

    public CountryDto getCountry() {
        return country;
    }

    public void setCountry(CountryDto country) {
        this.country = country;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayerImg() {
        return playerImg;
    }

    public void setPlayerImg(String playerImg) {
        this.playerImg = playerImg;
    }

    public List<String> getTeams() {
        return teams;
    }

    public void setTeams(List<String> teams) {
        this.teams = teams;
    }
}
