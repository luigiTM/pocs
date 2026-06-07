package com.lughtech.httpclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lughtech.httpclient.model.Post;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;

public class PostClient {

    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Post getPost(Integer id) throws URISyntaxException, IOException, InterruptedException {
        var request = HttpRequest
                .newBuilder(new URI("https://jsonplaceholder.typicode.com/posts/" + id))
                .version(HttpClient.Version.HTTP_2)
                .timeout(Duration.of(10, SECONDS))
                .GET()
                .build();
        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(), Post.class);
    }

    public Post createPost(Post newPost) throws URISyntaxException, IOException, InterruptedException {
        var request = HttpRequest.newBuilder(new URI("https://jsonplaceholder.typicode.com/posts"))
                .version(HttpClient.Version.HTTP_2)
                .timeout(Duration.of(10, SECONDS))
                .headers("Content-Type", "application/json; charset=UTF-8")
                .POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(newPost)))
                .build();
        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(), Post.class);
    }

    public Post updatePost(Post post) throws URISyntaxException, IOException, InterruptedException {
        var request = HttpRequest.newBuilder(new URI("https://jsonplaceholder.typicode.com/posts/" + post.getId()))
                .version(HttpClient.Version.HTTP_2)
                .timeout(Duration.of(10, SECONDS))
                .headers("Content-Type", "application/json; charset=UTF-8")
                .PUT(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(post)))
                .build();
        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(), Post.class);
    }

    public void deletePost(Integer id) throws URISyntaxException, IOException, InterruptedException {
        var request = HttpRequest.newBuilder(new URI("https://jsonplaceholder.typicode.com/posts/" + id))
                .version(HttpClient.Version.HTTP_2)
                .timeout(Duration.of(10, SECONDS))
                .headers("Content-Type", "application/json; charset=UTF-8")
                .DELETE()
                .build();
        httpClient.send(request, HttpResponse.BodyHandlers.discarding());
    }


}
