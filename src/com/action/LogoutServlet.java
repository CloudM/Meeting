package com.action;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.User;
import com.service.UserService;
import com.service.UserServiceImpl;

public class LogoutServlet extends HttpServlet {
    UserService service = new UserServiceImpl();
     
    public LogoutServlet() {
        super();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);
		if(session==null){
			return;
		}
		User u = (User)request.getSession().getAttribute("User");
		service.SLogout(u);
		session.removeAttribute("user");
		request.getSession().invalidate();
		//重定向到index.jsp
		response.sendRedirect("index.jsp");
    }
}