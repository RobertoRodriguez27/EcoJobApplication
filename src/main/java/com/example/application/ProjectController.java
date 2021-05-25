package com.example.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/app") // localhost:9898/app
public class ProjectController {

    @Autowired
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    /**
     * calls over all projects, which will be all the rows within the projects table,
     * and saves them into a list. The list is then sent over to frombase.html and put onto the
     * webpage when visiting localhost:9898/app/projects
     * @param model sends over a list of each project and its details to frombase.html
     * @return name of webpage this method is linked to
     */
    @GetMapping(path = "projects")
    public String displayAllProjects(Model model) {
        model.addAttribute("title", "Projects");
        List<String> projects = new ArrayList<>();
        for (Project project : projectService.getAllProjects()) {
            String rowCon = "Project Name: " + project.getName() + " | Difficulty: " + project.getDifficulty() +
                    " | Primary Language: " + project.getPrimaryLanguage() + " | Secondary Language: " +
                    project.getSecondaryLanguage() + " \n| Bio: " + project.getBio();
            projects.add(rowCon);
        }
        model.addAttribute("projects", projects);
        return "frombase";
    }

}
