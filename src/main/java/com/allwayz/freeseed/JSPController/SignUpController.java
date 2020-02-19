package com.allwayz.freeseed.JSPController;

import com.allwayz.freeseed.model.entity.Role;
import com.allwayz.freeseed.model.mapper.RoleMapper;
import com.allwayz.freeseed.util.AuthorizationCodeUtil;
import com.allwayz.freeseed.util.MailFormatCheckUtil;
import com.allwayz.freeseed.util.MailUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.github.biezhi.ome.SendMailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.List;

//@WebServlet(urlPatterns = "/*")
@Controller
public class SignUpController{
    @Autowired
    private RoleMapper roleMapper;

    /**
     *
     * @param email
     * @return
     * @throws SendMailException
     */
    @RequestMapping(value = "/sendAuCode")
    public String sendCode(String email) throws SendMailException {
        System.out.println(email);
        if(email.isEmpty()){
            return "Email is Enpty";
        }
        else {
            if(MailFormatCheckUtil.checkEmailFormat(email)){
                MailUtil.sendAuthorizationCodeEmail(email);
                return "send...";
            }else {
                return "Not a Email address...";
            }

        }
    }

    @RequestMapping("/roleLoad")
    @ResponseBody
    public List<Role> roleLoad(){
        List<Role> roleList = roleMapper.selectList(new QueryWrapper<Role>());
        return roleList;
    }

}
