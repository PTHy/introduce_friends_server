package kr.hs.dgsw.introduce_friends_server.Service;

import kr.hs.dgsw.introduce_friends_server.Domain.Post;
import kr.hs.dgsw.introduce_friends_server.Protocol.AttachmentProtocol;
import kr.hs.dgsw.introduce_friends_server.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        return this.postRepository.findAll();
    }

    @Override
    public List<Post> getPostsByUserId(Long userId) {
        return this.postRepository.getPostsByUserId(userId);
    }

    @Override
    public Post getPost(Long id) {
        return this.postRepository.findById(id)
                .orElse(null);
    }

    @Override
    public Post createPost(Post post) {
        return this.postRepository.save(post);
    }

    @Override
    public Post modifyPost(Post post, Long id) {
        return this.postRepository.findById(id)
                .map(fp -> {
                    if (post.getTitle() != null)
                        fp.setTitle(post.getTitle());
                    if (post.getContent() != null)
                        fp.setContent(post.getContent());
                    return this.postRepository.save(fp);
                })
                .orElse(null);
    }

    @Override
    public boolean deletePost(Long id) {
        try {
            return this.postRepository.findById(id)
                    .map(fp -> {
                        this.postRepository.delete(fp);
                        return true;
                    })
                    .orElse(null);
        } catch (Exception e) {
            return false;
        }
    }

//    @Override
//    public AttachmentProtocol getImage(Long id) {
//        return null;
//    }
}
