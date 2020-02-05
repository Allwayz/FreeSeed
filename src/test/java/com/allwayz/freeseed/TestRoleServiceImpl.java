package com.allwayz.freeseed;

import com.allwayz.freeseed.model.entity.Role;
import com.allwayz.freeseed.model.mapper.RoleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRoleServiceImpl {

    @Autowired
    private RoleMapper roleMapper;

    /**
     *
     */
    @Test
    public void testSelectAll(){
        System.out.println("----------Select All-------------");
        List<Role> roleList = roleMapper.selectList(null);
        roleList.forEach(System.out::println);
    }

    @Test
    public void testInsertRole(){
        System.out.println("----------Select All-------------");
        Role role = new Role();
        role.setRoleDesc("admin");
        roleMapper.insert(role);
        System.out.println("Insert Successfully");

    }

}
