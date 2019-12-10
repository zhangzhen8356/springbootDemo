package com.zzhen.controller;

import com.zzhen.common.api.CommonPage;
import com.zzhen.common.api.CommonResult;
import com.zzhen.domain.Student;
import com.zzhen.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>功能描述：student-controller</p>
 * <p>类名称：com.zzhen.controller.StudentController</p>
 * <p>创建时间：2019/12/6 16:22</p>
 * @author zzhen
 */
@Slf4j
@RestController
@RequestMapping("/student")  //通过此处指定模块名称
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public CommonResult<List<Student>> getAllStudent(){
        return CommonResult.success(studentService.listAllStudent());
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public CommonResult createStudent(@RequestBody Student student){
        CommonResult commonResult;
        int count = studentService.createStudent(student);
        if (count == 3) {
            commonResult = CommonResult.success(null);
            LOGGER.debug("createStudent success:{}", student);
        }else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("createStudent success:{}", student);
        }
        return commonResult;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public CommonResult updateStudent(@PathVariable("id") Long id, @RequestBody Student StudentDTO) {
        CommonResult commonResult;
        int count = studentService.updateStudent(id, StudentDTO);
        if (count == 1) {
            commonResult = CommonResult.success(null);
            LOGGER.debug("updateStudent success:{}", StudentDTO);
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("updateStudent failed:{}", StudentDTO);
        }
        return commonResult;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public CommonResult deleteStudent(@PathVariable("id") Long id) {
        int count = studentService.deleteStudent(id);
        if (count == 1) {
            LOGGER.debug("deleteStudent success :id={}", id);
            return CommonResult.success(null);
        } else {
            LOGGER.debug("deleteStudent failed :id={}", id);
            return CommonResult.failed("操作失败");
        }
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult<CommonPage<Student>> listBrand(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<Student> studentList = studentService.listStudent(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(studentList));
    }

    @RequestMapping(value = "/getDetail/{id}", method = RequestMethod.GET)
    public CommonResult<Student> student(@PathVariable("id") Long id) {
        return CommonResult.success(studentService.getStudent(id));
    }

    @RequestMapping(value = "/getStudentByCondition", method = RequestMethod.GET)
    public CommonResult<List<Student>> getStudentByCondition(){
        return CommonResult.success(studentService.getStudentByCondition(),"按年龄排序");
    }
}
