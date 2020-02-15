package com.allwayz.freeseed;

import com.allwayz.freeseed.model.entity.CityDtl;
import com.allwayz.freeseed.model.entity.Role;
import com.allwayz.freeseed.model.entity.User;
import com.allwayz.freeseed.model.mapper.CityDtlMapper;
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

    /**
     *
     * @param roleDesc
     * @return
     */
    @ResponseBody
    @RequestMapping("/addRole")
    public String addROles(String roleDesc){
//        Role role = new Role();
//        role.setRoleDesc(roleDesc);
//        System.out.println(role.toString());
//        roleMapper.insert(role);
        Object args[] = {roleDesc};
        System.out.println(args[0]);
        return "okok";
    }


    @RequestMapping("/roleList")
    @ResponseBody
    public List<Role> roleList() {
        List<Role> roleList = roleMapper.selectList(new QueryWrapper<Role>());
        roleList.forEach(System.out::println);
        return roleList;
    }

    @RequestMapping("/cityList")
    @ResponseBody
    public List<CityDtl> cityDtlList() {
        List<CityDtl> cityDtlList = cityDtlMapper.selectList(new QueryWrapper<CityDtl>());
        cityDtlList.forEach(System.out::println);
        return cityDtlList;
    }

}
