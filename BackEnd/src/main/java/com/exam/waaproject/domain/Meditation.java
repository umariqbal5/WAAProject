package com.exam.waaproject.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
public class Meditation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String location;
    private String timeSlot;
    @JsonFormat(pattern = "MM/dd/yy")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    @JsonBackReference
    private Student student;

    @Override
    public String toString() {
        String stu = "";
        if (student != null) {
            stu = "Student{" +
                    "id=" + student.getId() +
                    ", name='" + student.getName() + '\'' +
                    ", username='" + student.getUsername() + '\'' +
                    ", password='" + student.getPassword() + '\'' +
                    ", registrationNumber='" + student.getRegistrationNumber() + '\'' +
                    '}';
        }
        return "Meditation{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", timeSlot='" + timeSlot + '\'' +
                ", date=" + date +
                ", student=" + stu +
                '}';
    }
}
