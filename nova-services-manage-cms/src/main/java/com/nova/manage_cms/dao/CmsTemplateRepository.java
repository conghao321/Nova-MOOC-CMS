package com.nova.manage_cms.dao;


import com.nova.framework.domain.cms.CmsTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CmsTemplateRepository extends MongoRepository<CmsTemplate,String> {
}
