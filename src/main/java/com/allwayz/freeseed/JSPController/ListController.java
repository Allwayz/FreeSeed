package com.allwayz.freeseed.JSPController;

import com.allwayz.freeseed.model.entity.*;
import com.allwayz.freeseed.model.mapper.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ListController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MajorMapper majorMapper;
    @Autowired
    private EnrollmentMapper enrollmentMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private CityDtlMapper cityDtlMapper;
    @Autowired
    private ProvinceDtlMapper provinceDtlMapper;
    @Autowired
    private NationalDtlMapper nationalDtlMapper;
    @Autowired
    protected MajorDtlMapper majorDtlMapper;
    @Autowired
    private UserDtlMapper userDtlMapper;
    @Autowired
    private ClassroomMapper classroomMapper;

    /**
     *
     * @param table
     * @return
     */
    @RequestMapping("/listPage")
    public ModelAndView showUser(String table){
        Collection list;
        switch (table){
            case "user":
                list = userMapper.selectList(new QueryWrapper<User>());
                break;
            case "major":
                list = majorMapper.selectList(new QueryWrapper<Major>().orderByAsc("major_id"));
                break;
            case "enrollment":
                list = enrollmentMapper.selectList(new QueryWrapper<Enrollment>());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + table);
        }

        return new ModelAndView("list","message",table).addObject("tableMap",list);
    }

    @ResponseBody
    @GetMapping(value = "checkUserDtlById/{userId}")
    public Map<String,String> userDtlById(@PathVariable(value = "userId") int userId){
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("user_id",userId));
        Role role = roleMapper.selectById(user.getRoleId());
        UserDtl userDtl = userDtlMapper.selectOne(new QueryWrapper<UserDtl>().eq("user_id",user.getUserId()));
        CityDtl cityDtl = cityDtlMapper.selectById(userDtl.getCityDtlId());
        ProvinceDtl provinceDtl = provinceDtlMapper.selectById(cityDtl.getProvinceDtlId());
        NationalDtl nationalDtl = nationalDtlMapper.selectById(provinceDtl.getNationalDtlId());
        Map<String,String> map = new HashMap<>();
        map.put("user_email",user.getUserEmail());
        map.put("user_password",user.getUserPassword());
        map.put("firstName",userDtl.getFirstName());
        map.put("lastName",userDtl.getLastName());
        map.put("birthday",userDtl.getBirthday());
        map.put("telephone",userDtl.getTelephone());
        //地址
        map.put("nationalName",nationalDtl.getNationalDtlName());
        map.put("nationalCode",nationalDtl.getNationalDtlCode());
        map.put("provinceName",provinceDtl.getProvinceDtlName());
        map.put("cityName",cityDtl.getCityDtlName());
        map.put("roleDesc",role.getRoleDesc());
        return map;
    }

    @ResponseBody
    @GetMapping("checkMajorDtlById/{Id}")
    public Map<String,String> checkMajorDtlById(@PathVariable (value = "Id") int Id){
        MajorDtl majorDtl = majorDtlMapper.selectById(Id);
        Major major = majorMapper.selectById(majorDtl.getMajorId());
        Classroom classroom = classroomMapper.selectById(majorDtl.getClassroomId());
        Map<String,String> stringStringMap = new HashMap<>();
        stringStringMap.put("MajorName",major.getMajorName());
        stringStringMap.put("semester",majorDtl.getSemester());
        stringStringMap.put("semesterYear",String.valueOf(majorDtl.getSemesterYear()));
        stringStringMap.put("createTime",String.valueOf(majorDtl.getCreateTime()));
        stringStringMap.put("updateTime",String.valueOf(majorDtl.getUpdateTime()));
        stringStringMap.put("classroom",classroom.getClassroomName());
        stringStringMap.put("majorCode",major.getMajorCode());
        stringStringMap.put("majorStatus",major.getMajorStatus());

        return stringStringMap;
    }
}
