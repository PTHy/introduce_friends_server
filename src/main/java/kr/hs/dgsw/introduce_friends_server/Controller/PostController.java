package kr.hs.dgsw.introduce_friends_server.Controller;

import kr.hs.dgsw.introduce_friends_server.Domain.Post;
import kr.hs.dgsw.introduce_friends_server.Protocol.ResponseFormat;
import kr.hs.dgsw.introduce_friends_server.Protocol.ResponseType;
import kr.hs.dgsw.introduce_friends_server.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/api/posts")
    public ResponseEntity getAllPosts() {
        try {
            return ResponseEntity
                    .ok(new ResponseFormat(ResponseType.GET_POSTS_SUCCESS, this.postService.getAllPosts()));
        } catch (Exception ex) {
            return ResponseEntity
                    .status(500)
                    .body(new ResponseFormat(ResponseType.FAIL, ex.getMessage()));
        }
    }

    @PostMapping("/api/post/{id}")
    public ResponseEntity getPost(@PathVariable Long id) {
        try {
            return ResponseEntity
                    .ok(new ResponseFormat(ResponseType.GET_POST_SUCCESS, this.postService.getPost(id)));
        } catch (Exception ex) {
            return ResponseEntity
                    .status(500)
                    .body(new ResponseFormat(ResponseType.FAIL, ex.getMessage()));
        }
    }

    @GetMapping("/api/users/{id}/posts")
    public ResponseEntity getPostsByUserId(@PathVariable Long id) {
        try {
            return ResponseEntity
                    .ok(new ResponseFormat(ResponseType.GET_POSTS_BY_USER_SUCCESS, this.postService.getPostsByUserId(id)));
        } catch (Exception ex) {
            return ResponseEntity
                    .status(500)
                    .body(new ResponseFormat(ResponseType.FAIL, ex.getMessage()));
        }
    }

    @PostMapping("/api/posts")
    public ResponseEntity createPost(@RequestBody Post post) {
        try {
            return ResponseEntity
                    .ok(new ResponseFormat(ResponseType.CREATE_POST_SUCCESS, this.postService.createPost(post)));
        } catch (Exception ex) {
            return ResponseEntity
                    .status(500)
                    .body(new ResponseFormat(ResponseType.FAIL, ex.getMessage()));
        }
    }

    @PutMapping("/api/posts/{id}")
    public ResponseEntity modifyPost(@RequestBody Post post, @PathVariable Long id) {
        try {
            return ResponseEntity
                    .ok(new ResponseFormat(ResponseType.MODIFY_POST_SUCCESS, this.postService.modifyPost(post, id)));
        } catch (Exception ex) {
            return ResponseEntity
                    .status(500)
                    .body(new ResponseFormat(ResponseType.FAIL, ex.getMessage()));
        }
    }

    @DeleteMapping("/api/posts/{id}")
    public ResponseEntity deletePost(@PathVariable Long id) {
        try {
            return ResponseEntity
                    .ok(new ResponseFormat(ResponseType.DELETE_POST_SUCCESS, this.postService.deletePost(id)));
        } catch (Exception ex) {
            return ResponseEntity
                    .status(500)
                    .body(new ResponseFormat(ResponseType.FAIL, ex.getMessage()));
        }
    }
}
