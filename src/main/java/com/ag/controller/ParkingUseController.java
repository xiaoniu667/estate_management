package com.ag.controller;


import com.ag.common.MessageConstant;
import com.ag.common.PageResult;
import com.ag.common.Result;
import com.ag.common.StatusCode;
import com.ag.domain.Owner;
import com.ag.domain.Parking;
import com.ag.domain.ParkingUse;
import com.ag.service.OwnerService;
import com.ag.service.ParkingUseService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 车位使用表 前端控制器
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@RestController
@RequestMapping("/parkingUse")
public class ParkingUseController {
    @Resource
    private ParkingUseService parkingUseService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        IPage<ParkingUse> page = parkingUseService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.ParkingUse_SEARCH_SUCCESS, page.getRecords(), page.getTotal(),page.getCurrent(), page.getSize());
    }

    @RequestMapping("/add")
    public Result add(@RequestBody ParkingUse parkingUse){
        parkingUseService.save(parkingUse);
        return new Result(true,StatusCode.OK,MessageConstant.ParkingUse_ADD_SUCCESS);
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        ParkingUse parkingUse = parkingUseService.getById(id);
        return new Result(true,StatusCode.OK,MessageConstant.ParkingUse_FIND_BY_ID_SUCCESS,parkingUse);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody ParkingUse parkingUse){
        parkingUseService.updateById(parkingUse);
        return new Result(true,StatusCode.OK,MessageConstant.ParkingUse_UPDATE_SUCCESS);
    }
    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        parkingUseService.removeByIds(ids);
        return new Result(true,StatusCode.OK,MessageConstant.ParkingUse_DELETE_SUCCESS);
    }
}
