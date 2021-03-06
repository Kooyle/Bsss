package com.evan.bs.result;


import com.evan.bs.pojo.User;

public class ResultFactory {

    public static Result buildSuccessResult(Object data) {
        return buildResult(ResultCode.SUCCESS, "成功", data);
    }

    public static Result buildFailResult(String message) {
        return buildResult(ResultCode.FAIL, message, null);
    }
    public static Result buildSuccessMsgResult(String message) {
        return buildResult(ResultCode.SUCCESS, message, null);
    }

    public static Result buildSuccessPersonResult(String message) {
        return buildResult(ResultCode.PERSON, message, null);
    }
    public static Result buildSuccessCompanyResult(String message) {
        return buildResult(ResultCode.COMPONY, message, null);
    }
    public static Result buildSuccessAdminResult(String message) {
        return buildResult(ResultCode.ADMIN, message, null);
    }

    public static Result buildResult(ResultCode resultCode, String message, Object data) {
        return buildResult(resultCode.code, message, data);
    }

    public static Result buildResult(int resultCode, String message, Object data) {
        return new Result(resultCode, message, data);
    }
}
