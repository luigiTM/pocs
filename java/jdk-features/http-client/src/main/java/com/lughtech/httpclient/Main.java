package com.lughtech.httpclient;

import com.lughtech.httpclient.model.Post;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    static void main() throws URISyntaxException, IOException, InterruptedException {
        var postClient = new PostClient();
        Integer postId = 1;
        System.out.println("Fetching post " + postId);
        var post = postClient.getPost(postId);
        System.out.println("Post " + postId + ": -> " + post);

        var newPost = new Post();
        newPost.setTitle("This is a title");
        newPost.setBody("This is a body");
        newPost.setUserId(2);
        System.out.println("Creating new post: " + newPost);
        var createdPost = postClient.createPost(newPost);
        System.out.println("Post created: " + createdPost);

        createdPost.setTitle("Updated title");
        System.out.println("Updating post: " + createdPost);
        var updatedPost = postClient.updatePost(createdPost);
        System.out.println("Post updated: " + updatedPost);

        System.out.println("Deleting post: " + createdPost.getId());
        postClient.deletePost(createdPost.getId());
        System.out.println("Post deleted");
    }
}
