package com.nova.api.course;
/*
 * @Author:conghao
 * @description:
 */

import com.nova.framework.domain.course.ext.CategoryNode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(value = "课程分类管理",tags = {"课程分类管理"})
public interface CategoryControllerApi {
    @ApiOperation("查询分类")
    public CategoryNode findList();
}
