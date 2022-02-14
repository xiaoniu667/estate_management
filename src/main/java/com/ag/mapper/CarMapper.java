package com.ag.mapper;

import com.ag.domain.Car;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 车辆表 Mapper 接口
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@Mapper
public interface CarMapper extends BaseMapper<Car> {
       List<Car> selectByOwnerId();
}
