package konkuk.proteinroad.global.exception.errorCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum CommonErrorCode implements ErrorCode {

    BAD_REQUEST(4000, HttpStatus.BAD_REQUEST, "잘못된 파라미터입니다.");

    private final int code;
    private final HttpStatus httpStatus;
    private final String message;

}
