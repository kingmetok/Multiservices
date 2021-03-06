package com.example.first.repository;

import com.example.first.entity.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path = "players", rel = "players")
public interface PlayerDao extends CrudRepository<Player, Long> {
}
