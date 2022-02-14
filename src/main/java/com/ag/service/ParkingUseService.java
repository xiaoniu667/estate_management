package com.ag.service;

import com.ag.domain.Parking;
import com.ag.domain.ParkingUse;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 车位使用表 服务类
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
public interface ParkingUseService extends IService<ParkingUse> {
    IPage<ParkingUse> search(Map searchMap);

}
