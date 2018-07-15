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
		
		//1.获取能够与“url-pattern”中匹配的路径
		String method = request.getServletPath();
		//(此时处理的请求是查询 query.do)
		System.out.println("request.getServletPath()获取的值为: " + method);//输出 /query.do
		//2.通过字符串截取，把方法名 query 截取出来
		method = method.substring(1, method.length()-3);
		System.out.println("截取后的值为： "+ method);
		
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
	    	System.out.println("没有相关会议");
	    	PrintWriter out=response.getWriter();
			out.print("<script language='javascript'>alert('没有相关会议');window.location.href='jsp/center.jsp';</script>");
			
	    }
		
	   
	    myc.getSession(sessionid).setAttribute("Mlist", list);
	    myc.getSession(sessionid).setAttribute("count", list.size());
		//request.getRequestDispatcher("jsp/center.jsp").forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		doPost(request, response);
	}

}
