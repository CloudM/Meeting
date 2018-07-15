package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.entity.Meeting;
import com.entity.User;
import com.function.Cookies;
import com.function.SessionContext;
import com.service.MeetingService;
import com.service.MeetingServiceImpl;

@WebServlet("/ShowMeetingInfo")
public class ShowMeetingInfo extends HttpServlet {
	MeetingService ms = new MeetingServiceImpl();
       
    public ShowMeetingInfo() { 
    	super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		//User user = (User)request.getAttribute("User");
		
		//1.��ȡ�ܹ��롰url-pattern����ƥ���·��
		String method = request.getServletPath();
		//(��ʱ����������ǲ�ѯ query.do)
		System.out.println("request.getServletPath()��ȡ��ֵΪ: " + method);//��� /query.do
		//2.ͨ���ַ�����ȡ���ѷ����� query ��ȡ����
		method = method.substring(1, method.length()-3);
		System.out.println("��ȡ���ֵΪ�� "+ method);
		
		Cookie[] cookies=request.getCookies();
		Cookies c=new Cookies();
	    String sessionid= c.findCookie("SessionId",cookies);
	    SessionContext myc= SessionContext.getInstance();  
	    HttpSession sess = myc.getSession(sessionid);  
	    User u=(User) sess.getAttribute("User");
	    System.out.println(u.getUid());
	    
	    int status=0;
	    MeetingService service=new MeetingServiceImpl();
	    List<Meeting> list= new ArrayList();
	    if(method.equals("released")) {
			 status=1;
			 }
	    else if(method.equals(" released")) {
	    	status=2;
		 }
	    if(service.ShasReleasedMeeting(u.getUid(),status)!=null) {
	    	list=service.ShasReleasedMeeting(u.getUid(),1);
	    	System.out.println(list.size());
	    	request.getRequestDispatcher("jsp/center.jsp").forward(request, response);
	    }
	    else {
	    	request.getRequestDispatcher("jsp/center.jsp").forward(request, response);
	    	System.out.println("û����ػ���");
	    	PrintWriter out=response.getWriter();
			out.print("<script language='javascript'>alert('û����ػ���');window.location.href='jsp/center.jsp';</script>");
			
	    }
		
	   
	    myc.getSession(sessionid).setAttribute("Mlist", list);
	    myc.getSession(sessionid).setAttribute("count", list.size());
		//request.getRequestDispatcher("jsp/center.jsp").forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		doPost(request, response);
	}

}
