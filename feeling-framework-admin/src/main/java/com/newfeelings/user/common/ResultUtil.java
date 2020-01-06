package com.newfeelings.user.common;

import java.io.Serializable;

public class ResultUtil implements Serializable {

    private static final long serialVersionUID = 1679552421651455773L;

    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(StatusCode.OK.getValue());
        result.setFlag(true);
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(StatusCode statusCode) {
        Result result = new Result();
        result.setCode(statusCode.getValue());
        result.setMessage(statusCode.getMessage());
        return result;
    }
}
 