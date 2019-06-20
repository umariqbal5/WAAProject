package com.exam.waaproject.services;

import com.exam.waaproject.domain.Meditation;
import com.exam.waaproject.repository.MeditationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;


import java.util.List;

@Service
public class MeditationServiceImpl implements MeditationService {
    @Autowired
    MeditationRepository meditationRepository;

    @Override
    public Meditation save(Meditation record) {
        return meditationRepository.save(record);
    }

    @Override

    public List<Meditation> getAllByStudentIdAndStartDateEndDate(long studentId, LocalDate startDate, LocalDate endDate) {
        return meditationRepository.findMeditationsByDateIsInAndStudent(studentId, startDate, endDate);
    }

    @Override
    public List<Meditation> getAllByStudentId(Long studentId) {
        return meditationRepository.findAllByStudentId(studentId);
    }

    public Iterable<Meditation> saveAll(List<Meditation> meditations) {
        return meditationRepository.saveAll(meditations);
    }

    @Override
    public boolean isNotExist(Meditation meditation) {
        Meditation meditations = meditationRepository.findByLocationAndTimeSlotAndDateAndStudentId(
                meditation.getLocation(), meditation.getTimeSlot(), meditation.getDate(), meditation.getStudent().getId());
        return meditations == null ? true : false;

    }
}
