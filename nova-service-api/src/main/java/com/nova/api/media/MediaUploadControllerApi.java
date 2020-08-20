package com.nova.api.media;

import com.nova.framework.domain.media.response.CheckChunkResult;
import com.nova.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;

/*
 * @Author:conghao
 * @description:
 */
@Api(value = "Media resource management interface")
public interface MediaUploadControllerApi {

    @ApiOperation("uploadFile and Register")
    public ResponseResult register(String fileMd5,
                                   String fileName,
                                   Long fileSize,
                                   String mimetype,
                                   String fileExt);

    @ApiOperation("Chunk's check")
    public CheckChunkResult checkChunk(String fileMd5,
                                       Integer chunk,
                                       Integer chunkSize);

    @ApiOperation("uploadFile")
    public ResponseResult uploadChunk(MultipartFile file,
                                      String fileMd5,
                                      Integer chunk
                                      );


    @ApiOperation("merge File")
    public ResponseResult mergeChunks(String fileMd5,
                                      String fileName,
                                      Long fileSize,
                                      String mimetype,
                                      String fileExt);

}
