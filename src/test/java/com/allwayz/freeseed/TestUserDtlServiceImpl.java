package com.allwayz.freeseed;

import com.allwayz.freeseed.model.entity.CityDtl;
import com.allwayz.freeseed.model.entity.UserDtl;
import com.allwayz.freeseed.model.mapper.CityDtlMapper;
import com.allwayz.freeseed.model.mapper.UserDtlMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserDtlServiceImpl {

    @Autowired
    private UserDtlMapper userDtlMapper;

    @Autowired
    private CityDtlMapper cityDtlMapper;

    /**
     * Try to insert a User Detail about UserId = 1
     * Location at China 江苏 苏州
     */
    @Test
    public void testInsertUserDtl() {
        UserDtl userDtl = new UserDtl();
        CityDtl cityDtl = cityDtlMapper.selectOne(new QueryWrapper<CityDtl>().eq("city_dtl_name","苏州"));
        userDtl.setFirstName("Allwayz")
                .setLastName("Liu")
                .setBirthday("1999-03-12")
                .setUserId(1)
                .setTelephone("12345678901")
                .setCityDtlId(cityDtl.getCityDtlId());
        userDtlMapper.insert(userDtl);
    }
}
