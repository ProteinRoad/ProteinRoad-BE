package konkuk.proteinroad.global.exception.errorCode.store;

import konkuk.proteinroad.global.exception.errorCode.BaseErrorCode;
import konkuk.proteinroad.global.exception.errorCode.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum StoreErrorCode {

    STORE_NOT_FOUND(new BaseErrorCode(4042, HttpStatus.NOT_FOUND, "존재하지 않는 가게입니다."));

    private final ErrorCode errorCode;
}
