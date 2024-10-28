package konkuk.proteinroad.global.exception.errorCode;

import org.springframework.http.HttpStatus;

public interface ErrorCode {

    int getCode();
    HttpStatus getHttpStatus();
    String getMessage();
}
