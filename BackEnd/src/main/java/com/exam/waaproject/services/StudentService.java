package com.exam.waaproject.services;

import com.exam.waaproject.domain.Student;

import java.util.List;

public interface StudentService {
    public Student save(Student tmRecord);

    public Iterable<Student> saveAll(List<Student> students);

    public Student findById(Long id);

    public Student findByRegistrationNumber(String number);
}
