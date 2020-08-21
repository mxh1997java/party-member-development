package cn.sus.edu.partymemberdevelopment.service.Impl;

import cn.sus.edu.partymemberdevelopment.entity.ApplyRecord;
import cn.sus.edu.partymemberdevelopment.entity.Student;
import cn.sus.edu.partymemberdevelopment.entity.Teacher;
import cn.sus.edu.partymemberdevelopment.entity.User;
import cn.sus.edu.partymemberdevelopment.mapper.ApplyRecordMapper;
import cn.sus.edu.partymemberdevelopment.mapper.StudentMapper;
import cn.sus.edu.partymemberdevelopment.mapper.TeacherMapper;
import cn.sus.edu.partymemberdevelopment.mapper.UserMapper;
import cn.sus.edu.partymemberdevelopment.service.ApplyRecordService;
import cn.sus.edu.partymemberdevelopment.util.AssertUtils;
import cn.sus.edu.partymemberdevelopment.util.DateUtils;
import cn.sus.edu.partymemberdevelopment.util.EmptyUtils;
import cn.sus.edu.partymemberdevelopment.util.ResponseUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

@Service
public class ApplyRecordServiceImpl implements ApplyRecordService {

    @Autowired
    private ApplyRecordMapper applyRecordMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public int addApplyRecord(ApplyRecord applyRecord) throws RuntimeException {
        AssertUtils.assertTrue(EmptyUtils.isEmpty(applyRecord.getApplicant()), "未填写申请人!");
        AssertUtils.assertTrue(EmptyUtils.isEmpty(applyRecord.getApplicantId()), "未填写申请人!");
        User user = new User();
        user.setUserId(applyRecord.getApplicantId());
        user.setUsername(applyRecord.getApplicant());
        User existUser = userMapper.findOneByCondition(user);
        AssertUtils.assertTrue(EmptyUtils.isEmpty(existUser), "系统无申请人" + applyRecord.getApplicant() + "信息!");
        AssertUtils.assertTrue(existUser.getUserAge()<18, "申请人" + applyRecord.getApplicant() + "未满18岁不能申请!");
        applyRecord.setCreateTime(LocalDateTime.now());
        return applyRecordMapper.insertOne(applyRecord);
    }

    @Override
    public int delApplyRecord(Long recordId) throws RuntimeException {
        AssertUtils.assertTrue(null==recordId, "缺少必要参数!");
        return applyRecordMapper.deleteOne(recordId);
    }

    @Override
    public int modifyApplyRecord(ApplyRecord applyRecord) throws RuntimeException {
        return applyRecordMapper.updateOne(applyRecord);
    }


    @Override
    public ApplyRecord findOneByCondition(ApplyRecord applyRecord) throws RuntimeException {
        AssertUtils.assertTrue(EmptyUtils.isEmpty(applyRecord), "applyRecord不为空!");
        return applyRecordMapper.findOneByCondition(applyRecord);
    }


    @Override
    public Map<String, Object> findAllByCondition(Map<String, Object> params) throws RuntimeException {
        AssertUtils.assertTrue(EmptyUtils.isEmpty(params), "params不为空!");
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
        List<ApplyRecord> recordList = applyRecordMapper.findAllByCondition(params);
        PageInfo<ApplyRecord> pageInfo = new PageInfo<>(recordList);
        return ResponseUtils.getSuccess("查询成功", pageInfo.getList(), pageInfo.getTotal());
    }


