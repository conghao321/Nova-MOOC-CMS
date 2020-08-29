package com.nova.framework.domain.cms;

import lombok.Data;
import lombok.ToString;

import java.util.Map;

/**
 * @Author: HaoCong
 * @Description:
 * @Date:Created in 2020/1/24 10:04.
 * @Modified By:
 */
@Data
@ToString
public class CmsConfigModel {
    private String key;
    private String name;
    private String url;
    private Map mapValue;
    private String value;

}
