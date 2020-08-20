package com.nova.manage_course.dao;

import com.nova.framework.domain.course.TeachplanMediaPub;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * @Author:conghao
 * @description:
 */
public interface TeachplanMediaPubRepository extends JpaRepository<TeachplanMediaPub,String> {
    //根据课程id删除记录
    long deleteByCourseId(String courseId);
}