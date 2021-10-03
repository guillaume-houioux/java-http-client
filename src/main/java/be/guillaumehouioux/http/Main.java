package be.guillaumehouioux.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * @author guill (03/10/2021)
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer 1234");

        HTTPResponse response = new HTTPRequest()
                .withConfiguration("https://jsonplaceholder.typicode.com/posts/1", HTTPMethod.GET)
                .withHeaders(headers)
                .convertTo(Post.class)
                .send();

        System.out.println(((Post)response.getBody()).getTitle());

        System.out.println(response.getStatus().getSeverity());
    }
}