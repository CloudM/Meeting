package com.Dao;
/////
import java.sql.ResultSet;

import com.entity.User;
////
public interface UserDao {
	public int doDelete(User u);                 //���û���Ϣ����ɾ������
	public int doRegister(User u);               //���û���Ϣ���в������?
	public int resetUser(User u);                //���û���Ϣ���и��Ĳ���
	public int SetUserState(User u, int state);  //�����û���UserState
	public int SetRegistTime(User u);            //���û�ע��ɹ�ʱ���ã�����Ϊ��ǰʱ��?
	public ResultSet getUser(int uid);           //ͨ��UserID����ȡ�û�����Ϣ
	public ResultSet getUser(String email);      //ͨ��Email����ȡ�û���Ϣ
}

