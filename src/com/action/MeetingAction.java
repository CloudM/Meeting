package com.action;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Meeting;
import com.service.MeetingService;
import com.service.MeetingServiceImpl;

public class MeetingAction extends HttpServlet {
	
	MeetingService service=new MeetingServiceImpl();
	public MeetingAction(){
		super();
	}
 public void Service(HttpServletRequest request,HttpServletResponse response)throws IOException{
	 response.setContentType("text/html;charset=UTF-8");
 	String method = request.getParameter("method");
 	if(method=="CreateMeeting") {
 		CreateMeeting(request,response);
 	}
 	else if(method=="ReleaseMeeting") {
 		ReleaseMeeting(request,response);
 	}
 
 }
 public void CreateMeeting(HttpServletRequest request,HttpServletResponse response)throws IOException{
	 Meeting m=new Meeting();
	 m.setMname(request.getParameter("meetingname"));
	 m.setUserid(1);
	 m.setHost(request.getParameter("host"));
	 m.setDescribe(request.getParameter("describe"));
	 m.setGuest(request.getParameter("guest"));
	 m.setPlace(request.getParameter("place"));
	 m.setRemarks(request.getParameter("remark"));
	 m.setStartTime(request.getParameter("meetingtime"));
	 if(service.SFindMeeting(m) != null) {
		 if(service.SUpdateMeeting(m)==true) {
			 System.out.println("�޸Ļ���ɹ���");
			}
			else {
				System.out.println("�����޸�ʧ�ܣ�������Ϣ��д�Ƿ�����");
			}
	 }
	if(service.SAddMeeting(m)==true){
		System.out.println("��������ɹ���");
	}
	else {
		System.out.println("���鴴��ʧ�ܣ�������Ϣ��д�Ƿ�����");
	}
	 
 }
 public void ReleaseMeeting(HttpServletRequest request,HttpServletResponse response)throws IOException{
	 
 }
}
