package cn.sus.edu.partymemberdevelopment.service.Impl;

import cn.sus.edu.partymemberdevelopment.entity.Teacher;
import cn.sus.edu.partymemberdevelopment.mapper.TeacherMapper;
import cn.sus.edu.partymemberdevelopment.service.TeacherService;
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

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Map<String, Object> findAll(Map<String, Object> params) throws RuntimeException {
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
        List<Teacher> userList = teacherMapper.findAllByCondition(params);
        PageInfo<Teacher> pageInfo = new PageInfo<>(userList);
        return ResponseUtils.getSuccess("查询成功!", pageInfo.getList(), pageInfo.getTotal());
    }

    @Override
    public Teacher findOne(Teacher teacher) throws RuntimeException {
        AssertUtils.assertTrue(EmptyUtils.isEmpty(teacher), "role不为空!");
        return teacherMapper.findOneByCondition(teacher);
    }

    @Override
    public int addTeacher(Teacher teacher) throws RuntimeException {
        teacher.setCreateTime(LocalDateTime.now());
        return teacherMapper.addTeacher(teacher);
    }

    @Override
    public int modifyTeacher(Teacher teacher) throws RuntimeException {
        teacher.setModifyTime(LocalDateTime.now());
        return teacherMapper.updateTeacherById(teacher);
    }

    @Override
    public int deleteTeacher(Long teacherId) throws RuntimeException {
        AssertUtils.assertTrue(null==teacherId, "缺少必要参数!");
        Teacher teacher = new Teacher();
        teacher.setUserId(teacherId);
        Teacher existTeacher = teacherMapper.findOneByCondition(teacher);
        AssertUtils.assertTrue(null==existTeacher, "删除数据不存在!");
        return teacherMapper.deleteTeacherById(teacherId);
    }
}
