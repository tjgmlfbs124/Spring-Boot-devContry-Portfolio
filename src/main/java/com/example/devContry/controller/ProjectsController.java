package com.example.devContry.controller;

import com.example.devContry.domain.Project;
import com.example.devContry.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ProjectsController {
    private ProjectService projectService;

    public ProjectsController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/projects")
    public String projects(@RequestParam("fw") String fw, Model model){
        System.out.println("[project Controller]fw = " + fw);
        Optional<Project> projects = projectService.findProjects(fw);
        System.out.println("projects.toString() = " + projects.get().getTitle());
        model.addAttribute("projects", projects);
        return "projects";
    }
}
