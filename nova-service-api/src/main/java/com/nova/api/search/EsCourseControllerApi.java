package com.nova.api.search;
/*
 * @Author:conghao
 * @description:
 */

import com.nova.framework.domain.course.CoursePub;
import com.nova.framework.domain.search.CourseSearchParam;
import com.nova.framework.model.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.io.IOException;

@Api(value = "Search course",tags = {"Search Course"})
public interface EsCourseControllerApi {
    @ApiOperation("Search course")
    public QueryResponseResult<CoursePub> list(int page, int size, CourseSearchParam courseSearchParam) throws IOException;
}
