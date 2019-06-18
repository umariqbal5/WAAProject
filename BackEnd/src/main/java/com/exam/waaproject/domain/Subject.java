package com.exam.waaproject.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Name should not be empty!")
    @Column(name = "Name")
    private String name;

    //OnetoOne Relation
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "block_id", referencedColumnName = "id")
    private Block block;
}
