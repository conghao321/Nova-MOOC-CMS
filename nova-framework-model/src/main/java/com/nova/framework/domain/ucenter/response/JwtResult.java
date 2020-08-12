package com.nova.framework.domain.ucenter.response;

import com.nova.framework.model.response.ResponseResult;
import com.nova.framework.model.response.ResultCode;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by mrt on 2018/5/21.
 */
@Data
@ToString
@NoArgsConstructor
public class JwtResult extends ResponseResult {
    public JwtResult(ResultCode resultCode, String jwt) {
        super(resultCode);
        this.jwt = jwt;
    }
    private String jwt;
}
