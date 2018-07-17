//Karenzhu
package com.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Apply;
import com.entity.User;
import com.function.Cookies;
import com.function.SessionContext;
import com.service.ApplyService;
import com.service.ApplyServiceImpl;


public class ShowApply extends HttpServlet{
	ApplyService service=new ApplyServiceImpl();
	public ShowApply(){
		super();
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		 response.setContentType("text/html;charset=UTF-8");
		 
		 Apply apply=new Apply();
		 User user = (User)request.getSession().getAttribute("User");
		 int uid=user.getUid();
		//1.��ȡ�ܹ��롰url-pattern����ƥ���·��
			String method = request.getServletPath();
			//(��ʱ����������ǲ�ѯ query.do)
			System.out.println("request.getServletPath()��ȡ��ֵΪ: " + method);//��� /query.do
			//2.ͨ���ַ�����ȡ���ѷ����� query ��ȡ����
			method=method.substring(5, method.length()-15);
			System.out.println("��ȡ���ֵΪ: "+ method);
			int mid =Integer.parseInt(method);
			System.out.println("��ȡ���ֵΪ: "+ mid);
          request.getSession().setAttribute("Meetingid", mid);
		 //get all cookies and their values to find the cookie I need here through the cookie key
		/* Cookie[] cookies=request.getCookies();
		 
		  //find the session through sessionid which is saved in cookie
		 Cookies c=new Cookies();
		 String sessionid= c.findCookie("SessionId",cookies);
		 SessionContext myc= SessionContext.getInstance();  
		 HttpSession sess = myc.getSession(sessionid);  
		 User user1=(User) sess.getAttribute("User"); */
		 System.out.println("showapply");
		 //check whether the user has applyed the meeting
		 if(service.SIsApply(uid,mid)!=null) {
			 /*String applyid=apply.getApplyFormID()+"";
			 Cookie cookie = new Cookie("ApplyId",applyid);
	    	 response.addCookie(cookie);*/
	    	 String s="ȡ������";
	    	 System.out.println("isapply is not null");
	    	 request.setAttribute("buttonname", s);
			 request.getRequestDispatcher("content.jsp").forward(request, response);
		 }
		 else {
			/* String meetingid=apply.getMeetingID()+"";
			 Cookie cookie = new Cookie("ApplyId",meetingid);
	    	 response.addCookie(cookie);
	    	 response.addCookie(cookie);*/
	    	 System.out.println("isapply is null");
	    	 String s="����μ�";
	    	 request.setAttribute("buttonname", s);
			 request.getRequestDispatcher("content.jsp").forward(request, response);
		 }
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		doPost(request, response);
	}
}
