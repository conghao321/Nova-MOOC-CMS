package com.nova.ucenter.controller;
/*
 * @Author:conghao
 * @description:
 */

import com.nova.api.ucenter.UCenterControllerApi;
import com.nova.framework.domain.ucenter.ext.NovaUserExt;
import com.nova.ucenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ucenter")
public class UCenterController implements UCenterControllerApi {
    @Autowired
    UserService userService;

    @Override
    @GetMapping("/getUserExt")
    public NovaUserExt getUserExt(@RequestParam("username") String username) {
        return userService.getUserExt(username);
    }
}
