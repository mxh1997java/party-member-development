package cn.sus.edu.partymemberdevelopment.mapper;

import cn.sus.edu.partymemberdevelopment.entity.BranchApproveMeetingRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 功能描述: 支部审批大会会议记录持久层
 * @Author: 15735400536
 * @Date: 2020/8/18 13:24
 */
@Repository
@Mapper
public interface BranchApproveMeetingRecordMapper {

    int insertOne(BranchApproveMeetingRecord record);

    int updateOne(BranchApproveMeetingRecord record);

    int deleteOne(Long recordId);

    List<BranchApproveMeetingRecord> findAll(Map<String, Object> params);

}
