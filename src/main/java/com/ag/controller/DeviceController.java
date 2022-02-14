package com.ag.controller;


import com.ag.common.MessageConstant;
import com.ag.common.PageResult;
import com.ag.common.Result;
import com.ag.common.StatusCode;
import com.ag.domain.Device;
import com.ag.service.DeviceService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 设备表 前端控制器
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@RestController
@RequestMapping("/device")
public class DeviceController {
    @Resource
    private DeviceService DeviceService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        IPage<Device> page = DeviceService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.Device_SEARCH_SUCCESS, page.getRecords(), page.getTotal(),page.getCurrent(), page.getSize());
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Device Device){
        DeviceService.save(Device);
        return new Result(true,StatusCode.OK,MessageConstant.Device_ADD_SUCCESS);
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        Device Device = DeviceService.getById(id);
        return new Result(true,StatusCode.OK,MessageConstant.Device_FIND_BY_ID_SUCCESS,Device);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Device Device){
        DeviceService.updateById(Device);
        return new Result(true,StatusCode.OK,MessageConstant.Device_UPDATE_SUCCESS);
    }
    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        DeviceService.removeByIds(ids);
        return new Result(true,StatusCode.OK,MessageConstant.Device_DELETE_SUCCESS);
    }
}
