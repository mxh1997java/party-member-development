package cn.sus.edu.partymemberdevelopment.service.Impl;

import cn.sus.edu.partymemberdevelopment.entity.ExcellentRecommend;
import cn.sus.edu.partymemberdevelopment.mapper.ExcellentRecommendMapper;
import cn.sus.edu.partymemberdevelopment.service.ExcellentRecommendService;
import cn.sus.edu.partymemberdevelopment.util.AssertUtils;
import cn.sus.edu.partymemberdevelopment.util.EmptyUtils;
import cn.sus.edu.partymemberdevelopment.util.ResponseUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * 功能描述: 团组织优推表业务层
 * @Author: 15735400536
 * @Date: 2020/8/18 16:14
 */
@Service
public class ExcellentRecommendServiceImpl implements ExcellentRecommendService {

    @Autowired
    private ExcellentRecommendMapper excellentRecommendMapper;

    @Override
    public Map<String, Object> findAll(Map<String, Object> params) throws RuntimeException {
        AssertUtils.assertTrue(EmptyUtils.isEmpty(params), "缺少必要参数!");
        AssertUtils.assertTrue(EmptyUtils.isEmpty(params.get("pageNum")), "pageNum不为空!");
        AssertUtils.assertTrue(EmptyUtils.isEmpty(params.get("pageSize")), "pageSize不为空!");
        Integer pageNum = Integer.valueOf(String.valueOf(params.get("pageNum")));
        Integer pageSize = Integer.valueOf(String.valueOf(params.get("pageSize")));
        if(pageNum == null || pageNum == 0) {
            pageNum = 1;
        }
        if(pageSize == null || pageSize == 0) {
            pageSize = 10;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<ExcellentRecommend> excellentRecommendList = excellentRecommendMapper.findAllByCondition(params);
        PageInfo<ExcellentRecommend> pageInfo = new PageInfo<>(excellentRecommendList);
        return ResponseUtils.getSuccess("查询成功!", pageInfo.getList(), pageInfo.getTotal());
    }

    @Override
    public ExcellentRecommend findOne(ExcellentRecommend recommend) throws RuntimeException {
        AssertUtils.assertTrue(EmptyUtils.isEmpty(recommend), "缺少必要参数!");
        ExcellentRecommend existRecommend = excellentRecommendMapper.findOneByCondition(recommend);
        AssertUtils.assertTrue(EmptyUtils.isEmpty(existRecommend), "未查询数据!");
        return existRecommend;
    }

    @Override
    public int addOne(ExcellentRecommend recommend) throws RuntimeException {
        AssertUtils.assertTrue(EmptyUtils.isEmpty(recommend), "缺少必要参数!");
        recommend.setCreateTime(LocalDateTime.now());
        return excellentRecommendMapper.insertOne(recommend);
    }

    @Override
    public int modifyOne(ExcellentRecommend recommend) throws RuntimeException {
        AssertUtils.assertTrue(EmptyUtils.isEmpty(recommend), "缺少必要参数!");
        recommend.setModifyTime(LocalDateTime.now());
        return excellentRecommendMapper.updateOne(recommend);
    }

    @Override
    public int deleteOne(Long recordId) throws RuntimeException {
        AssertUtils.assertTrue(EmptyUtils.isEmpty(recordId), "缺少必要参数!");
        ExcellentRecommend condition = new ExcellentRecommend();
        condition.setRecordId(recordId);
        ExcellentRecommend existRecord = findOne(condition);
        AssertUtils.assertTrue(EmptyUtils.isEmpty(existRecord), "删除数据不存在!");
        return excellentRecommendMapper.deleteOne(recordId);
    }
}
