package be.guillaumehouioux.http;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

/*
 * @author guill (03/10/2021)
 */
public class HTTPRequestTest {

    private static HTTPRequest httpRequest;

    @BeforeClass
    public static void initialization() {
        httpRequest = new HTTPRequest();
    }

    @Test
    public void testResponseStatus200() throws IOException {
        HTTPResponse httpResponse = httpRequest.withConfiguration("https://jsonplaceholder.typicode.com/posts", HTTPMethod.GET)
                .withHeaders(null)
                .convertTo(String.class)
                .send();

        Assert.assertNotNull(httpResponse);
        Assert.assertEquals(httpResponse.getStatus().getStatusCode().intValue(), 200);
    }

    @Test
    public void testResponseStatus201() throws IOException {
        HTTPResponse httpResponse = httpRequest.withConfiguration("https://jsonplaceholder.typicode.com/posts", HTTPMethod.POST)
                .withHeaders(null)
                .convertTo(String.class)
                .send();

        Assert.assertNotNull(httpResponse);
        Assert.assertEquals(httpResponse.getStatus().getStatusCode().intValue(), 201);
    }

    @Test
    public void testResponseStatus404() throws IOException {
        HTTPResponse httpResponse = httpRequest.withConfiguration("https://jsonplaceholder.typicode.com/postsfuhd", HTTPMethod.GET)
                .withHeaders(null)
                .convertTo(String.class)
                .send();

        Assert.assertNotNull(httpResponse);
        Assert.assertEquals(httpResponse.getStatus().getStatusCode().intValue(), 404);
    }

    @Test
    public void testResponseBodyNotEmpty() throws IOException {
        HTTPResponse httpResponse = httpRequest.withConfiguration("https://jsonplaceholder.typicode.com/posts", HTTPMethod.GET)
                .withHeaders(null)
                .convertTo(String.class)
                .send();

        Assert.assertNotNull(httpResponse);
        Assert.assertTrue(((String)httpResponse.getBody()).length() > 0);
    }
}