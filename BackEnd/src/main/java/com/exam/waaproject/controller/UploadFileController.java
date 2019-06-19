package com.exam.waaproject.controller;

import com.exam.waaproject.domain.Meditation;
import com.exam.waaproject.domain.Student;
import com.exam.waaproject.repository.MeditationRepository;
import com.exam.waaproject.repository.StudentRepository;
import com.exam.waaproject.services.MeditationService;
import com.exam.waaproject.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class UploadFileController {
    @Autowired
    MeditationService meditationService;
    @Autowired
    StudentService studentService;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    MeditationRepository meditationRepository;

    @PostMapping(value = "/api/saveTmRecord", produces = "application/json")
    public List<Meditation> saveTmRecord(@RequestBody List<Meditation> records) {
        HashMap<Long, Student> studentHashMap = new HashMap<>();
        List<Meditation> meditations = new ArrayList<>();
        for (Meditation record : records) {
            Student student = null;
            if (record.getStudent() == null) {
                student = studentService.findById(record.getId());
            } else {
                student = studentService.findByRegistrationNumber(
                        record.getStudent().getRegistrationNumber());
            }
            if (student == null) {
                student = new Student();
                student.setId(record.getStudent() == null ? record.getId() :
                        toLongId(record.getStudent().getRegistrationNumber()));
                student.setName(record.getStudent() == null ?
                        student.getId().toString():
                        record.getStudent().getName());
                student.setUsername(student.getId().toString());
                student.setPassword(student.getId().toString());
                student.setRegistrationNumber(record.getStudent() == null ?
                        record.getId().toString() :
                        record.getStudent().getRegistrationNumber());
                student.getMeditations().add(record);
                record.setStudent(student);
                if (!studentHashMap.containsKey(student.getId())) {
                    studentHashMap.put(student.getId(), student);
                }
                else{
                    studentHashMap.get(student.getId())
                            .getMeditations().add(record);
                }
            } else {
                record.setStudent(student);
                if (meditationService.isNotExist(record)) {
                    meditations.add(record);
                }
            }
        }
        if (!studentHashMap.isEmpty()) {
            studentService.saveAll(studentHashMap.values()
                    .stream().collect(Collectors.toList()));
        }
        if (meditations.size() != 0) {
            meditationService.saveAll(meditations);
        }
        System.out.println("Save Success");
        return meditations;
    }

    /**
     * Return Badge number from Student id
     *
     * @param stuId
     * @return
     */
    private long toLongId(String stuId) {
        long rs = 0;
        stuId = stuId.replace("-", "");
        try {
            rs = Long.valueOf(stuId);
        } catch (Exception e) {
            rs = 1000 + (int) (Math.random() * ((9999 - 1000) + 1));
        }
        return rs;
    }
}
