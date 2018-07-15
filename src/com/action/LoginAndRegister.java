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
    	String method = request.getParameter("mthod");
    	if(method != null) {
            if(method.equals("login"))
            {
                login(request, response);//执行login代码
            } else if(method.equals("register1")){
                register1(request, response);//执行第一部分注册代码
            } else if(method.equals("register2")){
            	register2(request, response);//执行第二部分注册代码
            }else {
            	getPwdBack(request, response);
            }
    	}else {
    		System.out.println("mthod为空");
    	}
    }
    
    private void login(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {

    	User u = new User();
    	u.setUEmail(request.getParameter("email"));
    	u.setUpwd(request.getParameter("password"));
		if(service.SdoLogin(u)) {
			if(service.SIsRegister(u)) {
	    		//通知用户登录成功
	    		System.out.println("登录成功");
	    		
	    		User user=service.SgetUserByEmail(request.getParameter("email"));
	    		service.SLogin(user);
	    		
	    		//create a seesion and set the value of parameter
	    		HttpSession session= request.getSession();
	    		session.setAttribute("User", user);
	    		//System.out.println(session.getId());
	    		String sessionid=session.getId();
	    		//create a cookie to save the seesionid of the session for searching it later
	    		Cookie cookie = new Cookie("SessionId",sessionid);
	    		response.addCookie(cookie);
	    		
	    		request.getRequestDispatcher("jsp/center.jsp").forward(request, response);
			} else {
				//通知用户登录失败，用户还未输入验证码
	    		System.out.println("登录失败");
	    		PrintWriter out=response.getWriter();
	    		out.print("<script language='javascript'>alert('登录失败，请在注册界面输入您的邮箱和验证码。');window.location.href='index.jsp';</script>");
			}
    	} else {
    		//通知用户登录失败，密码错误
    		System.out.println("登录失败");
    		PrintWriter out=response.getWriter();
    		out.print("<script language='javascript'>alert('登录失败，账号或密码输入错误。');window.location.href='index.jsp';</script>");
    	}

    }
    private  void register1(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
    	
    	User u = new User();
    	u.setUEmail(request.getParameter("Email"));
    	u.setUpwd(request.getParameter("Password"));
    	u.setUname(request.getParameter("UserName"));
    	if(service.ShaveRegister(u.getUEmail())) {
    		if(service.SIsRegister(u)) {
    			//已经使用这个邮箱申请账号，需要对界面进行的操作
        		System.out.println("邮箱已被注册");
        		PrintWriter out = response.getWriter();
        		out.print("<script language='javascript'>alert('邮箱已被注册');window.location.href='index.jsp';</script>");
    		} else {
        		//用户信息已经被保存在系统中但未注册成功
    			service.SdoDelete(u);
    			Boolean isEmail = true; 
    			int secCode = (int)((Math.random()*9+1)*100000);
    			u.setSecCode(secCode);
    			String letter = "尊敬的用户,感谢您使用CloudM，您的验证码是  " + secCode + "  ,麻烦您尽快确认，谢谢。";
    			try {
    				service.sendEmail("15827635991@163.com", "g3110z14h32", u.getUEmail(), letter);
    				//System.out.println(letter);
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
    				PrintWriter out=response.getWriter();
    	    		out.print("<script language='javascript'>history.go(-1);</script>");
    			}
        		PrintWriter out = response.getWriter();
        		out.print("<script language='javascript'>alert('请输入您最新收到的验证码');</script>");
    		}
		} else {
			Boolean isEmail = true; 
			int secCode = (int)((Math.random()*9+1)*100000);
			u.setSecCode(secCode);
			String letter = "尊敬的用户,感谢您使用CloudM，您的验证码是  " + secCode + "  ,麻烦您尽快确认，谢谢。";
			try {
				service.sendEmail("15827635991@163.com", "g3110z14h32", u.getUEmail(), letter);
				//System.out.println(letter);
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
				PrintWriter out=response.getWriter();
	    		out.print("<script language='javascript'>history.go(-1);</script>");
			}
		}
    }
    
    private void register2(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
    	User u = new User();
    	u.setUEmail(request.getParameter("email"));
    	if(!service.ShaveRegister(u.getUEmail())) {
    		PrintWriter out=response.getWriter();
    		out.print("<script language='javascript'>alert('请先获得验证码！');window.location.href='index.jsp';</script>");
    		return;
    	}
    	u.setSecCode(Integer.parseInt(request.getParameter("secCode")));
    	if(service.SIsSecCode(u)) {
    		service.SLogout(u);//此处调用SLogout()函数是为了将UserState设为0，不表示退出。
    		service.SSetRegistTime(u);
    		PrintWriter out=response.getWriter();
    		out.print("<script language='javascript'>alert('注册成功！');window.location.href='index.jsp';</script>");
    	} else {
    		//service.SdoDelete(u);
    		PrintWriter out=response.getWriter();
    		out.print("<script language='javascript'>alert('验证码错误！');history.go(-1);</script>");
    	}
    }
    
    private  void getPwdBack(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
    	
    }
}