package com.example.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Iterable<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Iterable<Team> getCompletedTeams() {
        return teamRepository.isCompleted();
    }

    public Iterable<Team> getNotCompletedTeams() {
        return teamRepository.IsNotCompleted();
    }
}
