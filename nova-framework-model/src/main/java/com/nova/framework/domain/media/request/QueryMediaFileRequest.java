package com.nova.framework.domain.media.request;

import com.nova.framework.model.request.RequestData;
import lombok.Data;
/**
 * @Author: HaoCong
 * @Description:
 * @Modified By:
 */

@Data
public class QueryMediaFileRequest extends RequestData {

    private String fileOriginalName;
    private String processStatus;
    private String tag;
}
