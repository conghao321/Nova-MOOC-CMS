package com.nova.framework.domain.cms.response;

import com.nova.framework.domain.cms.CmsPage;
import com.nova.framework.model.response.ResponseResult;
import com.nova.framework.model.response.ResultCode;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by haocong.
 * The response of each cms page query.
 */
@Data
@NoArgsConstructor
public class CmsPageResult extends ResponseResult {
    CmsPage cmsPage;
    public CmsPageResult(ResultCode resultCode,CmsPage cmsPage) {
        super(resultCode);
        this.cmsPage = cmsPage;
    }
}
