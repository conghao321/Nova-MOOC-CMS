package com.nova.api.filesystem;
/*
 * @Author:conghao
 * @description:
 */


import com.nova.framework.domain.filesystem.response.UploadFileResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;

@Api(value="File Management")
public interface FileSystemControllerApi {

    //上传文件
    @ApiOperation("upload file")
    public UploadFileResult upload(MultipartFile multipartFile,
                                   String fileTag,
                                   String businessKey,
                                   String metadata);
}