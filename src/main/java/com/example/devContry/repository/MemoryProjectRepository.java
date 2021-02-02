package com.example.devContry.repository;

import com.example.devContry.domain.Project;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemoryProjectRepository implements ProjectRepository{
    private static Map<Long, Project> store = new HashMap<>();
    private static long seq = 0L;

    @Override
    public Project submit(Project project){
        project.setId(++seq);
        store.put(project.getId(), project);
        return project;
    }

    @Override
    public Optional<Project> findByProject(Long id) {

        return Optional.empty();
    }

    @Override
    public Optional<Project> findByProjects(String fw) {
        Optional<Project> getProject = store.values().stream().
                filter(project -> project.getfw().equals(fw))
                .findAny();

        return getProject;
    }

    @Override
    public List<Project> findAll() {
        return null;
    }
}
