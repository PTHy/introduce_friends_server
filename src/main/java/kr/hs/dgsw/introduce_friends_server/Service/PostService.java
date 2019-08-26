package kr.hs.dgsw.introduce_friends_server.Service;

import kr.hs.dgsw.introduce_friends_server.Domain.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();
    Post getPost(Long id);
    Post createPost();
    Post modifyPost();
    boolean deletePost();

}
