package com.nova.framework.domain.course.ext;

import com.nova.framework.domain.course.Teachplan;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Author: HaoCong
 * @Description:
 * @Modified By:
 */
@Data
@ToString
public class TeachplanParameter extends Teachplan {

    //二级分类ids
    List<String> bIds;
    //三级分类ids
    List<String> cIds;

}
