package cn.sus.edu.partymemberdevelopment.mapper;

import cn.sus.edu.partymemberdevelopment.entity.PartyMemberRecommend;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

/**
 * 功能描述: 入党积极分子党员群众推荐表
 * @Author: 15735400536
 * @Date: 2020/8/18 17:02
 */
@Repository
@Mapper
public interface PartyMemberRecommendMapper {

    int insertOne(PartyMemberRecommend record);

    int updateOne(PartyMemberRecommend record);

    int deleteOne(Long recordId);

    List<PartyMemberRecommend> findAllByCondition(Map<String, Object> params);

    PartyMemberRecommend findOneByCondition(PartyMemberRecommend history);

}
