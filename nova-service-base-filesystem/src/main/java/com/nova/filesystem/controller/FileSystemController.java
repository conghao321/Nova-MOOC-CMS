package com.nova.filesystem.controller;

import com.nova.filesystem.service.FileSystemService;
import com.nova.api.filesystem.FileSystemControllerApi;
import com.nova.framework.domain.filesystem.response.UploadFileResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Hao Cong
 * @date Aug2020
 * @version 1.0
 **/
@RestController
@RequestMapping("/filesystem")
public class FileSystemController implements FileSystemControllerApi {
    @Autowired
    FileSystemService fileSystemService;


    @Override
    @PostMapping("/upload")
    public UploadFileResult upload(MultipartFile multipartFile, String filetag, String businesskey, String metadata) {

        return fileSystemService.upload(multipartFile, filetag, businesskey, metadata);
    }
}
