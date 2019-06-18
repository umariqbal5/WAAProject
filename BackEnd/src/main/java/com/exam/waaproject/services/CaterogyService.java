package com.exam.waaproject.services;

import com.exam.waaproject.domain.Category;

import java.util.List;

public interface CaterogyService {
    public List<Category> getAll();
    public Category findById(Long id);
    public Category saveCategory(Category category);

    public List<Category> getAllbyName(String name);

}
