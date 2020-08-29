package com.nova.framework.domain.media;

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
public class MediaFileProcess_m3u8 extends MediaFileProcess {

    //ts列表
    private List<String> tslist;

}
