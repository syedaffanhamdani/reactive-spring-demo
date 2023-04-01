package com.example.reactivedemo.entities;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Value
@Builder
@Table(name = "students")
public class Student {

    @Id
    Integer id;

    String firstName;

    String lastName;

    int age;

}
