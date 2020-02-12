package com.allwayz.freeseed;

import com.allwayz.freeseed.model.mapper.EnrollmentMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestEnrollmentServiceImpl {

    @Autowired
    private EnrollmentMapper enrollmentMapper;
}
