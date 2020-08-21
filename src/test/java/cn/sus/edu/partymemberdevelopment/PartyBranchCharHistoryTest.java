package cn.sus.edu.partymemberdevelopment;
import cn.sus.edu.partymemberdevelopment.entity.PartyBranchCharHistory;
import cn.sus.edu.partymemberdevelopment.service.Impl.PartyBranchCharHistoryServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PartyBranchCharHistoryTest {

    @Autowired
    private PartyBranchCharHistoryServiceImpl charHistoryService;

    private void print(int row) {
        System.out.println("影响行数: " + row);
    }

    @Test
    public void add() {
        PartyBranchCharHistory history = new PartyBranchCharHistory();
        history.setRecordId(1L);
        history.setPartyBranchName("学院组织部");
        history.setApplicantName("马小明");
        history.setSex("男");
        history.setNation("汉");
        history.setHometown("山西省晋城市阳城县北留镇小沟村");
        history.setDepartment("");
        history.setWordId("T20200818010");
        history.setBirthDate(LocalDateTime.now());
        history.setJoinGroupDate(LocalDateTime.now());
        history.setApplyJoinPartyDate(LocalDateTime.now());
        history.setTalkTime(LocalDateTime.now());
        history.setTalkLocation("admin");
        history.setTalkRecord("一个幽灵，共产主义的幽灵，在欧洲游荡。为了对这个幽灵进行神圣的围剿，旧欧洲的一切势力，教皇和沙皇、梅特涅和基佐、法国的激进派和德国的警察，都联合起来了。" +
                "有哪一个反对党不被它的当政的敌人骂为共产党呢？又有哪一个反对党不拿共产主义这个罪名去回敬更进步的反对党人和自己的反动敌人呢？");
        history.setTalker("admin");
        history.setUnitPosition("admin");
        history.setCreateTime(LocalDateTime.now());
        history.setCreator("admin");
        int addResult = charHistoryService.addOne(history);
        print(addResult);
    }

}
