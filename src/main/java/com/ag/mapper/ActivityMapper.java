package com.ag.mapper;

import com.ag.domain.Activity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 活动表 Mapper 接口
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@Mapper
public interface ActivityMapper extends BaseMapper<Activity> {

     List<Activity> selectByStartTimeDesc();

}
