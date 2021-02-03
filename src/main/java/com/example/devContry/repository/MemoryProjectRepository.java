package com.example.devContry.repository;

import com.example.devContry.domain.Project;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Stream;

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

        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Stream<Project> findByProjects(String fw) {
        Stream<Project> getProject = store.values().stream().
                filter(project -> project.getFw().equals(fw));
        return getProject;
    }

    @Override
    public List<Project> findAll() {
        ArrayList projects = new ArrayList<>(store.values());
        return projects ;
    }
}
