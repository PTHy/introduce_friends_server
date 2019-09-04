package kr.hs.dgsw.introduce_friends_server.Service;

import kr.hs.dgsw.introduce_friends_server.Domain.User;
import kr.hs.dgsw.introduce_friends_server.Protocol.AttachmentProtocol;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User register(User user);
    User getUser(Long id);
    User login(User user);
    User modifyUser(User user, Long id);
    boolean deleteUser(Long id);
//    AttachmentProtocol getProfileImage(Long id);
}
