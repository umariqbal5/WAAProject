package com.exam.waaproject.services;

import com.exam.waaproject.domain.Student;
import com.exam.waaproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Iterable<Student> saveAll(List<Student> students) {
        return studentRepository.saveAll(students);
    }

    @Override
    public Student findById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.isPresent() ? student.get() : null;
    }

    @Override
<<<<<<< HEAD
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<String> getStudentsInBlock(String startDate, String endDate) {
        return studentRepository.findAllByBlockInSelect(startDate, endDate);
=======
    public Student findByRegistrationNumber(String number) {
        return studentRepository.findByRegistrationNumber(number);
>>>>>>> master
    }
}
