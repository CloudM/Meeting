package com.Dao;

import java.sql.ResultSet;

import com.entity.MyFile;

public interface MyFileDao {
	public int AddFile(MyFile mf);               //�����ݿ�resourcelist����һ������
	public int DeleteFile(MyFile mf);            //�����ݿ�resourcelistɾ��һ������
	public int ChangeFile(MyFile mf);            //�ı����ݿ�resourcelist��һ�����ݵ�UserID��ֵ
	public ResultSet GetFile(MyFile mf);         //ͨ��ResourceID��ȡһ���ļ���ȫ����Ϣ
	public ResultSet GetFile2(MyFile mf);        //ͨ��MeetingID��ResourceName��ȡһ���ļ���ȫ����Ϣ
	public ResultSet GetFileList(int meetingID); //ͨ��MeetingID��ȡһ���ļ��б��ȫ�����?
}
