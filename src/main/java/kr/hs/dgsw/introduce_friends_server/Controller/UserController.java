package kr.hs.dgsw.introduce_friends_server.Controller;

import kr.hs.dgsw.introduce_friends_server.Protocol.ResponseFormat;
import kr.hs.dgsw.introduce_friends_server.Protocol.ResponseType;
import kr.hs.dgsw.introduce_friends_server.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/api/users")
    public ResponseEntity getAllUsers() {
        try {
            return ResponseEntity
                    .ok(new ResponseFormat(ResponseType.GET_USERS_SUCCESS, this.userService.getAllUsers()));
        } catch (Exception ex) {
        }
    }

    @PostMapping("/api/users/register")
    public ResponseEntity register() {
        try {

        } catch (Exception ex) {

        }
    }

    @PostMapping("/api/users/login")
    public ResponseEntity login() {
        try {

        } catch (Exception ex) {

        }
    }
}
