package com.hyundairoad.mail.exception;

import com.hyundairoad.global.error.ErrorCode;
import com.hyundairoad.global.error.HyundaiRoadException;
import org.springframework.http.HttpStatus;

/**
 * MailVerificationException
 *
 * 작성자: 김진규
 */
public class MailVerificationException extends HyundaiRoadException {
    public MailVerificationException() {
        super(new ErrorCode(HttpStatus.BAD_REQUEST, "이메일 인증에 실패했습니다."));
    }
}
