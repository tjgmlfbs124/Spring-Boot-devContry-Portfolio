package com.example.devContry.repository;

import com.example.devContry.domain.Project;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class MySQLProjectRepository implements ProjectRepository{

    private final EntityManager em;

    public MySQLProjectRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List findAll() {
        return em.createQuery("select m from Project m").getResultList();
    }

    @Override
    public Optional<Project> findById(Long id) {

        return em.createQuery("select m from Project m where id = :id", Project.class)
                .setParameter("id",id)
                .getResultList().stream().findAny();
    }

    @Override
    public List<Project> findByFw(String fw) {

        return em.createQuery("select m from Project m where fw = :fw", Project.class)
                .setParameter("fw",fw)
                .getResultList();
    }
}
