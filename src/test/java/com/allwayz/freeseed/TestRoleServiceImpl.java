package com.allwayz.freeseed;

import com.allwayz.freeseed.model.entity.Role;
import com.allwayz.freeseed.model.mapper.RoleMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Scanner;

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
        Scanner input = new Scanner(System.in);


        System.out.println("----------Insert-------------");

        Role role = new Role();
        System.out.println("Please enter Role Description");
        String roleDesc = input.next();
        role.setRoleDesc(roleDesc);

        roleMapper.insert(role);
        System.out.println("Insert Successfully");
    }

    @Test
    public void testCount(){
        System.out.println(roleMapper.selectCount(new QueryWrapper<Role>()));
    }

}
