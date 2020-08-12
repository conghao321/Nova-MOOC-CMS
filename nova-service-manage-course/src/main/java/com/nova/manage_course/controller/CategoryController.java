package com.nova.manage_course.controller;
/*
 * @Author:conghao
 * @description:
 */

import com.nova.api.course.CategoryControllerApi;
import com.nova.framework.domain.course.ext.CategoryNode;
import com.nova.manage_course.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController implements CategoryControllerApi {
    @Autowired
    CategoryService categoryService;


    @Override
    @GetMapping("/list")
    public CategoryNode findList() {
        return categoryService.findList();
    }
}