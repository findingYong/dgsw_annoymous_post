package org.dgsw.finding_yong.controller;

import lombok.RequiredArgsConstructor;
import org.dgsw.finding_yong.dto.*;
import org.dgsw.finding_yong.service.DgswService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PatchMapping;
import org.dgsw.finding_yong.entity.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DgswController {

    private final DgswService dgswService;

    @PostMapping("/post")
    public ResponseEntity<PostResponse> createPost(@RequestBody PostRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(dgswService.createPost(request));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<UpdateRes> update(@RequestBody UpdateReq req, @PathVariable Long id){
            return ResponseEntity.ok(dgswService.update(req, id));
    }
    @GetMapping
    public List<GetPostsResponse> getPosts() {
        return dgswService.findAllPosts();
    }

    @GetMapping("/{id}")
    public GetPostsResponse getPost(@PathVariable Long id) {
        return dgswService.findPostsById(id);
    }
}
