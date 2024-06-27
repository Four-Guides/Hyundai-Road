package com.hyundairoad.member.exception;

import com.hyundairoad.global.error.ErrorCode;
import com.hyundairoad.global.error.HyundaiRoadException;
import org.springframework.http.HttpStatus;

public class CannotLikePlaceException extends HyundaiRoadException {
    public CannotLikePlaceException() {
        super(new ErrorCode(HttpStatus.BAD_REQUEST, "장소 좋아요에 실패했습니다!"));
    }
}