package cn.sus.edu.partymemberdevelopment;

import cn.sus.edu.partymemberdevelopment.entity.ExcellentRecommend;
import cn.sus.edu.partymemberdevelopment.service.Impl.ExcellentRecommendServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExcellentRecommendTest {

    @Autowired
    private ExcellentRecommendServiceImpl recommendService;

    private void print(int row) {
        System.out.println("影响行数: " + row);
    }

    @Test
    public void add() {
        ExcellentRecommend recommend = new ExcellentRecommend();
        recommend.setRecordId(1L);
        recommend.setApplicant("马晓明");
        recommend.setSex("男");
        recommend.setStudentId("T20200818001");
        recommend.setClassName("高级计算机2班");
        recommend.setCurrentPosition("小组长");
        recommend.setBirthDate(LocalDateTime.now());
        recommend.setJoinGroupDate(LocalDateTime.now());
        recommend.setApplyJoinPartyDate(LocalDateTime.now());
        recommend.setMainPerformance("连续两年获得三好学生，参加技能比赛");
        recommend.setMainRewardsPunishments("连续两年获得三好学生，参加技能比赛");
        recommend.setYearValue(2020);
        recommend.setMonthValue(8);
        recommend.setDayValue(18);
        recommend.setComrade("马小明");
        recommend.setLeagueBranchName("学院组织部");
        recommend.setLeagueSecretary("马云");
        recommend.setSignatureTime(LocalDateTime.now());
        recommend.setParticipateNum(20);
        recommend.setArrivalsNum(20);
        recommend.setAgreeNum(18);
        recommend.setOpposeNum(2);
        recommend.setEffectiveNum(12);
        recommend.setInvalidNum(8);
        recommend.setReviewOpinion("无意间，同意申请");
        recommend.setReviewOpinionSignature("666");
        recommend.setReviewOpinionSignatureTime(LocalDateTime.now());
        recommend.setRecordOpinion("无意间，同意申请");
        recommend.setSchoolLeagueCommitteeSeal("666");
        recommend.setSecretarySignature("66");
        recommend.setRecordOpinionSignatureTime(LocalDateTime.now());
        recommend.setCreateTime(LocalDateTime.now());
        recommend.setCreator("admin");
        int addResult = recommendService.addOne(recommend);
        print(addResult);
    }

}
