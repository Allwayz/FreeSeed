package com.allwayz.freeseed;

import com.allwayz.freeseed.model.entity.Classroom;
import com.allwayz.freeseed.model.mapper.ClassroomMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestClassroomServiceImpl {

    @Autowired
    private ClassroomMapper classroomMapper;

    /**
     *
     */
    @Test
    public void testInsertClassroom() {
        Classroom classroom = new Classroom();
        classroom.setClassroomName("SE-102");
        classroom.setClassroomFloor("First");
        classroom.setClassroomCapacity(30);
        classroomMapper.insert(classroom);
    }

    @Test
    public void testSelectClassroomById() {
        System.out.println(classroomMapper.selectById(1).toString());
    }
}
