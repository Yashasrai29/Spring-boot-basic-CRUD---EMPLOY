package com.example.Employ.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
@ComponentScan("com.example.Employ.*")
@EnableMongoRepositories(basePackages = {"com.example.Employ.*"})
public class WebConfig implements WebMvcConfigurer{


}
