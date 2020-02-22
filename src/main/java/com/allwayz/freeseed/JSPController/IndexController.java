package com.allwayz.freeseed.JSPController;

import com.allwayz.freeseed.model.entity.Role;
import com.allwayz.freeseed.model.entity.User;
import com.allwayz.freeseed.model.enums.RoleEnum;
import com.allwayz.freeseed.model.mapper.RoleMapper;
import com.allwayz.freeseed.model.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.catalina.Session;
import org.apache.catalina.SessionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    /**
     * multi url Mapping
     * @return
     */
    @RequestMapping({"/homepage","/","index","home","login"})
    public String index(){
        return "index";
    }

    /**
     * JSP Sign_Up
     * @return
     */
    @RequestMapping("/Sign_Up")
    public String sign_up(){
        return "Sign_Up";
    }

    /**
     * Login Interface
     * @param email
     * @param password
     * @return
     */
    @RequestMapping("/loginRequest")
    public String dashboard(String email,String password){
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("user_email",email));
        Role role = roleMapper.selectOne(new QueryWrapper<Role>().eq("role_id",user.getRoleId()));
        if(user.getUserPassword().equals(password)){
            return RoleEnum.valueOf(role.getRoleDesc()).LoginUrl();
        }else {
            return "error";
        }
    }
}
