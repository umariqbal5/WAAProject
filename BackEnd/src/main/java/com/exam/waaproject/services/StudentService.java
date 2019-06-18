package com.exam.waaproject.services;

import com.exam.waaproject.domain.Student;

public interface StudentService {
    public Student save(Student tmRecord);

    public Student findById(Long id);
}
