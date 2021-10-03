package be.guillaumehouioux.http;

import java.util.Arrays;

/*
 * @author guill (03/10/2021)
 */
public enum HTTPStatus {

    CONTINUE(100, "INFORMATIONAL", "Continue"),
    OK(200, "SUCCESSFUL", "OK"),
    BAD_REQUEST(400, "CLIENT ERROR", "Bad Request"),
    INTERNAL_SERVER_ERROR(500, "SERVER ERROR", "Internal Server Error");

    private Integer status;
    private String severity;
    private String message;

    HTTPStatus(Integer status, String severity, String message) {
        this.status = status;
        this.severity = severity;
        this.message = message;
    }

    public static HTTPStatus valueOf(Integer statusCode) {
        return Arrays
                .stream(HTTPStatus.values())
                .filter(s -> s.getStatus().equals(statusCode))
                .findFirst()
                .get();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}