package com.pcrt.softgraph.exception;

import org.springframework.http.HttpStatus;

public class InvalidInputException extends BaseException {

    public InvalidInputException(String message, Object... args) {
        super(message, args);
    }

    public InvalidInputException(Throwable cause, String message, Object... args) {
        super(cause, message, args);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.BAD_REQUEST;
    }

}
