package com.allwayz.freeseed.JSPController;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 页面错误跳转
 *
 * @author allwayz
 * @create 2020-02-23 04:23
 */
@Controller
public class MyErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request){
        //获取statusCode:401,404,500
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if(statusCode == 401){
            return "/ErrorPage/401";
        }else if(statusCode == 404){
            return "/ErrorPage/404";
        }else if(statusCode == 403){
            return "/ErrorPage/403";
        }else{
            return "/ErrorPage/500";
        }
    }

//    @RequestMapping
//    @ResponseBody //JSON
//    public ModelAndView returnErrorMessage(HttpServletRequest request,Exception e){
//        ModelAndView modelAndView = new ModelAndView("/ErrorPage/404");
//        modelAndView.addObject("exception",e);
//        modelAndView.addObject("url",request.getRequestURL());
//        return modelAndView;
//    }



    @Override
    public String getErrorPath() {
        return "/error";
    }
}
