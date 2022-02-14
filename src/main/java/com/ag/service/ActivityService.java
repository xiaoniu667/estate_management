package com.ag.service;

import com.ag.domain.Activity;
import com.ag.domain.Building;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 活动表 服务类
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
public interface ActivityService extends IService<Activity> {
    /**
     * 分页
     * @param searchMap
     * @return
     */
    IPage<Activity> search(Map searchMap);

    /**
     * 更新状态
     * @param status
     * @param id
     */
    void updateStatus(String status, Integer id);
    /**
     * 查找首页按时间展示出来的活动
     *
     */
    List<Activity> findByStartTimeDesc();

}
