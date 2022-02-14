package com.ag.controller;


import com.ag.common.MessageConstant;
import com.ag.common.PageResult;
import com.ag.common.Result;
import com.ag.common.StatusCode;
import com.ag.domain.EstateManagerPower;
import com.ag.service.EstateManagerPowerService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/estateManagerPower")
public class EstateManagerPowerController {

    @Resource
    private EstateManagerPowerService estateManagerPowerService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        IPage<EstateManagerPower> page = estateManagerPowerService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.EstateManagerPower_SEARCH_SUCCESS, page.getRecords(), page.getTotal(),page.getCurrent(), page.getSize());
    }

    @RequestMapping("/add")
    public Result add(@RequestBody EstateManagerPower EstateManagerPower){
        estateManagerPowerService.save(EstateManagerPower);
        return new Result(true,StatusCode.OK,MessageConstant.EstateManagerPower_ADD_SUCCESS);
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        EstateManagerPower EstateManagerPower = estateManagerPowerService.getById(id);
        return new Result(true,StatusCode.OK,MessageConstant.EstateManagerPower_FIND_BY_ID_SUCCESS,EstateManagerPower);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody EstateManagerPower EstateManagerPower){
        estateManagerPowerService.updateById(EstateManagerPower);
        return new Result(true,StatusCode.OK,MessageConstant.EstateManagerPower_UPDATE_SUCCESS);
    }
    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        estateManagerPowerService.removeByIds(ids);
        return new Result(true,StatusCode.OK,MessageConstant.EstateManagerPower_DELETE_SUCCESS);
    }
}
