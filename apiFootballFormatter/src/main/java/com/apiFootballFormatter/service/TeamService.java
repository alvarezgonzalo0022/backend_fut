package com.apiFootballFormatter.service;

import com.apiFootballFormatter.model.Player;
import com.apiFootballFormatter.model.Team;
import com.apiFootballFormatter.model.dto.TeamDto;
import com.apiFootballFormatter.repository.PlayerRepository;
import com.apiFootballFormatter.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private PlayerRepository playerRepository;

    public List<TeamDto> listAll() {
        List<Team> allTeams = teamRepository.findAll();
        List<TeamDto> allTeamsDto = new ArrayList<>();

        for (Team team : allTeams) {
            TeamDto teamDto = new TeamDto();
            teamDto.setName(team.getName());
            teamDto.setLogo(team.getLogo());
            List<String> players = new ArrayList<>();
            for (Player player : team.getPlayers()) {
                players.add(player.getFullname());
            }
            teamDto.setPlayers(players);
            allTeamsDto.add(teamDto);
        }

        return allTeamsDto;
    }

    public Team save(Team team){
        Optional<Team> teamOptional = teamRepository.findByName(team.getName());
        if (teamOptional.isPresent()) {
            return teamOptional.get();
        }else {
            if (team.getPlayers() != null) {
                for (Player player : team.getPlayers()) {
                    if (playerRepository.findByFullnameAndBirthdate(player.getFullname(), player.getBirthdate()).isEmpty()) {
                        playerRepository.save(player);
                    }
                }
            }
            return teamRepository.save(team);
        }
    }

    public List<Team> saveAll(List<Team> teams){
        for (Team team : teams) {
            save(team);
        }
        return teams;
    }

    public Team getById(Long id) {
        return teamRepository.findById(id).get();
    }

    public void delete(Long id) {
        teamRepository.deleteById(id);
    }

    public List<Player> getPlayers(Long id) {
        return teamRepository.findById(id).get().getPlayers();
    }

    public void deleteAll() {
        teamRepository.deleteAll();
    }
}
