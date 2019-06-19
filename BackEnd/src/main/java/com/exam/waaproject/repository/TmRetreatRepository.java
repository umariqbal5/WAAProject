package com.exam.waaproject.repository;

import com.exam.waaproject.domain.Student;
import com.exam.waaproject.domain.TmRetreat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TmRetreatRepository extends CrudRepository<TmRetreat, Long> {
    public List<TmRetreat> findAllByStudent(Student student);
}
