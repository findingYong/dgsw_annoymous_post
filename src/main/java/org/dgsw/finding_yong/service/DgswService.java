package org.dgsw.finding_yong.service;

import lombok.RequiredArgsConstructor;
import org.dgsw.finding_yong.entity.Post;
import org.dgsw.finding_yong.repository.DgswRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DgswService {

    private final DgswRepository dgswRepository;

    public List<Post> findAll() {
        return dgswRepository.findAll();
    }

    public Post findById(Long id) {
        return dgswRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found"));
    }
}
