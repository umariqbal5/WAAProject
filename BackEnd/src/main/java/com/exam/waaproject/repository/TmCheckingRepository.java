package com.exam.waaproject.repository;

import com.exam.waaproject.domain.Student;
import com.exam.waaproject.domain.TmChecking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TmCheckingRepository extends CrudRepository<TmChecking, Long> {
    public List<TmChecking> findAllByStudent(Student student);
}
