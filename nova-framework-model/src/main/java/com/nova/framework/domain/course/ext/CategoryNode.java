package com.nova.framework.domain.course.ext;

import com.nova.framework.domain.course.Category;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Author: HaoCong
 * @Description:
 * @Date:Created in 2020/1/24 10:04.
 * @Modified By:
 */
@Data
@ToString
public class CategoryNode extends Category {

    List<CategoryNode> children;

}
