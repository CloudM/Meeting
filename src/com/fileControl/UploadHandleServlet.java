package com.fileControl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.entity.MyFile;
import com.entity.User;
import com.service.MyFileService;
import com.service.MyFileServiceImpl;

public class UploadHandleServlet extends HttpServlet {
	
	MyFileService service = new MyFileServiceImpl();

	public UploadHandleServlet() {
        super();
    }

    public void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	
    	//User u = (User)request.getSession().getAttribute("User");
    	//int userID = u.getUid();
    	int userID = 11;
    	int meetingID = 1;//����Ҫд��ȡmeetingID�ķ�ʽ
    	
        String savePath = "D:\\360Downloads\\Software\\" + meetingID;
        File file = new File(savePath);
        
        //�ж��ϴ��ļ��ı���Ŀ¼�Ƿ����
        if (!file.exists() && !file.isDirectory()) {
        	System.out.println(savePath+"Ŀ¼�����ڣ���Ҫ����");
            //����Ŀ¼
            file.mkdir();
        }
        
        try {
        	//ʹ��Apache�ļ��ϴ���������ļ��ϴ����裺
            //1������һ��DiskFileItemFactory����
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //2������һ���ļ��ϴ�������
            ServletFileUpload upload = new ServletFileUpload(factory);
            //����ϴ��ļ�������������
            upload.setHeaderEncoding("UTF-8"); 
            //3���ж��ύ�����������Ƿ����ϴ���������
            if(!ServletFileUpload.isMultipartContent(request)){
            	//���մ�ͳ��ʽ��ȡ����
                return;
            }
            //4��ʹ��ServletFileUpload�����������ϴ����ݣ�����������ص���һ��List<FileItem>���ϣ�ÿһ��FileItem��Ӧһ��Form����������
            List<FileItem> list = upload.parseRequest(request);
            
            for(FileItem item : list){
            	
                if(item.isFormField()){
                	//fileitem�з�װ������ͨ����������ݵ������
                	String name = item.getFieldName();
                    String value = item.getString("UTF-8");
                    System.out.println(name + "=" + value);
                } else {//���fileitem�з�װ�����ϴ��ļ�
                    //�õ��ϴ����ļ����ƣ�
                    String filename = item.getName();
                    if(filename == null || filename.trim().equals("")){
                    	continue;
                    }
		            //ע�⣺��ͬ��������ύ���ļ����ǲ�һ���ģ���Щ������ύ�������ļ����Ǵ���·���ģ��磺  c:\a\b\1.txt������Щֻ�ǵ������ļ������磺1.txt
		            //�����ȡ�����ϴ��ļ����ļ�����·�����֣�ֻ�����ļ�������
		            filename = filename.substring(filename.lastIndexOf("\\")+1);
		            //��ȡitem�е��ϴ��ļ���������
		            InputStream in = item.getInputStream();
		            //����һ���ļ������
		            FileOutputStream out = new FileOutputStream(savePath + "\\" + filename);
		            //����һ��������
		            byte buffer[] = new byte[1024];
		            //�ж��������е������Ƿ��Ѿ�����ı�ʶ
		            int len = 0;
		            //ѭ�������������뵽���������У�(len=in.read(buffer))>0�ͱ�ʾin���滹������
		            while((len = in.read(buffer)) > 0){
		            	//ʹ��FileOutputStream�������������������д�뵽ָ����Ŀ¼(savePath + "\\" + filename)����
		                out.write(buffer, 0, len);
		            }
		            //�ر�������
		            in.close();
		            //�ر������
		            out.close();
		            //ɾ�������ļ��ϴ�ʱ���ɵ���ʱ�ļ�
		            item.delete();
			    	//System.out.println("�ļ��ϴ��ɹ���");
		            MyFile mf = new MyFile();
		            mf.setMeetingID(meetingID);
		            mf.setResourceName(filename);
		            mf.setUserID(userID);
		            service.SAddFile(mf);
                }
            }
	    } catch (Exception e) {
	    	//System.out.println("�ļ��ϴ�ʧ�ܣ�");
         	e.printStackTrace();
        }
        
        PrintWriter out=response.getWriter();
		out.print("<script language='javascript'>history.go(-1);</script>");
    }
}
