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
		//1.获取能够与“url-pattern”中匹配的路径
		String method = request.getServletPath();
		//(此时处理的请求是查询 query.do)
		System.out.println("request.getServletPath()获取的值为: " + method);//输出 /query.do
		//2.通过字符串截取，把方法名 query 截取出来
		method = method.substring(1, method.length()-19);
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
	    	    System.out.println("没有相关会议");
	    	    //response.getWriter().println("none"); 
	    	    }
	        
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		doPost(request, response);
	}
}
