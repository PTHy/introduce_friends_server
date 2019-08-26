package kr.hs.dgsw.introduce_friends_server.Service;

import kr.hs.dgsw.introduce_friends_server.Domain.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();
    List<Post> getPostsByUserId(Long id);
    Post getPost(Long id);
    Post createPost();
    Post modifyPost();
    boolean deletePost();

}
