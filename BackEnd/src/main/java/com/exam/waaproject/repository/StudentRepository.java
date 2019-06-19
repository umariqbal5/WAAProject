package com.exam.waaproject.repository;

import com.exam.waaproject.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    public Student findByRegistrationNumber(String registrationNumber);
}
