package com.ag.service;

import com.ag.domain.ChargeDetail;
import com.ag.domain.Complaint;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 收费名细表 服务类
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
public interface ChargeDetailService extends IService<ChargeDetail> {
    IPage<ChargeDetail> search(Map searchMap);
}
