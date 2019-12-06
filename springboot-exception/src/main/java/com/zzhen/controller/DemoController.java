package com.zzhen.controller;

import com.zzhen.exception.DemoExpection;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>功能描述：测试全局异常controller</p>
 * <p>类名称：com.zzhen.controller.DemoController</p>
 * <p>创建时间：2019/11/28 11:08</p>
 * @author zzhen
 */
@RestController
@RequestMapping("/api")
public class DemoController {

    /**
     * <p>Title: 测试空指针异常</p>
     * <p>Create Time: 2019/11/28 11:14</p>
     * @author zhangzhen@bonc.com.cn
     */
    @PostMapping("/test01")
    public void test01(){
        String aa = null;
        aa.length();
    }

    /**
     * <p>Title: 测试自定义异常</p>
     * <p>Create Time: 2019/11/28 11:38</p>
     * @author zhangzhen@bonc.com.cn
     */
    @PostMapping("/test02")
    public void test02(){
        if(true){
            throw new DemoExpection("参数不能为空");
        }
    }
}
