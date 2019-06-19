package com.exam.waaproject.controller;

import com.exam.waaproject.domain.Student;
import com.exam.waaproject.domain.TmChecking;
import com.exam.waaproject.repository.TmCheckingRepository;
import com.exam.waaproject.services.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:63342"}, maxAge = 6000)
public class TmCheckingController {
    @Autowired
    private TmCheckingRepository tmCheckingRepository;

    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping("/api/checking")
    public List<TmChecking> getChecking() {
        return null;
    }

    @PostMapping("/api/checking")
    public List<TmChecking> saveChecking(@RequestBody TmChecking tmChecking) {
        Student student = studentService.findById(tmChecking.getStu_id());
        tmChecking.setStudent(student);
        tmCheckingRepository.save(tmChecking);
        return tmCheckingRepository.findAllByStudent(student);
    }
}
