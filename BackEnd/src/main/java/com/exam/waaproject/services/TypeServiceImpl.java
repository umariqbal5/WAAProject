package com.exam.waaproject.services;

import com.exam.waaproject.domain.Type;
import com.exam.waaproject.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TypeServiceImpl implements TypeService{
    @Autowired
    public TypeRepository typeRepository;

    @Override
    public List<Type> getAllTypeList() {
        return (List<Type>)typeRepository.findAll();
    }
}
