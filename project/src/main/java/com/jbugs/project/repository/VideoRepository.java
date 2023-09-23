package com.jbugs.project.repository;

import com.jbugs.project.domain.Classes;
import com.jbugs.project.domain.Video;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional
public class VideoRepository {

    private final EntityManager em;

    public void save(Video video){
        em.persist(video);
    }

    public Video findOne(Long id){
        return em.find(Video.class, id);
    }

    public List<Video> findAll(){
        return em.createQuery("select v from Video v", Video.class)
                .getResultList();
    }
}
