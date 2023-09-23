package com.jbugs.project.repository;

import com.jbugs.project.domain.Student;
import com.jbugs.project.domain.Test;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TestRepository {

    private final EntityManager em;

    public void save(Test test) {
        em.persist(test);
    }
    public Test findOne(Long id) {
        return em.find(Test.class, id);
    }
    public List<Test> findAll() {
        return em.createQuery("select t from Test t", Test.class)
                .getResultList();
    }
}
