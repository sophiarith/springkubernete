package com.kshrd.registration.payload.response;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


public class ResponseRes<T> {

    private Integer statusCode;
    private LocalDateTime timestamp;
    private HttpStatus httpMessage;
    private String message;
    private String path;
    private Boolean success = false;
    private T payload;
    private Object pagination;

    public ResponseRes() {
    }

    public ResponseRes(Integer statusCode, LocalDateTime timestamp, HttpStatus httpMessage, String message, String path, Boolean success, T payload, Object pagination) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.httpMessage = httpMessage;
        this.message = message;
        this.path = path;
        this.success = success;
        this.payload = payload;
        this.pagination = pagination;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public HttpStatus getHttpMessage() {
        return httpMessage;
    }

    public void setHttpMessage(HttpStatus httpMessage) {
        this.httpMessage = httpMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public Object getPagination() {
        return pagination;
    }

    public void setPagination(Object pagination) {
        this.pagination = pagination;
    }

    @Override
    public String toString() {
        return "ResponseRes{" +
                "statusCode=" + statusCode +
                ", timestamp=" + timestamp +
                ", httpMessage=" + httpMessage +
                ", message='" + message + '\'' +
                ", path='" + path + '\'' +
                ", success=" + success +
                ", payload=" + payload +
                ", pagination=" + pagination +
                '}';
    }
}
