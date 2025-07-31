package com.thaaru.book_network.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.LockedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.thaaru.book_network.handler.BusinessErrorCodes.ACCOUNT_LOCKED;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@RestControllerAdvice
public class GlobalExceptionHandler {

        @ExceptionHandler(LockedException.class)
        public ResponseEntity<ExceptionResponse> handleException(LockedException exp) {
                return ResponseEntity
                        .status(UNAUTHORIZED)
                        .body(
                                ExceptionResponse.builder()
                                        .businessErrorCode(ACCOUNT_LOCKED.getCode())
                                        .businessErrorDescription(ACCOUNT_LOCKED.getDescription())
                                        .error(exp.getMessage())
                                        .build()
                        );
        }

}
