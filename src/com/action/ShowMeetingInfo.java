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
		User user = (User)request.getAttribute("User");
		 
		Cookie[] cookies=request.getCookies();
		Cookies c=new Cookies();
	    String sessionid= c.findCookie("SessionId",cookies);
	    SessionContext myc= SessionContext.getInstance();  
	    HttpSession sess = myc.getSession(sessionid);  
	    User u=(User) sess.getAttribute("User");
	    
	    int status=0;
	    MeetingService service=new MeetingServiceImpl();
	    List<Meeting> list= new ArrayList();
	    if(request.getParameter("type").equals("yantaohui")) {
			 status=1;
			 }
	    else if(request.getParameter("type").equals("luntan")) {
	    	status=2;
		 }
	    if(service.ShasReleasedMeeting(u.getUid(),status)!=null) {
	    	list=service.ShasReleasedMeeting(u.getUid(),status);
	    	request.getRequestDispatcher("jsp/center.jsp").forward(request, response);
	    }
	    else {
	    	request.getRequestDispatcher("jsp/center.jsp").forward(request, response);
	    	System.out.println("没有相关会议");
	    	PrintWriter out=response.getWriter();
			out.print("<script language='javascript'>alert('没有相关会议');window.location.href='jsp/center.jsp';</script>");
			
	    }
		
		sess.setAttribute("Mlist", list);
		sess.setAttribute("count", list.size());
		response.sendRedirect("/html/center.jsp");
	}

	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		doGet(request, response);
	}*/

}
