package kr.hs.dgsw.introduce_friends_server.Repository;

import kr.hs.dgsw.introduce_friends_server.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
