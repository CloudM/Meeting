package com.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.entity.Apply;
import com.entity.Meeting;
import com.entity.User;
import com.service.ApplyService;
import com.service.ApplyServiceImpl;
import com.service.MeetingService;
import com.service.MeetingServiceImpl;


public class ApplyAndCancel extends HttpServlet {
	Apply a = new Apply();
	ApplyService service = new ApplyServiceImpl();
    
    public ApplyAndCancel() {
        super();
    }
    
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//��ȡ�����user������Ϣ��
		User u = (User)request.getAttribute("User");
		a.setUserID(u.getUid());
		//��ȡ��ǰ��meeting������Ϣ
		Meeting m=(Meeting)request.getAttribute("Meeting");
		a.setMeetingID(m.getMid());
		
		if (service.SIsApply(a) != null) {
			Apply A = service.SIsApply(a);
			A.setApplyState(2);
			if(service.SSetApplyState(A)) {
				String str_text = "������ȡ����";
  	  			String str_title = "ȡ���ɹ���";
  	  			JOptionPane.showMessageDialog(null, str_text, str_title, JOptionPane.PLAIN_MESSAGE);
  	  			response.sendRedirect("/html/attend.html");
			}
			
		}
		else {
			//��ȡ���������ֹʱ��
	  		String startTime = m.getStartTime();
	  		SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd ");
	  		Date date = null;
			try {
				date = formatter.parse(startTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
	  		
	  		//��ȡ��ǰϵͳʱ��
	  		Date presentTime = new Date();    
	  		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	  		
	  		//�жϻ����Ƿ��ֹ����
	  		if(date.after(presentTime)) {
	  			//���û���������е�ֵ
	  			a.setApplyFormID(1);
	  			a.setMeetingID(m.getMid());
	  			a.setUserID(u.getUid());
	  			a.setNote(m.getRemarks());
	  			a.setApplyState(1);
	  			
	  			//�ж����ݿ�����Ƿ�ɹ�
	  			if(service.SAddApply(a)) {
	  	  			String str_text = "�����룬�ȴ�����Ա��ˣ�";
	  	  			String str_title = "������";
	  	  			JOptionPane.showMessageDialog(null, str_text, str_title, JOptionPane.PLAIN_MESSAGE);
	  	  			response.sendRedirect("");
	  			}else {
	  				System.out.println("���ݿ��������ʧ�ܣ�");
	  			}
	  		}else {
	  			String str_text = "�����ѽ�ֹ���룡";
		  		String str_title = "����ʧ�ܣ�";
		  		JOptionPane.showMessageDialog(null, str_text, str_title, JOptionPane.PLAIN_MESSAGE);
		  		response.sendRedirect("/page/attend.html");
	  		}
		}
	}
}