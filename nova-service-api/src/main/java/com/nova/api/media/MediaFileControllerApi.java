package com.nova.api.media;
/*
 * @Author:conghao
 * @description:
 */


import com.nova.framework.domain.course.TeachplanMedia;
import com.nova.framework.domain.media.MediaFile;
import com.nova.framework.domain.media.request.QueryMediaFileRequest;
import com.nova.framework.model.response.QueryResponseResult;
import com.nova.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Media File management",tags = {"Media File interface"})
public interface MediaFileControllerApi {

    @ApiOperation("My media-resources list")
    public QueryResponseResult<MediaFile> findList(int page, int size, QueryMediaFileRequest queryMediaFileRequest);


}
