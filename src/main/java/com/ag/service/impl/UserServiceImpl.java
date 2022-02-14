package com.ag.service.impl;

import com.ag.domain.Owner;
import com.ag.mapper.UserMapper;
import com.ag.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Owner findByUserImg(String name) {
      Owner owner = userMapper.selectByImg(name);
        return owner;
    }
    @Override
    public int findByCount(String type) {
        return  userMapper.selectByCount(type);
    }
}
