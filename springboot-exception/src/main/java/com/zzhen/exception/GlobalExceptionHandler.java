package com.zzhen.exception;

import com.zzhen.common.api.CommonResult;
import com.zzhen.common.api.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>功能描述：全局异常处理（此服务抛出的异常，都会别捕捉并返回给客户端）</p>
 * <p>类名称：com.zzhen.exception.GlobalExceptionHandler</p>
 * <p>创建时间：2019/11/28 10:43</p>
 * @author zzhen
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 处理自定义的业务异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = DemoExpection.class)
    @ResponseBody
    public CommonResult bizExceptionHandler(HttpServletRequest req, DemoExpection e) {
        LOGGER.error("发生业务异常！原因是：{}", e.getErrorMsg());
        return CommonResult.failed(e.getErrorMsg());
    }

    /**
     * 处理空指针的异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public CommonResult exceptionHandler(HttpServletRequest req, NullPointerException e) {
        LOGGER.error("发生空指针异常！原因是:", e);
        return CommonResult.failed(ResultCode.FAILED);
    }


    /**
     * 处理其他异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResult exceptionHandler(HttpServletRequest req, Exception e) {
        LOGGER.error("未知异常！原因是:", e);
        return CommonResult.failed(ResultCode.FAILED);
    }
}
