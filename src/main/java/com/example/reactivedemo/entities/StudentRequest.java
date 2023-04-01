package com.example.reactivedemo.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentRequest {

    private String firstName;

    private String lastName;

    private int age;
}
