package com.ag.service.impl;

import com.ag.domain.EstateManager;
import com.ag.mapper.EstateManagerMapper;
import com.ag.service.EstateManagerService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 物业管理人员表 服务实现类
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@Service
public class EstateManagerServiceImpl extends ServiceImpl<EstateManagerMapper, EstateManager> implements EstateManagerService {
    @Override
    public IPage<EstateManager> search(Map searchMap) {
        int currentPage = 1;
        int pageSize = 2;
        if ((Integer) searchMap.get("currentPage") != null) {
            currentPage = (Integer) searchMap.get("currentPage");
        }
        if ((Integer) searchMap.get("pageSize") != null) {
            pageSize = (Integer) searchMap.get("pageSize");
        }
        IPage<EstateManager> page = new Page<>(currentPage, pageSize);
        LambdaQueryWrapper<EstateManager> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Strings.isNotEmpty((String) searchMap.get("name")), EstateManager::getLoginName, searchMap.get("name"));
//        数据库中的时间大于传过来的开始时间
        lambdaQueryWrapper.ge(Strings.isNotEmpty((String) searchMap.get("startTime")), EstateManager::getCreateTime, searchMap.get("startTime"));
//        数据库中的时间小于传过来的结束时间
        lambdaQueryWrapper.le(Strings.isNotEmpty((String) searchMap.get("endTime")), EstateManager::getCreateTime, searchMap.get("endTime"));
        return baseMapper.selectPage(page, lambdaQueryWrapper);
    }

    @Override
    public EstateManager login(String loginName, String password) {
        LambdaQueryWrapper<EstateManager> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Strings.isNotEmpty(loginName), EstateManager::getLoginName, loginName)
                .eq(Strings.isNotEmpty(password), EstateManager::getPassword, password);
      return baseMapper.selectOne(lambdaQueryWrapper);

    }
}
