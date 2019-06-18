package com.exam.waaproject.repository;

import com.exam.waaproject.domain.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {


    @Query("Select c from Category c Where name like %:name%")
    public List<Category> findByName(String name);
}
