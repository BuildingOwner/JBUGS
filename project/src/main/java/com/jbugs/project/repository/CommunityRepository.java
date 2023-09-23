package com.jbugs.project.repository;

import com.jbugs.project.domain.Community;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional
public class CommunityRepository {
    private final EntityManager em;

    public void save(Community community){
        em.persist(community);
    }

    public Community findOne(Long id){
        return em.find(Community.class, id);
    }

    public List<Community> findAll(){
        return em.createQuery("select c from Community c", Community.class)
                .getResultList();
    }
}
