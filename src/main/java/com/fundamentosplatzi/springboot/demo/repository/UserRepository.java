package com.fundamentosplatzi.springboot.demo.repository;

import com.fundamentosplatzi.springboot.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
