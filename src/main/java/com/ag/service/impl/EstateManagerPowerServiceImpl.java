package com.ag.service.impl;

import com.ag.domain.EstateManagerPower;
import com.ag.domain.EstateManager;
import com.ag.domain.EstateManagerPower;
import com.ag.mapper.EstateManagerPowerMapper;
import com.ag.service.EstateManagerPowerService;
import com.ag.service.EstateManagerService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class EstateManagerPowerServiceImpl extends ServiceImpl<EstateManagerPowerMapper, EstateManagerPower> implements EstateManagerPowerService {

    @Override
    public IPage<EstateManagerPower> search(Map searchMap) {
        int currentPage = 1;
        int pageSize = 5;
        if ((Integer) searchMap.get("currentPage") != null) {
            currentPage = (Integer) searchMap.get("currentPage");
        }
        if ((Integer) searchMap.get("pageSize") != null) {
            pageSize = (Integer) searchMap.get("pageSize");
        }
        IPage<EstateManagerPower> page = new Page<>(currentPage, pageSize);
        LambdaQueryWrapper<EstateManagerPower> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Strings.isNotEmpty((String) searchMap.get("name")), EstateManagerPower::getPowName, searchMap.get("name"));
//        数据库中的时间大于传过来的开始时间
        lambdaQueryWrapper.ge(Strings.isNotEmpty((String) searchMap.get("startTime")), EstateManagerPower::getTime, searchMap.get("startTime"));
//        数据库中的时间小于传过来的结束时间
        lambdaQueryWrapper.le(Strings.isNotEmpty((String) searchMap.get("endTime")), EstateManagerPower::getTime, searchMap.get("endTime"));
        return baseMapper.selectPage(page, lambdaQueryWrapper);
    }
}
