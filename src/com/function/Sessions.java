package com.function;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.entity.User;

public class Sessions implements HttpSessionListener{
	private SessionContext myc = SessionContext.getInstance();  
    
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {  
        HttpSession session = httpSessionEvent.getSession();  
        myc.addSession(session);  
    }  
  
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {  
        HttpSession session = httpSessionEvent.getSession();  
        myc.delSession(session);  
    }  
	
}
