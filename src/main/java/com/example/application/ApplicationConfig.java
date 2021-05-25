package com.example.application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    // will create 4 entries for both project and teams tables

    @Bean
    CommandLineRunner commandLineRunner(ProjectRepository projectRepository, TeamRepository teamRepository) {
        return args -> {

            Team team1 = new Team(
                    "Team 1",
                    "N/A",
                    true
            );

            Team team2 = new Team(
                    "Team 2",
                    "https://github.com/RobertoRodriguez27/Obstacle-Pong",
                    true
            );

            Team team3 = new Team(
                    "Team 3",
                    "https://github.com/RobertoRodriguez27/DS-and-Spotify",
                    false
            );

            Team team4 = new Team(
                    "Team 4",
                    "https://github.com/AndrewCantrell23/EGR302-Py-Fi",
                    true
            );

            Project project1 = new Project(
                    "Spring Application",
                    "Hard",
                    "Java",
                    "Spring",
                    "Application for job"
            );

            Project project2 = new Project(
                    "Obstacle Pong",
                    "Easy",
                    "Python",
                    "Pygame",
                    "Fun pong recreation"

            );

            Project project3 = new Project(
                    "Fullstack Practice with Python",
                    "Hard",
                    "Python",
                    "Flask",
                    "Using Spotify's API I am creating a fullstack webpage that will take polls a song's " +
                            "popularity"
            );

            Project project4 = new Project(
                    "PyFi",
                    "Medium",
                    "Python",
                    "Javascript",
                    "Jr Design Project. Raspberry Pis spread across the school campus would run a speed test, " +
                            "upload results into a database, then extract onto a webpage"
            );

            // maps each project with a team and vice versa. this is where the tables are joined together
            // with foreign keys

            project1.setTeam(team1);
            team1.setProject(project1);

            project2.setTeam(team2);
            team2.setProject(project2);

            project3.setTeam(team3);
            team3.setProject(project3);

            project4.setTeam(team4);
            team4.setProject(project4);

            teamRepository.save(team1);
            teamRepository.save(team2);
            teamRepository.save(team3);
            teamRepository.save(team4);

            projectRepository.save(project1);
            projectRepository.save(project2);
            projectRepository.save(project3);
            projectRepository.save(project4);
        };
    }
}
