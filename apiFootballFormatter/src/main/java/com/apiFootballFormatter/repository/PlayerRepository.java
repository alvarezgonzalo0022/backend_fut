package com.apiFootballFormatter.repository;

import com.apiFootballFormatter.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    Optional<List<Player>> findAllByFullnameContaining(String text);
    Optional<Player> findByFullnameAndBirthdate(String name, Date birth_date);
}
