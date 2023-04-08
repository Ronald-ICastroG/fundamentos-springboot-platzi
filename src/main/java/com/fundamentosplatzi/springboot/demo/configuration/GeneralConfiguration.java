package com.fundamentosplatzi.springboot.demo.configuration;

import com.fundamentosplatzi.springboot.demo.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.demo.bean.MyBeanWithPropertiesImplement;
import com.fundamentosplatzi.springboot.demo.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:connection.properties")
@EnableConfigurationProperties(UserPojo.class)

public class GeneralConfiguration {

    @Value("${value.name}")
    private String name;


    @Value("${value.apellido}")
    private String apellido;


    @Value("${value.random}")
    private String random;


    //acá van las anotaciones de los parámetros del nuevo properties
    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${driver}")
    private String driver;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;




    @Bean
    public MyBeanWithProperties function(){
        return new MyBeanWithPropertiesImplement(name,apellido);
    }

    @Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder=DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driver);
                dataSourceBuilder.url(jdbcUrl);
                dataSourceBuilder.username(username);
                dataSourceBuilder.password(password);
gi
        return dataSourceBuilder.build();
    }
}
