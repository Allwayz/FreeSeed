package com.allwayz.freeseed.JSPController;

import com.allwayz.freeseed.model.entity.*;
import com.allwayz.freeseed.model.mapper.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
    private Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserDtlMapper userDtlMapper;
    @Autowired
    private MajorDtlMapper majorDtlMapper;
    @Autowired
    private TranscriptMapper transcriptMapper;
    @Autowired
    private EnrollmentMapper enrollmentMapper;

    @RequestMapping("studentDashboard")
    public String studentDashBoard(){
        return "StudentPage/studentDashboard";
    }

    @RequestMapping("UserInfo")
    public String userInfo(String email, HttpSession session){
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("user_email",email));
        UserDtl userDtl = userDtlMapper.selectOne(new QueryWrapper<UserDtl>().eq("user_id",user.getUserId()));
        session.setAttribute("UserDtl",userDtl);
        return "StudentPage/UserInfo";
    }

    @RequestMapping("majorResource")
    public String majorResource(HttpSession session){
        List<MajorDtl> majorDtlList = majorDtlMapper.selectList(new QueryWrapper<MajorDtl>().orderByAsc("semester_year"));
        session.setAttribute("MajorDtlList",majorDtlList);

        User user = userMapper.selectOne(new QueryWrapper<User>().eq("user_email",session.getAttribute("UserEmail")));
        List<Enrollment> enrollmentList = enrollmentMapper.selectList(new QueryWrapper<Enrollment>().eq("user_id",user.getUserId()));
        List<MajorDtl> myMajor = new ArrayList<>();
        for(Enrollment enrollment:enrollmentList){
            MajorDtl majorDtl = majorDtlMapper.selectById(enrollment.getMajorDtlId());
            myMajor.add(majorDtl);
        }
        session.setAttribute("MyMajor",myMajor);

        return "StudentPage/Resource";
    }

    @RequestMapping("studentWorkOrder")
    public String studentWorkOrder(){
        return "StudentPage/studentWorkOrder";
    }

    @RequestMapping("transcript")
    public String studentTranscript(String email, HttpSession session){
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("user_email",email));
        List<Transcript> transcriptList = transcriptMapper.selectList(new QueryWrapper<Transcript>().eq("user_id",user.getUserId()));
        session.setAttribute("TranscriptList",transcriptList);
        Transcript transcript;
        return "StudentPage/Transcript";
    }

    /**
     *
     * @param majorDtlId
     * @param session
     * @return
     */
    @RequestMapping("addEnrollment")
    @ResponseBody
    public String addEnrollment(int majorDtlId, HttpSession session){
        logger.info(String.valueOf(majorDtlId));
        logger.info(session.getAttribute("UserEmail").toString());
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("user_email",session.getAttribute("UserEmail")));
        Enrollment enrollment = new Enrollment().setMajorDtlId(majorDtlId)
                .setUserId(user.getUserId());
        //判断是否有加入该课程
        List<Enrollment> enrollmentList = enrollmentMapper
                .selectList(
                        new QueryWrapper<Enrollment>()
                                .and(
                                        i -> i.eq("user_id", user.getUserId()).eq("major_dtl_id", majorDtlId)
                                )
                );

        if(enrollmentList.size() == 0){
            enrollmentMapper.insert(enrollment);
            return "Success";
        }else {
            return "Fail";
        }
    }

    //TODO: work order system

}
