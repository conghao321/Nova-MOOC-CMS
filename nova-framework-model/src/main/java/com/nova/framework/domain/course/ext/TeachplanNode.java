package com.nova.framework.domain.course.ext;

import com.nova.framework.domain.course.Teachplan;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * Created by admin by hao cong on 2020/6/7
 */
@Data
@ToString
public class TeachplanNode extends Teachplan {

    List<TeachplanNode> children;

}
