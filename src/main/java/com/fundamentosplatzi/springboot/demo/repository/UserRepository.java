package com.fundamentosplatzi.springboot.demo.repository;

import com.fundamentosplatzi.springboot.demo.dto.UserDto;
import com.fundamentosplatzi.springboot.demo.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("Select u from User u WHERE u.email=?1")
    Optional<User> findByUserEmail(String email);

    @Query("SELECT u From User u WHERE u.name like ?1%")
    List<User> findAndSort(String name, Sort sort);


    List<User> findByName(String name);

    Optional<User> findByEmailAndName(String email, String name);

    List<User> findByNameLike(String name);

    List<User> findByNameOrEmail(String name, String email);

    List<User> findByBirthDateBetween(LocalDate begin, LocalDate end);



    //List<User> findByNameLikeOrderByIdDesc(String name);

    List<User> findByNameContainingOrderByIdDesc(String name);

    @Query("SELECT new com.fundamentosplatzi.springboot.demo.dto.UserDto(u.id,u.name,u.birthDate)"
            + " FROM User u "
            + "where u.birthDate=:parametroFecha "
            + "and u.email=:parametroEmail ")

    Optional<UserDto> getAllByBirthDateAndEmail(@Param("parametroFecha")LocalDate date,
                                               @Param("parametroEmail") String email);

}