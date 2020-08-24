package com.nova.auth.service;

import com.nova.auth.client.UserClient;
import com.nova.framework.domain.ucenter.NovaMenu;
import com.nova.framework.domain.ucenter.ext.NovaUserExt;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    ClientDetailsService clientDetailsService;

    @Autowired
    UserClient userClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //取出身份，如果身份为空说明没有认证
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //没有认证统一采用httpbasic认证，httpbasic中存储了client_id和client_secret，开始认证client_id和client_secret
        if(authentication==null){
            ClientDetails clientDetails = clientDetailsService.loadClientByClientId(username);
            if(clientDetails!=null){
                //密码
                String clientSecret = clientDetails.getClientSecret();
                return new User(username,clientSecret,AuthorityUtils.commaSeparatedStringToAuthorityList(""));
            }
        }
        if (StringUtils.isEmpty(username)) {
            return null;
        }

        //远程调用用户中心根据账号查询用户信息
        NovaUserExt userExt = userClient.getUserExt(username);
        if(userExt == null){
            //返回空给spring security表示用户不存在
            return null;
        }

        String password = userExt.getPassword();
        //用户权限，这里暂时使用静态数据，最终会从数据库读取
        //从数据库获取权限
        List<NovaMenu> permissions = userExt.getPermissions();
        if(permissions == null){
            permissions = new ArrayList<>();
        }
        List<String> user_permission = new ArrayList<>();
        permissions.forEach(item-> user_permission.add(item.getCode()));
        String user_permission_string  = StringUtils.join(user_permission.toArray(), ",");
        UserJwt userDetails = new UserJwt(username,
                password,
                AuthorityUtils.commaSeparatedStringToAuthorityList(user_permission_string));
        userDetails.setId(userExt.getId());
        //用户类型
        userDetails.setUtype(userExt.getUtype());
        userDetails.setCompanyId(userExt.getCompanyId());
        userDetails.setName(userExt.getName());
        // 用户头像
        userDetails.setUserpic(userExt.getUserpic());
        return userDetails;
    }
}
