package com.pcrt.softgraph.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.lang.NonNull;
import org.springframework.web.ErrorResponse;

public class BaseException extends RuntimeException implements ErrorResponse {

    public BaseException(String message, Object... args) {
        super(String.format(message, args));
    }

    public BaseException(Throwable cause, String message, Object... args) {
        super(String.format(message, args), cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public HttpStatus getHttpStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    @Override
    @NonNull
    public final HttpStatusCode getStatusCode() {
        return this.getHttpStatus();
    }

    @Override
    @NonNull
    public ProblemDetail getBody() {
        ProblemDetail problemDetail = ProblemDetail.forStatus(this.getStatusCode());
        problemDetail.setDetail(this.getMessage());
        problemDetail.setTitle(this.getHttpStatus().getReasonPhrase());
        return problemDetail;
    }
}
