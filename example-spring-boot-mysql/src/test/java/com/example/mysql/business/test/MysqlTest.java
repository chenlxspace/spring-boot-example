package com.example.mysql.business.test;

import com.example.mysql.business.entity.Department;
import com.example.mysql.business.entity.Role;
import com.example.mysql.business.entity.User;
import com.example.mysql.business.repository.DepartmentRepository;
import com.example.mysql.business.repository.RoleRepository;
import com.example.mysql.business.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JpaConfigurationTest.class)
public class MysqlTest {
    private static Logger logger = LoggerFactory.getLogger(MysqlTest.class);

    @Autowired
    UserRepository userRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    RoleRepository roleRepository;

    @Before
    public void initData(){
        userRepository.deleteAll();
        roleRepository.deleteAll();
        departmentRepository.deleteAll();

        Department department = new Department();
        department.setName("开发部");
        departmentRepository.save(department);
        Assert.assertNotNull(department.getId());

        Role role = new Role();
        role.setName("admin");
        roleRepository.save(role);
        Assert.assertNotNull(role.getId());

        User user = new User();
        user.setName("user");
        user.setCreateDate(new Date());
        user.setDepartment(department);

        List<Role> roles = roleRepository.findAll();
        Assert.assertNotNull(roles);
        user.setRoles(roles);

        userRepository.save(user);
        Assert.assertNotNull(user.getId());
    }


    @Test
    public void findPage(){
        Pageable pageable = new PageRequest(0, 10, new Sort(Sort.Direction.ASC, "id"));
        Page<User> page = userRepository.findAll(pageable);
        Assert.assertNotNull(page);
        for(User user : page.getContent()) {
            logger.info("====user==== user name:{}, department name:{}, role name:{}",
                    user.getName(), user.getDepartment().getName(), user.getRoles().get(0).getName());
        }
    }

    @Test
    public void test(){
        User user1 = userRepository.findByNameLike("u%");
        Assert.assertNotNull(user1);

        User user2 = userRepository.readByName("user");
        Assert.assertNotNull(user2);

        List<User> users = userRepository.getByCreateDateLessThan(new Date());
        Assert.assertNotNull(users);
    }
}
