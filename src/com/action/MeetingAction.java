//Karenzhu
package com.action;

import java.io.IOException;
import java.io.PrintWriter;

import com.function.Cookies;
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
import com.function.SessionContext;
import com.service.MeetingService;
import com.service.MeetingServiceImpl;

public class MeetingAction extends HttpServlet {
	
	MeetingService service=new MeetingServiceImpl();
	public MeetingAction(){
		super();
	}
	
	//new a meeting outside the functions
	Meeting m=new Meeting();
	Meeting meeting=new Meeting();
	
 public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
	 User user = (User)request.getSession().getAttribute("User");
	 
	 meeting=null;
	System.out.println("userid:"+user.getUid());
	 if(request.getSession().getAttribute("Meeting")!=null) {
	 meeting=(Meeting)request.getSession().getAttribute("Meeting");
	 
	 request.getSession().setAttribute("Meeting", null);
	 System.out.println("meetingid:"+meeting.getMid());
	 }
	 //get all cookies and their values to find the cookie I need here through the cookie key
	 //Cookie[] cookies=request.getCookies();
	
	 
	 
	 /* String sessionid=null,meetingid=null;
	  if(cookies!=null){
	       for(int i=0;i<cookies.length;i++) {
	              if(cookies[i].getName().equals("SessionId")){
	                	 sessionid=cookies[i].getValue();
	                 }
	              //if(cookies[i].getName().equals("meetingid")){
	                  // sessionid=cookies[i].getValue();
	              // }
	             }   
	         }
	  //get the session with the user entity who has login
	      HttpSession session=request.getSession(false);   
	      HttpSession sess = session.getSessionContext().getSession(sessionid); 
	      User user1=(User) session.getAttribute("User");*/
	    
	 
	    //find the session through sessionid which is saved in cookie
	    /*Cookies c=new Cookies();
	    String sessionid= c.findCookie("SessionId",cookies);
	    SessionContext myc= SessionContext.getInstance();  
	    HttpSession sess = myc.getSession(sessionid);  
	    User user1=(User) sess.getAttribute("User"); */ 
	  
	    //assignment of meeting entity
	 m.setMname(request.getParameter("name"));
	 //m.setMeetingStatus(1);
	 //get the userid from the user entity
	 m.setUserid(user.getUid());
	 //System.out.println("userid:"+user.getUid());
	 m.setHost(request.getParameter("host"));
	 m.setDescribe(request.getParameter("introduction"));
	 m.setGuest(request.getParameter("guest"));
	 m.setPlace(request.getParameter("place"));
	 m.setRemarks(request.getParameter("remarks"));
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
	 
	 //judge which button the user click and turn to the right function
	 String create = request.getParameter("create");
	 String release = request.getParameter("release");
	 String delete=request.getParameter("delete");
 	if(create!=null) {
 		CreateMeeting(request,response);
 	}
 	else if(release!=null) {
 	    ReleaseMeeting(request,response);
 	}
 	else if(delete!=null) {
 		DeleteMeeting(request,response);
 	}
 
}
 


public void CreateMeeting(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	
	if(meeting!=null) {
		if(service.SUpdateMeeting(m,meeting.getMid())==true) {
			 System.out.println("修改会议成功");
	    		PrintWriter out=response.getWriter();
	    		
	    		//request.getRequestDispatcher("history.back()").forward(request, response);
	    		out.print("<script language='javascript'>alert('修改会议成功');window.location.href='jsp/center-org-script.jsp';</script>");
			}
		 else {
			System.out.println("修改会议失败，请检查所填信息");
			}
   }
	else {
	 try {
		 //service.SAddMeeting(m);
		 //add meeting
		 m.setMeetingStatus(1);
	    if(service.SAddMeeting(m)==true){
		  System.out.println("创建会议成功");
		  PrintWriter out=response.getWriter();
		  out.print("<script language='javascript'>alert('创建会议成功');window.location.href='jsp/center-org-script.jsp';</script>");
			
		  // request.getRequestDispatcher("jsp/center-org-script.jsp").forward(request, response);
		
	    }
	   
	 }
	 catch(Exception e){
		 System.out.println("创建会议失败，请检查所填信息");
			PrintWriter out=response.getWriter();
			out.print("<script language='javascript'>alert('创建会议失败，请检查所填信息');window.location.href='createandrelease.jsp';</script>");
		
	 }
	 } 
 }
 public void ReleaseMeeting(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
	 //Meeting m=(Meeting) request.getAttribute("meetingname");
	 //if(service.SFindMeeting(m)==null) 
		// CreateMeeting(request, response);
	// m.setMid(3);
	 
	 /*if(service.SReleaseMeeting(meeting.getMid())) {
		 String str_text="会议发布成功！";
 		 String str_title="已发布";
 		 JOptionPane.showMessageDialog(null, str_text, str_title, JOptionPane.PLAIN_MESSAGE);
 		request.getRequestDispatcher("jsp/center.jsp").forward(request, response);
	 }else {
		 System.out.println("会议发布异常！");
	 }
*/
	 if(meeting!=null) {
		 if(service.SUpdateMeeting(m,meeting.getMid())==true) {
			 if(service.SReleaseMeeting(meeting.getMid())==true) {
				 System.out.println("发布会议成功");
				 PrintWriter out=response.getWriter();
				 out.print("<script language='javascript'>alert('发布会议成功');window.location.href='jsp/center-org-script.jsp';</script>");
				 
		 }
			 else {
				 System.out.println("发布会议失败");
				 PrintWriter out=response.getWriter();
				 out.print("<script language='javascript'>alert('发布会议失败，请检查会议信息填写是否正确');window.location.href='createandrelease.jsp';</script>");
				 
			 }
			 }
		 else {
			 System.out.println("发布会议失败");
			 PrintWriter out=response.getWriter();
			 out.print("<script language='javascript'>alert('发布会议失败，请检查会议信息填写是否正确');window.location.href='jsp/createandrelease.jsp';</script>");
			 
		 }
	 }
	 else {
		 m.setMeetingStatus(2);
		 if(service.SAddMeeting(m)==true) {
			 System.out.println("发布会议成功");
			 PrintWriter out=response.getWriter();
			 out.print("<script language='javascript'>alert('发布会议成功');window.location.href='jsp/center-org-script.jsp';</script>");
			 
		 }
		 else {
			 System.out.println("发布会议失败");
			 PrintWriter out=response.getWriter();
			 out.print("<script language='javascript'>alert('发布会议失败，请检查会议信息填写是否正确');window.location.href='jsp/createandrelease.jsp';</script>");
			 
		 }
	 }
 }
 public void DeleteMeeting(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
	 if(meeting!=null) {
		 if(service.SDeleteMeeting(meeting)) {
			 System.out.println("删除会议成功");
			 PrintWriter out=response.getWriter();
			 out.print("<script language='javascript'>alert('删除会议成功');window.location.href='jsp/center-org-script.jsp';</script>");
			 
		 }
		 else{
			 System.out.println("发删除会议失败");
			 PrintWriter out=response.getWriter();
			 out.print("<script language='javascript'>alert('删除会议失败，请检查会议信息填写是否正确');window.location.href='jsp/createandrelease.jsp';</script>");
			 
		 }
	 }
 }
}
