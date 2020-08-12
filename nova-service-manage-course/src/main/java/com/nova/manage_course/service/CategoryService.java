package com.nova.manage_course.service;
/*
 * @Author:conghao
 * @description:
 */

import com.nova.framework.domain.course.ext.CategoryNode;
import com.nova.manage_course.dao.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    CategoryMapper categoryMapper; //查询分类

    public CategoryNode findList(){
        return categoryMapper.selectList(); }
}