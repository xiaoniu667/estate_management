package com.ag.mapper;

import com.ag.domain.Activity;
import com.ag.domain.Repair;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 维修表 Mapper 接口
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@Mapper
public interface RepairMapper extends BaseMapper<Repair> {

    List<Repair> selectByUpdateTimeDesc();

}
