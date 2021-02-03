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
        project.setTitle("무료 포럼커뮤니틴");
        project.setFw("spring-boot");
        project.setContent("이것은 내용");
        project.setImages(arrayList);
        projectService.submit(project);

        Project project2 = new Project();
        project2.setTitle("로봇 코딩용 웹사이트");
        project2.setFw("nodejs");
        project2.setContent("이것은 내용");
        project2.setImages(arrayList);
        projectService.submit(project2);

        Project project3 = new Project();
        project3.setTitle("휴대폰 견적 사이트");
        project3.setFw("php");
        project3.setContent("이것은 내용");
        project3.setImages(arrayList);
        projectService.submit(project3);



    }

}
