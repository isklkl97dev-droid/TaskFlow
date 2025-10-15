package com.example.taskflow.domain.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BaseException extends  RuntimeException{

    private final HttpStatus status;

    private final String message;

    public BaseException(ErrorCode errorCode) {
        super(errorCode.getMessage());

        this.status = errorCode.getStatus();
        this.message = errorCode.getMessage();
    }
}
