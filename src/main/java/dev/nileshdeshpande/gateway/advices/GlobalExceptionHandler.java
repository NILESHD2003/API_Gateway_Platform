package dev.nileshdeshpande.gateway.advices;

import dev.nileshdeshpande.gateway.exceptions.ResourceNotFound;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ApiResponse<Void>> handleResourceNotFound(ResourceNotFound ex, HttpServletRequest request) {

        ApiError error = ApiError.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .errorCode(HttpStatus.NOT_FOUND.toString())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(error));
    }

    @ExceptionHandler
    public ResponseEntity<ApiResponse<Void>> handleUnhandledExceptions(Exception ex, HttpServletRequest request) {

        ApiError error = ApiError.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("An unexpected error occurred.")
                .path(request.getRequestURI())
                .errorCode(HttpStatus.INTERNAL_SERVER_ERROR.name())
                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse<>(error));
    }
}
