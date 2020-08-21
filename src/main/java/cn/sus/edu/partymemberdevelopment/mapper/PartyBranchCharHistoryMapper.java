package cn.sus.edu.partymemberdevelopment.mapper;

import cn.sus.edu.partymemberdevelopment.entity.PartyBranchCharHistory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 功能描述: 党支部派人同入党申请人谈话记录持久层
 * @Author: 15735400536
 * @Date: 2020/8/18 14:11
 */
@Repository
@Mapper
public interface PartyBranchCharHistoryMapper {

    int insertOne(PartyBranchCharHistory record);

    int updateOne(PartyBranchCharHistory record);

    int deleteOne(Long recordId);

    List<PartyBranchCharHistory> findAllByCondition(Map<String, Object> params);

    PartyBranchCharHistory findOneByCondition(PartyBranchCharHistory history);

}
