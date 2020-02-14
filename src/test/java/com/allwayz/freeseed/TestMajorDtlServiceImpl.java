package com.allwayz.freeseed;

import com.allwayz.freeseed.model.entity.MajorDtl;
import com.allwayz.freeseed.model.mapper.MajorDtlMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMajorDtlServiceImpl {

    @Autowired
    private MajorDtlMapper majorDtlMapper;

    @Test
    public void testInsertMajorDtl() {
        MajorDtl majorDtl = new MajorDtl();
        majorDtl.setClassroomId(1);
        majorDtl.setMajorId(1);
        majorDtl.setSemester("SS");
        majorDtl.setSemesterYear(2021);
        majorDtlMapper.insert(majorDtl);
    }
}
