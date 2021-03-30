package com.example.first.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id")
    private Set<Player> players;

    public Team(final String name, final String location, final Set<Player> players) {
        this.name = name;
        this.location = location;
        this.players = players;
    }
}
