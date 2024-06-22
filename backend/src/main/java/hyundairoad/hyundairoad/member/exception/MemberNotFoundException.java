package hyundairoad.hyundairoad.member.exception;

import hyundairoad.hyundairoad.global.error.ErrorCode;
import hyundairoad.hyundairoad.global.error.HyundaiRoadException;
import org.springframework.http.HttpStatus;

public class MemberNotFoundException extends HyundaiRoadException {
    public MemberNotFoundException() {
        super(new ErrorCode(HttpStatus.BAD_REQUEST, "일치하는 회원을 찾지 못했습니다."));
    }
}
