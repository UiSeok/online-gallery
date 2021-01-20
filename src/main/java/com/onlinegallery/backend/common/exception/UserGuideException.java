package com.onlinegallery.backend.common.exception;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class UserGuideException extends RuntimeException {

    private ErrorMessage errorMessage = ErrorMessage.COMMON_SYSTEM_ERROR;

    public UserGuideException(Throwable cause) {
        super(cause);
    }

    public UserGuideException(Throwable cause, ErrorMessage errorMessage) {
        super(errorMessage.getUserGuideMessage(), cause);
        this.errorMessage = errorMessage;
    }

    public UserGuideException(String message) {
        super(message);
    }

    public UserGuideException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserGuideException(String message, ErrorMessage errorMessage) {
        super(message);
        this.errorMessage = errorMessage;
    }

    public UserGuideException(ErrorMessage errorMessage) {
        super(errorMessage.getUserGuideMessage());
        this.errorMessage = errorMessage;
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

}
