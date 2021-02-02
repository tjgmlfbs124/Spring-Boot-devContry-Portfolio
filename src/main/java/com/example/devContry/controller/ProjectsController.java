package com.example.devContry.controller;

import com.example.devContry.domain.Project;
import com.example.devContry.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
import java.util.stream.Stream;

@Controller
public class ProjectsController {
    private ProjectService projectService;

    public ProjectsController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/projects")
    public String projects(@RequestParam("fw") String fw, Model model){
        System.out.println("[project Controller]fw = " + fw);
        Stream<Project> projects = projectService.findProjects(fw);
        System.out.println("projects.toArray().length = " + projects.toArray().length);

        model.addAttribute("projects", projects.toArray());
        return "projects";
    }
}
