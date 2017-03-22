package com.example.mysql.business.repository;

import com.example.mysql.business.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 一定要加泛型
 * Created by Richard on 2017/3/21.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByNameLike(String name);
    User readByName(String name);
    List<User> getByCreateDateLessThan(Date start);
}
