package com.ag.service.impl;

import com.ag.domain.Activity;
import com.ag.domain.Building;
import com.ag.domain.Community;
import com.ag.mapper.ActivityMapper;
import com.ag.service.ActivityService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 活动表 服务实现类
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements ActivityService {
    @Resource
    private  ActivityMapper activityMapper;
    /**
     * 分页
     * @param searchMap
     * @return
     */
    @Override
    public IPage<Activity> search(Map searchMap) {
        int currentPage = 1;
        int pageSize = 2;
        if ((Integer) searchMap.get("currentPage") != null) {
            currentPage = (Integer) searchMap.get("currentPage");
        }
        if ((Integer) searchMap.get("pageSize") != null) {
            pageSize = (Integer) searchMap.get("pageSize");
        }
        IPage<Activity> page = new Page<>(currentPage, pageSize);
        LambdaQueryWrapper<Activity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Strings.isNotEmpty((String) searchMap.get("name")), Activity::getTitle, searchMap.get("name"));
//        数据库中的时间大于传过来的开始时间
        lambdaQueryWrapper.ge(Strings.isNotEmpty((String) searchMap.get("startTime")), Activity::getCreateTime, searchMap.get("startTime"));
//        数据库中的时间小于传过来的结束时间
        lambdaQueryWrapper.le(Strings.isNotEmpty((String) searchMap.get("endTime")), Activity::getCreateTime, searchMap.get("endTime"));
        return baseMapper.selectPage(page, lambdaQueryWrapper);
    }
    @Override
    public void updateStatus(String status, Integer id) {
        Activity activity = new Activity();
        activity.setId(id);
        activity.setStatus(status);
        baseMapper.updateById(activity);
    }

    @Override
    public List<Activity> findByStartTimeDesc() {
        List<Activity> activities = activityMapper.selectByStartTimeDesc();
        return activities;
    }
}
