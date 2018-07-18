package com.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Meeting;
import com.service.MeetingService;
import com.service.MeetingServiceImpl;

public class FindMeeting {
	MeetingService service=new MeetingServiceImpl();
	public FindMeeting(){
		super();
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		//1.��ȡ�ܹ��롰url-pattern����ƥ���·��
				String method = request.getServletPath();
				//(��ʱ����������ǲ�ѯ query.do)
				System.out.println("request.getServletPath()��ȡ��ֵΪ: " + method);//��� /query.do
				//2.ͨ���ַ�����ȡ���ѷ����� query ��ȡ����
				method=method.substring(5, method.length()-14);
				System.out.println("��ȡ���ֵΪ: "+ method);
				int mid =Integer.parseInt(method);
				System.out.println("��ȡ���ֵΪ: "+ mid);
	
				MeetingService service=new MeetingServiceImpl();
				Meeting meeting=new Meeting();
				if(service.SFindMeeting(mid)!=null) {
					meeting=service.SFindMeeting(mid);
					System.out.println(meeting.getMid());
					request.getSession().setAttribute("Meeting", meeting);
					//response.getWriter().println(meeting); 
					request.getRequestDispatcher("/jsp/createandrelease.jsp").forward(request, response);	
				}
				else {
					//request.getRequestDispatcher("jsp/center.jsp").forward(request, response);
			    	System.out.println("�˻��鲻����");
			    	//response.getWriter().println("none");
			    	response.getWriter().print("<scrpti>history.go(-1)</script>"); 
				}
				
				
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		doPost(request, response);
	}

}
