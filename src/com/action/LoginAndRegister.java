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
            login(request, response);//ִ��login����
        } else if(method.equals("register")){
            register(request, response);//ִ��ע�����
        } else {
        	getPwdBack(request, response);
        }
    }
    
    private void login(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {

    	User u = new User();
    	u.setUEmail(request.getParameter("email"));
    	u.setUpwd(request.getParameter("password"));
		if(service.SdoLogin(u)) {
    		//֪ͨ�û���¼�ɹ�
    		System.out.println("��¼�ɹ�");
    		
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
    		//User user = (User)request.getAttribute("User");***������.java�ļ����ñ��д����ȡ�����user������Ϣ��
    		request.getRequestDispatcher("jsp/center.jsp").forward(request, response);
    	} else {
    		//֪ͨ�û���¼ʧ��
    		System.out.println("��¼ʧ��");
    		PrintWriter out=response.getWriter();
    		out.print("<script language='javascript'>alert('��¼ʧ�ܣ��˺Ż������������');window.location.href='index.jsp';</script>");
    	}

    }
    private  void register(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
    	
    	User u = new User();
    	u.setUEmail(request.getParameter("email"));
    	u.setUpwd(request.getParameter("password"));
    	u.setUname(request.getParameter("userName"));
    	
    	if(service.ShaveRegister(u.getUEmail())) {
			//�Ѿ�ʹ��������������˺ţ���Ҫ�Խ�����еĲ���
    		System.out.println("�����ѱ�ע��");
    		PrintWriter out=response.getWriter();
    		out.print("<script language='javascript'>alert('�����ѱ�ע��');window.location.href='index.jsp';</script>");
			//response.sendRedirect("login.jsp");
		} else {
			Boolean isEmail = true; 
			int secCode = (int)((Math.random()*9+1)*100000);
			u.setSecCode(secCode);
			String letter = "�𾴵��û�,��л��ʹ��CloudM��������֤����  " + secCode + "  ,�鷳������ȷ�ϣ�лл��";
			try {
				service.sendEmail("15827635991@163.com", "g3110z14h32", u.getUEmail(), letter);
				System.out.println(letter);
			} catch (Exception e) {
				isEmail = false;
				//��ʾ�û�������Ϣ����
	    		System.out.println("������Ϣ����");
	    		PrintWriter out=response.getWriter();
	    		out.print("<script language='javascript'>alert('������Ϣ����');window.location.href='index.jsp';</script>");
			}
			//���ݲ���
			if(isEmail) {
				service.SdoRegister(u);
				response.sendRedirect("index.jsp");
			}
			//��������
		}
    }
    
    private  void getPwdBack(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
    	
    }
}