package com.nova.api.learning;

/*
 * @Author:conghao
 * @description:
 */

import com.nova.framework.domain.learning.response.GetMediaResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Record management")
public interface CourseLearningControllerApi {

    @ApiOperation("Retrieve the record")
    public GetMediaResult getMedia(String courseId, String teachplanId);
}