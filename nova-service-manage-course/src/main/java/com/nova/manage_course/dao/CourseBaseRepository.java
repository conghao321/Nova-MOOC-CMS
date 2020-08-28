package com.nova.manage_course.dao;

import com.nova.framework.domain.course.CourseBase;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Hao Cong.
 */
public interface CourseBaseRepository extends JpaRepository<CourseBase,String> {
}
