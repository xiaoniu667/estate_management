package com.ag.controller;


import com.ag.common.MessageConstant;
import com.ag.common.PageResult;
import com.ag.common.Result;
import com.ag.common.StatusCode;
import com.ag.domain.Activity;
import com.ag.domain.Repair;
import com.ag.service.RepairService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 维修表 前端控制器
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@RestController
@RequestMapping("/repair")
public class RepairController {
    @Resource
    private RepairService repairService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        IPage<Repair> page = repairService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.Repair_SEARCH_SUCCESS, page.getRecords(), page.getTotal(),page.getCurrent(), page.getSize());
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Repair repair){
        repairService.save(repair);
        return new Result(true,StatusCode.OK,MessageConstant.Repair_ADD_SUCCESS);
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        Repair repair = repairService.getById(id);
        return new Result(true,StatusCode.OK,MessageConstant.Repair_FIND_BY_ID_SUCCESS,repair);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Repair repair){
        repairService.updateById(repair);
        return new Result(true,StatusCode.OK,MessageConstant.Repair_UPDATE_SUCCESS);
    }
    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        repairService.removeByIds(ids);
        return new Result(true,StatusCode.OK,MessageConstant.Repair_DELETE_SUCCESS);
    }
    @RequestMapping("/findByUpdateTimeDesc")
    public List<Repair> findByUpdateTimeDesc(){
        return  repairService.findByUpdateTimeDesc();
    }
}
