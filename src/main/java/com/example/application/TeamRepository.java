package com.example.application;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TeamRepository extends CrudRepository<Team, Integer> {

    // join query that grabs all completed projects and the projects teams
    @Query(value = "SELECT t.name, t.team_id, p.name, p.team_foreign_id, t.github, t.completed " +
            "FROM teams t, Project p " +
            "WHERE t.completed = true AND t.team_id = p.team_foreign_id",
            nativeQuery = true)
    List<Team> isCompleted();

    // join query that grabs all incompleted projects and the projects teams
    @Query(value = "SELECT t.name, t.team_id, p.name, p.team_foreign_id, t.github, t.completed " +
            "FROM teams t, Project p " +
            "WHERE t.completed = false AND t.team_id = p.team_foreign_id",
            nativeQuery = true)
    List<Team> IsNotCompleted();

}
