package com.apiFootballFormatter.controller;

import com.apiFootballFormatter.model.Player;
import com.apiFootballFormatter.model.Team;
import com.apiFootballFormatter.model.dto.TeamDto;
import com.apiFootballFormatter.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/all")
    public List<TeamDto> getTeams(){
        return teamService.listAll();
    }

    @PostMapping
    public Team saveTeam(@RequestBody Team team){
        return teamService.save(team);
    }

    @PostMapping("/all")
    public List<Team> saveAllTeams(@RequestBody List<Team> teams){
        return teamService.saveAll(teams);
    }

    @GetMapping("/{id}")
    public Team getTeam(@PathVariable Long id){
        return teamService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable Long id){
        teamService.delete(id);
    }

    @GetMapping("/{id}/players")
    public List<Player> getPlayers(Long id){
        return teamService.getPlayers(id);
    }

    @DeleteMapping
    public void deleteAll() {
        teamService.deleteAll();
    }


}
