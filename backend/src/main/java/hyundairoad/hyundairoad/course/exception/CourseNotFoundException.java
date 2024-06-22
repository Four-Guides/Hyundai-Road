package hyundairoad.hyundairoad.course.exception;

import hyundairoad.hyundairoad.global.error.ErrorCode;
import hyundairoad.hyundairoad.global.error.HyundaiRoadException;
import org.springframework.http.HttpStatus;

public class CourseNotFoundException extends HyundaiRoadException {
    public CourseNotFoundException() {
        super(new ErrorCode(HttpStatus.BAD_REQUEST, "코스 정보를 찾지 못했습니다."));
    }
}
