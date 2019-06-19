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
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:8083"}, maxAge = 6000)
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
        List<Student> students = new ArrayList<>();
        List<Meditation> meditations = new ArrayList<>();
        for (Meditation record : records) {
            Student student = null;
            if (record.getStudent() == null) {
                student = studentService.findById(record.getId());
                if (student == null) {
                    student = searchInList(students, record.getId(), null);
                }
            } else {
                student = studentService.findByRegistrationNumber(
                        record.getStudent().getRegistrationNumber());
                if (student == null) {
                    student = searchInList(students, null, record.getStudent().getRegistrationNumber());
                }
            }
            if (student == null) {
                student = new Student();
                student.setId(record.getStudent() == null ? record.getId() :
                        toLongId(record.getStudent().getRegistrationNumber()));
                student.setName(student.getId().toString());
                student.setUsername(student.getId().toString());
                student.setPassword(student.getId().toString());
                student.setRegistrationNumber(record.getStudent() == null ? record.getId().toString() :
                        record.getStudent().getRegistrationNumber());
                student.getMeditations().add(record);
                record.setStudent(student);
                students.add(student);
            } else {
                record.setStudent(student);
                if (meditationService.isNotExist(record)) {
                    meditations.add(record);
                }
            }
        }
        if (students.size() != 0) {
            studentService.saveAll(students);
        }
        if (meditations.size() != 0) {
            meditationService.saveAll(meditations);
        }
        System.out.println("Save Success");
        return meditations;
    }


    private Student searchInList(List<Student> students, Long id, String registNumber) {
        Optional<Student> student = students.stream().filter(
                x -> id != null ? x.getId() == id : x.getRegistrationNumber() == registNumber
        ).findFirst();
        return student.isPresent() ? student.get() : null;
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
