package cn.sus.edu.partymemberdevelopment.mapper;

import cn.sus.edu.partymemberdevelopment.entity.ExcellentRecommend;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

/**
 * 功能描述: 团组织“推优”表持久层
 * @Author: 15735400536
 * @Date: 2020/8/18 14:11
 */
@Repository
@Mapper
public interface ExcellentRecommendMapper {

    int insertOne(ExcellentRecommend record);

    int updateOne(ExcellentRecommend record);

    int deleteOne(Long recordId);

    List<ExcellentRecommend> findAllByCondition(Map<String, Object> params);

    ExcellentRecommend findOneByCondition(ExcellentRecommend history);

}
