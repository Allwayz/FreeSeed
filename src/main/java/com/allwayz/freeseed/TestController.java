package com.allwayz.freeseed;

import com.allwayz.freeseed.model.entity.CityDtl;
import com.allwayz.freeseed.model.entity.NationalDtl;
import com.allwayz.freeseed.model.entity.Role;
import com.allwayz.freeseed.model.entity.User;
import com.allwayz.freeseed.model.mapper.CityDtlMapper;
import com.allwayz.freeseed.model.mapper.NationalDtlMapper;
import com.allwayz.freeseed.model.mapper.RoleMapper;
import com.allwayz.freeseed.model.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class TestController {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private CityDtlMapper cityDtlMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private NationalDtlMapper nationalDtlMapper;

    /**
     *
     * @param roleDesc
     */
    @ResponseBody
    @RequestMapping("/addRole")
    public void addRoles(String roleDesc){
        System.out.println(roleDesc);
        if(roleDesc.isEmpty()){
            System.out.println("Input Desc");
        }else {
            Role role = new Role();
            role.setRoleDesc(roleDesc);
            roleMapper.insert(role);
            System.out.println("Success");
        }
    }

    /**
     *
     * @param password
     * @param email
     * @param role
     */
    @ResponseBody
    @RequestMapping("/addUser")
    public void addUser(String password,String email,String role){
        if(password.isEmpty()||email.isEmpty()||role.isEmpty()){
            System.out.println("Input variable");
        }else{

            User user = new User();
            user.setUserPassword(password)
                    .setUserEmail(email)
                    .setRoleId(
                            roleMapper.selectOne(new QueryWrapper<Role>().eq("role_desc",role)).getRoleId());
            userMapper.insert(user);
        }
    }

    @RequestMapping("/addMajor")
    @ResponseBody
    public void addMajor(){

    }

    /**
     *
     * @return
     */
    @RequestMapping("/roleList")
    @ResponseBody
    public List<Role> roleList() {
        List<Role> roleList = roleMapper.selectList(new QueryWrapper<Role>());
        roleList.forEach(System.out::println);
        return roleList;
    }

    /**
     *
     * @return
     */
    @RequestMapping("/cityList")
    @ResponseBody
    public List<CityDtl> cityDtlList() {
        List<CityDtl> cityDtlList = cityDtlMapper.selectList(new QueryWrapper<CityDtl>());
        cityDtlList.forEach(System.out::println);
        return cityDtlList;
    }


    @RequestMapping("/testAPI")
    public String testAPI() {
        return "testAPI";
    }

}
