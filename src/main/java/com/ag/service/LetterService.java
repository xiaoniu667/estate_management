package com.ag.service;

import com.ag.domain.Letter;
import com.ag.domain.Pet;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 信件表 服务类
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
public interface LetterService extends IService<Letter> {
    IPage<Letter> search(Map searchMap);
}
