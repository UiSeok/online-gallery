package com.onlinegallery.backend.common.model;

import com.onlinegallery.backend.common.exception.ErrorMessage;
import com.onlinegallery.backend.common.model.type.ResultCode;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommonResponse<T> {
    private ResultCode code;
    private String errorCode;
    private String message;
    private T result;
    
    public static <T>CommonResponse<T> SUCCESS(final T result) {
        return CommonResponse.<T>builder()
            .code(ResultCode.SUCCESS)
            .errorCode(ErrorMessage.COMMON_SUCCESS.getErrorCode())
            .result(result)
            .message(ErrorMessage.COMMON_SUCCESS.getUserGuideMessage())
            .build();
    }
    
    public static <T>CommonResponse<T> OK() {
        return CommonResponse.<T>builder()
            .code(ResultCode.SUCCESS)
            .errorCode(ErrorMessage.COMMON_SUCCESS.getErrorCode())
            .message(ErrorMessage.COMMON_SUCCESS.getUserGuideMessage())
            .build();
    }
    
    @Builder
    public CommonResponse(ResultCode code, String errorCode, String message, T result) {
        this.code = code;
        this.errorCode = errorCode;
        this.message = message;
        this.result = result;
    }
}