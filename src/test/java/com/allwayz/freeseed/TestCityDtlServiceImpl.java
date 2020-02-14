package com.allwayz.freeseed;

import com.allwayz.freeseed.model.entity.CityDtl;
import com.allwayz.freeseed.model.mapper.CityDtlMapper;
import com.allwayz.freeseed.util.StringToArrayUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCityDtlServiceImpl {

    @Autowired
    private CityDtlMapper cityDtlMapper;

    @Test
    public void testInsert() {
        String str = "乌鲁木齐，克拉玛依，吐鲁番，哈密，昌吉回族自治州，博尔塔拉蒙古自治州，巴音郭楞蒙古自治州，阿克苏地区，克孜勒苏柯尔克孜自治州，喀什地区，和田地区，伊犁哈萨克自治州，塔城地区，阿勒泰地区，其他地区";
        ArrayList<String> arrayList = StringToArrayUtil.StringToArray(str,"，");
        for(int i = 0; i < arrayList.size(); i++) {
            CityDtl cityDtl = new CityDtl();
            cityDtl.setCityDtlName(arrayList.get(i));
            cityDtl.setProvinceDtlId(31);
            cityDtlMapper.insert(cityDtl);
        }
    }

    @Test
    public void testSelectALl() {
        List<CityDtl> cityDtlList = cityDtlMapper.selectList(new QueryWrapper<CityDtl>());
        cityDtlList.forEach(System.out::println);
    }

    @Test
    public void testSelectOne() {
        CityDtl cityDtl = cityDtlMapper.selectOne(new QueryWrapper<CityDtl>().eq("city_dtl_name","苏州"));
        System.out.println(cityDtl.toString());
    }
}
