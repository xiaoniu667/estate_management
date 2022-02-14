package com.ag.controller;

import com.ag.common.MessageConstant;
import com.ag.common.PageResult;
import com.ag.common.Result;
import com.ag.common.StatusCode;
import com.ag.domain.Community;
import com.ag.service.CommunityService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Auth: zhuan
 * @Desc: 小区管理控制层:只负责接收前端浏览器发送的请求和请求参数，调用service层获取业务逻辑加工处理后的数据
 */
@RestController
@RequestMapping("/community")
public class CommunityController {
    
    @Resource
    private CommunityService communityService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        IPage<Community> page = communityService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.COMMUNITY_SEARCH_SUCCESS, page.getRecords(), page.getTotal(),page.getCurrent(), page.getSize());
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Community community){
          communityService.save(community);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_ADD_SUCCESS);
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        Community community = communityService.getById(id);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_FIND_BY_ID_SUCCESS,community);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Community community){
          communityService.updateById(community);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_UPDATE_SUCCESS);
    }
    // /community/updateStatus/0/1
    @RequestMapping("/updateStatus/{status}/{id}")
    public Result updateStatus(@PathVariable("status") String status,@PathVariable("id") Integer id){
        communityService.updateStatus(status,id);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_UPDATE_STATUS_SUCCESS);
    }
    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        communityService.removeByIds(ids);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_DELETE_SUCCESS);
    }
}
