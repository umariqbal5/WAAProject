package com.exam.waaproject.services;

import com.exam.waaproject.domain.Student;

import java.util.List;

public interface StudentService {
    public Student save(Student tmRecord);

    public Student findById(Long id);

    public List<Student> getAll();

    public List<String> getStudentsInBlock(String startDate, String endDate);
}
