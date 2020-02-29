package com.allwayz.freeseed.JSPController;

import com.allwayz.freeseed.model.entity.Enrollment;
import com.allwayz.freeseed.model.entity.MajorDtl;
import com.allwayz.freeseed.model.entity.User;
import com.allwayz.freeseed.model.mapper.EnrollmentMapper;
import com.allwayz.freeseed.model.mapper.MajorDtlMapper;
import com.allwayz.freeseed.model.mapper.UserDtlMapper;
import com.allwayz.freeseed.model.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TeacherController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserDtlMapper userDtlMapper;
    @Autowired
    private MajorDtlMapper majorDtlMapper;
    @Autowired
    private EnrollmentMapper enrollmentMapper;

    @RequestMapping("teacherDashboard")
    public String teacherDashboard(){
        return "TeacherPage/teacherDashboard";
    }

    @RequestMapping("teacherWorkOrder")
    public String studentWorkOrder(){
        return "TeacherPage/teacherWorkOrder";
    }

    @RequestMapping("allMajor")
    public String teacherMajor(HttpSession session){
        List<MajorDtl> majorDtlList = majorDtlMapper.selectList(new QueryWrapper<MajorDtl>());
        session.setAttribute("MajorDtlList",majorDtlList);
        return "TeacherPage/allMajor";
    }

    @RequestMapping("myMajor")
    public String teacherEnroll(HttpSession session){
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("user_email",session.getAttribute("UserEmail")));
        List<Enrollment> enrollmentList = enrollmentMapper.selectList(new QueryWrapper<Enrollment>().eq("user_id",user.getUserId()));
        List<MajorDtl> majorDtlList = new ArrayList<MajorDtl>();
        for(Enrollment enrollment:enrollmentList){
            MajorDtl majorDtl = majorDtlMapper.selectById(enrollment.getMajorDtlId());
            majorDtlList.add(majorDtl);
        }
        session.setAttribute("MajorDtlList",majorDtlList);
        return "TeacherPage/myMajor";
    }



}
