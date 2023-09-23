package com.jbugs.project.repository;

import com.jbugs.project.domain.Classes;
import com.jbugs.project.domain.Professor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional
public class ProfessorRepository {
    private final EntityManager em;

    public void save(Professor professor){
        em.persist(professor);
    }

    public Professor findOne(Long id){
        return em.find(Professor.class, id);
    }

    public List<Professor> findAll(){
        return em.createQuery("select p from Professor p", Professor.class)
                .getResultList();
    }
}
