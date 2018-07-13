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
		//获取存入的user对象信息。
		User u = (User)request.getAttribute("User");
		a.setUserID(u.getUid());
		//获取当前的meeting对象信息
		Meeting m=(Meeting)request.getAttribute("Meeting");
		a.setMeetingID(m.getMid());
		
		if (service.SIsApply(a) != null) {
			Apply A = service.SIsApply(a);
			A.setApplyState(2);
			if(service.SSetApplyState(A)) {
				String str_text = "申请已取消！";
  	  			String str_title = "取消成功！";
  	  			JOptionPane.showMessageDialog(null, str_text, str_title, JOptionPane.PLAIN_MESSAGE);
  	  			response.sendRedirect("/html/attend.html");
			}
			
		}
		else {
			//获取会议申请截止时间
	  		String startTime = m.getStartTime();
	  		SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd ");
	  		Date date = null;
			try {
				date = formatter.parse(startTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
	  		
	  		//获取当前系统时间
	  		Date presentTime = new Date();    
	  		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	  		
	  		//判断会议是否截止申请
	  		if(date.after(presentTime)) {
	  			//设置会议申请表中的值
	  			a.setApplyFormID(1);
	  			a.setMeetingID(m.getMid());
	  			a.setUserID(u.getUid());
	  			a.setNote(m.getRemarks());
	  			a.setApplyState(1);
	  			
	  			//判断数据库操作是否成功
	  			if(service.SAddApply(a)) {
	  	  			String str_text = "已申请，等待管理员审核！";
	  	  			String str_title = "已申请";
	  	  			JOptionPane.showMessageDialog(null, str_text, str_title, JOptionPane.PLAIN_MESSAGE);
	  	  			response.sendRedirect("");
	  			}else {
	  				System.out.println("数据库插入数据失败！");
	  			}
	  		}else {
	  			String str_text = "会议已截止申请！";
		  		String str_title = "申请失败！";
		  		JOptionPane.showMessageDialog(null, str_text, str_title, JOptionPane.PLAIN_MESSAGE);
		  		response.sendRedirect("/page/attend.html");
	  		}
		}
	}
}