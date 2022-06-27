package com.example.stocksystem.infrastructure.exception;

import com.example.stocksystem.infrastructure.common.ErrorsResource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;

public class GlobalRequestException {
    public static ResponseEntity badRequest(Errors errors) {
        return ResponseEntity.badRequest().body(new ErrorsResource(errors));
    }
}
