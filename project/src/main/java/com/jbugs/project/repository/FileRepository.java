package com.jbugs.project.repository;

import com.jbugs.project.domain.Classes;
import com.jbugs.project.domain.File;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional
public class FileRepository {
    private final EntityManager em;

    public void save(File file){
        em.persist(file);
    }

    public File findOne(Long id){
        return em.find(File.class, id);
    }

    public List<File> findAll(){
        return em.createQuery("select f from File f", File.class)
                .getResultList();
    }
}
