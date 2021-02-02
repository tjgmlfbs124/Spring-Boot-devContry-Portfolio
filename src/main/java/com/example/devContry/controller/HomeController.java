package com.example.devContry.controller;

import com.example.devContry.domain.Project;
import com.example.devContry.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class HomeController {
    private final ProjectService projectService;

    public HomeController(ProjectService projectService) {
        this.projectService = projectService;
        generateProjects();
    }

    @GetMapping("/")
    public String home(){
        return "index";
    }

    private void generateProjects(){
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("/images/projects/spring/forum_01.jpg");
        arrayList.add("/images/projects/spring/forum_02.jpg");
        arrayList.add("/images/projects/spring/forum_03.jpg");

        Project project = new Project();
        project.setTitle("테스트 제목");
        project.setfw("spring-boot");
        project.setContent("이것은 내용");
        project.setImages(arrayList);

        projectService.submit(project);

        System.out.println("[Home] project.getTitle() = " + project.getTitle());
        System.out.println("[Home] project.getId() = " + project.getId());

    }

}
