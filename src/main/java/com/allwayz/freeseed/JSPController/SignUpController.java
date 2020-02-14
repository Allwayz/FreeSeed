package com.allwayz.freeseed.JSPController;

import com.allwayz.freeseed.util.AuthorizationCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/*")
public class SignUpController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getPathInfo());
        req.setAttribute("logn","SSSSSSSSSSSSSSS");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String emailAddress = request.getParameter("email");
        response.setCharacterEncoding("UTF-8");

        String code = AuthorizationCodeUtil.randomCode();
        System.out.println("CODE: " + code);
        request.getSession().setAttribute("Code",code);
        response.getWriter().write("true");
        response.flushBuffer();
    }
}
