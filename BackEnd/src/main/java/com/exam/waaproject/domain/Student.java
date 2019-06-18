package com.exam.waaproject.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Student {

    @Id
    private Long id; //Badge number

    @NotEmpty(message = "Name should not be empty!")
    @Column(name = "Name")
    private String name;

    private String username;
    private String password;
    private String registrationNumber;

    //OnetoOne Relation
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "entry_block_id", referencedColumnName = "id")
    private Integer entryBlock;

    //OnetoOne Relation
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "current_subject_id", referencedColumnName = "id")
    private Long currentSubject;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Meditation> meditations = new ArrayList<>();

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TmChecking> tmCheckings = new ArrayList<>();

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TmRetreat> tmRetreats = new ArrayList<>();

}
