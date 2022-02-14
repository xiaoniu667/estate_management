package com.ag.service;

import com.ag.domain.Car;
import com.ag.domain.Parking;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 车位表 服务类
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
public interface ParkingService extends IService<Parking> {
    IPage<Parking> search(Map searchMap);

    void updateStatus(String status, Integer id);
}
