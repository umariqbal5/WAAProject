package com.exam.waaproject.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@Entity
public class Block {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Name should not be empty!")
    @Column(name = "Name")
    private String name;

    private Date startDate;
    private Date endDate;
    private Integer noOfDays;

}
