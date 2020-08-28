package com.nova.manage_course.dao;

import com.github.pagehelper.Page;
import com.nova.framework.domain.course.CourseBase;
import com.nova.framework.domain.course.ext.CourseInfo;
import com.nova.framework.domain.course.request.CourseListRequest;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Hao Cong.
 */
@Mapper
public interface CourseMapper {
   CourseBase findCourseBaseById(String id);
   Page<CourseBase> findCourseList();
   Page<CourseInfo> findCourseListPage(CourseListRequest courseListRequest);
}
