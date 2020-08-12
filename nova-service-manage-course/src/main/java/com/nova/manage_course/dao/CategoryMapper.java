package com.nova.manage_course.dao;

import com.nova.framework.domain.course.ext.CategoryNode;
import org.apache.ibatis.annotations.Mapper;

/*
 * @Author:conghao
 * @description:
 */
@Mapper
public interface CategoryMapper {
    //查询分类
    public CategoryNode selectList();
}
