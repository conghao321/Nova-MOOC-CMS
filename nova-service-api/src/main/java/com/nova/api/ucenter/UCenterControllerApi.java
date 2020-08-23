package com.nova.api.ucenter;
/*
 * @Author:conghao
 * @description:
 */

import com.nova.framework.domain.ucenter.ext.NovaUserExt;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "User Center")
public interface UCenterControllerApi {

    @ApiOperation("Query by user info")
    public NovaUserExt getUserExt(String username);
}
