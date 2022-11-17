package com.nhnacademy.springmvc.repository;

import com.nhnacademy.springmvc.domain.Category;
import com.nhnacademy.springmvc.domain.Post;

import java.util.*;
import java.util.function.Function;

public class PostRepositoryImpl implements PostRepository {

    private final Map<Long, Post> posts = new HashMap<>();

    @Override
    public boolean exists(long postId) {
        return posts.containsKey(postId);
    }

    @Override
    public boolean isEmpty() {
        return posts.isEmpty();
    }

    @Override
    public Map<Long, Post> getAllPosts() {
        return posts;
    }

    @Override
    public Post getPost(long postId) {
        return posts.get(postId);
    }

    @Override
    public Post addPost(String accountId, String title, Category category, String content) {

        long id = posts.keySet()
                .stream()
                .max(Comparator.comparing(Function.identity()))
                .map(l -> l + 1)
                .orElse(1L);

        Post post = Post.create(accountId, title, category, content);
        post.setId(id);

        posts.put(id, post);
        return post;
    }
}