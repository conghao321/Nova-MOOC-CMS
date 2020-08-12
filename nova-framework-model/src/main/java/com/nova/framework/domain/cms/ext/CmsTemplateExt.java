package com.nova.framework.domain.cms.ext;

import com.nova.framework.domain.cms.CmsTemplate;
import lombok.Data;
import lombok.ToString;

/**
 * @Author: mrt.
 * @Description:
 * @Date:Created in 2018/1/24 10:04.
 * @Modified By:
 */
@Data
@ToString
public class CmsTemplateExt extends CmsTemplate {

    //模版内容
    private String templateValue;

}
