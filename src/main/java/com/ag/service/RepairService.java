package com.ag.service;

import com.ag.domain.Activity;
import com.ag.domain.Owner;
import com.ag.domain.Repair;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 维修表 服务类
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
public interface RepairService extends IService<Repair> {

    IPage<Repair> search(Map searchMap);


    List<Repair> findByUpdateTimeDesc();


}
