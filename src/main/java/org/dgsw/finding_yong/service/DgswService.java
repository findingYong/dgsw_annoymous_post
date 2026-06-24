package org.dgsw.finding_yong.service;

import lombok.RequiredArgsConstructor;
import org.dgsw.finding_yong.dto.UpdateReq;
import org.dgsw.finding_yong.dto.UpdateRes;
import org.dgsw.finding_yong.entity.Post;
import org.dgsw.finding_yong.repository.DgswRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DgswService {

    private final DgswRepository dgswRepository;

    @Transactional
    public UpdateRes update(UpdateReq req, Long id){
        Post post = dgswRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시물입니다. id=" + id));

        if(!req.password().equals(post.getPassword())){
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        post.update(req.title(), req.content());

        return new UpdateRes(true,"성공적으로 저장되었습니다.");
    }
}
