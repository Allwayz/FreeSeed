package com.allwayz.freeseed.JSPController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashBoardController {

    @RequestMapping(value = "/list")
    public ModelAndView list(String table){


        return new ModelAndView("list","message","user");
    }


    @RequestMapping(value = "/main")
    public String main(){
        return "mainPage";
    }

    @RequestMapping(value = "/dashboard")
    public String dashboard(){
        return "dashboard";
    }
}
