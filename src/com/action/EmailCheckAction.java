//Dylan,2018.7.12,first build
package com.action;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.service.UserService;
import com.service.UserServiceImpl;


public class EmailCheckAction extends HttpServlet{
		
	    @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException
	    {
	        this.doPost(req, resp);
	    }
	     
	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException
	    {
	        String email =req.getParameter("email");
	        
	        UserService service =new UserServiceImpl();
	        ResultSet rs = service.S_EmailCheck(email);
	        try {
	        	  resp.getWriter().print(rs.next()==false?"ok":"error"); 
				}catch (Exception e) {
				System.out.println("邮箱检验失败");
			}
	          
	    }
}
