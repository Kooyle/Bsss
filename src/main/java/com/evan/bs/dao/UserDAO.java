package com.evan.bs.dao;

import com.evan.bs.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface UserDAO extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {
    User findByUsername(String username);

    User getByUsernameAndPassword(String username, String password);
    List<User> findAll();

}
