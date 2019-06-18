package com.exam.waaproject.services;

import com.exam.waaproject.domain.Category;
import com.exam.waaproject.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CaterogyService {
    @Autowired
    public CategoryRepository categoryRepository;


    @Override
    public List<Category> getAll() {
        return (List<Category>)categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return (Category)categoryRepository.findById(id).get();
    }

    @Override
    public Category saveCategory(Category category) {
        return (Category) categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllbyName(String name) {
        return categoryRepository.findByName(name);
    }
}
