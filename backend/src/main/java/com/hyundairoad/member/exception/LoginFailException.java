package com.hyundairoad.member.exception;

import com.hyundairoad.global.error.ErrorCode;
import com.hyundairoad.global.error.HyundaiRoadException;
import org.springframework.http.HttpStatus;

public class LoginFailException extends HyundaiRoadException {
    public LoginFailException() {
        super(new ErrorCode(HttpStatus.BAD_REQUEST, "로그인에 실패했습니다!"));
    }
}