    /**
     * 功能描述: 提交团组织优推表
     * @Param: [applyRecord]
     * @Return: int
     * @Author: 15735400536
     * @Date: 2020/8/16 18:17
     */
    @Override
    public int applyOrganizationRecommend(ApplyRecord applyRecord) throws RuntimeException {
        AssertUtils.assertTrue(EmptyUtils.isEmpty(applyRecord), "缺少必要参数!");
        User user = new User();
        user.setUserId(applyRecord.getApplicantId());
        user.setUsername(applyRecord.getApplicant());
        User existUser = userMapper.findOneByCondition(user);
        AssertUtils.assertTrue(EmptyUtils.isEmpty(existUser), "系统未查询到申请人" + applyRecord.getApplicant() + "用户信息!");
        String firstLevelRole = existUser.getFirstLevelRole();
        AssertUtils.assertTrue("教师".equals(firstLevelRole), "申请失败!角色不符合申请标准");
        Student student = new Student();
        student.setUserId(existUser.getUserId());
        Student existStudent = studentMapper.findOneByCondition(student);
        AssertUtils.assertTrue(EmptyUtils.isEmpty(existStudent), "系统未查询到申请人" + applyRecord.getApplicant() + "学生信息!");

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime joinPartyDate = existStudent.getJoinPartyDate();
        LocalDateTime plus = DateUtils.plus(joinPartyDate, 6, ChronoUnit.MONTHS);
        AssertUtils.assertTrue(DateUtils.localDateIsBefore(plus, now), "申请失败!申请人入党未满6个月");

        LocalDateTime joinGroupDate = existStudent.getJoinGroupDate();
        plus = DateUtils.plus(joinGroupDate, 1, ChronoUnit.YEARS);
        AssertUtils.assertTrue(DateUtils.localDateIsBefore(plus, now), "申请失败!申请人入团未满1个年");

        AssertUtils.assertTrue(28<=existUser.getUserAge(), "申请失败!团组织优推表适用于年龄28周岁以下的入党申请人");

        return applyRecordMapper.insertOne(applyRecord);
    }


    /**
     * 功能描述: 修改团组织优推表
     * @Param: [applyRecord]
     * @Return: int
     * @Author: 15735400536
     * @Date: 2020/8/16 18:18
     */
    @Override
    public int modifyOrganizationRecommend(ApplyRecord applyRecord) throws RuntimeException {
        AssertUtils.assertTrue(EmptyUtils.isEmpty(applyRecord), "缺少必要参数!");
        User user = new User();
        user.setUsername(applyRecord.getApplicant());
        user.setUserId(applyRecord.getApplicantId());
        User existUser = userMapper.findOneByCondition(user);
        AssertUtils.assertTrue(EmptyUtils.isEmpty(existUser), "系统未查询到修改人" + applyRecord.getApplicant() + "用户信息!");
        Teacher teacher = new Teacher();
        teacher.setUserId(existUser.getUserId());
        Teacher existTeacher = teacherMapper.findOneByCondition(teacher);
        AssertUtils.assertTrue(EmptyUtils.isEmpty(existTeacher), "系统未查询到修改人" + applyRecord.getApplicant() + "教师信息!");
        String collegeCommittee = existTeacher.getCollegeYouthLeagueCommittee();
        String schoolCommittee = existTeacher.getSchoolYouthLeagueCommittee();
        if(!"是".equals(collegeCommittee) && !"是".equals(schoolCommittee)) {
            AssertUtils.assertTrue(true, "修改人" + applyRecord.getApplicant() + "无权限修改状态");
        }
        return applyRecordMapper.updateOne(applyRecord);
    }


    @Override
    public Map<String, Object> findAllOrganizationRecommend(Map<String, Object> params) throws RuntimeException {
        AssertUtils.assertTrue(EmptyUtils.isEmpty(params), "缺少必要参数!");
        AssertUtils.assertTrue(EmptyUtils.isEmpty(params.get("userId")), "缺少必要参数");
        User user = new User();
        user.setUserId(Long.valueOf(params.get("userId").toString()));
        User existUser = userMapper.findOneByCondition(user);
        AssertUtils.assertTrue(EmptyUtils.isEmpty(existUser), "系统未查询到查阅者" + params.get("userId") + "用户信息!");
        String firstLevelRole = existUser.getFirstLevelRole();
        AssertUtils.assertTrue(EmptyUtils.isEmpty("学生".equals(firstLevelRole)), "查询失败!用户角色没权限查询数据");
        Teacher teacher = new Teacher();
        teacher.setUserId(existUser.getUserId());
        Teacher existTeacher = teacherMapper.findOneByCondition(teacher);
        AssertUtils.assertTrue(EmptyUtils.isEmpty(existTeacher), "系统未查询到查阅者" + params.get("userId") + "教师信息!");

        if(teacherAuth(existTeacher)) {
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
            List<ApplyRecord> applyRecordList = applyRecordMapper.findAllByCondition(params);
            PageInfo<ApplyRecord> pageInfo = new PageInfo<>(applyRecordList);
            return ResponseUtils.getSuccess("查询成功!", pageInfo.getList(), pageInfo.getTotal());
        }
        return ResponseUtils.getFailure("查询失败!没权限");
    }


