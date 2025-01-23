package com.example.Employ;

import com.example.Employ.Repo.EmployeeRepository;
import com.example.Employ.dto.EmployeeDto;
import com.example.Employ.model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
//@ComponentScan({"com.example.Employ.Repo.EmployeeRepository"})
//@EntityScan("com.example.Employ.Repo.EmployeeRepository")
@SpringBootApplication
@EnableMongoAuditing
public class EmployApplication {

	public static void main(String[] args){
		SpringApplication.run(EmployApplication.class, args);

	}

	@Bean
	public EmployeeDto EmployeeDto(){
		return  new EmployeeDto();
	}


}
