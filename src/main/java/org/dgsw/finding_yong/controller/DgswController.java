package org.dgsw.finding_yong.controller;

import lombok.RequiredArgsConstructor;
import org.dgsw.finding_yong.dto.PostRequest;
import org.dgsw.finding_yong.dto.PostResponse;
import org.dgsw.finding_yong.service.DgswService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DgswController {

    private final DgswService dgswService;

    @PostMapping("/post")
    public ResponseEntity<PostResponse> createPost(@RequestBody PostRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(dgswService.createPost(request));
    }
}
