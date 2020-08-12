package com.nova.framework.domain.course.ext;

import com.nova.framework.domain.course.Category;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * Created by admin by hao cong on 2020/6/7
 */
@Data
@ToString
public class CategoryParameter extends Category {

    //二级分类ids
    List<String> bIds;
    //三级分类ids
    List<String> cIds;

}
