package com.ag.service.impl;

import com.ag.domain.House;
import com.ag.domain.Owner;
import com.ag.domain.Owner;
import com.ag.mapper.OwnerMapper;

import com.ag.service.OwnerService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * <p>
 * 业主表 服务实现类
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@Service
public class OwnerServiceImpl extends ServiceImpl<OwnerMapper, Owner> implements OwnerService {


    /**
     * 分页
     * @param searchMap
     * @return
     */
    @Override
    public IPage<Owner> search(Map searchMap) {
        int currentPage = 1;
        int pageSize = 2;
        if ((Integer) searchMap.get("currentPage") != null) {
            currentPage = (Integer) searchMap.get("currentPage");
        }
        if ((Integer) searchMap.get("pageSize") != null) {
            pageSize = (Integer) searchMap.get("pageSize");
        }
        IPage<Owner> page = new Page<>(currentPage, pageSize);
        LambdaQueryWrapper<Owner> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Strings.isNotEmpty((String) searchMap.get("name")), Owner::getName, searchMap.get("name"));
//        数据库中的时间大于传过来的开始时间
        lambdaQueryWrapper.ge(Strings.isNotEmpty((String) searchMap.get("startTime")), Owner::getCreateTime, searchMap.get("startTime"));
//        数据库中的时间小于传过来的结束时间
        lambdaQueryWrapper.le(Strings.isNotEmpty((String) searchMap.get("endTime")), Owner::getCreateTime, searchMap.get("endTime"));

        return  baseMapper.selectPage(page, lambdaQueryWrapper);

    }
    
}
