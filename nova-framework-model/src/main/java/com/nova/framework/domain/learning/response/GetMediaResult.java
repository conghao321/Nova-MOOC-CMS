package com.nova.framework.domain.learning.response;
/*
 * @Author:conghao
 * @description:
 */

import com.nova.framework.model.response.ResponseResult;
import com.nova.framework.model.response.ResultCode;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class GetMediaResult extends ResponseResult {
    //视频播放地址
    String fileUrl;
    public GetMediaResult(ResultCode resultCode, String fileUrl){
        super(resultCode);
        this.fileUrl = fileUrl;
    }
}

