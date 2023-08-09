package com.jbugs.project.repository;

import com.jbugs.project.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(User user){
        em.persist(user);
    }

    public User findOne(Long id){
        return em.find(User.class, id);
    }

    public List<User> findAll(){
        return em.createQuery("select m from User m", User.class)
                .getResultList();
    }

    public List<User> findByName(String name){
        return em.createQuery("select m from User m where m.name = name", User.class)
                .setParameter("name", name)
                .getResultList();
    }
}
