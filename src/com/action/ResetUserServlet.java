package com.action;

import java.io.IOException;

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
        response.setContentType("text/html;charset=UTF-8");
        User u = new User();
        u.setUid(Integer.parseInt(request.getParameter("UserID")));
        u.setUname(request.getParameter("userName"));
        u.setUpwd(request.getParameter("upwd"));
        u.setSex(request.getParameter("sex"));
        u.setPhotoUrl(request.getParameter("photoUrl"));
        u.setPhoneNumber(request.getParameter("phoneNumber"));
        u.setJob(request.getParameter("job"));
        u.setHobby(request.getParameter("hobby"));
        u.setBirthday(request.getParameter("birthday"));
        if(service.SResetUser(u)) {
            //通知用户信息修改成功
        } else {
        	//通知用户信息修改失败
        }
    }
}
