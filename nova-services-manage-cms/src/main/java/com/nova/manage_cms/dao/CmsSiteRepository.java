package com.nova.manage_cms.dao;

import com.nova.framework.domain.cms.CmsSite;
import org.springframework.data.mongodb.repository.MongoRepository;

/*
 * @Author:conghao
 * @description:
 */
public interface CmsSiteRepository extends MongoRepository<CmsSite,String> {
}
