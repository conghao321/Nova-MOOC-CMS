package com.nova.manage_cms.controller;

import com.nova.framework.web.BaseController;
import com.nova.manage_cms.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletOutputStream;
import java.io.IOException;

/**
 * @author Administrator
 * @version 1.0
 * @create 2018-09-15 16:20
 **/
@Controller
public class CmsPagePreviewController extends BaseController {

    @Autowired
    PageService pageService;

    //页面预览
    @RequestMapping(value="/cms/preview/{pageId}",method = RequestMethod.GET)
    public void preview(@PathVariable("pageId") String pageId) throws IOException {
        //执行静态化
        String pageHtml = pageService.getPageHtml(pageId);
        //通过response对象将内容输出
        ServletOutputStream outputStream = response.getOutputStream();
        //ssi tag, to preview and show html page
        response.setHeader("Content‐type","text/html;charset=utf‐8");
        outputStream.write(pageHtml.getBytes("utf-8"));

    }
}
