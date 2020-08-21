package cn.sus.edu.partymemberdevelopment.service;

import cn.sus.edu.partymemberdevelopment.entity.PartyMemberRecommend;

import java.util.Map;

public interface PartyMemberRecommendService {

    Map<String, Object> findAll(Map<String, Object> params) throws RuntimeException;

    PartyMemberRecommend findOne(PartyMemberRecommend recommend) throws RuntimeException;

    int addOne(PartyMemberRecommend recommend) throws RuntimeException;

    int modifyOne(PartyMemberRecommend recommend) throws RuntimeException;

    int deleteOne(Long recordId) throws RuntimeException;

}
