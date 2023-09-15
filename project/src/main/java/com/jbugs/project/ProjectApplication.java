package com.jbugs.project;


import com.jbugs.project.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@SpringBootApplication
public class ProjectApplication {
    public static void main(String[] args){
        SpringApplication.run(ProjectApplication.class, args);
    }
}
