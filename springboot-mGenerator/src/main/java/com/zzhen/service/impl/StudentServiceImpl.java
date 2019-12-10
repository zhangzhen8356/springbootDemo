package com.zzhen.service.impl;

import com.github.pagehelper.PageHelper;
import com.zzhen.dao.StudentMapper;
import com.zzhen.domain.Student;
import com.zzhen.domain.StudentExample;
import com.zzhen.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>功能描述：</p>
 * <p>类名称：com.zzhen.service.impl.StudentServiceImpl</p>
 * <p>创建时间：2019/12/6 10:21</p>
 * @author zzhen
 */
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public List<Student> listAllStudent() {
        return studentMapper.selectByExample(new StudentExample());
    }

    @Override
    public int createStudent(Student student) {
        return studentMapper.insertSelective(student);
    }

    @Override
    public int updateStudent(Long id, Student student) {
        student.setId(id);
        return studentMapper.updateByPrimaryKeySelective(student);
    }

    @Override
    public int deleteStudent(Long id) {
        return studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Student> listStudent(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return studentMapper.selectByExample(new StudentExample());
    }

    @Override
    public Student getStudent(Long id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Student> getStudentByCondition() {
        StudentExample studentExample = new StudentExample();
        studentExample.setOrderByClause("age");
        studentExample.setDistinct(true);
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andAgeBetween(18,35);
        criteria.andSexEqualTo(0);
        return studentMapper.selectByExample(studentExample);
    }
}
