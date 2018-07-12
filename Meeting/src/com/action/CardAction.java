//Dylan,2018.7.9,first build,add function "CreatCard""AlterCard""DeleteCard"
//Dylan,2018.7.11,add function "FindSelfCard""FindOtherCard""CollectCard""CancleCollectCard"

package com.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.entity.Card;
import com.entity.User;
import com.function.Cookies;
import com.function.SessionContext;
import com.service.CardService;
import com.service.CardServiceImpl;

public class CardAction extends HttpServlet {
	CardService c_service = new CardServiceImpl();
	User u = new User();
	
	public CardAction() {
		super();
	}
	
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("text/html;charset=UTF-8");
		String method = request.getParameter("method");
		if(method.equals("CreatCard")) {
				CreateCard(request,response);
			}else if(method.equals("AlterCard")){
				AlterCard(request,response);
			}
			else if(method.equals("DeleteCard")){
				DeleteCard(request,response);
			}
			else if(method.equals("FindSelfCard")){
				FindSelfCard(request,response);
			}
			else if(method.equals("FindOtherCard")){
				FindOtherCard(request,response);
			}
			else if(method.equals("CollectCard")){
				CollectCard(request,response);
			}
			else if(method.equals("CancleCollectCard")){
				CancleCollectCard(request,response);
			}
	}
	
	//create card
	public void CreateCard(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		Card c = new Card();
		c.setC_username(request.getParameter("username"));
		c.setC_mail(request.getParameter("email"));
		c.setC_phone(request.getParameter("phone"));
		c.setC_company(request.getParameter("company"));
		//c.setC_companyAddress(request.getParameter("address"));
		c.setC_position(request.getParameter("position"));
		c.setC_introduction(request.getParameter("introduction"));
		
		 Cookie[] cookies=request.getCookies();
		 Cookies cook=new Cookies();
		    String sessionid= cook.findCookie("SessionId",cookies);
		    SessionContext myc= SessionContext.getInstance();  
		    HttpSession sess = myc.getSession(sessionid);  
		    u=(User) sess.getAttribute("User");  
		    
		      if(c_service.C_AddCard(c,u)) {
		    	  System.out.println("创建名片成功");
		    	  request.getRequestDispatcher("jsp/center.jsp").forward(request, response);
		      } else {
		    		System.out.println("创建名片失败");
		    	}
	}
	
	//update card
	public void AlterCard(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		Card c = new Card();
		c.setC_username(request.getParameter("username"));
		c.setC_mail(request.getParameter("email"));
		c.setC_phone(request.getParameter("phone"));
		c.setC_company(request.getParameter("company"));
		if(c_service.C_UpdateCard(c,u)) {
	    	  System.out.println("修改名片成功");
	    	  request.getRequestDispatcher("jsp/center.jsp").forward(request, response);
	      } else {
	    		System.out.println("修改名片失败");
	    	}
	}
	
	//query your card
	public void FindSelfCard(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		Card card = c_service.C_FindSelfCard(u);
		System.out.println("查询成功"+card.getC_id());
	}
	
	//query collected card,but this function doesn't complete 
	public void FindOtherCard(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		Card card = c_service.C_FindOtherCard(u);
		System.out.println("查询成功"+card.getC_id());
	}
	
	//delete your card
	public void DeleteCard(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		Card c = new Card();
		if(c_service.C_DeleteCard(c,u)) {
	    	  System.out.println("删除名片成功");
	    	  request.getRequestDispatcher("jsp/center.jsp").forward(request, response);
	      } else {
	    		System.out.println("删除名片失败");
	    	}
	}
	
	//collect other card
	public void CollectCard(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		Card c = new Card();
		if(c_service.C_CollectCard(c, u)) {
	    	  System.out.println("收藏名片成功");
	    	  request.getRequestDispatcher("jsp/center.jsp").forward(request, response);
	      } else {
	    		System.out.println("收藏名片失败");
	    	}
	}
	
	//not collect other card
	public void CancleCollectCard(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		Card c = new Card();
		c.setC_id(2);
		if(c_service.C_CancleCollectCard(c, u)) {
	    	  System.out.println("取消收藏名片成功");
	    	  request.getRequestDispatcher("jsp/center.jsp").forward(request, response);
	      } else {
	    		System.out.println("取消收藏名片失败");
	    	}
	}
}
