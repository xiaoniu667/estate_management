package com.ag.service.impl;

import com.ag.domain.ChargeItem;
import com.ag.domain.Community;
import com.ag.mapper.ChargeItemMapper;
import com.ag.service.ChargeItemService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 收费项目表 服务实现类
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@Service
public class ChargeItemServiceImpl extends ServiceImpl<ChargeItemMapper, ChargeItem> implements ChargeItemService {
    @Override
    public IPage<ChargeItem> search(Map searchMap) {
        int currentPage = 1;
        int pageSize = 2;
        if ((Integer) searchMap.get("currentPage") != null) {
            currentPage = (Integer) searchMap.get("currentPage");
        }
        if ((Integer) searchMap.get("pageSize") != null) {
            pageSize = (Integer) searchMap.get("pageSize");
        }
        IPage<ChargeItem> page = new Page<>(currentPage, pageSize);
        LambdaQueryWrapper<ChargeItem> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Strings.isNotEmpty((String) searchMap.get("name")), ChargeItem::getName, searchMap.get("name"));
//        数据库中的时间大于传过来的开始时间
        lambdaQueryWrapper.ge(Strings.isNotEmpty((String) searchMap.get("startTime")), ChargeItem::getCreateTime, searchMap.get("startTime"));
//        数据库中的时间小于传过来的结束时间
        lambdaQueryWrapper.le(Strings.isNotEmpty((String) searchMap.get("endTime")), ChargeItem::getCreateTime, searchMap.get("endTime"));
        return baseMapper.selectPage(page, lambdaQueryWrapper);

    }
}
