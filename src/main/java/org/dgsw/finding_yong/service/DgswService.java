package org.dgsw.finding_yong.service;

import lombok.RequiredArgsConstructor;
import org.dgsw.finding_yong.dto.*;
import org.dgsw.finding_yong.entity.Post;
import org.dgsw.finding_yong.repository.DgswRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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
    @Transactional
    public UpdateRes update(UpdateReq req, Long id){
            Post post = dgswRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시물입니다. id=" + id));

            if (!req.password().equals(post.getPassword())) {
                throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
            }

            post.update(req.title(), req.content());

            return new UpdateRes(true, "성공적으로 저장되었습니다.");
    }
    public List<GetPostsResponse> findAllPosts() {
        return dgswRepository.findAllTitleAndContent();
    }

    public GetPostsResponse findPostsById(Long id) {
        return dgswRepository.findPostById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found"));
    }
}
