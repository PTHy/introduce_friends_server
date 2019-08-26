package kr.hs.dgsw.introduce_friends_server.Service;

import kr.hs.dgsw.introduce_friends_server.Domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User register() {
        return null;
    }

    @Override
    public User getUser(Long id) {
        return null;
    }

    @Override
    public User login() {
        return null;
    }

    @Override
    public User modifyUser() {
        return null;
    }

    @Override
    public boolean deleteUser() {
        return false;
    }
}
