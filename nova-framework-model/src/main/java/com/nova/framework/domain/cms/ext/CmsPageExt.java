package com.nova.framework.domain.cms.ext;

import com.nova.framework.domain.cms.CmsPage;
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
public class CmsPageExt extends CmsPage {
    private String htmlValue;

}
