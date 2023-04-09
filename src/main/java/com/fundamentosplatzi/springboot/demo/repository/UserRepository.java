package com.fundamentosplatzi.springboot.demo.repository;

import com.fundamentosplatzi.springboot.demo.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("Select u from User u WHERE u.email=?1")
    Optional<User> findByUserEmail(String email);

@Query("SELECT u From User u WHERE u.name like ?1%")
    List<User> findAndSort(String name, Sort sort);



List<User> findByName(String name);
Optional<User> findByEmailAndName(String email,String name);



}
