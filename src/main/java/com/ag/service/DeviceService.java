package com.ag.service;

import com.ag.domain.Car;
import com.ag.domain.Device;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 设备表 服务类
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
public interface DeviceService extends IService<Device> {
    IPage<Device> search(Map searchMap);

}
