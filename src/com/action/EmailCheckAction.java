//Dylan,2018.7.12,first build
package com.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.User;
import com.service.UserService;
import com.service.UserServiceImpl;


public class EmailCheckAction extends HttpServlet{
    UserService service =new UserServiceImpl();
    
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        String email =req.getParameter("email");
        User u = new User();
        u.setUEmail(email);
        if(service.ShaveRegister(email)) {
        	if(service.SIsRegister(u))
        		resp.getWriter().print("error");
        	else
            	resp.getWriter().print("secCode");
        }
        else {
        	resp.getWriter().print("ok");
        }
    }
}