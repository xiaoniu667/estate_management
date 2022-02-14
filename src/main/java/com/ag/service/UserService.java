package com.ag.service;

import com.ag.domain.Owner;

public interface UserService {

    Owner findByUserImg(String name);

    int  findByCount(String type);
}
