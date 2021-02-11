package com.example.devContry.controller;

import com.example.devContry.domain.Pager;
import com.example.devContry.domain.Project;
import com.example.devContry.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
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

        Optional<Project> project = projectService.findById(id);    // id에 해당하는 project
        List<Project> list = projectService.findByFrameWorks(fw);   // fw에 해당하는 projects

        int projectIndex = list.indexOf(project.get());             // fw에 해당하는 project List중에서 속한 index

        Pager pager = new Pager();
        pager.setPrev(list.get(Math.max((projectIndex - 1), 0)));
        pager.setNext(list.get((projectIndex + 1) < list.size() ? (projectIndex + 1) : projectIndex));

        project.ifPresent(m->{
            model.addAttribute("project", project.get());
            model.addAttribute("pager", pager);
        });

        return "project/" + fw + "/" + id;
    }
}
