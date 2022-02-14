package com.ag.controller;


import com.ag.common.MessageConstant;
import com.ag.common.PageResult;
import com.ag.common.Result;
import com.ag.common.StatusCode;
import com.ag.domain.Activity;
import com.ag.service.ActivityService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 活动表 前端控制器
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Resource
    private ActivityService activityService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        IPage<Activity> page = activityService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.Activity_SEARCH_SUCCESS, page.getRecords(), page.getTotal(),page.getCurrent(), page.getSize());
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Activity Activity){
        activityService.save(Activity);
        return new Result(true,StatusCode.OK,MessageConstant.Activity_ADD_SUCCESS);
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        Activity Activity = activityService.getById(id);
        return new Result(true,StatusCode.OK,MessageConstant.Activity_FIND_BY_ID_SUCCESS,Activity);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Activity Activity){
        activityService.updateById(Activity);
        return new Result(true,StatusCode.OK,MessageConstant.Activity_UPDATE_SUCCESS);
    }
    // /Activity/updateStatus/0/1
    @RequestMapping("/updateStatus/{status}/{id}")
    public Result updateStatus(@PathVariable("status") String status, @PathVariable("id") Integer id){
        activityService.updateStatus(status,id);
        return new Result(true,StatusCode.OK,MessageConstant.Activity_UPDATE_STATUS_SUCCESS);
    }
    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        activityService.removeByIds(ids);
        return new Result(true,StatusCode.OK,MessageConstant.Activity_DELETE_SUCCESS);
    }
    @RequestMapping("/findCount")
    public int findCount(){
        int count = activityService.count();
        return count;
    }
    @RequestMapping("/findByStartTimeDesc")
    public List<Activity> findByStartTimeDesc(){
       return  activityService.findByStartTimeDesc();
    }
}
