package com.nova.manage_cms.dao;


import com.nova.framework.domain.cms.CmsConfig;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CmsConfigRepository extends MongoRepository<CmsConfig,String> {
}
