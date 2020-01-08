package org.user.config;

import org.common.constants.StatusCode;
import org.common.exception.CustomException;
import org.common.result.Result;
import org.common.result.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Slf4j
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(HttpServletRequest req, Exception e) {
        log.error(req.getRequestURL().toString(), e);

        if (e instanceof CustomException) {
            StatusCode statusCode = ((CustomException) e).getStatusCode();
            return ResultUtil.error(statusCode);
        } else {
            return ResultUtil.error(StatusCode.ERROR);
        }

    }
}