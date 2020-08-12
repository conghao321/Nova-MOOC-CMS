package com.nova.manage_cms.service;
/*
 * @Author:conghao
 * @description:
 */

import com.nova.framework.domain.system.SysDictionary;
import com.nova.manage_cms.dao.SysDictionaryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysdictionaryService {
    @Autowired
    SysDictionaryDao sysDictionaryDao;

    //根据字典分类type查询字典信息
    public SysDictionary findDictionaryByType(String type) {
        return sysDictionaryDao.findBydType(type);
    }
}
