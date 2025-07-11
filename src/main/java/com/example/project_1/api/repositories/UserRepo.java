package com.example.project_1.api.repositories;

import com.example.project_1.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    @Autowired
    JdbcTemplate jdbcTemplate = new JdbcTemplate();

    // Custom query method based on naming convention
    List<User> findByAccountid(String accountid);

    // Native SQL query
    @Query(value = "SELECT * FROM dbo.[User] WHERE accountId = :accountid AND password = :password", nativeQuery = true)
    List<User> authenticateUserNative(String accountid, String password);
}
