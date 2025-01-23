package com.example.Employ.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.mongodb.core.mapping.MongoId;


//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Document(collection = "Empdb")
public class Employee {
    @Id
    private int id;
    private String name;
    private String status;
    @JsonFormat(pattern = "yyyy-mm-dd HH:MM:SS")
    private Date duedate;
}
