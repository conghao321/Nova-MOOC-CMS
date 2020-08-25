package com.nova.manage_course.dao;

import com.nova.framework.domain.course.CoursePic;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * @Author:conghao
 * @description:
 */
public interface CoursePicRepository extends JpaRepository<CoursePic, String> {

    //删除成功返回1否则返回0
    long deleteByCourseid(String courseId);

}