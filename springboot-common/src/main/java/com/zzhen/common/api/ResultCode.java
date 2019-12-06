package com.zzhen.common.api;

/**
 * <p>功能描述：api返回枚举对象</p>
 * <p>类名称：common.api.ResultCode</p>
 * <p>创建时间：2019/11/21 10:06</p>
 * @author zzhen
 */
public enum ResultCode implements IErrorCode {

    SUCCESS("200", "操作成功"),
    FAILED("500", "操作失败"),
    VALIDATE_FAILED("404", "参数检验失败"),
    UNAUTHORIZED("401", "暂未登录或token已经过期"),
    FORBIDDEN("403", "没有相关权限");

    private String code;

    private String message;

    private ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
