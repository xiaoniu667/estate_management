package com.ag.service.impl;

import com.ag.domain.Community;
import com.ag.mapper.CommunityMapper;
import com.ag.domain.Community;
import com.ag.service.CommunityService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 小区表 服务实现类
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@Service
public class CommunityServiceImpl extends ServiceImpl<CommunityMapper, Community> implements CommunityService {
    /**
     * 分页
     * @param searchMap
     * @return
     */
    @Override
    public IPage<Community> search(Map searchMap) {
        int currentPage = 1;
        int pageSize = 2;
        if ((Integer) searchMap.get("currentPage") != null) {
            currentPage = (Integer) searchMap.get("currentPage");
        }
        if ((Integer) searchMap.get("pageSize") != null) {
            pageSize = (Integer) searchMap.get("pageSize");
        }
        IPage<Community> page = new Page<>(currentPage, pageSize);
        LambdaQueryWrapper<Community> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Strings.isNotEmpty((String) searchMap.get("name")), Community::getName, searchMap.get("name"));
//        数据库中的时间大于传过来的开始时间
        lambdaQueryWrapper.ge(Strings.isNotEmpty((String) searchMap.get("startTime")), Community::getCreateTime, searchMap.get("startTime"));
//        数据库中的时间小于传过来的结束时间
        lambdaQueryWrapper.le(Strings.isNotEmpty((String) searchMap.get("endTime")), Community::getCreateTime, searchMap.get("endTime"));
        return baseMapper.selectPage(page, lambdaQueryWrapper);

    }

    /**
     * 更新状态
     * @param status
     * @param id
     */
    @Override
    public void updateStatus(String status, Integer id) {
        Community community = new Community();
        community.setId(id);
        community.setStatus(status);
        baseMapper.updateById(community);
    }
}
