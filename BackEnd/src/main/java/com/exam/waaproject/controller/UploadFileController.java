package com.exam.waaproject.controller;

import com.exam.waaproject.domain.Meditation;
import com.exam.waaproject.domain.Student;
import com.exam.waaproject.services.MeditationService;
import com.exam.waaproject.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@CrossOrigin(origins = {"http://localhost:8083"}, maxAge = 6000)
public class UploadFileController {
    @Autowired
    MeditationService meditationService;
    @Autowired
    StudentService studentService;

    @PostMapping(value = "/saveTmRecord", produces = "application/json")
    public Meditation saveTmRecord(@RequestBody Meditation record) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");
//        System.out.println(record);
//        //convert String to LocalDate
//        LocalDate localDate = LocalDate.parse(record.getStrDate(), formatter);
//        record.setDate(localDate);
        Student student = studentService.findById(record.getId());
        if (student == null) {
            student = new Student();
            student.setId(record.getId());
            student.setName(record.getId().toString());
            student.setUsername(record.getId().toString());
            student.setPassword(record.getId().toString());
            student.setRegistrationNumber(record.getId().toString());
            student.getMeditations().add(record);
            record.setStudent(student);
            studentService.save(student);
        } else {
            record.setStudent(student);
            record = meditationService.save(record);
        }
        System.out.println(String.format("afterSave: %s", record));
        return record;
    }
}
