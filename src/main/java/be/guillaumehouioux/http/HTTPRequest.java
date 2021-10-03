package be.guillaumehouioux.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * @author guill (03/10/2021)
 */
public class HTTPRequest {

    private ObjectMapper objectMapper = new ObjectMapper();
    private HttpURLConnection httpURLConnection;
    private Class convertTo;

    public HTTPRequest() { }

    // TODO throw exception when map object
    // TODO calculate request time
    // TODO convert responsejson to object OK


    public HTTPRequest withConfiguration(String path, HTTPMethod method) throws IOException {
        this.httpURLConnection = (HttpURLConnection) new URL(path).openConnection();
        this.httpURLConnection.setRequestMethod(method.toString());
        return this;
    }

    public HTTPResponse send() throws IOException {
        return this.buildResponse();
    }

    public HTTPRequest withHeaders(Map<String, String> headers) {
        for(Map.Entry<String, String> entry : headers.entrySet()) {
            this.httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        return this;
    }

    public HTTPRequest convertTo(Class convertTo) {
        this.convertTo = convertTo;
        return this;
    }

    private HTTPResponse buildResponse() throws IOException {

        String body = new BufferedReader(new InputStreamReader(this.httpURLConnection.getInputStream(), StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));

        HTTPResponse httpResponse = new HTTPResponse();

        httpResponse.setStatus(HTTPStatus.valueOf(this.httpURLConnection.getResponseCode()));
        httpResponse.setContentLength(this.httpURLConnection.getContentLength());

        Object objectConverted = objectMapper.readValue(body, this.convertTo);
        httpResponse.setBody(objectConverted);

        return httpResponse;
    }
}