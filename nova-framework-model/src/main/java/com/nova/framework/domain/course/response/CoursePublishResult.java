package com.nova.framework.domain.course.response;
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
public class CoursePublishResult extends ResponseResult {
    String previewUrl;
    public CoursePublishResult(ResultCode resultCode, String previewUrl) {
        super(resultCode);
        this.previewUrl = previewUrl; }
}