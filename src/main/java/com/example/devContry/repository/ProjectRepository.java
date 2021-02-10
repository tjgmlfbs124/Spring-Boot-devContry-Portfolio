package com.example.devContry.repository;

import com.example.devContry.domain.Project;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface ProjectRepository {
    Optional<Project> findById(Long id);
    List<Project> findAll();
}
