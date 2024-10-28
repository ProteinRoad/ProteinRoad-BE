package konkuk.proteinroad.global.exception.errorCode.brand;

import konkuk.proteinroad.global.exception.errorCode.BaseErrorCode;
import konkuk.proteinroad.global.exception.errorCode.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum BrandErrorCode {

    BRAND_NOT_FOUND(new BaseErrorCode(4041, HttpStatus.NOT_FOUND, "존재하지 않는 브랜드입니다."));

    private final ErrorCode errorCode;
}
