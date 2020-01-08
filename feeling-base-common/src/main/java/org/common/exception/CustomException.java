package org.common.exception;

import org.common.constants.StatusCode;
import lombok.Data;

@Data
public class CustomException extends RuntimeException{
    /**
     * 抛出异常使用自定义的异常码
     * @param statusCode 自定义异常码
     */
    public static final long serialVersionUID = 1L;
    private StatusCode statusCode;

    public CustomException(StatusCode statusCode) {
        super(statusCode.getMessage());
        this.statusCode = statusCode;
    }
 
    public CustomException(StatusCode statusCode, Throwable cause) {
        super(statusCode.getMessage(), cause);
        this.statusCode = statusCode;
    }
 
    public CustomException(StatusCode statusCode, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(statusCode.getMessage(), cause, enableSuppression, writableStackTrace);
        this.statusCode = statusCode;
    }
 
}