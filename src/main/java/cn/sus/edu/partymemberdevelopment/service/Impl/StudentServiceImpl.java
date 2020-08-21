package cn.sus.edu.partymemberdevelopment.service.Impl;

import cn.sus.edu.partymemberdevelopment.entity.Student;
import cn.sus.edu.partymemberdevelopment.mapper.StudentMapper;
import cn.sus.edu.partymemberdevelopment.service.StudentService;
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
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

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
        List<Student> userList = studentMapper.findAllByCondition(params);
        PageInfo<Student> pageInfo = new PageInfo<>(userList);
        return ResponseUtils.getSuccess("查询成功!", pageInfo.getList(), pageInfo.getTotal());
    }

    @Override
    public Student findOne(Map<String, Object> params) throws RuntimeException {
        AssertUtils.assertTrue(EmptyUtils.isEmpty(params), "params不为空!");
        Student student = new Student();
        if(!EmptyUtils.isEmpty(params.get("studentId"))) {
            student.setUserId(Long.valueOf(String.valueOf(params.get("studentId"))));
        }
        if(!EmptyUtils.isEmpty(params.get("studentName"))) {
            student.setStudentName(String.valueOf(params.get("studentName")));
        }
        return studentMapper.findOneByCondition(student);
    }

    @Override
    public int addStudent(Student student) throws RuntimeException {
        AssertUtils.assertTrue(null==student, "student不为空!");
        student.setCreateTime(LocalDateTime.now());
        return studentMapper.addStudent(student);
    }

    @Override
    public int modifyStudent(Student student) throws RuntimeException {
        Student condition = new Student();
        condition.setStudentId(student.getStudentId());
        condition.setStudentName(student.getStudentName());
        Student existStudent = studentMapper.findOneByCondition(condition);
        AssertUtils.assertFalse(null!=existStudent, "修改失败!修改数据不存在");
        student.setModifyTime(LocalDateTime.now());
        return studentMapper.updateStudentById(student);
    }

    @Override
    public int deleteStudent(Long studentId) throws RuntimeException {
        AssertUtils.assertTrue(null==studentId, "缺少必要参数!");
        Student student = new Student();
        student.setStudentId(studentId);
        Student existStudent = studentMapper.findOneByCondition(student);
        AssertUtils.assertTrue(null==existStudent, "删除数据不存在!");
        return studentMapper.deleteStudentById(studentId);
    }
}
