package dev.nileshdeshpande.gateway.advices;

public enum ErrorCode {
    // General Errors
    INTERNAL_SERVER_ERROR,
    BAD_REQUEST,
    UNAUTHORIZED,
    FORBIDDEN,
    NOT_FOUND,

    // Specific Errors
    ROUTE_NOT_FOUND,
    SERVICE_UNAVAILABLE,
    TIMEOUT,
    RATE_LIMIT_EXCEEDED,
}
