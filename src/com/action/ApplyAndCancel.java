package com.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.entity.Apply;
import com.entity.Meeting;
import com.entity.User;
import com.service.ApplyService;
import com.service.ApplyServiceImpl;




public class ApplyAndCancel extends HttpServlet {
	Apply a = new Apply();
	ApplyService service = new ApplyServiceImpl();
    
    public ApplyAndCancel() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		System.out.println("jump into applyandcancelservlet");
		User u = (User)request.getSession().getAttribute("User");
		int uid=u.getUid();
		System.out.println("userid:"+uid);
		int mid=(int)request.getSession().getAttribute("Meetingid");
		System.out.println("meetingid:"+mid);
		request.getSession().setAttribute("Meetingid", 0);
		
		a.setApplyState(1);
		a.setMeetingID(mid);
		a.setUserID(uid);
		a.setNote(null);
		System.out.println("meetingid:"+mid);
		if(service.SIsApply(uid,mid)!=null) {
			System.out.println("apply is not null");
			if(service.SIsApply(uid,mid).getApplyState()==3) {
				if(service.SUpdateApply(uid, mid)) {
					System.out.println("applymeeting");
					   request.getRequestDispatcher("jsp/attend.jsp").forward(request, response);
					   }
				}
			else {
				if(service.SDeleteApply(mid,uid)) {
					/*System.out.println("mid:"+mid);
				
	    			System.out.println("uid"+uid);*/
	    			//service.SDeleteApply(mid, uid);
	    			System.out.println("cancelapply");
	    			request.getRequestDispatcher("jsp/attend.jsp").forward(request, response);
	    			}
	    		else {
	    			System.out.println("delete failed");
	    			request.getRequestDispatcher("/jsp/attend.jsp").forward(request, response);
	    		}
			}
	    
		 }
		 else {
              if(service.SAddApply(a)) {
            	  System.out.println("applymeeting");
			   request.getRequestDispatcher("jsp/attend.jsp").forward(request, response);
              }
		 }
		
		

	/*	//锟斤拷取锟斤拷锟斤拷锟絬ser锟斤拷锟斤拷锟斤拷息锟斤拷
		User u = (User)request.getAttribute("User");
		a.setUserID(u.getUid());
		//锟斤拷取锟斤拷前锟斤拷meeting锟斤拷锟斤拷锟斤拷息
		Meeting m=(Meeting)request.getAttribute("Meeting");
		a.setMeetingID(m.getMid());
		
		if (service.SIsApply(a) != null) {
			Apply A = service.SIsApply(a);
			A.setApplyState(2);
			if(service.SSetApplyState(A)) {
				String str_text = "锟斤拷锟斤拷锟斤拷取锟斤拷锟斤拷";
  	  			String str_title = "取锟斤拷锟缴癸拷锟斤拷";
  	  			JOptionPane.showMessageDialog(null, str_text, str_title, JOptionPane.PLAIN_MESSAGE);
  	  			response.sendRedirect("/html/attend.html");
			}
			
		}
		//else {
			//锟斤拷取锟斤拷锟斤拷锟斤拷锟斤拷锟街故憋拷锟�
	  		String startTime = m.getStartTime();
	  		SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd ");
	  		Date date = null;
			try {
				date = formatter.parse(startTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
	  		
	  		//锟斤拷取锟斤拷前系统时锟斤拷
	  		Date presentTime = new Date();    
	  		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	  		
	  		//锟叫断伙拷锟斤拷锟角凤拷锟街癸拷锟斤拷锟�
	  		if(date.after(presentTime)) {
	  			//锟斤拷锟矫伙拷锟斤拷锟斤拷锟斤拷锟斤拷械锟街�
	  			a.setApplyFormID(1);
	  			a.setMeetingID(m.getMid());
	  			a.setUserID(u.getUid());
	  			a.setNote(m.getRemarks());
	  			a.setApplyState(1);
	  			
	  			//锟叫讹拷锟斤拷锟捷匡拷锟斤拷锟斤拷欠锟缴癸拷
	  			if(service.SAddApply(a)) {
	  	  			String str_text = "锟斤拷锟斤拷锟诫，锟饺达拷锟斤拷锟斤拷员锟斤拷耍锟�";
	  	  			String str_title = "锟斤拷锟斤拷锟斤拷";
	  	  			JOptionPane.showMessageDialog(null, str_text, str_title, JOptionPane.PLAIN_MESSAGE);
	  	  			response.sendRedirect("");
	  			}else {
	  				System.out.println("锟斤拷锟捷匡拷锟斤拷锟斤拷锟斤拷锟绞э拷埽锟�");
	  			}
	  		}else {
	  			String str_text = "锟斤拷锟斤拷锟窖斤拷止锟斤拷锟诫！";
		  		String str_title = "锟斤拷锟斤拷失锟杰ｏ拷";
		  		JOptionPane.showMessageDialog(null, str_text, str_title, JOptionPane.PLAIN_MESSAGE);
		  		response.sendRedirect("/page/attend.html");
	  		}
		}*/
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		doPost(request, response);
	}

}