package com.ag.service;

import com.ag.domain.Building;
import com.ag.domain.Community;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 楼栋表 服务类
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
public interface BuildingService extends IService<Building> {

    IPage<Building> search(Map searchMap);
}
