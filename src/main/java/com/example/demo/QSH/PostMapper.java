package com.example.demo.QSH;


import java.util.List;

public interface PostMapper {
    List<Post> selectAll();
    void createPost(Post post);
    Post getPostById(Long id);

    Long getId(Post post);
    List<Post> getPostByTitle(String title);

    void deletePost(Long id);
    void updatePost(Post post);

}