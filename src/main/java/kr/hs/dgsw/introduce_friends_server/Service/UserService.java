package kr.hs.dgsw.introduce_friends_server.Service;

import kr.hs.dgsw.introduce_friends_server.Domain.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User register();
    public User login();
    public User modifyUser();
    public boolean deleteUser();
}
