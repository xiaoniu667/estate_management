package com.ag.controller;


import com.ag.common.MessageConstant;
import com.ag.common.PageResult;
import com.ag.common.Result;
import com.ag.common.StatusCode;
import com.ag.domain.EstateManager;
import com.ag.service.EstateManagerService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 物业管理人员表 前端控制器
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@RestController
@RequestMapping("/estateManager")
public class EstateManagerController {
    @Resource
    private EstateManagerService estateManagerService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        IPage<EstateManager> page = estateManagerService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.EstateManager_SEARCH_SUCCESS, page.getRecords(), page.getTotal(),page.getCurrent(), page.getSize());
    }

    @RequestMapping("/add")
    public Result add(@RequestBody EstateManager EstateManager){
        estateManagerService.save(EstateManager);
        return new Result(true,StatusCode.OK,MessageConstant.EstateManager_ADD_SUCCESS);
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        EstateManager EstateManager = estateManagerService.getById(id);
        return new Result(true,StatusCode.OK,MessageConstant.EstateManager_FIND_BY_ID_SUCCESS,EstateManager);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody EstateManager EstateManager){
        estateManagerService.updateById(EstateManager);
        return new Result(true,StatusCode.OK,MessageConstant.EstateManager_UPDATE_SUCCESS);
    }
    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        estateManagerService.removeByIds(ids);
        return new Result(true,StatusCode.OK,MessageConstant.EstateManager_DELETE_SUCCESS);
    }
}
