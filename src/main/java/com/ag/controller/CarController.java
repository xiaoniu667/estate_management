package com.ag.controller;


import com.ag.common.MessageConstant;
import com.ag.common.PageResult;
import com.ag.common.Result;
import com.ag.common.StatusCode;
import com.ag.domain.Building;
import com.ag.domain.Car;
import com.ag.domain.Community;
import com.ag.service.CarService;
import com.ag.service.CommunityService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 车辆表 前端控制器
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@RestController
@RequestMapping("/car")
public class CarController {


    @Resource
    private CarService carService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        IPage<Car> page = carService.search(searchMap);
        //封装一个ownName属性
        /*List<Car> cars = carService.selectByOwnerId();
        List<Car> records = page.getRecords();
        System.out.println(records);
        records.addAll(cars);*/
        return new PageResult(true, StatusCode.OK, MessageConstant.CAR_SEARCH_SUCCESS, page.getRecords(), page.getTotal(),page.getCurrent(), page.getSize());
    }
    @RequestMapping("/add")
    public Result add(@RequestBody Car car){
        carService.save(car);
        return new Result(true,StatusCode.OK,MessageConstant.CAR_ADD_SUCCESS);
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        Car car = carService.getById(id);
        return new Result(true,StatusCode.OK,MessageConstant.CAR_FIND_BY_ID_SUCCESS,car);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Car car){
        carService.updateById(car);
        return new Result(true,StatusCode.OK,MessageConstant.CAR_UPDATE_SUCCESS);
    }
    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        carService.removeByIds(ids);
        return new Result(true,StatusCode.OK,MessageConstant.CAR_DELETE_SUCCESS);
    }

}
