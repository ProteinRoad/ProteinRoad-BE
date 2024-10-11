package konkuk.proteinroad.global.exception.errorCode.store;

import konkuk.proteinroad.global.exception.errorCode.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum StoreErrorCode implements ErrorCode {

    STORE_NOT_FOUND(4041, HttpStatus.NOT_FOUND, "Store Not Found");

    private final int code;
    private final HttpStatus httpStatus;
    private final String message;
}
