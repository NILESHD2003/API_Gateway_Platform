package dev.nileshdeshpande.gateway.advices;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ApiError {
    private int status;
    private String message;
    private String path;
    private String errorCode;
}
