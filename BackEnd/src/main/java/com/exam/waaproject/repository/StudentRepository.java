package com.exam.waaproject.repository;

import com.exam.waaproject.domain.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {


    public List<Student> findAll();

    @Query("Select s from Student s Where entryBlockId <= :blockId")
    public List<Student> findStudentsByEntryBlockId(Long blockId);

    @Query(value = "SELECT S.NAME, COUNT(M.*)  \"TOTAL MEDITATIONS OF CURRENT MONTH\" FROM STUDENT AS S JOIN MEDITATION AS M ON S.ID = M.STUDENT_ID WHERE M.DATE BETWEEN ?1 AND ?2  GROUP BY (S.NAME)\n", nativeQuery = true)
    public List<String> findAllByBlockInSelect(String startDate, String endDate);


    public Student findByRegistrationNumber(String registrationNumber);

}
