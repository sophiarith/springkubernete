package com.kshrd.registration.exception;

public class AppExceptionHandler extends Exception {

    private Integer statusCode;
    private String message;
    private String path;

    public AppExceptionHandler( Integer statusCode, String message, String path) {
        this.statusCode = statusCode;
        this.message = message;
        this.path = path;
    }

    public AppExceptionHandler() {
    }

    @Override
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

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return "AppExceptionHandler{" +
                "statusCode=" + statusCode +
                ", message='" + message + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
