package com.exam.waaproject.controller;

import com.exam.waaproject.domain.Category;
import com.exam.waaproject.services.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserApiController {
    @Autowired
    private CategoryServiceImpl service;

    @PostMapping("/api/post")
    public Category SaveCategory(@Valid @RequestBody Category category){
        service.saveCategory(category);
        return category;
    }
}
