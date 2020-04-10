package com.evan.bs.result;

public class Result {
    // 响应码  实际上由于响应码是固定的，code 属性应该是一个枚举值
    private int code;
    private String message;
    private Object data;

     public Result(int code,String message,Object data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode(){
        return code;
    }

    public void setCode(int code){
        this.code = code;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
