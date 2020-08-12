package com.nova.manage_cms_client.dao;


import com.nova.framework.domain.cms.CmsPage;
import com.nova.framework.domain.cms.CmsSite;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CmsSiteRepository extends MongoRepository<CmsSite,String> {
    //根据页面名称查询
    CmsPage findByPageName(String pageName);
    //根据页面名称、站点Id、页面webpath查询
    CmsPage findByPageNameAndSiteIdAndPageWebPath(String pageName,String siteId,String pageWebPath);
}