    @Override
    public int applyPartyMemberRecommend(ApplyRecord applyRecord) throws RuntimeException {
        AssertUtils.assertTrue(EmptyUtils.isEmpty(applyRecord), "缺少必要参数!");
        User user = new User();
        user.setUserId(applyRecord.getApplicantId());
        user.setUsername(applyRecord.getApplicant());
        User existUser = userMapper.findOneByCondition(user);
        AssertUtils.assertTrue(EmptyUtils.isEmpty(existUser), "系统未查询到申请人" + applyRecord.getApplicant() + "用户信息!");
        String firstLevelRole = existUser.getFirstLevelRole();
        AssertUtils.assertTrue("教师".equals(firstLevelRole), "申请失败!角色不符合申请标准");
        Student student = new Student();
        student.setUserId(existUser.getUserId());
        Student existStudent = studentMapper.findOneByCondition(student);
        AssertUtils.assertTrue(EmptyUtils.isEmpty(existStudent), "系统未查询到申请人" + applyRecord.getApplicant() + "学生信息!");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime joinPartyDate = existStudent.getJoinPartyDate();
        LocalDateTime plus = DateUtils.plus(joinPartyDate, 6, ChronoUnit.MONTHS);
        AssertUtils.assertTrue(DateUtils.localDateIsBefore(plus, now), "申请失败!申请人入党未满6个月");
        LocalDateTime joinGroupDate = existStudent.getJoinGroupDate();
        plus = DateUtils.plus(joinGroupDate, 1, ChronoUnit.YEARS);
        AssertUtils.assertTrue(DateUtils.localDateIsBefore(plus, now), "申请失败!申请人入团未满1个年");
        AssertUtils.assertTrue(28<=existUser.getUserAge(), "申请失败!团组织优推表适用于年龄28周岁以下的入党申请人");
        return applyRecordMapper.insertOne(applyRecord);
    }

    @Override
    public int modifyPartyMemberRecommend(ApplyRecord applyRecord) throws RuntimeException {
        AssertUtils.assertTrue(EmptyUtils.isEmpty(applyRecord), "缺少必要参数!");
        User user = new User();
        user.setUsername(applyRecord.getApplicant());
        user.setUserId(applyRecord.getApplicantId());
        User existUser = userMapper.findOneByCondition(user);
        AssertUtils.assertTrue(EmptyUtils.isEmpty(existUser), "系统未查询到修改人" + applyRecord.getApplicant() + "用户信息!");
        Teacher teacher = new Teacher();
        teacher.setUserId(existUser.getUserId());
        Teacher existTeacher = teacherMapper.findOneByCondition(teacher);
        AssertUtils.assertTrue(EmptyUtils.isEmpty(existTeacher), "系统未查询到修改人" + applyRecord.getApplicant() + "教师信息!");
        String collegeCommittee = existTeacher.getCollegeYouthLeagueCommittee();
        String schoolCommittee = existTeacher.getSchoolYouthLeagueCommittee();
        if(!"是".equals(collegeCommittee) && !"是".equals(schoolCommittee)) {
            AssertUtils.assertTrue(true, "修改人" + applyRecord.getApplicant() + "无权限修改状态");
        }
        return applyRecordMapper.updateOne(applyRecord);
    }


    @Override
    public int addPartyActivistsMeetingMinutes(ApplyRecord applyRecord) throws RuntimeException {
        return 0;
    }

    @Override
    public Map<String, Object> findAllPartyActivistsMeetingMinutes(Map<String, Object> params) throws RuntimeException {
        return null;
    }

    @Override
    public int submitThoughtReport(ApplyRecord applyRecord) throws RuntimeException {
        return 0;
    }

