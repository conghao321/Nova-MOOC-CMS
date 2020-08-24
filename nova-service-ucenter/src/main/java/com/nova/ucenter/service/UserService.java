package com.nova.ucenter.service;
/*
 * @Author:conghao
 * @description:
 */

import com.nova.framework.domain.ucenter.NovaCompanyUser;
import com.nova.framework.domain.ucenter.NovaMenu;
import com.nova.framework.domain.ucenter.NovaUser;
import com.nova.framework.domain.ucenter.ext.NovaUserExt;
import com.nova.ucenter.dao.NovaCompanyUserRepository;
import com.nova.ucenter.dao.NovaMenuMapper;
import com.nova.ucenter.dao.NovaUserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    NovaUserRepository novaUserRepository;

    @Autowired
    NovaCompanyUserRepository novaCompanyUserRepository;

    @Autowired
    NovaMenuMapper novaMenuMapper;


    //根据账号查询xcUser信息
    public NovaUser findXcUserByUsername(String username){
        return novaUserRepository.findByUsername(username);
    }

    //根据账号查询用户信息
    public NovaUserExt getUserExt(String username){
        //根据账号查询xcUser信息
        NovaUser novaUser = this.findXcUserByUsername(username);
        if(novaUser == null){
            return null;
        }
        //用户id
        String userId = novaUser.getId();
        List<NovaMenu> novaMenus = novaMenuMapper.selectPermissionByUserId(userId);
        //根据用户id查询用户所属公司id
        NovaCompanyUser novaCompanyUser = novaCompanyUserRepository.findByUserId(userId);
        //取到用户的公司id
        String companyId = null;
        if(novaCompanyUser!=null){
            companyId = novaCompanyUser.getCompanyId();
        }
        NovaUserExt novaUserExt = new NovaUserExt();
        BeanUtils.copyProperties(novaUser,novaUserExt);
        novaUserExt.setCompanyId(companyId);
        novaUserExt.setPermissions(novaMenus);
        return novaUserExt;
    }
}
