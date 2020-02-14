package com.allwayz.freeseed;

import com.allwayz.freeseed.model.entity.Major;
import com.allwayz.freeseed.model.mapper.MajorMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMajorServiceImpl {

    @Autowired
    private MajorMapper majorMapper;

    /**
     * 哲学        经济学     法学  教育学       文学     历史学   力学     工学         农学        医学     军事学             管理学     艺术学
     * Philosophy,Economics,Law,Education,Literature,History,Science,Engineering,Agriculture,Medicine,Military Science,Management, Art
     * 501xx      502xx    503xx 504xx      505xx     506xx   507xx   508xx        509xx      510xx    511xx            512xx       513xx
     */
    @Test
    public void testInsertMajor(){
        Major major = new Major();
        major.setMajorName("Ancient Greece:Myth,Art,War");
        major.setMajorCode("MC_50603");
        majorMapper.insert(major);
    }

    /**
     * Fuzzy query
     */
    @Test
    public void testSelectMajor(){
        List<Major> majorList = majorMapper.selectList(new QueryWrapper<Major>().like("major_code","MC_506"));
        majorList.forEach(System.out::println);
    }
}
