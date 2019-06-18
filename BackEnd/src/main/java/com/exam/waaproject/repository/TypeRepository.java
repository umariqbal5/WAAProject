package com.exam.waaproject.repository;

import com.exam.waaproject.domain.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends CrudRepository<Type , Long> {
}
