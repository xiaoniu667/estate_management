package com.ag.controller;


import com.ag.common.MessageConstant;
import com.ag.common.PageResult;
import com.ag.common.Result;
import com.ag.common.StatusCode;
import com.ag.domain.House;
import com.ag.service.HouseService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 房屋表 前端控制器
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@RestController
@RequestMapping("/house")
public class HouseController {
    @Resource
    private HouseService houseService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        IPage<House> page = houseService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.HOUSE_SEARCH_SUCCESS, page.getRecords(), page.getTotal(),page.getCurrent(), page.getSize());
    }

    @RequestMapping("/add")
    public Result add(@RequestBody House house){
        houseService.save(house);
        return new Result(true,StatusCode.OK,MessageConstant.HOUSE_ADD_SUCCESS);
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        House house = houseService.getById(id);
        return new Result(true,StatusCode.OK,MessageConstant.HOUSE_FIND_BY_ID_SUCCESS,house);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody House house){
        houseService.updateById(house);
        return new Result(true,StatusCode.OK,MessageConstant.HOUSE_UPDATE_SUCCESS);
    }
    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        houseService.removeByIds(ids);
        return new Result(true,StatusCode.OK,MessageConstant.HOUSE_DELETE_SUCCESS);
    }
    @RequestMapping("/findCount")
    public int findCount(){
        int count = houseService.count();
        return count;
    }
}
