package cn.sus.edu.partymemberdevelopment.service;

import cn.sus.edu.partymemberdevelopment.entity.ExcellentRecommend;

import java.util.Map;

/**
 * 功能描述:
 * @Author: 15735400536
 * @Date: 2020/8/18 16:14
 */
public interface ExcellentRecommendService {

    Map<String, Object> findAll(Map<String, Object> params) throws RuntimeException;

    ExcellentRecommend findOne(ExcellentRecommend recommend) throws RuntimeException;

    int addOne(ExcellentRecommend recommend) throws RuntimeException;

    int modifyOne(ExcellentRecommend recommend) throws RuntimeException;

    int deleteOne(Long recordId) throws RuntimeException;

}
