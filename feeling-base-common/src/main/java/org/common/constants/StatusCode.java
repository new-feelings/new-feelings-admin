package org.common.constants;

public enum StatusCode {

    OK(20000, "成功"),
    ERROR(20001, "服务错误"),
    LOGINERROR(20002, "登录错误"),
    ACCESSERROR(20003, "权限错误"),
    REMOTEERROR(20004, "远程钓调用失败"),
    REPERROR(20005, "重复操作");
    private int value;
    private String message;

    StatusCode(int value, String message){
        this.value = value;
        this.message = message;
    }

    public int getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }


}
