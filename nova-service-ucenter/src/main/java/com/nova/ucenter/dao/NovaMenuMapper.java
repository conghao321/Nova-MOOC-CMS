package com.nova.ucenter.dao;

import com.nova.framework.domain.ucenter.NovaMenu;

import java.util.List;

/*
 * @Author:conghao
 * @description:
 */
public interface NovaMenuMapper {
    //根据用户id查询用户的权限
    public List<NovaMenu> selectPermissionByUserId(String userId);
}
