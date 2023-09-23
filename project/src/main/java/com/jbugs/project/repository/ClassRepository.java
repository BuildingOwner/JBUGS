package com.jbugs.project.repository;

import com.jbugs.project.domain.Classes;
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

    public void save(Classes classes){
        em.persist(classes);
    }

    public Classes findOne(Long id){
        return em.find(Classes.class, id);
    }

    public List<Classes> findAll(){
        return em.createQuery("select c from Classes c", Classes.class)
                .getResultList();
    }
}
