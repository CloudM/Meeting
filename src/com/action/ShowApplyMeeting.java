//Karenzhu
package com.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.User;
import com.service.MeetingService;
import com.service.MeetingServiceImpl;

import net.sf.json.JSONArray;

public class ShowApplyMeeting extends HttpServlet{
	MeetingService ms = new MeetingServiceImpl();
    
    public ShowApplyMeeting() { 
    	super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		User user = (User)request.getSession().getAttribute("User");
		int uid=user.getUid();
		//1.��ȡ�ܹ��롰url-pattern����ƥ���·��
		String method = request.getServletPath();
		//(��ʱ����������ǲ�ѯ query.do)
		System.out.println("request.getServletPath()��ȡ��ֵΪ: " + method);//��� /query.do
		//2.ͨ���ַ�����ȡ���ѷ����� query ��ȡ����
		method = method.substring(1, method.length()-19);
		System.out.println("��ȡ���ֵΪ: "+ method);
		
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
	    
	    
	    int applystatus=0;
	    int ispresent=0;
	   
	    MeetingService service=new MeetingServiceImpl();
	    JSONArray Mlist = new JSONArray();
	
	    	if(method.equals("jsp/wait")) {
	    		applystatus=1;
	    		
	    		}
	        else if(method.equals("jsp/have")) {
	        	applystatus=2;
	        	ispresent=1;
	    	   
		        }
	        else if(method.equals("jsp/to")) {
	        	applystatus=2;
	        	
	    		
	            }
	    	System.out.println("status="+applystatus+ispresent);
	    //System.out.println("userid+"+user.getUid());
	    //search meetings with status
	        if(service.SapplyedMeeting(uid,applystatus,ispresent).size()!=0) {
	    	    Mlist=service.SapplyedMeeting(uid,applystatus,ispresent);
	    	
	    	    System.out.println("Mlist.size:"+Mlist.size());
	    	    response.getWriter().println(Mlist); 
	    	//request.getRequestDispatcher("jsp/center.jsp").forward(request, response);
	            }
	        else {
	    	    request.getRequestDispatcher("jsp/center.jsp").forward(request, response);
	    	    System.out.println("û����ػ���");
	    	    //response.getWriter().println("none"); 
	    	    }
	        
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		doPost(request, response);
	}
}
