package com.nova.auth.client;

import com.nova.framework.client.NovaServiceList;
import com.nova.framework.domain.ucenter.ext.NovaUserExt;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = NovaServiceList.NOVA_SERVICE_UCENTER)
public interface UserClient {
    //根据账号查询用户信息
    @GetMapping("/ucenter/getUserExt")
    public NovaUserExt getUserExt(@RequestParam("username") String username);
}
