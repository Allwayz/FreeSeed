package com.allwayz.freeseed.JSPController;

import com.allwayz.freeseed.model.entity.MajorDtl;
import com.allwayz.freeseed.model.entity.User;
import com.allwayz.freeseed.model.entity.UserDtl;
import com.allwayz.freeseed.model.mapper.MajorDtlMapper;
import com.allwayz.freeseed.model.mapper.RoleMapper;
import com.allwayz.freeseed.model.mapper.UserDtlMapper;
import com.allwayz.freeseed.model.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserDtlMapper userDtlMapper;
    @Autowired
    private MajorDtlMapper majorDtlMapper;

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
        return "StudentPage/Resource";
    }

    @RequestMapping("studentWorkOrder")
    public String studentWorkOrder(){
        return "StudentPage/studentWorkOrder";
    }

}
