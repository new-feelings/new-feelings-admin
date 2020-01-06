package com.newfeelings.user.common;

import lombok.Data;

@Data
public class Result {
    private boolean flag;
    private Integer code;
    private String message;
    private Object data;
}
