package com.nova.manage_course.controller;
/*
 * @Author:conghao
 * @description:
 */

import com.nova.api.course.CourseControllerApi;
import com.nova.framework.domain.course.CourseBase;
import com.nova.framework.domain.course.CourseMarket;
import com.nova.framework.domain.course.Teachplan;
import com.nova.framework.domain.course.ext.CourseInfo;
import com.nova.framework.domain.course.ext.CourseView;
import com.nova.framework.domain.course.ext.TeachplanNode;
import com.nova.framework.domain.course.request.CourseListRequest;
import com.nova.framework.domain.course.response.AddCourseResult;
import com.nova.framework.domain.course.response.CoursePublishResult;
import com.nova.framework.model.response.CommonCode;
import com.nova.framework.model.response.QueryResponseResult;
import com.nova.framework.model.response.ResponseResult;
import com.nova.manage_course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController implements CourseControllerApi {

    @Autowired
    CourseService courseService;

    @Override
    @GetMapping("/teachplan/list/{courseId}")
    public TeachplanNode findTeachplanList(@PathVariable("courseId") String courseId) {
        return courseService.findTeachplanList(courseId);
    }

    @Override
    @PostMapping("/teachplan/add")
    public ResponseResult addTeachplanList(@RequestBody Teachplan teachplan) {
        return courseService.addTeachplan(teachplan);
    }


    @Override
    @GetMapping("/coursebase/list/{page}/{size}")
    public QueryResponseResult<CourseInfo> findCourseList(
            @PathVariable("page") int page,
            @PathVariable("size") int size,
            CourseListRequest courseListRequest) {
        return courseService.findCourseList(page, size, courseListRequest);
    }

    @Override
    @PostMapping("/coursebase/add")
    public AddCourseResult addCourseBase(@RequestBody CourseBase courseBase) {
        return courseService.addCourseBase(courseBase);
    }

    @Override
    @GetMapping("/coursebase/get/{courseId}")
    public CourseBase getCourseBaseById(@PathVariable("courseId") String courseId) throws RuntimeException {
        return courseService.getCoursebaseById(courseId);
    }

    @Override
    @PutMapping("/coursebase/update/{id}")
    public ResponseResult updateCourseBase(@PathVariable("id") String id, @RequestBody CourseBase
            courseBase) {
        return courseService.updateCoursebase(id, courseBase);
    }

    @GetMapping("/coursemarket/get/{courseId}")
    public CourseMarket getCourseMarketById(@PathVariable("courseId") String courseId) { return courseService.getCourseMarketById(courseId);
    }

    @Override
    @PostMapping("/courseMarket/update/{id}")
    public ResponseResult updateCourseMarket(@PathVariable("id") String id, @RequestBody CourseMarket
            courseMarket) {
        CourseMarket courseMarket_u = courseService.updateCourseMarket(id, courseMarket);
        if(courseMarket_u!=null){
            return new ResponseResult(CommonCode.SUCCESS);
        }else{
            return new ResponseResult(CommonCode.FAIL);
        }
    }

    @Override
    @GetMapping("/courseview/{id}")
    public CourseView courseView(@PathVariable("id") String id) {

        return courseService.getCoruseView(id);
    }
    @Override
    @PostMapping("/preview/{id}")
    public CoursePublishResult preview(@PathVariable("id") String id) {

        return courseService.preview(id);
    }

}


