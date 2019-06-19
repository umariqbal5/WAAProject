package com.exam.waaproject.services;

import com.exam.waaproject.domain.Meditation;

import java.time.LocalDate;
import java.util.List;

public interface MeditationService {
    public Meditation save(Meditation record);

    public List<Meditation> getAllByStudentIdAndStartDateEndDate(long studentId, LocalDate startDate, LocalDate endDate);

    public List<Meditation> getAllByStudentId(Long studentId);
}
