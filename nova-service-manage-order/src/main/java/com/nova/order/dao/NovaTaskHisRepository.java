package com.nova.order.dao;

import com.nova.framework.domain.task.NvTaskHis;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author haocong
 * @date Aug2020
 * @version 1.0
 */
public interface NovaTaskHisRepository extends JpaRepository<NvTaskHis,String> {
}