    @Override
    public int modifyThoughtReport(ApplyRecord applyRecord) throws RuntimeException {
        return 0;
    }

    @Override
    public int submitPartyBranchCharHistory(ApplyRecord applyRecord) throws RuntimeException {
        return 0;
    }

    @Override
    public int modifyPartyBranchCharHistory(ApplyRecord applyRecord) throws RuntimeException {
        return 0;
    }

    @Override
    public Map<String, Object> findAllPartyBranchCharHistory(Map<String, Object> params) throws RuntimeException {
        AssertUtils.assertTrue(EmptyUtils.isEmpty(params), "缺少必要参数!");
        AssertUtils.assertTrue(EmptyUtils.isEmpty(params.get("userId")), "缺少必要参数");
        User user = new User();
        user.setUserId(Long.valueOf(params.get("userId").toString()));
        User existUser = userMapper.findOneByCondition(user);
        AssertUtils.assertTrue(EmptyUtils.isEmpty(existUser), "系统未查询到查阅者" + params.get("userId") + "用户信息!");
        String firstLevelRole = existUser.getFirstLevelRole();
        AssertUtils.assertTrue(EmptyUtils.isEmpty("学生".equals(firstLevelRole)), "查询失败!用户角色没权限查询数据");
        Teacher teacher = new Teacher();
        teacher.setUserId(existUser.getUserId());
        Teacher existTeacher = teacherMapper.findOneByCondition(teacher);
        AssertUtils.assertTrue(EmptyUtils.isEmpty(existTeacher), "系统未查询到查阅者" + params.get("userId") + "教师信息!");

        if(teacherAuth(existTeacher)) {
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
            List<ApplyRecord> applyRecordList = applyRecordMapper.findAllByCondition(params);
            PageInfo<ApplyRecord> pageInfo = new PageInfo<>(applyRecordList);
            return ResponseUtils.getSuccess("查询成功!", pageInfo.getList(), pageInfo.getTotal());
        }
        return ResponseUtils.getFailure("查询失败!没权限");
    }


    /**
     * 功能描述: 校验教师权限
     * @Param: [teacher]
     * @Return: boolean
     * @Author: 15735400536
     * @Date: 2020/8/16 21:25
     */
    public boolean teacherAuth(Teacher teacher) {
        //学院党支部书记
        String collegePartyBranchSecretary = teacher.getCollegePartyBranchSecretary();
        //学院团委
        String collegeYouthLeagueCommittee = teacher.getCollegeYouthLeagueCommittee();
        //学校团委
        String schoolYouthLeagueCommittee = teacher.getSchoolYouthLeagueCommittee();
        String collegePartyCommitteeOrganizer = teacher.getCollegePartyCommitteeOrganizer();
        String collegePartyTotalBranchOrganizer = teacher.getCollegePartyTotalBranchOrganizer();
        String collegeDirectlyUnderPartyBranchOrganizer = teacher.getCollegeDirectlyUnderPartyBranchOrganizer();
        String collegePartySecretary = teacher.getCollegePartySecretary();
        String collegePartyCommitteeViceSecretary = teacher.getCollegePartyCommitteeViceSecretary();
        String collegePartyTotalBranchSecretary = teacher.getCollegePartyTotalBranchSecretary();
        String collegePartyTotalBranchViceSecretary = teacher.getCollegePartyTotalBranchViceSecretary();
        //TODO 少了两个角色： 学院直属党支书记、党组织部
        if("是".equals(collegePartyBranchSecretary) || "是".equals(collegeYouthLeagueCommittee) || "是".equals(schoolYouthLeagueCommittee) ||
                "是".equals(collegePartyCommitteeOrganizer) || "是".equals(collegePartyTotalBranchOrganizer) || "是".equals(collegeDirectlyUnderPartyBranchOrganizer) ||
                "是".equals(collegePartySecretary) || "是".equals(collegePartyCommitteeViceSecretary) || "是".equals(collegePartyTotalBranchSecretary) ||
                "是".equals(collegePartyTotalBranchViceSecretary)) {
            return true;
        }
        return false;
    }

}
