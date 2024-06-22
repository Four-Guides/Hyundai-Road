package hyundairoad.hyundairoad.image.exception;

import hyundairoad.hyundairoad.global.error.ErrorCode;
import hyundairoad.hyundairoad.global.error.HyundaiRoadException;
import org.springframework.http.HttpStatus;

public class ImageNotFoundException extends HyundaiRoadException {
    public ImageNotFoundException() {
        super(new ErrorCode(HttpStatus.BAD_REQUEST, "이미지를 찾을 수 없습니다."));
    }
}
