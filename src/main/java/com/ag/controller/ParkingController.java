package com.ag.controller;


import com.ag.common.MessageConstant;
import com.ag.common.PageResult;
import com.ag.common.Result;
import com.ag.common.StatusCode;
import com.ag.domain.Parking;
import com.ag.service.ParkingService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 车位表 前端控制器
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@RestController
@RequestMapping("/parking")
public class ParkingController {
    @Resource
    private ParkingService parkingService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        IPage<Parking> page = parkingService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.Parking_SEARCH_SUCCESS, page.getRecords(), page.getTotal(),page.getCurrent(), page.getSize());
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Parking parking){
        parkingService.save(parking);
        return new Result(true,StatusCode.OK,MessageConstant.Parking_ADD_SUCCESS);
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        Parking parking = parkingService.getById(id);
        return new Result(true,StatusCode.OK,MessageConstant.Parking_FIND_BY_ID_SUCCESS,parking);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Parking parking){
        parkingService.updateById(parking);
        return new Result(true,StatusCode.OK,MessageConstant.Parking_UPDATE_SUCCESS);
    }
    @RequestMapping("/updateStatus/{status}/{id}")
    public Result updateStatus(@PathVariable("status") String status, @PathVariable("id") Integer id){
        parkingService.updateStatus(status,id);
        return new Result(true,StatusCode.OK,MessageConstant.Parking_UPDATE_STATUS_SUCCESS);
    }
    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        parkingService.removeByIds(ids);
        return new Result(true,StatusCode.OK,MessageConstant.Parking_DELETE_SUCCESS);
    }
}
