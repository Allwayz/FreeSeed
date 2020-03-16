package com.allwayz.freeseed.JSPController;

import com.allwayz.freeseed.model.entity.*;
import com.allwayz.freeseed.model.mapper.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.net.ssl.HttpsURLConnection;
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
    @Autowired
    private MajorMapper majorMapper;
    @Autowired
    private ClassroomMapper classroomMapper;

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
        List<Map<String,String>> mapArrayList= new ArrayList<>();
        for(MajorDtl majorDtl:majorDtlList){
            Map<String,String> map = new HashMap<>();
            Major major = majorMapper.selectById(majorDtl.getMajorId());
            Classroom classroom = classroomMapper.selectById(majorDtl.getClassroomId());
            map.put("major_Name",major.getMajorName());
            map.put("semesterYear",String.valueOf(majorDtl.getSemesterYear()));
            map.put("semester",majorDtl.getSemester());
            map.put("classroom",classroom.getClassroomName());
            map.put("createTime",majorDtl.getCreateTime().toString());
            map.put("majorDtlId",String.valueOf(majorDtl.getMajorDtlId()));
            mapArrayList.add(map);
        }
        session.setAttribute("mapList",mapArrayList);

        return "TeacherPage/allMajor";
    }

    @RequestMapping("myMajor")
    public String teacherEnroll(HttpSession session){
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("user_email",session.getAttribute("UserEmail")));
        List<Enrollment> enrollmentList = enrollmentMapper.selectList(new QueryWrapper<Enrollment>().eq("user_id",user.getUserId()));
        List<Map<String,String>> myMajor = new ArrayList<>();
        for(Enrollment enrollment:enrollmentList){
            Map<String,String> stringStringMap = new HashMap<>();
            MajorDtl majorDtl = majorDtlMapper.selectById(enrollment.getMajorDtlId());
            Major major = majorMapper.selectById(majorDtl.getMajorId());
            Classroom classroom = classroomMapper.selectById(majorDtl.getClassroomId());
            stringStringMap.put("major_Name",major.getMajorName());
            stringStringMap.put("semesterYear",String.valueOf(majorDtl.getSemesterYear()));
            stringStringMap.put("semester",majorDtl.getSemester());
            stringStringMap.put("classroom",classroom.getClassroomName());
            stringStringMap.put("createTime",majorDtl.getCreateTime().toString());
            stringStringMap.put("majorDtlId",String.valueOf(majorDtl.getMajorId()));
            myMajor.add(stringStringMap);
        }
        session.setAttribute("MyMajor",myMajor);
        return "TeacherPage/myMajor";
    }

    @RequestMapping("teacherUserInfo")
    public String teacherUserInfo(String email,HttpSession session){
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("user_email",email));
        UserDtl userDtl = userDtlMapper.selectOne(new QueryWrapper<UserDtl>().eq("user_id",user.getUserId()));
        session.setAttribute("UserDtl",userDtl);
        return "TeacherPage/UserInfo";
    }

}
