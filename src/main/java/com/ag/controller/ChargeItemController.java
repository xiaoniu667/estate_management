package com.ag.controller;


import com.ag.common.MessageConstant;
import com.ag.common.PageResult;
import com.ag.common.Result;
import com.ag.common.StatusCode;
import com.ag.domain.ChargeItem;
import com.ag.service.ChargeItemService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 收费项目表 前端控制器
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@RestController
@RequestMapping("/chargeItem")
public class ChargeItemController {
    @Resource
    private ChargeItemService ChargeItemService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        IPage<ChargeItem> page = ChargeItemService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.ChargeItem_SEARCH_SUCCESS, page.getRecords(), page.getTotal(),page.getCurrent(), page.getSize());
    }

    @RequestMapping("/add")
    public Result add(@RequestBody ChargeItem ChargeItem){
        ChargeItemService.save(ChargeItem);
        return new Result(true,StatusCode.OK,MessageConstant.ChargeItem_ADD_SUCCESS);
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        ChargeItem ChargeItem = ChargeItemService.getById(id);
        return new Result(true,StatusCode.OK,MessageConstant.ChargeItem_FIND_BY_ID_SUCCESS,ChargeItem);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody ChargeItem ChargeItem){
        ChargeItemService.updateById(ChargeItem);
        return new Result(true,StatusCode.OK,MessageConstant.ChargeItem_UPDATE_SUCCESS);
    }
    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        ChargeItemService.removeByIds(ids);
        return new Result(true,StatusCode.OK,MessageConstant.ChargeItem_DELETE_SUCCESS);
    }
}
