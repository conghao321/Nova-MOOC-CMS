package com.nova.test.freemarker.model;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0
 * @create 2018-06-13 8:24
 **/
@Data
@ToString
public class Student {
    private String name;//姓名
    private int age;//年龄
    private Date birthday;//生日
    private Float mondy;//钱包
    private List<Student> friends;//朋友列表
    private Student bestFriend;//最好的朋友
}
