//karen
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

import net.sf.json.JSONArray;

@WebServlet("/ShowMeetingInfo")
public class ShowMeetingInfo extends HttpServlet {
	
    public ShowMeetingInfo() { 
    	super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		User user = (User)request.getSession().getAttribute("User");
		int uid=user.getUid();
		//1.获取能够与“url-pattern”中匹配的路径
		String method = request.getServletPath();
		//(此时处理的请求是查询 query.do)
		System.out.println("request.getServletPath()获取的值为: " + method);//输出 /query.do
		//2.通过字符串截取，把方法名 query 截取出来
		method = method.substring(method.length()-6,method.length());
		System.out.println("截取后的值为: "+ method);
		
/*		Cookie[] cookies=request.getCookies();
		Cookies c=new Cookies();
	    String sessionid= c.findCookie("SessionId",cookies);
	    System.out.println("sessionid="+sessionid);
	    SessionContext myc= SessionContext.getInstance();
	    HttpSession sess = myc.getSession(sessionid);
	    if(sess ==null) {
	    	System.out.println("sess is null");
	    }
	    else {
	    	System.out.println("sess is not null");
	    }
	    User u=(User) sess.getAttribute("User");
	    System.out.println("userid="+u.getUid());*/
	    
	    
	    int status1=0;
	    int status2=0;
	    MeetingService service=new MeetingServiceImpl();
	    JSONArray Mlist = new JSONArray();
	    //search all meetings
	    if(method.equals("all.do")){
	    	if(service.SallMeetings()!=null) {
	    		Mlist=service.SallMeetings();
	    	    System.out.println("Mlist.size:"+Mlist.size());
	    	    response.getWriter().println(Mlist);
	    	}
	    	else {
	    		request.getRequestDispatcher("jsp/center.jsp").forward(request, response);
		    	System.out.println("没有相关会议");
		    	response.getWriter().println("none"); 
	    	}
	    }
	    
	    //see which status is transfered from js
	    else {
	    	if(method.equals("ted.do")) {
	    		status1=1;
	    		}
	        else if(method.equals("sed.do")) {
	    	    status1=2;
	    	    status2=3;
		        }
	        else if(method.equals("jsp/ended")) {
	    	    status1=4;
	            }
	    	System.out.println("status="+status1+status2);
	    //System.out.println("userid+"+user.getUid());
	    //search meetings with status
	        if(service.ShasReleasedMeeting(uid,status1,status2)!=null) {
	    	    Mlist=service.ShasReleasedMeeting(uid,status1,status2);
	    	
	    	    System.out.println("Mlist.size:"+Mlist.size());
	    	    response.getWriter().println(Mlist); 
	    	//request.getRequestDispatcher("jsp/center.jsp").forward(request, response);
	            }
	        else {
	    	    request.getRequestDispatcher("jsp/center.jsp").forward(request, response);
	    	    System.out.println("没有相关会议");
	    	    response.getWriter().println("none"); 
	    	    }
	        }
	   
	   // myc.getSession(sessionid).setAttribute("Mlist", list);
	    //myc.getSession(sessionid).setAttribute("count", list.size());
		//request.getRequestDispatcher("jsp/center.jsp").forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		doPost(request, response);
	}

}
