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

import net.sf.json.JSONObject;

public class ShowMyCard extends HttpServlet{
	public ShowMyCard() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        this.doPost(request,response);
    }
     
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
    	response.setContentType("text/json; charset=utf-8");

    	Cookie[] cookies=request.getCookies();
		Cookies c=new Cookies();
	    String sessionid= c.findCookie("SessionId",cookies);
	    SessionContext myc= SessionContext.getInstance();  
	    HttpSession sess = myc.getSession(sessionid);  
	    User u=(User) sess.getAttribute("User");
	    
    	//User u = new User();
    	//u.setUid(1);
	    CardService service = new CardServiceImpl();
	    Card mycard = service.C_FindSelfCard(u);
	    request.getSession().setAttribute("mycard", mycard);
	    System.out.println(mycard.getC_mail());
	    System.out.println(mycard.getC_phone());
	    System.out.println(mycard.getC_introduction());
	    System.out.println(mycard.getC_position());
	    request.getRequestDispatcher("jsp/CreatCard.jsp").forward(request, response);
    }
    
}
