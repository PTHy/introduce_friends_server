package kr.hs.dgsw.introduce_friends_server.Service;

import kr.hs.dgsw.introduce_friends_server.Domain.User;
import kr.hs.dgsw.introduce_friends_server.Protocol.AttachmentProtocol;
import kr.hs.dgsw.introduce_friends_server.Repository.UserRepository;
import org.apache.tomcat.jni.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User register(User user){
        Optional<User> fu = this.userRepository.findByAccount(user.getAccount());

        if (fu.isPresent())
            return null;

        return this.userRepository.save(user);
    }

    @Override
    public User getUser(Long id) {
        return this.userRepository.findById(id)
                .orElse( null );
    }

    @Override
    public User login(User user) {
        Optional<User> fu = this.userRepository.findByAccount(user.getAccount());
        if (!fu.isPresent())
            return null;
        user.setPassword(user.getPassword());

        if (!fu.get().getPassword().equals(user.getPassword()))
            return null;

        return user;
    }

    @Override
    public User modifyUser(User user, Long id) {
        return this.userRepository.findById(id)
                .map(fu -> {
                    if(user.getName() != null)
                        fu.setName(user.getName());
                    if(user.getEmail() != null)
                        fu.setEmail(user.getEmail());
                    if(user.getPassword() != null) {
                        fu.setPassword(user.getPassword());
                    }
                    return this.userRepository.save(fu);
                })
                .orElse(null);
    }

    @Override
    public boolean deleteUser(Long id) {
        return this.userRepository.findById(id)
                .map(fu -> {
                    this.userRepository.delete(fu);
                    return true;
                })
                .orElse( false );
    }

//    @Override
//    public AttachmentProtocol getProfileImage(Long id) {
//        return null;
//    }
}
