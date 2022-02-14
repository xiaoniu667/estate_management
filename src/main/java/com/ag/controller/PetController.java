package com.ag.controller;


import com.ag.common.MessageConstant;
import com.ag.common.PageResult;
import com.ag.common.Result;
import com.ag.common.StatusCode;
import com.ag.domain.Pet;
import com.ag.service.PetService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 宠物表 前端控制器
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@RestController
@RequestMapping("/pet")
public class PetController {

    @Resource
    private PetService petService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        IPage<Pet> page = petService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.Pet_SEARCH_SUCCESS, page.getRecords(), page.getTotal(),page.getCurrent(), page.getSize());
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Pet pet){
        petService.save(pet);
        return new Result(true,StatusCode.OK,MessageConstant.Pet_ADD_SUCCESS);
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        Pet Pet = petService.getById(id);
        return new Result(true,StatusCode.OK,MessageConstant.Pet_FIND_BY_ID_SUCCESS,Pet);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Pet pet){
        petService.updateById(pet);
        return new Result(true,StatusCode.OK,MessageConstant.Pet_UPDATE_SUCCESS);
    }
    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        petService.removeByIds(ids);
        return new Result(true,StatusCode.OK,MessageConstant.Pet_DELETE_SUCCESS);
    }

}
