package com.nova.api.course;

import com.nova.framework.domain.course.CourseBase;
import com.nova.framework.domain.course.CourseMarket;
import com.nova.framework.domain.course.Teachplan;
import com.nova.framework.domain.course.ext.CourseInfo;
import com.nova.framework.domain.course.ext.CourseView;
import com.nova.framework.domain.course.ext.TeachplanNode;
import com.nova.framework.domain.course.request.CourseListRequest;
import com.nova.framework.domain.course.response.AddCourseResult;
import com.nova.framework.domain.course.response.CoursePublishResult;
import com.nova.framework.model.response.QueryResponseResult;
import com.nova.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/*
 * @Author:conghao
 * @description:
 */

@Api(value = "课程管理接口,提供课程的增删改查")
public interface CourseControllerApi {
    @ApiOperation("课程计划查询")
    public TeachplanNode findTeachplanList(String courseId);

    @ApiOperation("添加课程计划")
    public ResponseResult addTeachplanList(Teachplan teachplan);

    @ApiOperation("查询我的课程列表")
    public QueryResponseResult<CourseInfo> findCourseList(
            int page,
            int size,
            CourseListRequest courseListRequest
    );

    @ApiOperation("添加课程基础信息")
    public AddCourseResult addCourseBase(CourseBase courseBase);

    @ApiOperation("获取课程基础信息")
    public CourseBase getCourseBaseById(String courseId) throws RuntimeException;


    @ApiOperation("更新课程基础信息")
    public ResponseResult updateCourseBase(String id, CourseBase courseBase);


    @ApiOperation("获取课程营销信息")
    public CourseMarket getCourseMarketById(String courseId);

    @ApiOperation("更新课程营销信息")
    public ResponseResult updateCourseMarket(String id,CourseMarket courseMarket);

    @ApiOperation("课程视图查询")
    public CourseView courseView(String id);

    @ApiOperation("预览课程")
    public CoursePublishResult preview(String id);
}
