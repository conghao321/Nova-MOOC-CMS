package com.nova.framework.domain.course.request;

import com.nova.framework.model.request.RequestData;
import lombok.Data;
import lombok.ToString;

/**
 * @Author: HaoCong
 * @Description:
 * @Modified By:
 */
@Data
@ToString
public class CourseListRequest extends RequestData {
    //公司Id
    private String companyId;
}
