package com.function;

import javax.servlet.http.Cookie;

public class Cookies {
 
	public String findCookie(String keyword,Cookie[] cookies) {
	//get all cookies and their values to find the cookie I need here through the cookie key
		 //Cookie[] cookies=request.getCookies();
		 String key=null;
		  if(cookies!=null){
		       for(int i=0;i<cookies.length;i++) {
		              if(cookies[i].getName().equals(keyword)){
		                	 key=cookies[i].getValue();
		                 }
		             }   
		         }
	
	return key;
    }
}
