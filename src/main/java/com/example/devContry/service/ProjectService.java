package com.example.devContry.service;

import com.example.devContry.domain.Project;
import com.example.devContry.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void submit(Project project){
        projectRepository.submit(project);
    }

    public Optional<Project> findProject(Long id){
        return projectRepository.findByProject(id);
    }

    public Stream<Project> findProjects(String fw){
        return projectRepository.findByProjects(fw);
    }
}
