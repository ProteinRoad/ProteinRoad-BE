package konkuk.proteinroad.global.exception.errorCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public class BaseErrorCode implements ErrorCode {

    private final int code;
    private final HttpStatus httpStatus;
    private final String message;
}
