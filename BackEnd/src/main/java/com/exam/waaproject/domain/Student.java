package com.exam.waaproject.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Student {

    @Id
    @Excel(name = "STU_ID")
    private Long id; //Badge number

    @NotEmpty(message = "Name should not be empty!")
    @Column(name = "Name")
    @Excel(name = "NAME")
    private String name;

    private String username;
    private String password;

    @Excel(name = "STU_R_NUM", width = 12)
    private String registrationNumber;

    //OnetoOne Relation
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "entry_block_id", referencedColumnName = "id")
    private Block entryBlock;

    //OnetoOne Relation
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "current_subject_id", referencedColumnName = "id")
    private Subject currentSubject;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Meditation> meditations = new ArrayList<>();
}
