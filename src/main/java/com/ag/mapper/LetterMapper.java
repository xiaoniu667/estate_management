package com.ag.mapper;

import com.ag.domain.Letter;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 信件表 Mapper 接口
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@Mapper
public interface LetterMapper extends BaseMapper<Letter> {

}
