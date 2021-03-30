package com.example.first.configuration;

import com.example.first.entity.Player;
import com.example.first.entity.Team;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
public class TeamsInsertConfiguration {
    @Bean
    public List<Team> getTeam() {
        Set<Player> players = new HashSet<>();
        players.add(new Player("Pavlov", "forward"));
        players.add(new Player("Dignev", "goalkeeper"));
        players.add(new Player("Jechich", "defender"));

        List<Team> teams = new ArrayList<>();
        teams.add(new Team("California", "Trix", players));

        players = new HashSet<>();
        players.add(new Player("Porukin", "pitcher"));
        players.add(new Player("Kitchereky", "forward"));

        teams.add(new Team("New York", "Qul", players));

        return teams;
    }
}
