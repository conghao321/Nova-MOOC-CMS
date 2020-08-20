package com.nova.api.course;

import com.nova.framework.domain.course.CourseBase;
import com.nova.framework.domain.course.CourseMarket;
import com.nova.framework.domain.course.Teachplan;
import com.nova.framework.domain.course.TeachplanMedia;
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
import org.springframework.web.bind.annotation.PathVariable;

/*
 * @Author:conghao
 * @description:
 */

@Api(value = "Course management Api, provides CRUD of course info.")
public interface CourseControllerApi {
    @ApiOperation("Query course plan")
    public TeachplanNode findTeachplanList(String courseId);

    @ApiOperation("Add course plan")
    public ResponseResult addTeachplanList(Teachplan teachplan);

    @ApiOperation("Query course's list")
    public QueryResponseResult<CourseInfo> findCourseList(
            int page,
            int size,
            CourseListRequest courseListRequest
    );

    @ApiOperation("Add course basic info")
    public AddCourseResult addCourseBase(CourseBase courseBase);

    @ApiOperation("Get course basic info")
    public CourseBase getCourseBaseById(String courseId) throws RuntimeException;


    @ApiOperation("Update course basic info")
    public ResponseResult updateCourseBase(String id, CourseBase courseBase);


    @ApiOperation("Get course's marketing info")
    public CourseMarket getCourseMarketById(String courseId);

    @ApiOperation("Update course's marketing info")
    public ResponseResult updateCourseMarket(String id,CourseMarket courseMarket);

    @ApiOperation("Query CourseView")
    public CourseView courseView(String id);

    @ApiOperation("Preview course")
    public CoursePublishResult preview(String id);

    @ApiOperation("Post course")
    public CoursePublishResult publish(@PathVariable String id);

    @ApiOperation("Save media-recourse info")
    public ResponseResult savemedia(TeachplanMedia teachplanMedia);
}
