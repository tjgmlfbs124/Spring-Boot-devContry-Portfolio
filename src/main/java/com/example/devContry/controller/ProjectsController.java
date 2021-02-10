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
    public String projects(Model model){

        model.addAttribute("projects", projectService.findAll());

        return "projects";
    }

    @GetMapping("project")
    public String project(@RequestParam("id") Long id, @RequestParam("fw") String fw, Model model){

        Optional<Project> project = projectService.findById(id);
        project.ifPresent(m->{
            model.addAttribute("project", project.get());
        });

        return "project/" + fw + "/" + id;
    }
}
