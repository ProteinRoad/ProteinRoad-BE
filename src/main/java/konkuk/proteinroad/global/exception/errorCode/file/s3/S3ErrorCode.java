package konkuk.proteinroad.global.exception.errorCode.file.s3;

import konkuk.proteinroad.global.exception.errorCode.BaseErrorCode;
import konkuk.proteinroad.global.exception.errorCode.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum S3ErrorCode {
    UNPROCESSABLE_IMAGE(new BaseErrorCode(4223, HttpStatus.UNPROCESSABLE_ENTITY, "업로드된 이미지를 처리할 수 없습니다.")),
    UPLOAD_FAILED(new BaseErrorCode(5001, HttpStatus.INTERNAL_SERVER_ERROR, "파일 업로드에 실패했습니다.")),
    DELETE_FAILED(new BaseErrorCode(5002, HttpStatus.INTERNAL_SERVER_ERROR, "파일 삭제에 실패했습니다.")),
    GET_URL_FAILED(new BaseErrorCode(5003, HttpStatus.INTERNAL_SERVER_ERROR, "파일 URL 발급에 실패했습니다."));

    private final ErrorCode errorCode;
}
