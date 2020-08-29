package com.nova.framework.domain.course.ext;

import com.nova.framework.domain.course.Teachplan;
import lombok.Data;
import lombok.ToString;

/**
 * @Author: HaoCong
 * @Description:
 * @Modified By:
 */
@Data
@ToString
public class TeachplanExt extends Teachplan {

    //媒资文件id
    private String mediaId;

    //媒资文件原始名称
    private String mediaFileOriginalName;

    //媒资文件访问地址
    private String mediaUrl;
}
