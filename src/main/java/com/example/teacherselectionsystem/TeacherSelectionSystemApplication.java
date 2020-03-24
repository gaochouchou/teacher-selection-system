package com.example.teacherselectionsystem;

import com.example.teacherselectionsystem.repository.baseRepository.impl.BaseRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
public class TeacherSelectionSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeacherSelectionSystemApplication.class, args);
    }

}
