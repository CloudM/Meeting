package com.fileControl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.MyFile;
import com.service.MyFileService;
import com.service.MyFileServiceImpl;

public class FileCheckAction extends HttpServlet{
    MyFileService service =new MyFileServiceImpl();
    
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
    	int meetingID = 1;//还需要写获取meetingID的方式
        String file1Name = req.getParameter("file1Name");
        file1Name = java.net.URLDecoder.decode(file1Name,"UTF-8");
        MyFile mf = new MyFile();
        mf.setMeetingID(meetingID);
        mf.setResourceName(file1Name);
        if(service.SIsFileExist(mf)) {
        	resp.getWriter().print("exist");
        }
        else {
        	resp.getWriter().print("no");
        }
    }
}