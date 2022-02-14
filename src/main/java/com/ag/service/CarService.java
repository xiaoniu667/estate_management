package com.ag.service;

import com.ag.domain.Car;
import com.ag.domain.Community;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 车辆表 服务类
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
public interface CarService extends IService<Car> {
    IPage<Car> search(Map searchMap);

    List<Car> selectByOwnerId();
}
