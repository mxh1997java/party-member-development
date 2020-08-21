package cn.sus.edu.partymemberdevelopment;

import cn.sus.edu.partymemberdevelopment.configuration.constant.Constant;
import cn.sus.edu.partymemberdevelopment.entity.ApplyRecord;
import cn.sus.edu.partymemberdevelopment.service.Impl.ApplyRecordServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述: 入党申请人接口(没问题)
 * @Author: 15735400536
 * @Date: 2020/8/17 22:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplyRecordTest {

    @Autowired
    private ApplyRecordServiceImpl applyRecordService;

    private void print(int row) {
        System.out.println("影响行数: " + row);
    }

    @Test
    public void add() {
        ApplyRecord applyRecord = new ApplyRecord();
        applyRecord.setApplyId(2L);
        applyRecord.setApplicantId(7L);
        applyRecord.setApplicant("孙小明");
        applyRecord.setCreator("孙小明");
        applyRecord.setFileUrl("http://122.51.248.77/index.html");
        applyRecord.setApplyStatus(Constant.APPLY_STATUS);
        int addResult = applyRecordService.addApplyRecord(applyRecord);
        print(addResult);
    }


    @Test
    public void update(){
        ApplyRecord applyRecord = new ApplyRecord();
        applyRecord.setApplyId(2L);
        applyRecord.setApplicantId(7L);
        applyRecord.setApplicant("孙小明");
        applyRecord.setModifier("孙小明");
        applyRecord.setApplyStatus(Constant.APPLY_UNDER_REVIEW_STATUS);
        int modifyResult = applyRecordService.modifyApplyRecord(applyRecord);
        print(modifyResult);
    }


    @Test
    public void delete() {
        int deleteResult = applyRecordService.delApplyRecord(1L);
        print(deleteResult);
    }


    @Test
    public void findOne() {
        ApplyRecord applyRecord = new ApplyRecord();
        applyRecord.setApplyId(2L);
        applyRecord.setApplicantId(7L);
        ApplyRecord existApplyRecord = applyRecordService.findOneByCondition(applyRecord);
        System.out.println(existApplyRecord);
    }

    @Test
    public void findAll() {
        Map<String, Object> params = new HashMap<>();
        params.put("pageNum", 1);
        params.put("pageSize", 5);
        params.put("beginTime", "2020-8-17 00:00:00");
        params.put("endTime", "2020-8-20 00:00:00");
        Map<String, Object> response = applyRecordService.findAllByCondition(params);
        System.out.println(response);
    }

}
