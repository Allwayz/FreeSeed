package com.allwayz.freeseed.JSPController;

import com.allwayz.freeseed.model.entity.Role;
import com.allwayz.freeseed.model.mapper.RoleMapper;
import com.allwayz.freeseed.util.AuthorizationCodeUtil;
import com.allwayz.freeseed.util.MailFormatCheckUtil;
import com.allwayz.freeseed.util.MailUtil;
import com.allwayz.freeseed.util.OhMyEmailUtil.OhMyEmail;
import com.allwayz.freeseed.util.OhMyEmailUtil.SendMailException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @ResponseBody
    @RequestMapping(value = "/sendAuCode/{email}")
    public Map sendCode(@PathVariable(value = "email") String email, HttpSession session) throws SendMailException {
        Map<String,String> map = new HashMap<>();
        System.out.println("Into Mail Controller");
        if(email.isEmpty()){
            map.put("Message","enter the Email");
            return map;
        }
        else {
            if(MailFormatCheckUtil.checkEmailFormat(email)){
                MailUtil.sendAuthorizationCodeEmail(email);
                map.put("Message","Success");
                return map;
            }else {
                map.put("Message","Field");
                return map;
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
