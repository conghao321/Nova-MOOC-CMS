package com.nova.learning.Service;
/*
 * @Author:conghao
 * @description:
 */

import com.nova.framework.domain.course.TeachplanMediaPub;
import com.nova.framework.domain.learning.response.GetMediaResult;
import com.nova.framework.domain.learning.response.LearningCode;
import com.nova.framework.exception.ExceptionCast;
import com.nova.framework.model.response.CommonCode;
import com.nova.learning.client.CourseSearchClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class LearningService {

    @Autowired
    CourseSearchClient courseSearchClient;

    //获取课程学习地址（视频播放地址）
    public GetMediaResult getMedia(String courseId, String teachplanId) {
        //校验学生的学生权限...
        //远程调用搜索服务查询课程计划所对应的课程媒资信息
        TeachplanMediaPub teachplanMediaPub = courseSearchClient.getMedia(teachplanId);
        if(teachplanMediaPub == null || StringUtils.isEmpty(teachplanMediaPub.getMediaUrl())){
            //获取学习地址错误
            ExceptionCast.cast(LearningCode.LEARNING_GETMEDIA_ERROR);
        }
        return new GetMediaResult(CommonCode.SUCCESS,teachplanMediaPub.getMediaUrl());
    }
}
