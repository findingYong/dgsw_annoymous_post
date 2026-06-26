package org.dgsw.finding_yong.repository;

import org.dgsw.finding_yong.dto.GetPostsResponse;
import org.dgsw.finding_yong.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DgswRepository extends JpaRepository<Post, Long> {

    @Query("""
    select Post(
        p.title,
        p.content
    )
    from Post p
""")
    List<GetPostsResponse> findAllTitleAndContent();

    @Query("""
    select post(
        p.title,
        p.content
    )
    from Post p
    where p.id = :id
""")
    Optional<GetPostsResponse> findPostById(@Param("id") Long id);
}
