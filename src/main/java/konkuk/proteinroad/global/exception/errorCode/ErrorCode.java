package konkuk.proteinroad.global.exception.errorCode;

import org.springframework.http.HttpStatus;

public interface ErrorCode {

    String name();
    int getCode();
    HttpStatus getHttpStatus();
    String getMessage();
}
