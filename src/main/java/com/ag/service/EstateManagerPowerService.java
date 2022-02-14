package com.ag.service;

import com.ag.domain.EstateManagerPower;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

public interface EstateManagerPowerService extends IService<EstateManagerPower> {
    IPage<EstateManagerPower> search(Map searchMap);


}
