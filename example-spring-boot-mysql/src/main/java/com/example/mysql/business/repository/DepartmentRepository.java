package com.example.mysql.business.repository;

import com.example.mysql.business.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 一定要加泛型
 * Created by Richard on 2017/3/21.
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
