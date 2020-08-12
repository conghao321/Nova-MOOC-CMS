package com.nova.manage_course.dao;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nova.framework.domain.cms.CmsPage;
import com.nova.framework.domain.course.CourseBase;
import com.nova.framework.domain.course.ext.CourseInfo;
import com.nova.framework.domain.course.ext.TeachplanNode;
import com.nova.framework.domain.course.request.CourseListRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author haocong
 * @version 1.0
 * @descrpition: unit-test for jdbc,druid
 **/
@SuppressWarnings("ALL")
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestDao {
    
    @Autowired
    TeachplanMapper teachplanMapper;

    @Autowired
    CourseBaseRepository courseBaseRepository;
    @Autowired
    CourseMapper courseMapper;

    @Autowired
    RestTemplate restTemplate;

    @Test
    public void testCourseBaseRepository() {
        Optional<CourseBase> optional = courseBaseRepository.findById("402885816240d276016240f7e5000002");
        if (optional.isPresent()) {
            CourseBase courseBase = optional.get();
            System.out.println(courseBase);
        }
    }

    @Test
    public void testCourseMapper() {
        CourseBase courseBase = courseMapper.findCourseBaseById("402885816240d276016240f7e5000002");
        System.out.println(courseBase);

    }

    @Test
    public void testFindTeachplan(){
        TeachplanNode teachplanNode=teachplanMapper.selectList("4028e581617f945f01617f9dabc40000");
        System.out.println(teachplanNode);
    }

    //测试分页
    @Test
    public void testPageHelper(){
        PageHelper.startPage(2, 1);
        CourseListRequest courseListRequest = new CourseListRequest();
        Page<CourseInfo> courseListPage = courseMapper.findCourseListPage(courseListRequest);
        List<CourseInfo> result = courseListPage.getResult();
        System.out.println(courseListPage);
    }

    @Test
    public void testRibbon() {

        String serviceId="NOVA-SERVICE-MANAGE-CMS";
        for (int i = 0; i < 10; i++) {
            ResponseEntity<CmsPage> forEntity = restTemplate.getForEntity("http://"+serviceId+"/cms/page/get/5a754adf6abb500ad05688d9", CmsPage.class);
            CmsPage cmsPage = forEntity.getBody();
            System.out.println(cmsPage);
        }
    }
}
