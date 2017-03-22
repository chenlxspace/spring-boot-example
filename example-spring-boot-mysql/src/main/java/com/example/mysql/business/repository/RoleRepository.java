package com.example.mysql.business.repository;

import com.example.mysql.business.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 一定要加泛型
 * Created by Richard on 2017/3/21.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
