package com.fundamentosplatzi.springboot.demo.repository;

import com.fundamentosplatzi.springboot.demo.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

}
