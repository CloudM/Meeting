package com.action;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.entity.User;
import com.function.Cookies;
import com.function.SessionContext;
import com.service.CardService;
import com.service.CardServiceImpl;
import com.service.UserService;
import com.service.UserServiceImpl;

public class ShowCard extends HttpServlet{
	public ShowCard() {
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
    	JSONArray cardlist_json = new JSONArray(); 
    	JSONObject card_json = new JSONObject();
    	/*
    	Cookie[] cookies=request.getCookies();
		Cookies c=new Cookies();
	    String sessionid= c.findCookie("SessionId",cookies);
	    SessionContext myc= SessionContext.getInstance();  
	    HttpSession sess = myc.getSession(sessionid);  
	    User u=(User) sess.getAttribute("User");
	    */
    	User u = new User();
    	u.setUid(1);
	    CardService service = new CardServiceImpl();
	    cardlist_json = service.C_FindOtherCard(u, card_json);
	    response.getWriter().println(cardlist_json); 
    }
    
    
}
