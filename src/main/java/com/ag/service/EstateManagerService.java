package com.ag.service;

import com.ag.domain.EstateManager;
import com.ag.domain.Parking;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 物业管理人员表 服务类
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
public interface EstateManagerService extends IService<EstateManager> {
    IPage<EstateManager> search(Map searchMap);
    /**
     * 用户登录
     */
    EstateManager login(String loginName,String password);


}
