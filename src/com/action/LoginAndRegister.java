package com.action;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.User;
import com.service.UserService;
import com.service.UserServiceImpl;

@WebServlet("/HelloForm")
public class LoginAndRegister extends HttpServlet {
    UserService service = new UserServiceImpl();
    
    public LoginAndRegister() {
        super();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    	String method = request.getParameter("method");
        if(method.equals("login"))
        {
            login(request, response);//执行login代码
        } else if(method.equals("register")){
            register(request, response);//执行注册代码
        } else {
        	getPwdBack(request, response);
        }
    }
    
    private void login(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {

    	User u = new User();
    	u.setUEmail(request.getParameter("email"));
    	u.setUpwd(request.getParameter("password"));
		if(service.SdoLogin(u)) {
    		//通知用户登录成功
    		System.out.println("登录成功");
    		
    		/*
    		//create a seesion and set the value of parameter
    		HttpSession session= request.getSession();
    		session.setAttribute("User", u);
    		System.out.println(session.getId());
    		String sessionid=session.getId();
    		//create a cookie to save the seesionid of the session for searching it later
    		Cookie cookie = new Cookie("SessionId",sessionid);
    		response.addCookie(cookie);
    		//if cookie is banned,then use redirectUrl
    		String url="/com.action/LoginAndRegister";
    		String newUrl=response.encodeRedirectUrl(url);
    		System.out.println(newUrl);*/
    		
    		
    		request.setAttribute("User", u);
    		//User user = (User)request.getAttribute("User");***在其它.java文件中用本行代码获取存入的user对象信息。
    		request.getRequestDispatcher("jsp/center.jsp").forward(request, response);
    	} else {
    		//通知用户登录失败
    		System.out.println("登录失败");
    		PrintWriter out=response.getWriter();
    		out.print("<script language='javascript'>alert('登录失败，账号或密码输入错误。');window.location.href='index.jsp';</script>");
    	}

    }
    private  void register(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
    	
    	User u = new User();
    	u.setUEmail(request.getParameter("email"));
    	u.setUpwd(request.getParameter("password"));
    	u.setUname(request.getParameter("userName"));
    	
    	if(service.ShaveRegister(u.getUEmail())) {
			//已经使用这个邮箱申请账号，需要对界面进行的操作
    		System.out.println("邮箱已被注册");
    		PrintWriter out=response.getWriter();
    		out.print("<script language='javascript'>alert('邮箱已被注册');window.location.href='index.jsp';</script>");
			//response.sendRedirect("login.jsp");
		} else {
			Boolean isEmail = true; 
			int secCode = (int)((Math.random()*9+1)*100000);
			u.setSecCode(secCode);
			String letter = "尊敬的用户,感谢您使用CloudM，您的验证码是  " + secCode + "  ,麻烦您尽快确认，谢谢。";
			try {
				service.sendEmail("15827635991@163.com", "g3110z14h32", u.getUEmail(), letter);
				System.out.println(letter);
			} catch (Exception e) {
				isEmail = false;
				//提示用户邮箱信息有误
	    		System.out.println("邮箱信息错误");
	    		PrintWriter out=response.getWriter();
	    		out.print("<script language='javascript'>alert('邮箱信息错误');window.location.href='index.jsp';</script>");
			}
			//数据插入
			if(isEmail) {
				service.SdoRegister(u);
				response.sendRedirect("index.jsp");
			}
			//其它操作
		}
    }
    
    private  void getPwdBack(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
    	
    }
}