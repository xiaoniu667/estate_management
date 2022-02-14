package com.ag.service;

import com.ag.domain.ChargeItem;
import com.ag.domain.Community;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 收费项目表 服务类
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
public interface ChargeItemService extends IService<ChargeItem> {
    IPage<ChargeItem> search(Map searchMap);

}
