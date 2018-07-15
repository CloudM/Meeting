package com.fileControl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.MyFileService;
import com.service.MyFileServiceImpl;

public class ListFileServlet extends HttpServlet {
	
	MyFileService service = new MyFileServiceImpl();

	public ListFileServlet() {
        super();
    }

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	int meetingID = 1;//����Ҫд��ȡmeetingID�ķ�ʽ
        List<String> list = service.SGetFileList1(meetingID);
        //�洢Ҫ���ص��ļ���
        Map<String,String> fileNameMap = new HashMap<String,String>();
        for(int i = 0; i < list.size(); i++) {
        	fileNameMap.put(list.get(i), list.get(i));
        }
        //��Map���Ϸ��͵�listfile.jspҳ�������ʾ
        request.getSession().setAttribute("fileNameMap", fileNameMap);
    }
}