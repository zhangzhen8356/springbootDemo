package com.zzhen.exception;

import com.zzhen.common.api.IErrorCode;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>功能描述：自定义异常</p>
 * <p>类名称：com.zzhen.exception.DemoExpection</p>
 * <p>创建时间：2019/11/28 10:48</p>
 * @author zzhen
 */
@Getter
@Setter
public class DemoExpection extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    protected String errorCode;
    /**
     * 错误信息
     */
    protected String errorMsg;

    public DemoExpection() {
        super();
    }

    public DemoExpection(IErrorCode iErrorCode) {
        super(iErrorCode.getCode());
        this.errorCode = iErrorCode.getCode();
        this.errorMsg = iErrorCode.getMessage();
    }

    public DemoExpection(IErrorCode iErrorCode, Throwable cause) {
        super(iErrorCode.getCode(), cause);
        this.errorCode = iErrorCode.getCode();
        this.errorMsg = iErrorCode.getMessage();
    }

    public DemoExpection(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public DemoExpection(String errorCode, String errorMsg) {
        super(errorCode);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public DemoExpection(String errorCode, String errorMsg, Throwable cause) {
        super(errorCode, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
