package kr.hs.dgsw.introduce_friends_server.Controller;

import kr.hs.dgsw.introduce_friends_server.Domain.User;
import kr.hs.dgsw.introduce_friends_server.Protocol.ResponseFormat;
import kr.hs.dgsw.introduce_friends_server.Protocol.ResponseType;
import kr.hs.dgsw.introduce_friends_server.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            return ResponseEntity
                    .status(500)
                    .body(new ResponseFormat(ResponseType.FAIL, ex.getMessage()));
        }
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity getUser(@PathVariable Long id) {
        try {
            return ResponseEntity
                    .ok(new ResponseFormat(ResponseType.GET_USER_SUCCESS, this.userService.getUser(id)));
        } catch (Exception ex) {
            return ResponseEntity
                    .status(500)
                    .body(new ResponseFormat(ResponseType.FAIL, ex.getMessage()));
        }
    }

    @PostMapping("/api/users/register")
    public ResponseEntity register(@RequestBody User user) {
        try {
            return ResponseEntity
                    .ok(new ResponseFormat(ResponseType.REGISTER_USER_SUCCESS, this.userService.register(user)));
        } catch (Exception ex) {
            return ResponseEntity
                    .status(500)
                    .body(new ResponseFormat(ResponseType.FAIL, ex.getMessage()));
        }
    }

    @PostMapping("/api/users/login")
    public ResponseEntity login(@RequestBody User user) {
        try {
            return ResponseEntity
                    .ok(new ResponseFormat(ResponseType.LOGIN_USER_SUCCESS, this.userService.login(user)));
        } catch (Exception ex) {
            return ResponseEntity
                    .status(500)
                    .body(new ResponseFormat(ResponseType.FAIL, ex.getMessage()));
        }
    }

    @PutMapping("/api/users/{id}")
    public ResponseEntity modifyUser(@RequestBody User user, @PathVariable Long id) {
        try {
            return ResponseEntity
                    .ok(new ResponseFormat(ResponseType.MODIFY_USER_SUCCESS, this.userService.modifyUser(user, id)));
        } catch (Exception ex) {
            return ResponseEntity
                    .status(500)
                    .body(new ResponseFormat(ResponseType.FAIL, ex.getMessage()));
        }
    }

    @DeleteMapping("/api/users/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return ResponseEntity
                    .ok(new ResponseFormat(ResponseType.DELETE_USER_SUCCESS, this.userService.deleteUser(id)));
        } catch (Exception ex) {
            return ResponseEntity
                    .status(500)
                    .body(new ResponseFormat(ResponseType.FAIL, ex.getMessage()));
        }
    }
}
