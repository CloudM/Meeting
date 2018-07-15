package com.service;

import com.entity.User;

public interface UserService {
	public void sendEmail(String myEmail, String myPassword, String receiveMail, String letter) throws Exception;
	public void sendEmail(String myEmail, String myPassword, String receiveMail, String letter, String filePath) throws Exception;
	public boolean SdoDelete(User u);           //在表UserLogin中删除一个用户的信息
	public boolean SdoLogin(User u);            //判断密码
	public boolean SdoRegister(User u);         //向数据库中插入一个用户的信息
	public boolean ShaveRegister(String email); //判断数据库中是否已经有某个用户的信息
	public boolean SResetUser(User u);          //更新一个用户的信息
	public User SgetUser(int uid);              //通过UserID来获取一个用户的全部信息并返回
	public User SgetUserByEmail(String Email);  //通过Email来获取一个用户的全部信息并返回
	public boolean SLogin(User u);              //修改UserState为1
	public boolean SLogout(User u);             //修改UserState为0
	public boolean SIsSecCode(User u);          //判断验证码SecCode是否相符
	public boolean SIsRegister(User u);         //判断用户是否注册成功（UserState是否为100）
	public boolean SSetRegistTime(User u);      //在用户注册成功时调用，设置为当前时间
}
