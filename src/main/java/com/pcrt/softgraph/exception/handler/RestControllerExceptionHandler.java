package com.pcrt.softgraph.exception.handler;

import com.pcrt.softgraph.exception.BaseException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleInternalServerError(WebRequest request, Exception e) {
        return this.handleManagedException(request, new BaseException(e));
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Object> handleAuthenticationException(WebRequest request, Exception e) {
        return this.handleExceptionInternal(e, null, new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
    }

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<Object> handleManagedException(WebRequest request, BaseException e) {
        return this.handleExceptionInternal(e, null, new HttpHeaders(), e.getHttpStatus(), request);
    }

    @Override
    @Nullable
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        // override to log exception stacktrace
        logger.error("Encountered unhandled exception", ex);
        return super.handleExceptionInternal(ex, body, headers, statusCode, request);
    }

}
