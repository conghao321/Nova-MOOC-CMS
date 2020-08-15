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

@Api(value = "Course Category Management",tags = {"Course Category Management"})
public interface CategoryControllerApi {
    @ApiOperation("Query course category")
    public CategoryNode findList();
}
