package cn.sus.edu.partymemberdevelopment.mapper;

import cn.sus.edu.partymemberdevelopment.entity.ApplyRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 类描述: 申请入党持久层
 * @Author: XinHai.Ma
 * @Date: 2020/8/16 11:16
 */
@Repository
@Mapper
public interface ApplyRecordMapper {

    List<ApplyRecord> findAllByCondition(Map<String, Object> params);

    ApplyRecord findOneByCondition(ApplyRecord record);

    int insertOne(ApplyRecord applyRecord);

    int deleteOne(Long recordId);

    int updateOne(ApplyRecord applyRecord);

}
