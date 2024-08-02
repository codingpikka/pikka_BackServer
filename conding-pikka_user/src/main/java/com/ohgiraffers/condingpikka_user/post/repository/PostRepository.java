package com.ohgiraffers.condingpikka_user.post.repository;


import com.ohgiraffers.condingpikka_user.post.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Integer> {
}
