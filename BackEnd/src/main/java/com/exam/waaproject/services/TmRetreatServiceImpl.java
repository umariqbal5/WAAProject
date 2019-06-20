package com.exam.waaproject.services;

import com.exam.waaproject.domain.Student;
import com.exam.waaproject.domain.TmRetreat;
import com.exam.waaproject.repository.TmRetreatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TmRetreatServiceImpl implements TmRetreatService {
    @Autowired
    private TmRetreatRepository tmRetreatRepository;
    @Override
    public void save(TmRetreat tmRetreat) {
        if (tmRetreat.getStudent() == null) return;
        if (tmRetreatRepository.findByDateAndStudent(tmRetreat.getDate(), tmRetreat.getStudent()) != null) return;
        tmRetreatRepository.save(tmRetreat);
    }

    @Override
    public List<TmRetreat> findByStudent(Student student) {
        return tmRetreatRepository.findAllByStudent(student);
    }
}
