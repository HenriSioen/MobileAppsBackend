package com.mobile.demo;

import com.mobile.demo.controller.AnswerController;
import com.mobile.demo.dao.AnswerEntityRepository;
import com.mobile.demo.dao.QuestionEntityRepository;
import com.mobile.demo.dao.UserEntityRepository;
import com.mobile.demo.controller.QuestionController;
import com.mobile.demo.controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@SpringBootApplication
@EnableJpaRepositories("com.mobile.demo.dao")
/*@Configuration
@ComponentScan(basePackages = {"com.mobile.demo.dao"})*/
public class ProjectApplication implements CommandLineRunner {

    @Autowired
    DataSource dataSource;

    @Autowired
    UserEntityRepository userEntityRepository;

    @Autowired
    QuestionEntityRepository questionEntityRepository;

    @Autowired
    AnswerEntityRepository answerEntityRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws  Exception{
        UserController userController = new UserController(userEntityRepository);
        QuestionController questionController = new QuestionController(questionEntityRepository);
        AnswerController answerController = new AnswerController(answerEntityRepository);
    }



}
