package com.allwayz.freeseed;

import com.allwayz.freeseed.model.entity.Role;
import com.allwayz.freeseed.model.entity.User;
import com.allwayz.freeseed.model.entity.UserDtl;
import com.allwayz.freeseed.model.mapper.UserDtlMapper;
import com.allwayz.freeseed.model.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserServiceImpl {
    @Autowired
    private UserMapper userMapper;
    private UserDtlMapper userDtlMapper;

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUserEmail("allwayzio@126.com");
        user.setUserPassword("123456");
        user.setRoleId(1);

        userMapper.insert(user);
        System.out.println(user.toString());
    }

    @Test
    public void testCount() {
        System.out.println(userMapper.selectCount(new QueryWrapper<User>()));
    }

    @Test
    public void testUpdate() {
        User user = userMapper.selectById(1);
        user.setUserDtlId(1);
        //user.setUserPassword("666666");
        userMapper.updateById(user);
        System.out.println(user);
    }

    //TODO fix mail send bug and test sign up function
    public void testUserRegister() {

    }


}
