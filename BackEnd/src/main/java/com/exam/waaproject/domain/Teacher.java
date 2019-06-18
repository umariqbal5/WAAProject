package com.exam.waaproject.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
public class Teacher {

    @Id
    private Long id; //Badge number

    @NotEmpty(message = "Name should not be empty!")
    @Column(name = "Name")
    private String name;

    private String username;
    private String password;

    //OnetoOne Relation
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;

}
