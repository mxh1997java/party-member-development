package cn.sus.edu.partymemberdevelopment;

import cn.sus.edu.partymemberdevelopment.entity.UserRole;
import cn.sus.edu.partymemberdevelopment.mapper.UserRoleMapper;
import cn.sus.edu.partymemberdevelopment.service.Impl.UserRoleServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 功能描述: 用户角色接口测试(没问题)
 * @Author: 15735400536
 * @Date: 2020/8/17 15:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRoleTest {

    @Autowired
    private UserRoleServiceImpl userRoleService;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Test
    public void addUserRole() {
        UserRole userRole = new UserRole();
        userRole.setRoleId(1l);
        userRole.setRoleName("党委主席");
        userRole.setDescription("大官");
        userRole.setUrl("www.baidu.com");
        userRole.setCode(100);
        userRole.setCreator("admin");
        int addResult = userRoleService.addRole(userRole);
        System.out.println("影响行数: " + addResult);
    }

    @Test
    public void batchInsert() {
        String data = "学院党支部书记、学院党委组织员、学院党总支组织员、学院直属党支组织员、学院党委副书记、学院党委书记、学院党总支副书记、学院党总支书记、学院直属党支书记、党组织部";
        String[] split = data.split("、");
        List<UserRole> userRoleList = new ArrayList<>(split.length);
        long id = 2;
        for(int i=0; i<split.length; i++) {
            UserRole userRole = new UserRole();
            userRole.setRoleId(id);
            userRole.setRoleName(split[i]);
            userRole.setDescription(split[i]);
            userRole.setUrl("www.baidu.com");
            userRole.setCode(100);
            userRole.setCreator("admin");
            userRole.setCreateTime(LocalDateTime.now());
            userRoleList.add(userRole);
            id++;
        }
        System.out.println(Arrays.asList(userRoleList));
        int addResult = userRoleMapper.batchInsert(userRoleList);
        System.out.println("影响行数: " + addResult);
    }


    @Test
    public void findAllTest() {
        List<UserRole> userRoleList = userRoleService.findAll();
        System.out.println(Arrays.asList(userRoleList));
    }


    @Test
    public void findOneTest() {
        UserRole role = new UserRole();
        role.setRoleId(1l);
        role.setRoleName("党委主席");
        UserRole userRole = userRoleService.findOne(role);
        System.out.println(userRole);
    }


    @Test
    public void update() {
        UserRole role = new UserRole();
        role.setRoleId(1l);
        role.setRoleName("军委主席");
        role.setUrl("www.*.com");
        role.setDescription("一号首长");
        int modifyResult = userRoleService.modifyRole(role);
        System.out.println("影响行数: " + modifyResult);
    }

    @Test
    public void delete() {
        int deleteResult = userRoleService.deleteRole(1l);
        System.out.println("影响行数: " + deleteResult);
    }

}
