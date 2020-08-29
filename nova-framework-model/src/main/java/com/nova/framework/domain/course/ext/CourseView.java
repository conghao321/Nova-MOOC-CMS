package com.nova.framework.domain.course.ext;
/**
 * @Author: HaoCong
 * @Description:
 * @Modified By:
 */

import com.nova.framework.domain.course.CourseBase;
import com.nova.framework.domain.course.CourseMarket;
import com.nova.framework.domain.course.CoursePic;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@NoArgsConstructor
public class CourseView  implements Serializable {
    //basic info
    CourseBase courseBase;

    //marketing info
    CourseMarket courseMarket;

    //pictures
    CoursePic coursePic;

    //course plan
    TeachplanNode TeachplanNode;

}