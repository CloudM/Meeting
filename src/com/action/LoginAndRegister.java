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
                login(request, response);//ִ��login����
            } else if(method.equals("register1")){
                register1(request, response);//ִ�е�һ����ע�����
            } else if(method.equals("register2")){
            	register2(request, response);//ִ�еڶ�����ע�����
            }else {
            	getPwdBack(request, response);
            }
    	}else {
    		System.out.println("mthodΪ��");
    	}
    }
    
    private void login(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {

    	User u = new User();
    	u.setUEmail(request.getParameter("email"));
    	u.setUpwd(request.getParameter("password"));
		if(service.SdoLogin(u)) {
			if(service.SIsRegister(u)) {
	    		//֪ͨ�û���¼�ɹ�
	    		System.out.println("��¼�ɹ�");
	    		
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
				//֪ͨ�û���¼ʧ�ܣ��û���δ������֤��
	    		System.out.println("��¼ʧ��");
	    		PrintWriter out=response.getWriter();
	    		out.print("<script language='javascript'>alert('��¼ʧ�ܣ�����ע��������������������֤�롣');window.location.href='index.jsp';</script>");
			}
    	} else {
    		//֪ͨ�û���¼ʧ�ܣ��������
    		System.out.println("��¼ʧ��");
    		PrintWriter out=response.getWriter();
    		out.print("<script language='javascript'>alert('��¼ʧ�ܣ��˺Ż������������');window.location.href='index.jsp';</script>");
    	}

    }
    private  void register1(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
    	
    	User u = new User();
    	u.setUEmail(request.getParameter("Email"));
    	u.setUpwd(request.getParameter("Password"));
    	u.setUname(request.getParameter("UserName"));
    	if(service.ShaveRegister(u.getUEmail())) {
    		if(service.SIsRegister(u)) {
    			//�Ѿ�ʹ��������������˺ţ���Ҫ�Խ�����еĲ���
        		System.out.println("�����ѱ�ע��");
        		PrintWriter out = response.getWriter();
        		out.print("<script language='javascript'>alert('�����ѱ�ע��');window.location.href='index.jsp';</script>");
    		} else {
        		//�û���Ϣ�Ѿ���������ϵͳ�е�δע��ɹ�
    			service.SdoDelete(u);
    			Boolean isEmail = true; 
    			int secCode = (int)((Math.random()*9+1)*100000);
    			u.setSecCode(secCode);
    			String letter = "�𾴵��û�,��л��ʹ��CloudM��������֤����  " + secCode + "  ,�鷳������ȷ�ϣ�лл��";
    			try {
    				service.sendEmail("15827635991@163.com", "g3110z14h32", u.getUEmail(), letter);
    				//System.out.println(letter);
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
    				PrintWriter out=response.getWriter();
    	    		out.print("<script language='javascript'>history.go(-1);</script>");
    			}
        		PrintWriter out = response.getWriter();
        		out.print("<script language='javascript'>alert('�������������յ�����֤��');</script>");
    		}
		} else {
			Boolean isEmail = true; 
			int secCode = (int)((Math.random()*9+1)*100000);
			u.setSecCode(secCode);
			String letter = "�𾴵��û�,��л��ʹ��CloudM��������֤����  " + secCode + "  ,�鷳������ȷ�ϣ�лл��";
			try {
				service.sendEmail("15827635991@163.com", "g3110z14h32", u.getUEmail(), letter);
				//System.out.println(letter);
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
    		out.print("<script language='javascript'>alert('���Ȼ����֤�룡');window.location.href='index.jsp';</script>");
    		return;
    	}
    	u.setSecCode(Integer.parseInt(request.getParameter("secCode")));
    	if(service.SIsSecCode(u)) {
    		service.SLogout(u);//�˴�����SLogout()������Ϊ�˽�UserState��Ϊ0������ʾ�˳���
    		service.SSetRegistTime(u);
    		PrintWriter out=response.getWriter();
    		out.print("<script language='javascript'>alert('ע��ɹ���');window.location.href='index.jsp';</script>");
    	} else {
    		//service.SdoDelete(u);
    		PrintWriter out=response.getWriter();
    		out.print("<script language='javascript'>alert('��֤�����');history.go(-1);</script>");
    	}
    }
    
    private  void getPwdBack(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
    	
    }
}