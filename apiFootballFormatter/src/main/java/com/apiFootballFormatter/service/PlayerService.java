package com.apiFootballFormatter.service;

import com.apiFootballFormatter.model.Country;
import com.apiFootballFormatter.model.Player;
import com.apiFootballFormatter.model.PlayerUnformatted;
import com.apiFootballFormatter.model.Team;
import com.apiFootballFormatter.model.dto.CountryDto;
import com.apiFootballFormatter.model.dto.PlayerDto;
import com.apiFootballFormatter.repository.CountryRepository;
import com.apiFootballFormatter.repository.PlayerRepository;
import com.apiFootballFormatter.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private CountryRepository countryRepository;

    public List<PlayerDto> listAll() {
        List<Player> allPlayers = playerRepository.findAll();
        List<PlayerDto> allPlayersDto = new ArrayList<>();

        for (Player player : allPlayers) {
            allPlayersDto.add(playerToPLayerDto(player));
        }

        return allPlayersDto;
    }


    public Player save(PlayerUnformatted player){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha_nac = null;
        try {
            fecha_nac = simpleDateFormat.parse(player.getBirth_date());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Optional<Player> playerOptional = playerRepository.findByFullnameAndBirthdate(player.getFullName(), fecha_nac);
        Optional<Team> teamInBD = teamRepository.findByName(player.getTeam());
        Optional<Country> countryInBD = countryRepository.findByname(player.getNationality());

        if (teamInBD.isPresent()) {

            if (playerOptional.isPresent()) {
                if (!playerOptional.get().getTeams().contains(teamInBD.get())) {
                    playerOptional.get().getTeams().add(teamInBD.get());

                    playerRepository.save(playerOptional.get());
                }
                return playerOptional.get();
            } else {
                Player formattedPlayer = new Player();
                formattedPlayer.setFullname(player.getFullName());
                formattedPlayer.setPlayerImg(player.getPlayerImg());
                formattedPlayer.setBirthdate(fecha_nac);
                formattedPlayer.setPosition(player.getPosition());
                formattedPlayer.setCountry(countryInBD.get());
                List<Team> teams = new ArrayList<>();
                teams.add(teamInBD.get());
                formattedPlayer.setTeams(teams);

                Player savedPlayer = playerRepository.save(formattedPlayer);


                return savedPlayer;
            }
        } else {
            return null;
        }

    }

    public List<PlayerDto> saveAll(List<PlayerUnformatted> players){
        for (PlayerUnformatted player : players) {
            save(player);
        }
        return listAll();
    }

    public List<PlayerDto> getByFullName (String text) {

         Optional<List<Player>> players = playerRepository.findAllByFullnameContaining(text);

         if (players.isPresent()) {
             List<PlayerDto> playersDto = new ArrayList<>();

             for (Player player : players.get()) {
                 playersDto.add(playerToPLayerDto(player));
             }

             return playersDto;
         } else {
             return null;
         }
    }
    public Player getById(Long id) {
        return playerRepository.findById(id).get();
    }

    public void delete(Long id) {
        playerRepository.deleteById(id);
    }

    public List<Team> getTeams(Long id) {
        return playerRepository.findById(id).get().getTeams();
    }

    public void deleteAll(){
        playerRepository.deleteAll();
    }

    public PlayerDto playerToPLayerDto (Player player) {
        PlayerDto playerDto = new PlayerDto();
        playerDto.setName(player.getFullname());
        playerDto.setPlayerImg(player.getPlayerImg());
        playerDto.setPosition(player.getPosition());
        playerDto.setBirthdate(player.getBirthdate());
        playerDto.setCountry(new CountryDto(player.getCountry().getName(), player.getCountry().getFlag(), player.getCountry().getCode()));
        List<String> teams = new ArrayList<>();
        for (Team team : player.getTeams()) {
            teams.add(team.getName());
        }
        playerDto.setTeams(teams);
        return playerDto;
    }
}
