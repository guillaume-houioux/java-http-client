package be.guillaumehouioux.http;

import java.util.Objects;

/*
 * @author guill (03/10/2021)
 */
public class HTTPResponse {

    private HTTPStatus status;
    private Integer contentLength;
    private Object body;

    public HTTPResponse() { }

    public HTTPResponse(Integer contentLength, Object body) {
        this.contentLength = contentLength;
        this.body = body;
    }

    public HTTPStatus getStatus() {
        return status;
    }

    public void setStatus(HTTPStatus status) {
        this.status = status;
    }

    public Integer getContentLength() {
        return contentLength;
    }

    public void setContentLength(Integer contentLength) {
        this.contentLength = contentLength;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HTTPResponse)) return false;
        HTTPResponse that = (HTTPResponse) o;
        return getStatus() == that.getStatus() && Objects.equals(getContentLength(), that.getContentLength()) && Objects.equals(getBody(), that.getBody());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStatus(), getContentLength(), getBody());
    }

    @Override
    public String toString() {
        return "HTTPResponse{" +
                "status=" + status +
                ", contentLength=" + contentLength +
                ", body=" + body +
                '}';
    }
}