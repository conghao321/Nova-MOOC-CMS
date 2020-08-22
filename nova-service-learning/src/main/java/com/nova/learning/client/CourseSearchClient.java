package com.nova.learning.client;
/*
 * @Author:conghao
 * @description:
 */


import com.nova.framework.client.NovaServiceList;
import com.nova.framework.domain.course.TeachplanMediaPub;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value= NovaServiceList.NOVA_SERVICE_SEARCH)
public interface CourseSearchClient {

    //根据课程计划id查询课程媒资
    @GetMapping("/search/course/getMedia/{teachplanId}")
    public TeachplanMediaPub getMedia(@PathVariable("teachplanId") String teachplanId);
}
