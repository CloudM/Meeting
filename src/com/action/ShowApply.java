//Karenzhu
package com.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Apply;
import com.entity.User;
import com.function.Cookies;
import com.function.SessionContext;
import com.service.ApplyService;
import com.service.ApplyServiceImpl;


public class ShowApply {
	ApplyService service=new ApplyServiceImpl();
	public ShowApply(){
		super();
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		 response.setContentType("text/html;charset=UTF-8");
		 
		 Apply apply=new Apply();
		 User user = (User)request.getAttribute("User");
		 
		 //get all cookies and their values to find the cookie I need here through the cookie key
		 Cookie[] cookies=request.getCookies();
		 
		  //find the session through sessionid which is saved in cookie
		 Cookies c=new Cookies();
		 String sessionid= c.findCookie("SessionId",cookies);
		 SessionContext myc= SessionContext.getInstance();  
		 HttpSession sess = myc.getSession(sessionid);  
		 User user1=(User) sess.getAttribute("User"); 
		 
		 //check whether the user has applyed the meeting
		 if(service.SIsApply(apply)!=null) {
			 String applyid=apply.getApplyFormID()+"";
			 Cookie cookie = new Cookie("ApplyId",applyid);
	    	 response.addCookie(cookie);
	    	 String s="取消申请";
	    	 request.setAttribute("buttonname", s);
			 request.getRequestDispatcher("jsp/content.jsp").forward(request, response);
		 }
		 else {
			 String meetingid=apply.getMeetingID()+"";
			 Cookie cookie = new Cookie("ApplyId",meetingid);
	    	 response.addCookie(cookie);
	    	 response.addCookie(cookie);
	    	 String s="申请参加";
	    	 request.setAttribute("buttonname", s);
			 request.getRequestDispatcher("jsp/content.jsp").forward(request, response);
		 }
	}
}
