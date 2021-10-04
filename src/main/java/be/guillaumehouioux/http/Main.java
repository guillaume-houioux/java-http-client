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
        headers.put("Authorization", "Bearer omx614r4tq5w86knxuznyekzh0uf7v");
        headers.put("Client-Id", "ikeyaget9k8bzhr4vvl37cpquduyug");

        HTTPResponse response = new HTTPRequest()
                .withConfiguration("https://api.twitch.tv/helix/users?login=zerator&login=jiraya", HTTPMethod.GET)
                .withHeaders(headers)
                .convertTo(String.class)
                .send();

        System.out.println(response.getBody());
    }
}