package com.ag.service;

import com.ag.domain.Community;
import com.ag.domain.Complaint;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 投诉表 服务类
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
public interface ComplaintService extends IService<Complaint> {
    IPage<Complaint> search(Map searchMap);

}
