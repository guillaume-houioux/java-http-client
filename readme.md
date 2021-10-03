### HTTP Client

Once downloaded :
<pre>mvn clean install</pre>

Usage :
```java
// Define your headers
Map<String, String> headers = new HashMap<>();
headers.put("Authorization", "Bearer 1a2b3c4d...");

// Prepare and send HTTP request then convert response to object
HTTPResponse response = new HTTPRequest()
                .withConfiguration("path", HTTPMethod.GET)
                .withHeaders(headers)
                .convertTo(ObjectType.class)
                .send();
```

Supported methods :
<pre>GET, POST, PUT, DELETE, OPTIONS</pre>