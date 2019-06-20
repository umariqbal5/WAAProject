package com.exam.waaproject.controller;

import com.exam.waaproject.domain.*;
import com.exam.waaproject.services.BlockService;
import com.exam.waaproject.services.CaterogyService;
import com.exam.waaproject.services.MeditationService;
import com.exam.waaproject.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class AttendanceReportController {

    @Autowired
    BlockService blockService;

    @Autowired
    CaterogyService caterogyService;

    @Autowired
    StudentService studentService;

    @Autowired
    MeditationService meditationService;

    @GetMapping("/api/get/blocks")
    public List<Block> getBlocks() {
        return blockService.getAll();
    }

    @GetMapping("/api/get/blocks/{entryBlockId}")
    public List<Block> getBlocksByEntryBlockId(@PathVariable Long entryBlockId) {
        return blockService.getBlocksByEntryBlockId(entryBlockId);
    }

    @GetMapping("/api/get/categories")
    public List<Category> getCategories() {
        return caterogyService.getAll();
    }

    @GetMapping("/api/get/students")
    public List<Student> getStudents() {
        return studentService.getAll();
    }

    @GetMapping("/api/get/meditations/{studentId}")
    public List<Meditation> getMeditations(@PathVariable Long studentId) {
        return meditationService.getAllByStudentId(studentId);
    }

    @GetMapping("/api/get/meditations/{studentId}/{startDate}/{endDate}")
    public List<Meditation> getMeditations(@PathVariable Long studentId, @PathVariable String startDate, @PathVariable String endDate) {
        return meditationService.getAllByStudentIdAndStartDateEndDate(studentId, LocalDate.parse(startDate), LocalDate.parse(endDate));
    }

    @GetMapping("/api/get/stu/{startDate}/{endDate}")
    public List<String> getMeditations(@PathVariable String startDate, @PathVariable String endDate) {
        return studentService.getStudentsInBlock(startDate, endDate);
    }

}
