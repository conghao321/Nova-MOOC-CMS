package com.nova.manage_cms.dao;
/*
 * @Author:conghao
 * @description:
 */

import com.nova.framework.domain.system.SysDictionary;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SysDictionaryDao extends MongoRepository<SysDictionary,String> {

    //根据字典分类查询字典信息
    SysDictionary findBydType(String dType);
}
