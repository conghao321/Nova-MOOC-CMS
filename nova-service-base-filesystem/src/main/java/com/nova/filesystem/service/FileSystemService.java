package com.nova.filesystem.service;

import com.alibaba.fastjson.JSON;
import com.nova.filesystem.dao.FileSystemRepository;
import com.nova.framework.domain.filesystem.FileSystem;
import com.nova.framework.domain.filesystem.response.FileSystemCode;
import com.nova.framework.domain.filesystem.response.UploadFileResult;
import com.nova.framework.exception.ExceptionCast;
import com.nova.framework.model.response.CommonCode;
import org.apache.commons.lang3.StringUtils;
import org.csource.fastdfs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @author hao cong
 * @date Aug2020
 * @version 1.0
 **/
@Service
public class FileSystemService {

    @Value("${nova.fastdfs.tracker_servers}")
    String tracker_servers;
    @Value("${nova.fastdfs.connect_timeout_in_seconds}")
    int connect_timeout_in_seconds;
    @Value("${nova.fastdfs.network_timeout_in_seconds}")
    int network_timeout_in_seconds;
    @Value("${nova.fastdfs.charset}")
    String charset;

    @Autowired
    FileSystemRepository fileSystemRepository;

    //上传文件
    public UploadFileResult upload( MultipartFile multipartFile,
                                   String filetag,
                                   String businesskey,
                                   String metadata){
        if(multipartFile ==null){
            ExceptionCast.cast(FileSystemCode.FS_UPLOADFILE_FILEISNULL);
        }
        //第一步：将文件上传到fastDFS中，得到一个文件id
        String fileId = fdfs_upload(multipartFile);
        if(StringUtils.isEmpty(fileId)){
            ExceptionCast.cast(FileSystemCode.FS_UPLOADFILE_SERVERFAIL);
        }
        //第二步：将文件id及其它文件信息存储到mongodb中。
        FileSystem fileSystem = new FileSystem();
        fileSystem.setFileId(fileId);
        fileSystem.setFilePath(fileId);
        fileSystem.setFiletag(filetag);
        fileSystem.setBusinesskey(businesskey);
        fileSystem.setFileName(multipartFile.getOriginalFilename());
        fileSystem.setFileType(multipartFile.getContentType());
        if(StringUtils.isNotEmpty(metadata)){
            try {
                Map map = JSON.parseObject(metadata, Map.class);
                fileSystem.setMetadata(map);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        fileSystemRepository.save(fileSystem);
        return new UploadFileResult(CommonCode.SUCCESS,fileSystem);
    }

    //上传文件到fastDFS

    /**
     *
     * @param multipartFile 文件
     * @return 文件id
     */
    private String fdfs_upload(MultipartFile multipartFile){
         //初始化fastDFS的环境
         initFdfsConfig();
         //创建trackerClient
        TrackerClient trackerClient = new TrackerClient();
        try {
            TrackerServer trackerServer = trackerClient.getConnection();
            //得到storage服务器

            StorageServer storeStorage = trackerClient.getStoreStorage(trackerServer);
            //创建storageClient来上传文件
            StorageClient1 storageClient1 = new StorageClient1(trackerServer,storeStorage);
            //上传文件
            //得到文件字节
            byte[] bytes = multipartFile.getBytes();
            //得到文件的原始名称
            String originalFilename = multipartFile.getOriginalFilename();
            //得到文件扩展名
            String ext = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            String fileId = storageClient1.upload_file1(bytes, ext, null);
            return fileId;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //初始化fastDFS环境
    private void initFdfsConfig(){
        //初始化tracker服务地址（多个tracker中间以半角逗号分隔）
        try {
            ClientGlobal.initByTrackers(tracker_servers);
            ClientGlobal.setG_charset(charset);
            ClientGlobal.setG_network_timeout(network_timeout_in_seconds);
            ClientGlobal.setG_connect_timeout(connect_timeout_in_seconds);
        } catch (Exception e) {
            e.printStackTrace();
            //抛出异常
            ExceptionCast.cast(FileSystemCode.FS_INITFDFSERROR);
        }
    }
}
