package dev.nileshdeshpande.gateway.advices;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {
    private boolean success;
    private LocalDateTime timestamp;
    private T data;
    private ApiError error;

    public ApiResponse() {
        this.timestamp = LocalDateTime.now();
    }

    public ApiResponse(T data) {
        this();
        this.success = true;
        this.data = data;
    }

    public ApiResponse(ApiError error) {
        this();
        this.success = false;
        this.error = error;
    }
}
