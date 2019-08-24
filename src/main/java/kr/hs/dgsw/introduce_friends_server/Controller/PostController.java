package kr.hs.dgsw.introduce_friends_server.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
    @GetMapping("/")
    public String ping() {
        return "pong";
    }
}
