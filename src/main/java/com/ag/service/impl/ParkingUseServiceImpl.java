package com.ag.service.impl;

import com.ag.domain.ParkingUse;
import com.ag.mapper.ParkingUseMapper;
import com.ag.service.ParkingUseService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 车位使用表 服务实现类
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@Service
public class ParkingUseServiceImpl extends ServiceImpl<ParkingUseMapper, ParkingUse> implements ParkingUseService {
    /**
     * 分页
     *
     * @param searchMap
     * @return
     */
    @Override
    public IPage<ParkingUse> search(Map searchMap) {
        int currentPage = 1;
        int pageSize = 2;
        if ((Integer) searchMap.get("currentPage") != null) {
            currentPage = (Integer) searchMap.get("currentPage");
        }
        if ((Integer) searchMap.get("pageSize") != null) {
            pageSize = (Integer) searchMap.get("pageSize");
        }
        IPage<ParkingUse> page = new Page<>(currentPage, pageSize);
        LambdaQueryWrapper<ParkingUse> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Strings.isNotEmpty((String) searchMap.get("name")), ParkingUse::getOwnerName, searchMap.get("name"));
//        数据库中的时间大于传过来的开始时间
        lambdaQueryWrapper.ge(Strings.isNotEmpty((String) searchMap.get("startTime")), ParkingUse::getCreateTime, searchMap.get("startTime"));
//        数据库中的时间小于传过来的结束时间
        lambdaQueryWrapper.le(Strings.isNotEmpty((String) searchMap.get("endTime")), ParkingUse::getCreateTime, searchMap.get("endTime"));

        return baseMapper.selectPage(page, lambdaQueryWrapper);


    }
 
}
