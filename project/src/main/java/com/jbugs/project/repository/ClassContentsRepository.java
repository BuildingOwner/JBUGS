package com.jbugs.project.repository;

import com.jbugs.project.domain.ClassContents;
import com.jbugs.project.domain.Classes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional
public class ClassContentsRepository {

    private final EntityManager em;

    public void save(ClassContents classContents){
        em.persist(classContents);
    }

    public ClassContents findOne(Long id){
        return em.find(ClassContents.class, id);
    }

    public List<ClassContents> findAll(){
        return em.createQuery("select c from ClassContents c", ClassContents.class)
                .getResultList();
    }
}
