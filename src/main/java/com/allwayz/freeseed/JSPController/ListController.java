package com.allwayz.freeseed.JSPController;

import com.allwayz.freeseed.model.entity.Enrollment;
import com.allwayz.freeseed.model.entity.Major;
import com.allwayz.freeseed.model.entity.Role;
import com.allwayz.freeseed.model.entity.User;
import com.allwayz.freeseed.model.mapper.EnrollmentMapper;
import com.allwayz.freeseed.model.mapper.MajorMapper;
import com.allwayz.freeseed.model.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

    /**
     *
     * @return
     */
    //@GetMapping(value = "/list?table=user")
    public String userList(@RequestParam(value = "table") String table, Model model){
        model.addAttribute("table",table);

        return "list";
    }

    @RequestMapping("/listPage")
    public ModelAndView showUser(String table){
        //String message = "table";
        ModelAndView modelAndView = new ModelAndView();
        List list;
        switch (table){
            case "user":
                list = userMapper.selectList(new QueryWrapper<User>());
                break;
            case "major":
                list = majorMapper.selectList(new QueryWrapper<Major>());
                break;
            case "enrollment":
                list = enrollmentMapper.selectList(new QueryWrapper<Enrollment>());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + table);
        }

        return new ModelAndView("list","message",table).addObject("tableMap",list);
    }

}
