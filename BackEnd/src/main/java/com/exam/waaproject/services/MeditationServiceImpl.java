package com.exam.waaproject.services;

import com.exam.waaproject.domain.Meditation;
import com.exam.waaproject.repository.MeditationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeditationServiceImpl implements MeditationService {
    @Autowired
    MeditationRepository meditationRepository;

    @Override
    public Meditation save(Meditation record) {
        return meditationRepository.save(record);
    }
}
