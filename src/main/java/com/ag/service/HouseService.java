package com.ag.service;

import com.ag.domain.Building;
import com.ag.domain.House;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 房屋表 服务类
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
public interface HouseService extends IService<House> {
    IPage<House> search(Map searchMap);
}
