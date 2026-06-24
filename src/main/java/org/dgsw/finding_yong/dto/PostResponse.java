package org.dgsw.finding_yong.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dgsw.finding_yong.entity.Post;

@Getter
@AllArgsConstructor
public class PostResponse {

    private Long id;
    private String title;
    private String content;

    public static PostResponse from(Post post) {
        return new PostResponse(post.getId(), post.getTitle(), post.getContent());
    }
}
