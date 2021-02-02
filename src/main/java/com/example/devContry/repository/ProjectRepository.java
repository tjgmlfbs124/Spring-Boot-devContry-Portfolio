package com.example.devContry.repository;

import com.example.devContry.domain.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository {
    Project submit(Project project);
    Optional<Project> findByProject(Long id);
    Optional<Project> findByProjects(String fw);
    List<Project> findAll();

}
