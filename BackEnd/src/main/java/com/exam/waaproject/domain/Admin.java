package com.exam.waaproject.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //Badge number

    @NotEmpty(message = "Name should not be empty!")
    @Column(name = "Name")
    private String name;

    private String username;
    private String password;

}
