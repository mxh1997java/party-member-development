package cn.sus.edu.partymemberdevelopment.service.Impl;

import cn.sus.edu.partymemberdevelopment.entity.PartyBranchCharHistory;
import cn.sus.edu.partymemberdevelopment.mapper.PartyBranchCharHistoryMapper;
import cn.sus.edu.partymemberdevelopment.service.PartyBranchCharHistoryService;
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
 * 功能描述: 党支部派人同入党申请人谈话记录业务层
 * @Author: 15735400536
 * @Date: 2020/8/18 15:00
 */
@Service
public class PartyBranchCharHistoryServiceImpl implements PartyBranchCharHistoryService {

    @Autowired
    private PartyBranchCharHistoryMapper charHistoryMapper;

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
        List<PartyBranchCharHistory> charHistoryList = charHistoryMapper.findAllByCondition(params);
        PageInfo<PartyBranchCharHistory> pageInfo = new PageInfo<>(charHistoryList);
        return ResponseUtils.getSuccess("查询成功!", pageInfo.getList(), pageInfo.getTotal());
    }

    @Override
    public PartyBranchCharHistory findOne(PartyBranchCharHistory history) throws RuntimeException {
        AssertUtils.assertTrue(EmptyUtils.isEmpty(history), "缺少必要参数!");
        PartyBranchCharHistory charHistory = charHistoryMapper.findOneByCondition(history);
        AssertUtils.assertTrue(EmptyUtils.isEmpty(charHistory), "未查询数据!");
        return charHistory;
    }

    @Override
    public int addOne(PartyBranchCharHistory history) throws RuntimeException {
        AssertUtils.assertTrue(EmptyUtils.isEmpty(history), "缺少必要参数!");
        history.setCreateTime(LocalDateTime.now());
        return charHistoryMapper.insertOne(history);
    }

    @Override
    public int modifyOne(PartyBranchCharHistory history) throws RuntimeException {
        AssertUtils.assertTrue(EmptyUtils.isEmpty(history), "缺少必要参数!");
        history.setModifyTime(LocalDateTime.now());
        return charHistoryMapper.updateOne(history);
    }

    @Override
    public int deleteOne(Long recordId) throws RuntimeException {
        AssertUtils.assertTrue(EmptyUtils.isEmpty(recordId), "缺少必要参数!");
        PartyBranchCharHistory condition = new PartyBranchCharHistory();
        condition.setRecordId(recordId);
        PartyBranchCharHistory existRecord = findOne(condition);
        AssertUtils.assertTrue(EmptyUtils.isEmpty(existRecord), "删除数据不存在!");
        return charHistoryMapper.deleteOne(recordId);
    }
}
