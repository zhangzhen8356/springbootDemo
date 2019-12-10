package com.zzhen.service;

import com.zzhen.domain.Student;

import java.util.List;

/**
 * <p>功能描述：</p>
 * <p>类名称：com.zzhen.service.StudentService</p>
 * <p>创建时间：2019/11/28 16:54</p>
 * @author zzhen
 */
public interface StudentService {


    List<Student> listAllStudent();

    int createStudent(Student student);

    int updateStudent(Long id,Student student);

    int deleteStudent(Long id);

    List<Student> listStudent(int pageNum, int pageSize);

    Student getStudent(Long id);

    List<Student> getStudentByCondition();
}
