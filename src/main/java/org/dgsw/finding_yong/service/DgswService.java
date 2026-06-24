package org.dgsw.finding_yong.service;

import lombok.RequiredArgsConstructor;
import org.dgsw.finding_yong.dto.PostRequest;
import org.dgsw.finding_yong.dto.PostResponse;
import org.dgsw.finding_yong.entity.Post;
import org.dgsw.finding_yong.repository.DgswRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DgswService {

    private final DgswRepository dgswRepository;

    public PostResponse createPost(PostRequest request) {
        Post post = Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .password(request.getPassword())
                .build();
        return PostResponse.from(dgswRepository.save(post));
    }
}
