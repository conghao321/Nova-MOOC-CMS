package com.nova.manage_course.dao;

import com.nova.framework.domain.course.TeachplanMedia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
 * @Author:conghao
 * @description:
 */
public interface TeachplanMediaRepository extends JpaRepository<TeachplanMedia,String> {
    //根据课程id查询列表
    List<TeachplanMedia> findByCourseId(String courseId);
}
