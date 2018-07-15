package com.service;

import java.util.List;

import com.entity.MyFile;

public interface MyFileService {
	public boolean SAddFile(MyFile mf);                 //�����ݿ������һ���ļ�����Ϣ
	public boolean SDeleteFile(MyFile mf);              //�����ݿ���ɾ��һ���ļ�����Ϣ
	public boolean SChangeFile(MyFile mf);              //�ı�һ���ļ���Ϣ��UserID��ֵ
	public MyFile SGetFile(MyFile mf);                  //�����ݿ��л�ȡһ���ļ���ȫ����Ϣ�󷵻�һ���ļ�����  
	public List<String> SGetFileList1(int meetingID);   //����ResourceName�б�
	public List<String> SGetFileList2(int meetingID);   //����ResourceID�б�
	public boolean SIsFileExist(MyFile mf);             //�ж�������ļ������Ƿ����
}
