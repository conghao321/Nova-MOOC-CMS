package com.nova.order.dao;

import com.nova.framework.domain.task.NvTask;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

/**
 *
 * @author haocong
 * @date Aug2020
 * @version 1.0
 **/
public interface NovaTaskRepository extends JpaRepository<NvTask,String> {
    //查询某个时间之间的前n条任务
    Page<NvTask> findByUpdateTimeBefore(Pageable pageable, Date updateTime);

    //更新updateTime
    @Modifying
    @Query("update NvTask t set t.updateTime = :updateTime where t.id = :id")
    public int updateTaskTime(@Param(value = "id") String id,@Param(value = "updateTime") Date updateTime);

    @Modifying
    @Query("update NvTask t set t.version = :version+1 where t.id = :id and t.version = :version")
    public int updateTaskVersion(@Param(value = "id") String id,@Param(value = "version") int version);
}
