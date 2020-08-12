package com.nova.manage_cms.dao;
/*
 * @Author:conghao
 * @description:
 */

import com.nova.framework.domain.cms.CmsPage;
import com.nova.manage_cms.service.PageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PageServiceTest {

    @Autowired
    PageService pageService;

    @Test
    public void testGetPageHtml(){
        String html=pageService.getPageHtml("5f228e9b3f05fe82005bdbca");
        System.out.println(html);
    }



}
