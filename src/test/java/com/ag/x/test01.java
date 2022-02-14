package com.ag.x;


import com.ag.domain.Activity;
import com.ag.domain.Car;
import com.ag.domain.House;
import com.ag.domain.Owner;
import com.ag.mapper.*;
import com.ag.service.ActivityService;
import com.ag.service.CarService;
import com.ag.service.OwnerService;
import com.ag.service.RepairService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class test01 {
    @Resource
    private CarMapper carMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private ActivityMapper activityMapper;


    @Resource
    private ActivityService activityService;

    @Resource
    private RepairMapper repairMapper;


    @Resource
    private RepairService repairService;


    @Test
    public void  test2(){

    }




}
