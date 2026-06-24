package org.dgsw.finding_yong.dto;

public record UpdateReq(
        String password,
        String title,
        String content
) {
}
