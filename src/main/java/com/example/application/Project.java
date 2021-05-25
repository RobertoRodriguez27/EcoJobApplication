package com.example.application;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "project")
public class Project implements Serializable {

    // each field will become a column in the database

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // will enumerate the id value with each entry
    private int projectId;

    @Column(unique = true)
    private String name;

    private String difficulty;
    private String primaryLanguage;
    private String secondaryLanguage;
    private String bio;

    // creates a column named team_foreign_id and maps to the team_id's value
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId
    @JoinColumn(name = "team_foreign_id")
    private Team team;

    public Project() {
    }

    public Project(String name, String difficulty, String primaryLanguage, String secondaryLanguage, String bio) {
        this.name = name;
        this.difficulty = difficulty;
        this.primaryLanguage = primaryLanguage;
        this.secondaryLanguage = secondaryLanguage;
        this.bio = bio;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getPrimaryLanguage() {
        return primaryLanguage;
    }

    public void setPrimaryLanguage(String primaryLanguage) {
        this.primaryLanguage = primaryLanguage;
    }

    public String getSecondaryLanguage() {
        return secondaryLanguage;
    }

    public void setSecondaryLanguage(String secondaryLanguage) {
        this.secondaryLanguage = secondaryLanguage;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", name='" + name + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", primaryLanguage='" + primaryLanguage + '\'' +
                ", secondaryLanguage='" + secondaryLanguage + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }
}
