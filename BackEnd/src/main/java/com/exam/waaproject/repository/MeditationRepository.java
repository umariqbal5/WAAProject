package com.exam.waaproject.repository;

import com.exam.waaproject.domain.Meditation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface MeditationRepository extends CrudRepository<Meditation, Long> {
    public Meditation findByLocationAndTimeSlotAndDateAndStudentId(String location, String timeSlot, LocalDate date, long studentId);
}
