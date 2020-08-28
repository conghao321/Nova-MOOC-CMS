package com.nova.manage_media.controller;
/*
 * @Author:conghao
 * @description:
 */


import com.nova.api.media.MediaFileControllerApi;
import com.nova.framework.domain.media.MediaFile;
import com.nova.framework.domain.media.request.QueryMediaFileRequest;
import com.nova.framework.model.response.QueryResponseResult;
import com.nova.manage_media.service.MediaFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/media/file")
public class MediaFileController implements MediaFileControllerApi {
    @Autowired
    MediaFileService mediaFileService;

    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult<MediaFile> findList(int page, int size, QueryMediaFileRequest queryMediaFileRequest) {
        return mediaFileService.findList(page,size,queryMediaFileRequest);
    }
    
}
