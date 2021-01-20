package com.onlinegallery.backend.common.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.boot.logging.LogLevel;

@ToString
@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorMessage {
    
    // 공통 에러 메시지
    COMMON_SUCCESS("CM_0000", LogLevel.OFF, "정상 처리", "정상입니다."),
    COMMON_SYSTEM_ERROR("CM_0001", LogLevel.ERROR, "시스템 오류", "시스템 오류입니다."),
    
    // 작가 관련 에러
    ARTIST_NO_MATCHING_ID("AR_0000", LogLevel.ERROR, "작가 조회 실패", "작가 정보가 없습니다."),
    
    ;
    
    private final String errorCode;
    private final LogLevel error;
    private final String systemMessage;
    private final String userGuideMessage;
}
