package com.nova.ucenter.dao;
/*
 * @Author:conghao
 * @description:
 */

import com.nova.framework.domain.ucenter.NovaCompanyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NovaCompanyUserRepository extends JpaRepository<NovaCompanyUser,String> {
    //根据用户id查询该用户所属的公司id
    NovaCompanyUser findByUserId(String userId);
}