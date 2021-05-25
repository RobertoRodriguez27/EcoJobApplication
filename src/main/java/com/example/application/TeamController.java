package com.example.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/app")
public class TeamController {

    @Autowired
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    /**
     * calls over all teams, which will be all the rows within the teams table,
     * and saves them into a list. The list is then sent over to frombase.html and put onto the
     * webpage when visiting localhost:9898/app/projects
     * @param model sends over a list of each team and its details to frombase.html
     * @return name of webpage this method is linked to
     */
    @GetMapping(path = "/teams")
    public String displayAllTeams(Model model){
        model.addAttribute("title", "Teams");
        List<String> teams = new ArrayList<>();

        for (Team team : teamService.getAllTeams()) {
            String rowCon = "Team Name: " + team.getName() + " | Project Completion: " + team.isCompleted()
                    + "\n | Github: " + team.getGithub();
            teams.add(rowCon);
        }
        model.addAttribute("teams", teams);
        return "frombase";
    }

    /**
     * retrieves completed projects with the incompleted projects
     * @param model sends repsective rows of completed and incompleted projects to status.html
     * @return name of webpage this method is linked to
     */
    @GetMapping(path = "status")
    public String completedProjects(Model model) {
        List<String> completed = getRows(teamService.getCompletedTeams());
        List<String> notCompleted = getRows(teamService.getNotCompletedTeams());

        model.addAttribute("completed", completed);
        model.addAttribute("notCompleted", notCompleted);

        return "status";
    }

    /**
     * helper method for completedProjects. This for loop creates each row that will
     * be sent over to status.html
     * @param serviceResults the iterable results from the called queries
     * @return a list of parsed query results
     */
    private static List<String> getRows(Iterable<Team> serviceResults) {
        List<String> teams = new ArrayList<>();

        for (Team team : serviceResults) {
            String rowCon = "Team Name: " + team.getName() + " | Project Name: " + team.getProject().getName() + " | Project Completion: " + team.isCompleted()
                    + "\n | Github: " + team.getGithub();
            teams.add(rowCon);
        }

        return teams;
    }
}
