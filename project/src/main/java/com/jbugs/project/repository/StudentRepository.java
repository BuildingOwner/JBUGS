package com.jbugs.project.repository;

import com.jbugs.project.domain.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Student student) {
        em.persist(student);
    }
    public Student findOne(Long id) {
        return em.find(Student.class, id);
    }
    public List<Student> findAll() {
        return em.createQuery("select m from Student m", Student.class)
                .getResultList();
    }

    public List<Student> findByName(String name){
        return em.createQuery("select m from Student  m where m.name = :name", Student.class)
                .setParameter("name", name)
                .getResultList();
    }
}
