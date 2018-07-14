package com.service;

import com.entity.User;

public interface UserService {
	public void sendEmail(String myEmail, String myPassword, String receiveMail, String letter) throws Exception;
	public void sendEmail(String myEmail, String myPassword, String receiveMail, String letter, String filePath) throws Exception;
	public boolean SdoDelete(User u);           //�ڱ�UserLogin��ɾ��һ���û�����Ϣ
	public boolean SdoLogin(User u);            //�ж�����
	public boolean SdoRegister(User u);         //�����ݿ��в���һ���û�����Ϣ
	public boolean ShaveRegister(String email); //�ж����ݿ����Ƿ��Ѿ���ĳ���û�����Ϣ
	public boolean SResetUser(User u);          //����һ���û�����Ϣ
	public User SgetUser(int uid);              //ͨ��UserID����ȡһ���û���ȫ����Ϣ������
	public User SgetUserByEmail(String Email);  //ͨ��Email����ȡһ���û���ȫ����Ϣ������
	public boolean SLogin(User u);              //�޸�UserStateΪ1
	public boolean SLogout(User u);             //�޸�UserStateΪ0
	public boolean SIsSecCode(User u);          //�ж���֤��SecCode�Ƿ����
	public boolean SIsRegister(User u);         //�ж��û��Ƿ�ע��ɹ���UserState�Ƿ�Ϊ100��
	public boolean SSetRegistTime(User u);      //���û�ע��ɹ�ʱ���ã�����Ϊ��ǰʱ��
}
