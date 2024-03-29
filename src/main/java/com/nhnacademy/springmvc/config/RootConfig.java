package com.nhnacademy.springmvc.config;

import com.nhnacademy.springmvc.Base;
import com.nhnacademy.springmvc.domain.Role;
import com.nhnacademy.springmvc.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackageClasses = Base.class,
        excludeFilters = { @ComponentScan.Filter(Controller.class)})
public class RootConfig {

    @Bean
    public AccountRepository accountRepository() {
        AccountRepository accountRepository = new AccountRepositoryImpl();
        accountRepository.addAccount("client", "1234", "client", Role.Client);
        accountRepository.addAccount("admin", "1234", "admin", Role.Admin);
        return accountRepository;
    }

    @Bean
    public PostRepository postRepository() {
        PostRepository postRepository = new PostRepositoryImpl();
        return postRepository;
    }

    @Bean
    public AnswerRepository answerRepository() {
        AnswerRepository answerRepository = new AnswerRepositoryImpl();
        return answerRepository;
    }

}
