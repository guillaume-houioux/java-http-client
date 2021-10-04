package be.guillaumehouioux.http;

import java.util.Arrays;

/*
 * @author guill (03/10/2021)
 */
public enum HTTPStatus {

    // 1xx
    CONTINUE(100, "INFORMATIONAL", "Continue"),
    SWITCHING_PROTOCOL(101, "INFORMATIONAL", "Switching Protocol"),
    PROCESSING(103, "INFORMATIONAL", "Processing"),

    // 2xx
    OK(200, "SUCCESSFUL", "OK"),
    CREATED(201, "SUCCESSFUL", "Created"),
    ACCEPTED(202, "SUCCESSFUL", "Accepted"),
    NON_AUTHORITATIVE_INFORMATION(203, "SUCCESSFUL", "Non-Authoritative Information"),
    NO_CONTENT(204, "SUCCESSFUL", "No Content"),
    RESET_CONTENT(205, "SUCCESSFUL", "Reset Content"),
    PARTIAL_CONTENT(206, "SUCCESSFUL", "Partial Content"),

    // 3xx
    MULTIPLE_CHOICE(300, "REDIRECTION", "Multiple Choice"),
    MOVED_PERMANENTLY(301, "REDIRECTION", "Moved Permanently"),
    FOUND(302, "REDIRECTION", "Found"),
    SEE_OTHER(303, "REDIRECTION", "See Other"),
    NOT_MODIFIED(304, "REDIRECTION", "Not Modified"),
    TEMPORARY_REDIRECT(307, "REDIRECTION", "Temporary Redirect"),
    PERMANENT_REDIRECT(308, "REDIRECTION", "Permanent Redirect"),

    // 4xx
    BAD_REQUEST(400, "CLIENT ERROR", "Bad Request"),
    UNAUTHORIZED(401, "CLIENT ERROR", "Unauthorized"),
    PAYMENT_REQUIRED(402, "CLIENT ERROR", "Payment Required"),
    FORBIDDEN(403, "CLIENT ERROR", "Forbidden"),
    NOT_FOUND(404, "CLIENT ERROR", "Not Found"),
    METHOD_NOT_ALLOWED(405, "CLIENT ERROR", "Method Not Allowed"),
    NOT_ACCEPTABLE(406, "CLIENT ERROR", "Not Acceptable"),
    PROXY_AUTHENTICATION_REQUIRED(407, "CLIENT ERROR", "Proxy Authentication Required"),
    REQUEST_TIMEOUT(408, "CLIENT ERROR", "Request Timeout"),
    CONFLICT(409, "CLIENT ERROR", "Conflict"),
    GONE(410, "CLIENT ERROR", "Gone"),
    LENGTH_REQUIRED(411, "CLIENT ERROR", "Length Required"),
    PRECONDITION_FAILED(412, "CLIENT ERROR", "Precondition Failed"),
    PAYLOAD_TOO_LARGE(413, "CLIENT ERROR", "Payload Too Large"),
    URI_TOO_LONG(414, "CLIENT ERROR", "Proxy URI Too Long"),
    UNSUPPORTED_MEDIA_TYPE(415, "CLIENT ERROR", "Unsupported Media Type"),
    REQUESTED_RANGE_NOT_SATISFIABLE(416, "CLIENT ERROR", "Requested Range Not Satisfiable"),
    EXPECTATION_FAILED(417, "CLIENT ERROR", "Expectation Failed"),
    I_AM_A_TEAPOT(418, "CLIENT ERROR", "I'm a teapot"),
    UNPROCESSABLE_ENTITY(422, "CLIENT ERROR", "Unprocessable Entity"),
    UPGRADE_REQUIRED(426, "CLIENT ERROR", "Upgrade Required"),
    PRECONDITION_REQUIRED(428, "CLIENT ERROR", "Precondition Required"),
    TOO_MANY_REQUESTS(429, "CLIENT ERROR", "Too Many Requests"),
    REQUEST_HEADER_FIELDS_TOO_LARGE(431, "CLIENT ERROR", "Request Header Fields Too Large"),
    UNAVAILABLE_FOR_LEGAL_REASONS(451, "CLIENT ERROR", "Unavailable For Legal Reasons"),

    // 5xx
    INTERNAL_SERVER_ERROR(500, "SERVER ERROR", "Internal Server Error"),
    NOT_IMPLEMENTED(501, "SERVER ERROR", "Not Implemented"),
    BAD_GATEWAY(502, "SERVER ERROR", "Bad Gateway"),
    SERVICE_UNAVAILABLE(503, "SERVER ERROR", "Service Unavailable"),
    GATEWAY_TIMEOUT(504, "SERVER ERROR", "Gateway Timeout"),
    HTTP_VERSION_NOT_SUPPORTED(505, "SERVER ERROR", "HTTP Version Not Supported"),
    VARIANT_ALSO_NEGOTIATES(506, "SERVER ERROR", "Variant Also Negotiates"),
    INSUFFICIENT_STORAGE(507, "SERVER ERROR", "Insufficient Storage"),
    LOOP_DETECTED(508, "SERVER ERROR", "Loop Detected"),
    NOT_EXTENDED(510, "SERVER ERROR", "Not Extended"),
    NETWORK_AUTHENTICATION_REQUIRED(511, "SERVER ERROR", "Network Authentication Required");

    private Integer statusCode;
    private String severity;
    private String message;

    HTTPStatus(Integer statusCode, String severity, String message) {
        this.statusCode = statusCode;
        this.severity = severity;
        this.message = message;
    }

    public static HTTPStatus valueOf(Integer statusCode) {
        return Arrays
                .stream(HTTPStatus.values())
                .filter(s -> s.getStatusCode().equals(statusCode))
                .findFirst()
                .get();
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
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

    @Override
    public String toString() {
        return "HTTPStatus{" +
                "status=" + statusCode +
                ", severity='" + severity + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}