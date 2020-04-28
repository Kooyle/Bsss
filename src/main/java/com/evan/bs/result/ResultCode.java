package com.evan.bs.result;

public enum ResultCode {
    SUCCESS(200),
    FAIL(400),
    UNAUTHORIZED(401),
    NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500),
    PERSON(201),
    COMPONY(202),
    ADMIN(203);

    public int code;

    ResultCode(int code) {
        this.code = code;
    }
}
