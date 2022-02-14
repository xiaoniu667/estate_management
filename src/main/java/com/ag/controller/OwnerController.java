package com.ag.controller;


import com.ag.common.MessageConstant;
import com.ag.common.PageResult;
import com.ag.common.Result;
import com.ag.common.StatusCode;
import com.ag.domain.Owner;
import com.ag.service.OwnerService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 业主表 前端控制器
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@RestController
@RequestMapping("/owner")
public class OwnerController {
    @Resource
    private OwnerService ownerService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        IPage<Owner> page = ownerService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.OWNER_SEARCH_SUCCESS, page.getRecords(), page.getTotal(),page.getCurrent(), page.getSize());
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Owner owner){
        ownerService.save(owner);
        return new Result(true,StatusCode.OK,MessageConstant.OWNER_ADD_SUCCESS);
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        Owner owner = ownerService.getById(id);
        return new Result(true,StatusCode.OK,MessageConstant.OWNER_FIND_BY_ID_SUCCESS,owner);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Owner owner){
        ownerService.updateById(owner);
        return new Result(true,StatusCode.OK,MessageConstant.OWNER_UPDATE_SUCCESS);
    }
    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        ownerService.removeByIds(ids);
        return new Result(true,StatusCode.OK,MessageConstant.OWNER_DELETE_SUCCESS);
    }
    @RequestMapping("/findCount")
    public int findCount(){
        int count = ownerService.count();
        return count;
    }
}
