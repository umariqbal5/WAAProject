package com.exam.waaproject.controller;

import com.exam.waaproject.domain.Block;
import com.exam.waaproject.domain.Category;
import com.exam.waaproject.services.BlockService;
import com.exam.waaproject.services.CaterogyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AttendanceReportController {

    @Autowired
    BlockService blockService;

    @Autowired
    CaterogyService caterogyService;

    @GetMapping("/api/get/blocks")
    public List<Block> getBlocks() {
        return blockService.getAll();
    }

    @GetMapping("/api/get/categories")
    public List<Category> getCategories() {
        return caterogyService.getAll();
    }



}
