package com.ag.service.impl;

import com.ag.domain.Letter;
import com.ag.domain.Letter;
import com.ag.mapper.LetterMapper;
import com.ag.service.LetterService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 信件表 服务实现类
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@Service
public class LetterServiceImpl extends ServiceImpl<LetterMapper, Letter> implements LetterService {
    /**
     * 分页
     * @param searchMap
     * @return
     */
    @Override
    public IPage<Letter> search(Map searchMap) {
        int currentPage = 1;
        int pageSize = 4;
        if ((Integer) searchMap.get("currentPage") != null) {
            currentPage = (Integer) searchMap.get("currentPage");
        }
        if ((Integer) searchMap.get("pageSize") != null) {
            pageSize = (Integer) searchMap.get("pageSize");
        }
        IPage<Letter> page = new Page<>(currentPage, pageSize);
        LambdaQueryWrapper<Letter> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            lambdaQueryWrapper.like(Strings.isNotEmpty((String) searchMap.get("name")), Letter::getTitle, searchMap.get("name"));
//        数据库中的时间大于传过来的开始时间
        lambdaQueryWrapper.ge(Strings.isNotEmpty((String) searchMap.get("startTime")), Letter::getCreateTime, searchMap.get("startTime"));
//        数据库中的时间小于传过来的结束时间
        lambdaQueryWrapper.le(Strings.isNotEmpty((String) searchMap.get("endTime")), Letter::getCreateTime, searchMap.get("endTime"));

        return  baseMapper.selectPage(page, lambdaQueryWrapper);

    }
}
