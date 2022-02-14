package com.ag.mapper;

import com.ag.domain.Pet;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 宠物表 Mapper 接口
 *
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@Mapper
public interface PetMapper extends BaseMapper<Pet> {

}
