package com.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.User;
import com.service.UserService;
import com.service.UserServiceImpl;

public class ResetUserServlet extends HttpServlet {
    UserService service = new UserServiceImpl();
    
    public ResetUserServlet() {
        super();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html;charset=UTF-8");
        User u = new User();
        User user = (User)request.getSession().getAttribute("User");
        u.setUid(user.getUid());
        //下面这一段是对输入框输入空值时的处理，现在用不上
        /*if(request.getParameter("userName").equals(""))
            u.setUname(user.getUname());
        else
        	u.setUname(request.getParameter("userName"));
        if(request.getParameter("upwd").equals(""))
        	u.setUpwd(user.getUpwd());
        else
        	u.setUpwd(request.getParameter("upwd"));
        if(request.getParameter("sex").equals(""))
        	u.setSex(user.getSex());
        else
        	u.setSex(request.getParameter("sex"));
        //此处还应添加获取PhotoUrl的操作
        if(request.getParameter("phoneNumber").equals(""))
        	u.setPhoneNumber(user.getPhoneNumber());
        else
        	u.setPhoneNumber(request.getParameter("phoneNumber"));
        if(request.getParameter("job").equals(""))
        	u.setJob(user.getJob());
        else
        	u.setJob(request.getParameter("job"));
        if(request.getParameter("city").equals(""))
        	u.setCity(user.getCity());
        else
        	u.setCity(request.getParameter("city"));
        if(request.getParameter("hobby").equals(""))
        	u.setHobby(user.getHobby());
        else
        	u.setHobby(request.getParameter("hobby"));
        if(request.getParameter("Motto").equals(""))
        	u.setMotto(user.getMotto());
        else
        	u.setMotto(request.getParameter("Motto"));*/
        u.setUname(request.getParameter("userName"));
    	u.setUpwd(request.getParameter("upwd"));
    	u.setSex(request.getParameter("sex"));
    	u.setPhoneNumber(request.getParameter("phoneNumber"));
    	u.setJob(request.getParameter("job"));
    	u.setCity(request.getParameter("city"));
    	u.setHobby(request.getParameter("hobby"));
    	u.setMotto(request.getParameter("Motto"));
        u.setBirthday(request.getParameter("year") + " " 
              + request.getParameter("month") + " " + request.getParameter("date"));
        
        if(service.SResetUser(u)) {
        	PrintWriter out=response.getWriter();
    		out.print("<script language='javascript'>alert('您的个人信息更改成功');history.go(-1);" + 
    				"</script>");
        } else {
        	PrintWriter out=response.getWriter();
    		out.print("<script language='javascript'>alert('您的个人信息更改失败');history.go(-1);" + 
    				"</script>");
        }
    }
}
