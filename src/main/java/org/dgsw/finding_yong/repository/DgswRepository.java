package org.dgsw.finding_yong.repository;

import org.dgsw.finding_yong.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DgswRepository extends JpaRepository<Post, Long> {
}
