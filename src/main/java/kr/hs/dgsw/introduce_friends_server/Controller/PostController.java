package kr.hs.dgsw.introduce_friends_server.Controller;

import kr.hs.dgsw.introduce_friends_server.Protocol.ResponseFormat;
import kr.hs.dgsw.introduce_friends_server.Protocol.ResponseType;
import kr.hs.dgsw.introduce_friends_server.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/api/posts")
    public ResponseEntity getAllPosts() {
        try {
            return ResponseEntity
                    .ok(new ResponseFormat(ResponseType.FAIL, this.postService.getAllPosts()));
        } catch (Exception ex) {
            return ResponseEntity
                    .status(500)
                    .body(new ResponseFormat(ResponseType.FAIL, ex.getMessage()));
        }
    }
}
