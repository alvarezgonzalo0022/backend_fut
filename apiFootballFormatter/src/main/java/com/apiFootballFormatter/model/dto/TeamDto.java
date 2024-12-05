package com.apiFootballFormatter.model.dto;

import java.util.List;

public class TeamDto {

    private String name;
    private String logo;
    private List<String> players;

    public TeamDto() {

    }
    public TeamDto(String name, String logo) {
        this.name = name;
        this.logo = logo;
        this.players = players;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<String> getPlayers() {
        return players;
    }

    public void setPlayers(List<String> players) {
        this.players = players;
    }
}
