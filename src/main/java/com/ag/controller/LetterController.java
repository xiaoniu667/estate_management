package com.ag.controller;
import com.ag.common.MessageConstant;
import com.ag.common.PageResult;
import com.ag.common.Result;
import com.ag.common.StatusCode;
import com.ag.domain.Letter;
import com.ag.service.LetterService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 信件表 前端控制器
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@RestController
@RequestMapping("/letter")
public class LetterController {
    @Resource
    private LetterService letterService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        IPage<Letter> page = letterService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.Letter_SEARCH_SUCCESS, page.getRecords(), page.getTotal(),page.getCurrent(), page.getSize());
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Letter letter){
        letterService.save(letter);
        return new Result(true,StatusCode.OK,MessageConstant.Letter_ADD_SUCCESS);
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        Letter letter = letterService.getById(id);
        return new Result(true,StatusCode.OK,MessageConstant.Letter_FIND_BY_ID_SUCCESS,letter);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Letter letter){
        letterService.updateById(letter);
        return new Result(true,StatusCode.OK,MessageConstant.Letter_UPDATE_SUCCESS);
    }
    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        letterService.removeByIds(ids);
        return new Result(true,StatusCode.OK,MessageConstant.Letter_DELETE_SUCCESS);
    }
}
