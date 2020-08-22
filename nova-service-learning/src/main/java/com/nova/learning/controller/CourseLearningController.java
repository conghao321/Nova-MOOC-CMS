package com.nova.learning.controller;

import com.nova.api.learning.CourseLearningControllerApi;
import com.nova.framework.domain.learning.response.GetMediaResult;
import com.nova.learning.Service.LearningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @Author:conghao
 * @description:
 */
@RestController
@RequestMapping("/learning/course")
public class CourseLearningController implements CourseLearningControllerApi {

    @Autowired
    LearningService learningService;

    @Override
    @GetMapping("/getMedia/{courseId}/{teachplanId}")
    public GetMediaResult getMedia(@PathVariable("courseId") String courseId,
                                   @PathVariable("teachplanId")String teachplanId) {

        return learningService.getMedia(courseId,teachplanId);
    }
}
