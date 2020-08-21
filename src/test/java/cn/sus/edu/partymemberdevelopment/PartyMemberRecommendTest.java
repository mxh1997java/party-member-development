package cn.sus.edu.partymemberdevelopment;
import cn.sus.edu.partymemberdevelopment.entity.PartyMemberRecommend;
import cn.sus.edu.partymemberdevelopment.service.Impl.PartyMemberRecommendServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

/**
 * 功能描述: 申请入党积极分子党员群众推荐表
 * @Author: 15735400536
 * @Date: 2020/8/17 22:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PartyMemberRecommendTest {

    @Autowired
    private PartyMemberRecommendServiceImpl recommendService;

    private void print(int row) {
        System.out.println("影响行数: " + row);
    }

    @Test
    public void add() {
        PartyMemberRecommend recommend = new PartyMemberRecommend();
        recommend.setRecordId(3L);
        recommend.setApplicant("马小明");
        recommend.setSex("男");
        recommend.setNation("汉");
        recommend.setStudentId("T200208180004");
        recommend.setDepartment("学生会-学习部");
        recommend.setCurrentPosition("班长");
        recommend.setBirthDate(LocalDateTime.now());
        recommend.setApplyJoinPartyDate(LocalDateTime.now());
        recommend.setMainPerformance("三好学生，参加技能比赛，参加学生会活动，成绩优异");
        recommend.setMainRewardsPunishments("三好学生，参加技能比赛，参加学生会活动");
        recommend.setRecommendedSituation("三好学生，参加技能比赛，参加学生会活动，成绩优异");
        recommend.setPartyBranchName("学院组织部");
        recommend.setPartyBranchSecretarySignature("赵无极");
        recommend.setSignatureTime(LocalDateTime.now());
        recommend.setCreateTime(LocalDateTime.now());
        recommend.setCreator("admin");
        int addResult = recommendService.addOne(recommend);
        print(addResult);
    }

}
