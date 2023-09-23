package com.jbugs.project.repository;

import com.jbugs.project.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.Member;
import java.util.*;

@Repository
@Slf4j
@Transactional
@RequiredArgsConstructor
public class UserRepository {

    @PersistenceContext
    private final EntityManager em;

    private static Map<Long, User> store = new HashMap<>();
    private static long sequence = 0L;



//    public User save(User user){
//        user.setId(++sequence);
//        log.info("save: user={}", user);
//        store.put(user.getId(), user);
//        return user;
//    }

    public User findById(Long id){
        return store.get(id);
    }

    public Optional<User> findByLoginId(String loginId){
        return findAll().stream()
                .filter(u -> u.getLoginId().equals(loginId))
                .findFirst();
    }

//    public List<User> findAll(){
//        return new ArrayList<>(store.values());
//    }


    public Long save(User user){
        em.persist(user);
        user.setId(++sequence);
        store.put(user.getId(), user);
        return user.getId();
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
