package com.allwayz.freeseed.JSPController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashBoardController {

    @RequestMapping(value = "/list")
    public String list(){
        return "list";
    }

    @RequestMapping(value = "/test")
    public String test(){
        return "PublicSnippets/border";
    }

    @RequestMapping(value = "/main")
    public String main(){
        return "mainPage";
    }

}
