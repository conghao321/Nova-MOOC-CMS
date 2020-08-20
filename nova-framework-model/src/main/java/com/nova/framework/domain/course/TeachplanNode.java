package com.nova.framework.domain.course;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/*
 * @Author:conghao
 * @description:
 */
@Data
@ToString
public class TeachplanNode extends Teachplan {
    List<TeachplanNode> children;
    //媒资信息
    private String mediaId;
    private String mediaFileOriginalName;
}