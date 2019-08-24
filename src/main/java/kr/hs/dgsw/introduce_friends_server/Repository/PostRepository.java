package kr.hs.dgsw.introduce_friends_server.Repository;

import kr.hs.dgsw.introduce_friends_server.Domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
