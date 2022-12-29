package com.example.springboot_crud.repository;

import com.example.springboot_crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value = "SELECT * FROM user u where u.name like %:keyword% or u.last_name like %:keyword%",nativeQuery = true)
    List<User> findByKeyword(@Param("keyword")String keyword);
}
