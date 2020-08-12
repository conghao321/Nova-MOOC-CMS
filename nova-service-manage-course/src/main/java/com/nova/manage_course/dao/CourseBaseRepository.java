package com.nova.manage_course.dao;

import com.nova.framework.domain.course.CourseBase;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator.
 */
public interface CourseBaseRepository extends JpaRepository<CourseBase,String> {
}
