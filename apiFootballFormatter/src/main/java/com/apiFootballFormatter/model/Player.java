package com.apiFootballFormatter.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String fullname;
    @Column
    private String position;
    @Column
    private Date birthdate;
    @Column
    private String playerImg;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Team> teams;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "countryID")
    private Country country;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Player() {

    }
    public Player(String fullname, String position, Date birthdate, String playerImg) {
        this.fullname = fullname;
        this.position = position;
        this.birthdate = birthdate;
        this.playerImg = playerImg;
        this.teams = new ArrayList<>();
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public void setBirthdate(Date birth_date) {
        this.birthdate = birth_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlayerImg() {
        return playerImg;
    }

    public void setPlayerImg(String playerImg) {
        this.playerImg = playerImg;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
