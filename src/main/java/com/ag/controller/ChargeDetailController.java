package com.ag.controller;


import com.ag.common.MessageConstant;
import com.ag.common.PageResult;
import com.ag.common.Result;
import com.ag.common.StatusCode;
import com.ag.domain.ChargeDetail;
import com.ag.service.ChargeDetailService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 收费名细表 前端控制器
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@RestController
@RequestMapping("/chargeDetail")
public class ChargeDetailController {
    @Resource
    private ChargeDetailService ChargeDetailService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        IPage<ChargeDetail> page = ChargeDetailService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.ChargeDetail_SEARCH_SUCCESS, page.getRecords(), page.getTotal(),page.getCurrent(), page.getSize());
    }

    @RequestMapping("/add")
    public Result add(@RequestBody ChargeDetail ChargeDetail){
        ChargeDetailService.save(ChargeDetail);
        return new Result(true,StatusCode.OK,MessageConstant.ChargeDetail_ADD_SUCCESS);
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        ChargeDetail ChargeDetail = ChargeDetailService.getById(id);
        return new Result(true,StatusCode.OK,MessageConstant.ChargeDetail_FIND_BY_ID_SUCCESS,ChargeDetail);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody ChargeDetail ChargeDetail){
        ChargeDetailService.updateById(ChargeDetail);
        return new Result(true,StatusCode.OK,MessageConstant.ChargeDetail_UPDATE_SUCCESS);
    }
    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        ChargeDetailService.removeByIds(ids);
        return new Result(true,StatusCode.OK,MessageConstant.ChargeDetail_DELETE_SUCCESS);
    }
}
