package com.kshrd.registration.constant;

/**
        2xx :  SUCCESS
        200 OK : success
        201 CREATED : successfully added data
        204 NO-CONTENT successfully updated or deleted

        3xx : REDIRECTION
        304 NOT MODIFIED:

        4xx :  CLIENT SIDE ERROR
        400 BAD REQUEST : bad data being sent
        401 UNAUTHORIZED :
        403 FORBIDDEN :
        404 NOT FOUND : the resource does not exists at that location
        405 METHOD NOT ALLOWED :
        DELETE /api/spartans -->> 405 error
        406 NOT ACCEPTABLE
        415 Unsupported Media type
        if you forget to specify the Content-Type
        of Post request body, it will see it as plain text
        and it will throw this error if it does not support

        5xx : Server side error
        500 internal service error
        If the server do not have any mapping of the url
        requested to handle the action -->> 500
        503 SERVICE UNAVAILABLE :
        504 GATEWAY TIMEOUT :
 **/
public enum StatusCodeEnum {
    OK(200, "Data is retrieved successfully!"),
    CRETAED(201, "Data is added successfully!"),
    NO_CONTENT(204, "Data is manipulated successfully!"),
    NOT_MODIFIED(304, "Nothing is modified!"),
    BAD_REQUEST(400, "Bad data was rejected!"),
    UNAUTHORIZED(401, "Please login!"),
    FORBIDDEN(403, "Not allowed to request!"),
    NOT_FOUND(404, "Nothing is found!"),
    METHOD_NOT_ALLOWED(405, "Http request is not allowed!"),
    NOT_ACCEPTABLE(406, "No accept your request!"),
    UNSUPPORTED_MEDIA_TYPE(415, "Media is not supported!"),
    INTERNAL_SERVER_ERROR(500, "Internal server error!"),
    SERVICE_UNAVAILABLE(503, "Service is unavailable!"),
    GATWAY_TIMEOUT(504, "Gateway is timeout!");

    private int num;
    private String sms;

    StatusCodeEnum(int num, String sms) {
        this.num = num;
        this.sms = sms;
    }

    public int getNum() {
        return num;
    }

    public String getSms() {
        return sms;
    }

    //    public void setNum(int num) {
    //        this.num = num;
    //    }

}
