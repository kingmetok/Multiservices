package com.example.first.controller;

import com.example.first.entity.Team;
import com.example.first.repository.TeamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
public class TeamsController {

    private List<Team> teams;
    private TeamDao teamDao;

    @Autowired
    public TeamsController(final List<Team> teams, final TeamDao teamDao) {
        this.teams = teams;
        this.teamDao = teamDao;
    }

    @PostConstruct
    public void init() {
        teams.forEach(team -> teamDao.save(team));
    }
}
