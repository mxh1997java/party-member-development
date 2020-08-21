package cn.sus.edu.partymemberdevelopment.service.Impl;

import cn.sus.edu.partymemberdevelopment.entity.PartyMemberRecommend;
import cn.sus.edu.partymemberdevelopment.mapper.PartyMemberRecommendMapper;
import cn.sus.edu.partymemberdevelopment.service.PartyMemberRecommendService;
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
 * 功能描述: 入党积极分子党员群众推荐表业务层
 * @Author: 15735400536
 * @Date: 2020/8/18 17:34
 */
@Service
public class PartyMemberRecommendServiceImpl implements PartyMemberRecommendService {

    @Autowired
    private PartyMemberRecommendMapper recommendMapper;

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
        List<PartyMemberRecommend> excellentRecommendList = recommendMapper.findAllByCondition(params);
        PageInfo<PartyMemberRecommend> pageInfo = new PageInfo<>(excellentRecommendList);
        return ResponseUtils.getSuccess("查询成功!", pageInfo.getList(), pageInfo.getTotal());
    }

    @Override
    public PartyMemberRecommend findOne(PartyMemberRecommend recommend) throws RuntimeException {
        AssertUtils.assertTrue(EmptyUtils.isEmpty(recommend), "缺少必要参数!");
        PartyMemberRecommend existRecommend = recommendMapper.findOneByCondition(recommend);
        AssertUtils.assertTrue(EmptyUtils.isEmpty(existRecommend), "未查询数据!");
        return existRecommend;
    }

    @Override
    public int addOne(PartyMemberRecommend recommend) throws RuntimeException {
        AssertUtils.assertTrue(EmptyUtils.isEmpty(recommend), "缺少必要参数!");
        recommend.setCreateTime(LocalDateTime.now());
        return recommendMapper.insertOne(recommend);
    }

    @Override
    public int modifyOne(PartyMemberRecommend recommend) throws RuntimeException {
        AssertUtils.assertTrue(EmptyUtils.isEmpty(recommend), "缺少必要参数!");
        recommend.setModifyTime(LocalDateTime.now());
        return recommendMapper.updateOne(recommend);
    }

    @Override
    public int deleteOne(Long recordId) throws RuntimeException {
        AssertUtils.assertTrue(EmptyUtils.isEmpty(recordId), "缺少必要参数!");
        PartyMemberRecommend condition = new PartyMemberRecommend();
        condition.setRecordId(recordId);
        PartyMemberRecommend existRecord = findOne(condition);
        AssertUtils.assertTrue(EmptyUtils.isEmpty(existRecord), "删除数据不存在!");
        return recommendMapper.deleteOne(recordId);
    }
}
