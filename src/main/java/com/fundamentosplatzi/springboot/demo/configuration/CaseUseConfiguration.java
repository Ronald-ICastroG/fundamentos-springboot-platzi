package com.fundamentosplatzi.springboot.demo.configuration;

import com.fundamentosplatzi.springboot.demo.caseuse.GetUser;
import com.fundamentosplatzi.springboot.demo.caseuse.GetUserImplement;
import com.fundamentosplatzi.springboot.demo.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {
    @Bean
    GetUser getUser(UserService userService){
        return new GetUserImplement(userService);
    }
}
