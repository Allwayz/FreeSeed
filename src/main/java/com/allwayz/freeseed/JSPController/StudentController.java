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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  学生用户界面的控制器
 * </p>
 *
 * @author Allwayz
 * @since 2020-02-21
 */
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
    private MajorMapper majorMapper;
    @Autowired
    private TranscriptMapper transcriptMapper;
    @Autowired
    private EnrollmentMapper enrollmentMapper;
    @Autowired
    private AssessmentMapper assessmentMapper;

    /**
     *
     * @return
     */
    @RequestMapping("studentDashboard")
    public String studentDashBoard(){
        return "StudentPage/studentDashboard";
    }

    /**
     *
     * @param email
     * @param session
     * @return
     */
    @RequestMapping("UserInfo")
    public String userInfo(String email, HttpSession session){
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("user_email",email));
        UserDtl userDtl = userDtlMapper.selectOne(new QueryWrapper<UserDtl>().eq("user_id",user.getUserId()));
        session.setAttribute("UserDtl",userDtl);
        return "StudentPage/UserInfo";
    }

    /**
     *
     * @param session
     * @return
     */
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

    /**
     *
     * @return
     */
    @RequestMapping("studentWorkOrder")
    public String studentWorkOrder(){
        return "StudentPage/studentWorkOrder";
    }

    /**
     *
     * @param email
     * @param session
     * @return
     */
    @RequestMapping("transcript")
    public String studentTranscript(String email, HttpSession session){
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("user_email",email));
        List<Transcript> transcriptList = transcriptMapper.selectList(new QueryWrapper<Transcript>().eq("user_id",user.getUserId()));
        session.setAttribute("TranscriptList",transcriptList);
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

    /**
     * 显示成绩单的方法
     *
     * @param email
     * @param session
     * @return Map
     */
    @RequestMapping("ShowTranscript")
    @ResponseBody
    public Map testTranscript(String email,HttpSession session){
        /*
        如果要显示某学生在某一年某门课的总体成绩, 需要user拿到Enrollment, 历遍EnrollmentList拿到major_dtl,
        用major_dtl 拿到 major -> assessment,
        用assessment 和 major_dtl 拿到transcript
         */
        Map<String,List> map = new HashMap<>();
        //学生身份
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("user_email",email));
        List<Enrollment> enrollmentList = enrollmentMapper.selectList(new QueryWrapper<Enrollment>().eq("user_id",user.getUserId()));
        logger.info(enrollmentList.toString());
        //历遍enrollmentList，得到MajorDtlId
        for(Enrollment enrollment : enrollmentList){
            Map<String,String> stringStringMap = new HashMap<>();
            List<Transcript> transcriptList = new ArrayList<>();
            MajorDtl majorDtl = majorDtlMapper.selectOne(new QueryWrapper<MajorDtl>().eq("major_dtl_id",enrollment.getMajorDtlId()));
            //通过MajorDtlId 得到 Major
            Major major = majorMapper.selectOne(new QueryWrapper<Major>().eq("major_id",majorDtl.getMajorId()));
            //通过MajorId 得到 assessmentList
            List<Assessment> assessmentList = assessmentMapper.selectList(new QueryWrapper<Assessment>().eq("major_id",major.getMajorId()));
            logger.info(assessmentList.toString());

            //历遍assessmentList 得到 AssessmentId
            for(Assessment assessment : assessmentList){
                //Select Transcript
                Transcript transcript = transcriptMapper.selectOne(
                    new QueryWrapper<Transcript>()
                        .and(i -> i.eq("assessment_id",assessment.getAssessmentId()).eq("enrollment_id",enrollment.getEnrollmentId()))
                );
                //放入List
                transcriptList.add(transcript);


            }
            //List放入Map
            //TODO 如何在map的list中放入想要的数据库字段
            map.put("TranScript",transcriptList);
        }
        return map;
    }

    //TODO: work order system

    @RequestMapping("testShowTranscript")
    @ResponseBody
    public Map testShowTranscript(String email,HttpSession session){
        /*
        如果要显示某学生在某一年某门课的总体成绩, 需要user拿到Enrollment, 历遍EnrollmentList拿到major_dtl,
        用major_dtl 拿到 major -> assessment,
        用assessment 和 major_dtl 拿到transcript
         */
        Map<String,Map<String,String>> map = new HashMap<>();
        //学生身份
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("user_email",email));
        List<Enrollment> enrollmentList = enrollmentMapper.selectList(new QueryWrapper<Enrollment>().eq("user_id",user.getUserId()));
        //历遍enrollmentList，得到MajorDtlId

        for(Enrollment enrollment : enrollmentList){
            logger.warn(enrollment.toString());
            MajorDtl majorDtl = majorDtlMapper.selectOne(new QueryWrapper<MajorDtl>().eq("major_dtl_id",enrollment.getMajorDtlId()));
            //通过MajorDtlId 得到 Major
            Major major = majorMapper.selectOne(new QueryWrapper<Major>().eq("major_id",majorDtl.getMajorId()));
            //通过MajorId 得到 assessmentList
            List<Assessment> assessmentList = assessmentMapper.selectList(new QueryWrapper<Assessment>().eq("major_id",major.getMajorId()));
            Map<String,String> stringStringMap = new HashMap<>();
            //历遍assessmentList 得到 AssessmentId
            for(Assessment assessment : assessmentList){
                logger.warn(assessment.toString());
                //Select Transcript
                logger.warn(transcriptMapper.selectOne(
                        new QueryWrapper<Transcript>()
                                .and(i -> i.eq("assessment_id",assessment.getAssessmentId()).eq("enrollment_id",enrollment.getEnrollmentId()))
                ).toString());
                //Transcript transcript = ;
                //放入stringStringMap
                stringStringMap.put("Major",major.getMajorName());
                stringStringMap.put("semester",majorDtl.getSemester());
                stringStringMap.put("semesterYear",majorDtl.getSemesterYear().toString());
                stringStringMap.put("Assessment",assessment.getAssessmentName());
                stringStringMap.put("percentage",assessment.getPrecentage().toString());
                map.put("TranScript",stringStringMap);
            }
            //List放入Map
            //TODO 如何在map的list中放入想要的数据库字段
        }
        return map;
    }












}
