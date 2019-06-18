package com.exam.waaproject.repository;

import com.exam.waaproject.domain.Meditation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeditationRepository extends CrudRepository<Meditation, Long> {
}
