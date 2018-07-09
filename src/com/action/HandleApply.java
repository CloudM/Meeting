package com.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Apply;
import com.entity.Meeting;
import com.service.ApplyService;
import com.service.ApplyServiceImpl;
import com.service.MeetingService;
import com.service.MeetingServiceImpl;
import com.service.UserService;
import com.service.UserServiceImpl;

public class HandleApply extends HttpServlet {
	
    ApplyService AService = new ApplyServiceImpl();
    MeetingService MService = new MeetingServiceImpl();
    UserService UService = new UserServiceImpl();
	
    public HandleApply() {
        super();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        Apply apply = new Apply();
        apply.setMeetingID(Integer.parseInt(request.getParameter("MeetingID")));
        apply.setUserID(Integer.parseInt(request.getParameter("UserID")));
        if(request.getParameter("ApplyState").equals("agree")) {
        	apply.setApplyState(2);
        } else {
        	apply.setApplyState(3);
        }
        
        Meeting meeting = new Meeting();
        meeting.setMid(Integer.parseInt(request.getParameter("MeetingID")));
        String MName = MService.SFindMeeting(meeting).getMname();
        String letter = null;
        
        String UserEmail = UService.SgetUser(Integer.parseInt(request.getParameter("UserID"))).getUEmail();
        
        if(AService.ShandleApply(apply)) {
        	if(apply.getApplyState() == 2) {
        		letter = " 尊敬的用户，您向会议 " + MName + " 发起的参与申请已被允许，请及时参加会议。 ";
        	}
        	else if(apply.getApplyState() == 3) {
        		letter = " 尊敬的用户，您向会议 " + MName + " 发起的参与申请已被拒绝，您可以私下与会议发起者联系以了解详情。 ";
        	} else {
        		System.out.println("前端数据获取有异常！！！！！！");
        	}
        } else {
        	System.out.println("数据库操作有异常！！！！！！");
        }
        try {
			UService.sendEmail("15827635991@163.com", "g3110z14h32", UserEmail, letter);
			System.out.println(letter);
		} catch (Exception e) {
			System.out.println("邮件发送异常！！！！！！");
		}
    }
}
