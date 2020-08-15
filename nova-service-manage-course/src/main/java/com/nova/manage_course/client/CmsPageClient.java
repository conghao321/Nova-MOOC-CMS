package com.nova.manage_course.client;
/*
 * @Author:conghao
 * @description:
 */

import com.nova.framework.client.NovaServiceList;
import com.nova.framework.domain.cms.CmsPage;
import com.nova.framework.domain.cms.response.CmsPageResult;
import com.nova.framework.domain.cms.response.CmsPostPageResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "NOVA-SERVICE-MANAGE-CMS")
public interface CmsPageClient {
    //find cms page
    @GetMapping("/cms/page/get/{id}")
    public CmsPage findCmsPageById(@PathVariable("id") String id);

    //save page
    @PostMapping("/cms/page/save")
    public CmsPageResult save(@RequestBody CmsPage cmsPage);

    //hot-key to post page.
    @PostMapping("/cms/page/postPageQuick")
    public CmsPostPageResult postPageQuick(CmsPage cmsPage);


}