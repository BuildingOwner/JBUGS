package com.jbugs.project.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional
public class ClassRepository {

    private final EntityManager em;

    public void save(Class classes){
        em.persist(classes);
    }

    public Class findOne(Long id){
        return em.find(Class.class, id);
    }

    public List<Class> findAll(){
        return em.createQuery("select c from Class c", Class.class)
                .getResultList();
    }
}
