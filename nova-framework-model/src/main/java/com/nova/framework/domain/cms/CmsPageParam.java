package com.nova.framework.domain.cms;

import lombok.Data;
import lombok.ToString;

/**
 * @Author: haocong.
 * @Description:
 * @Date:Created in 2020/1/24 10:04.
 * @Modified By:
 */
@Data
@ToString
public class CmsPageParam {
   //参数名称
    private String pageParamName;
    //参数值
    private String pageParamValue;

}
