package com.nova.framework.domain.ucenter.ext;

import com.nova.framework.domain.course.ext.CategoryNode;
import com.nova.framework.domain.ucenter.NovaMenu;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * Created by admin on 2020/3/20.
 */
@Data
@ToString
public class NovaMenuExt extends NovaMenu {

    List<CategoryNode> children;
}
