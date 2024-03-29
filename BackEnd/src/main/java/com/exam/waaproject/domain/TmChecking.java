package com.exam.waaproject.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class TmChecking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    @ExcelEntity()
    private Student student;

    @JsonFormat(pattern = "MM/dd/yyyy")
    @Excel(name = "DATE", exportFormat = "yyyy-MM-dd", width = 12)
    private LocalDate date;

    @Excel(name = "Group", replace = {"YES_true", "NO_false", "NO_null"})
    private Boolean groupBool;

    @Transient
    private Long stu_id;


}
