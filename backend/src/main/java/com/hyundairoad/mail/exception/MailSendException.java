package com.hyundairoad.mail.exception;

import com.hyundairoad.global.error.ErrorCode;
import com.hyundairoad.global.error.HyundaiRoadException;
import org.springframework.http.HttpStatus;

/**
 * MailSendException
 *
 * 작성자: 김진규
 */
public class MailSendException extends HyundaiRoadException {
    public MailSendException() {
        super(new ErrorCode(HttpStatus.BAD_REQUEST, "메일 전송에 실패했습니다"));
    }
}
