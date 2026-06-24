package org.dgsw.finding_yong.controller;

import lombok.RequiredArgsConstructor;
import org.dgsw.finding_yong.dto.UpdateReq;
import org.dgsw.finding_yong.dto.UpdateRes;
import org.dgsw.finding_yong.service.DgswService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.dgsw.finding_yong.entity.Post;
import org.dgsw.finding_yong.service.DgswService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DgswController {

    private final DgswService dgswService;

    @PatchMapping("/{id}")
    public ResponseEntity<UpdateRes> update(UpdateReq req, @PathVariable Long id){
        return ResponseEntity.ok(dgswService.update(req, id));
    @GetMapping
    public List<Post> getPosts() {
        return dgswService.findAll();
    }

    @GetMapping("/{id}")
    public Post getPost(@PathVariable Long id) {
        return dgswService.findById(id);
    }
}
