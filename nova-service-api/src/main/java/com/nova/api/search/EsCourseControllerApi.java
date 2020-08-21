package com.nova.api.search;
/*
 * @Author:conghao
 * @description:
 */

import com.nova.framework.domain.course.CoursePub;
import com.nova.framework.domain.course.TeachplanMediaPub;
import com.nova.framework.domain.search.CourseSearchParam;
import com.nova.framework.model.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.io.IOException;
import java.util.Map;

@Api(value = "Search course",tags = {"Search Course"})
public interface EsCourseControllerApi {
    @ApiOperation("Search course")
    public QueryResponseResult<CoursePub> list(int page, int size, CourseSearchParam courseSearchParam) throws IOException;

    //based on indices of course....
    @ApiOperation("Find course info by id")
    public Map<String,CoursePub> getAll(String id);

    @ApiOperation("Get media info by teachplan")
    public TeachplanMediaPub getMedia(String teachplanId);
}
