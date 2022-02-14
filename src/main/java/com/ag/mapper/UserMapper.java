package com.ag.mapper;


import com.ag.domain.Owner;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper  {


    Owner selectByImg(String name);

    int selectByCount(String type);
}
