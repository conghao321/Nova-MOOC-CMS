package com.nova.api.auth;

import com.nova.framework.domain.ucenter.request.LoginRequest;
import com.nova.framework.domain.ucenter.response.JwtResult;
import com.nova.framework.domain.ucenter.response.LoginResult;
import com.nova.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/*
 * @Author:conghao
 * @description:
 */
@Api(value = "User Authentication")
public interface AuthControllerApi {
    @ApiOperation("Login")
    public LoginResult login(LoginRequest loginRequest);

    @ApiOperation("Log out")
    public ResponseResult logout();

    @ApiOperation("Query user's JWT")
    public JwtResult userJwt();
}
