package com.jbugs.project;

import com.jbugs.project.domain.Student;
import com.jbugs.project.domain.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(ProjectApplication.class);
    @Autowired
    private StudentRepository repository;
    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        repository.save(new Student(1971084L, "진승원", "웹공학", "모바일소프트웨어", "없음"));
        repository.save(new Student(1971080L, "장주찬","모바일소프트웨어", "웹공학"));
        for (Student student : repository.findAll()) {
            logger.info(student.getId() + " " + student.getName());
        }
    }
}
