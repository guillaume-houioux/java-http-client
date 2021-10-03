package be.guillaumehouioux.http;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
 * @author guill (03/10/2021)
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer 1234");

        HTTPResponse response = new HTTPRequest()
                .withConfiguration("https://jsonplaceholder.typicode.com/posts", HTTPMethod.GET)
                .withHeaders(headers)
                .convertTo(Post.class)
                .send();

        System.out.println(response.getBody());

        System.out.println(response.getStatus().getSeverity());
    }
}