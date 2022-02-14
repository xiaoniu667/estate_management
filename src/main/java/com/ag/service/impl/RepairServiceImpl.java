package com.ag.service.impl;

import com.ag.domain.Activity;
import com.ag.domain.Repair;
import com.ag.domain.Repair;
import com.ag.mapper.RepairMapper;
import com.ag.service.RepairService;
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
 * 维修表 服务实现类
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@Service
public class RepairServiceImpl extends ServiceImpl<RepairMapper, Repair> implements RepairService {


    @Resource
    private  RepairMapper repairMapper;

    /**
     * 分页
     * @param searchMap
     * @return
     */
    @Override
    public IPage<Repair> search(Map searchMap) {
        int currentPage = 1;
        int pageSize = 2;
        if ((Integer) searchMap.get("currentPage") != null) {
            currentPage = (Integer) searchMap.get("currentPage");
        }
        if ((Integer) searchMap.get("pageSize") != null) {
            pageSize = (Integer) searchMap.get("pageSize");
        }
        IPage<Repair> page = new Page<>(currentPage, pageSize);
        LambdaQueryWrapper<Repair> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Strings.isNotEmpty((String) searchMap.get("name")), Repair::getOwnerName, searchMap.get("name"));
//        数据库中的时间大于传过来的开始时间
        lambdaQueryWrapper.ge(Strings.isNotEmpty((String) searchMap.get("startTime")), Repair::getCreateTime, searchMap.get("startTime"));
//        数据库中的时间小于传过来的结束时间
        lambdaQueryWrapper.le(Strings.isNotEmpty((String) searchMap.get("endTime")), Repair::getCreateTime, searchMap.get("endTime"));

        return  baseMapper.selectPage(page, lambdaQueryWrapper);

    }

    @Override
    public List<Repair> findByUpdateTimeDesc() {
      return  repairMapper.selectByUpdateTimeDesc();
    }
}
