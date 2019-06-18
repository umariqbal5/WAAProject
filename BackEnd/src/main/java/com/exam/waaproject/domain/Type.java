package com.exam.waaproject.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Type")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

}
