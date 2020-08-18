package com.nova.search.controller;
/*
 * @Author:conghao
 * @description:
 */

import com.nova.api.search.EsCourseControllerApi;
import com.nova.framework.domain.course.CoursePub;
import com.nova.framework.domain.search.CourseSearchParam;
import com.nova.framework.model.response.QueryResponseResult;
import com.nova.search.service.EsCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@SuppressWarnings("ALL")
@RestController
public class EsCourseController implements EsCourseControllerApi {

    @Autowired
    EsCourseService esCourseService;

    @Override
    public QueryResponseResult<CoursePub> list(int page, int size, CourseSearchParam courseSearchParam) throws IOException {
        return esCourseService.list(page,size,courseSearchParam);
    }
}
