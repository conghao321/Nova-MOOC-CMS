package com.nova.manage_cms_client.dao;


import com.nova.framework.domain.cms.CmsPage;
import com.nova.framework.domain.cms.CmsSite;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CmsSiteRepository extends MongoRepository<CmsSite,String> {

}
