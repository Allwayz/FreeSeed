package com.allwayz.freeseed;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/dashboard")
    public String dashboard(){

        return "dashboard";
    }

    @RequestMapping("/list")
    public String list(){
        return "list";
    }

    @RequestMapping("/free")
    public String testFreemarker(ModelMap modelMap){
        modelMap.addAttribute("msg","Hello World!");
        return "/FreeMarkerTemplates/freemarker";
    }

}
