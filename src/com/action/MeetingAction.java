//Karenzhu
package com.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

//import org.apache.tomcat.util.http.parser.Cookie;

import com.entity.Meeting;
import com.entity.User;
import com.service.MeetingService;
import com.service.MeetingServiceImpl;

public class MeetingAction extends HttpServlet {
	
	MeetingService service=new MeetingServiceImpl();
	public MeetingAction(){
		super();
	}
	
	//new a meeting outside the functions
	Meeting m=new Meeting();
 public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
	 response.setContentType("text/html;charset=UTF-8");
	 User user = (User)request.getAttribute("User");
	 
	 //get all cookies and their values to find the cookie I need here through the cookie key
	 /*Cookie[] cookies=request.getCookies();
	 String sessionid=null,meetingid=null;
	  if(cookies!=null){
	       for(int i=0;i<cookies.length;i++) {
	              if(cookies[i].getName().equals("SessionId")){
	                	 sessionid=cookies[i].getValue();
	                 }
	              //if(cookies[i].getName().equals("meetingid")){
	                  // sessionid=cookies[i].getValue();
	              // }
	             }   
	         }*/
	      //HttpSession session=request.getSession(false);   
	      //HttpSession sess = session.getSessionContext().getSession(sid); 
	 m.setMname(request.getParameter("name"));
	 m.setMeetingStatus(1);
	 m.setUserid(user.getUid());
	 m.setHost(request.getParameter("host"));
	 m.setDescribe(request.getParameter("introduction"));
	 m.setGuest(request.getParameter("guest"));
	 m.setPlace(request.getParameter("place"));
	 m.setRemarks(request.getParameter("remark"));
	 m.setStartTime(request.getParameter("time"));
	 if(request.getParameter("type").equals("yantaohui")) {
		 m.setTypeid(1);
		 
	 }
	 
    else if(request.getParameter("type").equals("luntan")) {
	     m.setTypeid(2);
	 }
    else if(request.getParameter("type").equals("zuotanhui")) {
	     m.setTypeid(3);
     }
    else if(request.getParameter("type").equals("taolunhui")) {
	     m.setTypeid(4);
     }
    else if(request.getParameter("type").equals("jiangzuo")) { 
         m.setTypeid(5);
    }
    else if(request.getParameter("type").equals("bianlunhui")) {
	     m.setTypeid(6);
    }
    else if(request.getParameter("type").equals("else")) {
	     m.setTypeid(7);
    }
	 String create = request.getParameter("create");
	 String release = request.getParameter("release");
 	if(create!=null) {
 		CreateMeeting(request,response);
 	}
 	else if(release!=null) {
 	ReleaseMeeting(request,response);
 	}
 
}
 
 public void CreateMeeting(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	
	//if(service.SFindMeeting(m) != null) {
		// if(service.SUpdateMeeting(m)==true) {
		//	 System.out.println("修改会议成功");
	    //		PrintWriter out=response.getWriter();
	    //		out.print("<script language='javascript'>alert('修改会议成功');window.location.href='center.jsp';</script>");
		//	}
		// else {
		//	System.out.println("修改会议失败，请检查所填信息");
		//	}
	// }
	//else {
	 try {
		 //service.SAddMeeting(m);
	    if(service.SAddMeeting(m)==true){
		  System.out.println("创建会议成功");
		  PrintWriter out=response.getWriter();
			out.print("<script language='javascript'>alert('创建会议成功');window.location.href='createandrelease.jsp';</script>");
		
		   request.getRequestDispatcher("jsp/center.jsp").forward(request, response);
		
	    }
	   
	 }
	 catch(Exception e){
		 System.out.println("创建会议失败，请检查所填信息");
			PrintWriter out=response.getWriter();
			out.print("<script language='javascript'>alert('创建会议失败，请检查所填信息');window.location.href='createandrelease.jsp';</script>");
		
	 }
	// } 
 }
 public void ReleaseMeeting(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
	 //Meeting m=(Meeting) request.getAttribute("meetingname");
	 //if(service.SFindMeeting(m)==null) 
		// CreateMeeting(request, response);
	 m.setMid(3);
	 
	 if(service.SReleaseMeeting(m)) {
		 String str_text="会议发布成功！";
 		 String str_title="已发布";
 		 JOptionPane.showMessageDialog(null, str_text, str_title, JOptionPane.PLAIN_MESSAGE);
 		request.getRequestDispatcher("jsp/center.jsp").forward(request, response);
	 }else {
		 System.out.println("会议发布异常！");
	 }

 }
}
