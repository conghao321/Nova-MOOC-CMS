package com.nova.manage_course.dao;
/*
 * @Author:conghao
 * @description: define a mapper class to retrieve course plan
 */

import com.nova.framework.domain.course.ext.TeachplanNode;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeachplanMapper {
    //课程计划查询
    public TeachplanNode selectList(String courseId);
}
