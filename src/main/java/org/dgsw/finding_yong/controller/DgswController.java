package org.dgsw.finding_yong.controller;

import lombok.RequiredArgsConstructor;
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

    @GetMapping
    public List<Post> getPosts() {
        return dgswService.findAll();
    }

    @GetMapping("/{id}")
    public Post getPost(@PathVariable Long id) {
        return dgswService.findById(id);
    }
}
