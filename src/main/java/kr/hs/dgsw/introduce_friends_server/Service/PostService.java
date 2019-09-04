package kr.hs.dgsw.introduce_friends_server.Service;

import kr.hs.dgsw.introduce_friends_server.Domain.Post;
import kr.hs.dgsw.introduce_friends_server.Protocol.AttachmentProtocol;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();
    List<Post> getPostsByUserId(Long id);
    Post getPost(Long id);
    Post createPost(Post post);
    Post modifyPost(Post post, Long id);
    boolean deletePost(Long id);
//    AttachmentProtocol getImage(Long id);
}
