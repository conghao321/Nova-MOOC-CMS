package com.nova.ucenter.dao;

import com.nova.framework.domain.ucenter.NovaUser;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * @Author:conghao
 * @description:
 */
public interface NovaUserRepository extends JpaRepository<NovaUser,String> {
    //根据账号查询用户信息
    NovaUser findByUsername(String username);
}
