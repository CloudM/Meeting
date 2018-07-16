package com.fileControl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {

	public DownloadServlet() {
        super();
    }
    
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	int meetingID = 1;//����Ҫд��ȡmeetingID�ķ�ʽ
        //�õ�Ҫ���ص��ļ���
        String fileName = request.getParameter("filename");
        //fileName = new String(fileName.getBytes("iso8859-1"),"UTF-8");
        String fileSaveRootPath = "D:\\360Downloads\\Software\\" + meetingID;
        //ͨ���ļ����ҳ��ļ�������Ŀ¼
        String path = fileSaveRootPath;
        //�õ�Ҫ���ص��ļ�
        File file = new File(path + "\\" + fileName);
        //����ļ�������
        if(!file.exists()){
            request.setAttribute("message", "��Ҫ���ص���Դ�ѱ�ɾ������");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
            return;
        }
        //�����ļ���
        String realname = fileName.substring(fileName.indexOf("_")+1);
        //������Ӧͷ��������������ظ��ļ�
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realname, "UTF-8"));
        //��ȡҪ���ص��ļ������浽�ļ�������
        FileInputStream in = new FileInputStream(path + "\\" + fileName);
        //���������
        OutputStream out = response.getOutputStream();
        //����������
        byte buffer[] = new byte[1024];
        int len = 0;
        //ѭ�����������е����ݶ�ȡ������������
        while((len=in.read(buffer))>0){
            //��������������ݵ��������ʵ���ļ�����
            out.write(buffer, 0, len);
        }
        //�ر��ļ�������
        in.close();
        //�ر������
        out.close();
    }
}