package com.nova.framework.domain.ucenter.ext;

import com.nova.framework.domain.ucenter.NovaMenu;
import com.nova.framework.domain.ucenter.NovaUser;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * Created by admin on 2020/3/20.
 */
@Data
@ToString
public class NovaUserExt extends NovaUser {

    //权限信息
    private List<NovaMenu> permissions;

    //企业信息
    private String companyId;
}
