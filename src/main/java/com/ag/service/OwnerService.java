package com.ag.service;

import com.ag.domain.House;
import com.ag.domain.Owner;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 业主表 服务类
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
public interface OwnerService extends IService<Owner> {
    /**
     * 分页查询
     * @param searchMap
     * @return
     */
    IPage<Owner> search(Map searchMap);

}
