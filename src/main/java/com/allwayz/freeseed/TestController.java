package com.allwayz.freeseed;

import com.allwayz.freeseed.model.entity.*;
import com.allwayz.freeseed.model.mapper.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {
    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private CityDtlMapper cityDtlMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ProvinceDtlMapper provinceDtlMapper;
    @Autowired
    private NationalDtlMapper nationalDtlMapper;
    @Autowired
    private MajorMapper majorMapper;
    @Autowired
    protected MajorDtlMapper majorDtlMapper;
    @Autowired
    private UserDtlMapper userDtlMapper;

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
    public String addUser(String password,String email,String role){
        if(password.isEmpty()||email.isEmpty()||role.isEmpty()){
            return "Input variable";
        }else{

            User user = new User();
            user.setUserPassword(password)
                    .setUserEmail(email)
                    .setRoleId(
                            roleMapper.selectOne(new QueryWrapper<Role>().eq("role_desc",role)).getRoleId());
            userMapper.insert(user);

            UserDtl userDtl = new UserDtl()
                    .setUserId(userMapper.selectCount(new QueryWrapper<User>()));
            userDtlMapper.insert(userDtl);
            return "You are Sign Up";
        }
    }

    /**
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/addUserDtl")
    public String addUserDtl(){
        return null;
    }

    /**
     *
     * @param majorDepartment
     * @param majorName
     * @return
     */
    @RequestMapping("/addMajor")
    @ResponseBody
    public String addMajor(String majorDepartment,String majorName){
        Major major = new Major();
        major.setMajorName(majorName);

        /*
         * 哲学        经济学     法学  教育学       文学     历史学   力学     工学         农学        医学     军事学             管理学     艺术学
         * Philosophy,Economics,Law,Education,Literature,History,Science,Engineering,Agriculture,Medicine,Military Science,Management, Art
         * 501xx      502xx    503xx  504xx      505xx     506xx   507xx   508xx        509xx      510xx    511xx            512xx       513xx
         */
        String majorCodePrefix;

        switch(majorDepartment){
            case "Philosophy" :
                majorCodePrefix = "MC_501";
                break;
            case "Economics" :
                majorCodePrefix = "MC_502";
                break;
            case "Law" :
                majorCodePrefix = "MC_503";
                break;
            case "Education" :
                majorCodePrefix = "MC_504";
                break;
            case "Literature" :
                majorCodePrefix = "MC_505";
                break;
            case "History" :
                majorCodePrefix = "MC_506";
                break;
            case "Science" :
                majorCodePrefix = "MC_507";
                break;
            case "Engineering" :
                majorCodePrefix = "MC_508";
                break;
            case "Agriculture" :
                majorCodePrefix = "MC_509";
                break;
            case "Medicine" :
                majorCodePrefix = "MC_510";
                break;
            case "Military" :
                majorCodePrefix = "MC_511";
                break;
            case "Management" :
                majorCodePrefix = "MC_512";
                break;
            case "Art" :
                majorCodePrefix = "MC_513";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + majorName);
        }
            String i = Integer.toString(majorMapper.selectCount(new QueryWrapper<Major>().like("major_code",majorCodePrefix))+1);
        major.setMajorCode(majorCodePrefix+i);
        majorMapper.insert(major);
        return "Successful";
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
    @RequestMapping("/majorList")
    @ResponseBody
    public List<Major> majorList() {
        List<Major> majorList = majorMapper.selectList(new QueryWrapper<Major>());
        majorList.forEach(System.out::println);
        return majorList;
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

    @RequestMapping("/userList")
    @ResponseBody
    public List<User> userList(){
        List<User> userList = userMapper.selectList(new QueryWrapper<User>());
        return userList;
    }

    /**
     *
     * @param email
     * @return
     */
    @RequestMapping(value = "checkUserDtl/{email}", method = {RequestMethod.GET})
    @ResponseBody
    public Map<String,String> userDtlSelect(@PathVariable(value = "email") String email){
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("user_email",email));
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
        map.put("roseDesc",role.getRoleDesc());
        return map;
    }

    @RequestMapping("/checkMajorDtl")
    @ResponseBody
    public List<MajorDtl> majorDtlSelect(String input){
        int i = majorMapper.selectOne(new QueryWrapper<Major>().eq("major_name",input)).getMajorId();
        List<MajorDtl> majorDtlList = majorDtlMapper.selectList(new QueryWrapper<MajorDtl>().eq("major_id",i));
        return majorDtlList;
    }

    @RequestMapping("/updateUserDtl")
    @ResponseBody
    public String updateUserDtl(int id, String firstName, String lastName, String Birthday, String Telephone){
        UserDtl userDtl = userDtlMapper.selectById(id);
        userDtl.setFirstName(firstName)
                .setLastName(lastName)
                .setBirthday(Birthday)
                .setTelephone(Telephone);
        userDtlMapper.update(userDtl,new UpdateWrapper<UserDtl>().eq("user_dtl_id",userDtl.getUserDtlId()));
        return "Successful";
    }

    @RequestMapping("/addMajorDtl")
    @ResponseBody
    public String addMajorDtl(int year,String semester,int classroom,int majorId){
        MajorDtl majorDtl = new MajorDtl()
                .setSemester(semester)
                .setSemesterYear(year)
                .setClassroomId(classroom)
                .setMajorId(majorId);
        List<MajorDtl> majorDtlList = majorDtlMapper.selectList(
                new QueryWrapper<MajorDtl>()
                        .and(
                                i -> i.eq("semester",majorDtl.getSemester())
                                .eq("semester_year",majorDtl.getSemesterYear())
                                .eq("major_id",majorDtl.getMajorId())
                                .eq("classroom_id",majorDtl.getClassroomId())
                        )
        );
        if (majorDtlList.size() == 0){
            majorDtlMapper.insert(majorDtl);
            return "Success";
        }else {
            return "Fail";
        }
    }

    /**
     * <p>
     *     删除用户
     * </p>
     * @param userId
     * @return
     */
    @ResponseBody
    @DeleteMapping("deleteUser/{userId}")
    public String deleteUser(@PathVariable("userId") int userId){
        logger.info("Delete user = "+userId);
        userMapper.deleteById(userId);
        return "Succeed";
    }



    @RequestMapping("/testAPI")
    public String testAPI() {
        return "testAPI";
    }

    @RequestMapping("/testServlet")
    public String textServlet(){
        return "testServlet";
    }

    @RequestMapping("/testPublicPart")
    public String testPublicPart(){
        return "testPublicPart";
    }

    @RequestMapping("/LogConsole")
    public String logConsole(){
        return "LogConsole";
    }

    @RequestMapping("workOrder")
    public String workOrder(){
        return "workOrder";
    }
}
