package com.apiFootballFormatter.controller;

import com.apiFootballFormatter.model.Player;
import com.apiFootballFormatter.model.PlayerUnformatted;
import com.apiFootballFormatter.model.Team;
import com.apiFootballFormatter.model.dto.PlayerDto;
import com.apiFootballFormatter.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private  PlayerService playerService;

    @GetMapping("/all")
    public List<PlayerDto> getPlayers(){
        return playerService.listAll();
    }

    @PostMapping
    public Player savePlayer(@RequestBody PlayerUnformatted player){
        return playerService.save(player);
    }

    @PostMapping("/all")
    public List<PlayerDto> saveAllPlayers(@RequestBody List<PlayerUnformatted> players){
        return playerService.saveAll(players);
    }
    @GetMapping
    public List<PlayerDto> getPlayersByName(@RequestParam String name){
        return playerService.getByFullName(name);
    }
    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable Long id){
        return playerService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable Long id){
        playerService.delete(id);
    }

    @GetMapping("/{id}/teams")
    public List<Team> getTeams(@PathVariable Long id){
        return playerService.getTeams(id);
    }

    @DeleteMapping
    public void deleteAll() {
        playerService.deleteAll();
    }
}
