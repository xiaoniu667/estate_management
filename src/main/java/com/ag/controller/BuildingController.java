package com.ag.controller;


import com.ag.common.MessageConstant;
import com.ag.common.PageResult;
import com.ag.common.Result;
import com.ag.common.StatusCode;
import com.ag.domain.Building;
import com.ag.service.BuildingService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 楼栋表 前端控制器
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@RestController
@RequestMapping("/building")
public class BuildingController {
    @Resource
    private BuildingService buildingService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        IPage<Building> page = buildingService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.BUILDING_SEARCH_SUCCESS, page.getRecords(), page.getTotal(),page.getCurrent(), page.getSize());
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Building building){
        buildingService.save(building);
        return new Result(true,StatusCode.OK,MessageConstant.BUILDING_ADD_SUCCESS);
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        Building building = buildingService.getById(id);
        return new Result(true,StatusCode.OK,MessageConstant.BUILDING_FIND_BY_ID_SUCCESS,building);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Building building){
        buildingService.updateById(building);
        return new Result(true,StatusCode.OK,MessageConstant.BUILDING_UPDATE_SUCCESS);
    }
    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        buildingService.removeByIds(ids);
        return new Result(true,StatusCode.OK,MessageConstant.BUILDING_DELETE_SUCCESS);
    }
    @RequestMapping("/findCount")
    public int findCount(){
        int count = buildingService.count();
        return count;
    }
}
