package kr.hs.dgsw.introduce_friends_server.Service;

import kr.hs.dgsw.introduce_friends_server.Domain.Post;

import java.util.List;

public interface PostService {
    public List<Post> getAllPosts();
}
