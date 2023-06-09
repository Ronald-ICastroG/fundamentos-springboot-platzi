package com.fundamentosplatzi.springboot.demo.configuration;


import com.fundamentosplatzi.springboot.demo.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {
@Bean
    public MyBean beanOperation(){
    return new MyBean2Implement();
}


    @Bean
    public MyOperation beanOperationOperation(){
        return new MyOperationImplement();
    }

    @Bean
    public MyBeanWithDependency beanOperationOperationWithDependency (MyOperation myOperation){
        return new MyBeanWithDependencyImplement(myOperation);
    }
}
