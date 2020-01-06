package com.newfeelings.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;



@Slf4j
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {

        if (e instanceof CustomException ) {
            StatusCode statusCode = ((CustomException) e).getStatusCode();
            return ResultUtil.error(statusCode);
        } else {
            return ResultUtil.error(StatusCode.ERROR);
        }

    }
}