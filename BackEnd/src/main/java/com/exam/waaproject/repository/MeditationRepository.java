package com.exam.waaproject.repository;

import com.exam.waaproject.domain.Meditation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

import java.util.List;

@Repository
public interface MeditationRepository extends CrudRepository<Meditation, Long> {

    @Query("Select m from Meditation m Where student_id = :studentId")
    public List<Meditation> findAllByStudentId(Long studentId);

    @Query("Select m from Meditation m Where student_id = :studentId and date between :startDate and :endDate")
    public List<Meditation> findMeditationsByDateIsInAndStudent(Long studentId, LocalDate startDate, LocalDate endDate);





    public Meditation findByLocationAndTimeSlotAndDateAndStudentId(String location, String timeSlot, LocalDate date, long studentId);

}
