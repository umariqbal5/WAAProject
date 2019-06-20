package com.exam.waaproject.services;

import com.exam.waaproject.domain.Student;
import com.exam.waaproject.domain.TmRetreat;

import java.util.List;

public interface TmRetreatService {
    public void save(TmRetreat tmRetreat);
    public List<TmRetreat> findByStudent(Student student);
}
