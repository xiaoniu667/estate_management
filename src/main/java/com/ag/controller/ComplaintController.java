package com.ag.controller;


import com.ag.common.MessageConstant;
import com.ag.common.PageResult;
import com.ag.common.Result;
import com.ag.common.StatusCode;
import com.ag.domain.Complaint;
import com.ag.service.ComplaintService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 投诉表 前端控制器
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@RestController
@RequestMapping("/complaint")
public class ComplaintController {
    @Resource
    private ComplaintService ComplaintService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        IPage<Complaint> page = ComplaintService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.Complaint_SEARCH_SUCCESS, page.getRecords(), page.getTotal(),page.getCurrent(), page.getSize());
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Complaint Complaint){
        ComplaintService.save(Complaint);
        return new Result(true,StatusCode.OK,MessageConstant.Complaint_ADD_SUCCESS);
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        Complaint Complaint = ComplaintService.getById(id);
        return new Result(true,StatusCode.OK,MessageConstant.Complaint_FIND_BY_ID_SUCCESS,Complaint);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Complaint Complaint){
        ComplaintService.updateById(Complaint);
        return new Result(true,StatusCode.OK,MessageConstant.Complaint_UPDATE_SUCCESS);
    }
    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        ComplaintService.removeByIds(ids);
        return new Result(true,StatusCode.OK,MessageConstant.Complaint_DELETE_SUCCESS);
    }
    @RequestMapping("/findCount")
    public int findCount(){
        int count = ComplaintService.count();
        return count;
    }
}
