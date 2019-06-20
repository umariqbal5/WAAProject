package com.exam.waaproject.controller;

import com.exam.waaproject.domain.Student;
import com.exam.waaproject.domain.TmRetreat;
import com.exam.waaproject.services.StudentServiceImpl;
import com.exam.waaproject.services.TmRetreatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:63342"}, maxAge = 6000)
public class RetreatController {

    @Autowired
    private TmRetreatServiceImpl tmRetreatService;
    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping("/api/retreat")
    public List<TmRetreat> getRetreatList(@RequestParam Long stu_id) {
        Student student =
                studentService.findById(stu_id);
        if (student == null) return null;
        return tmRetreatService.findByStudent(student);
    }

    @PostMapping("/api/retreat")
    public List<TmRetreat> saveRetreat(@RequestBody TmRetreat tmRetreat) {
        Student student =
                studentService.findById(tmRetreat.getStu_id());
        tmRetreat.setStudent(student);
        tmRetreatService.save(tmRetreat);
        return tmRetreatService.findByStudent(student);
    }
}
