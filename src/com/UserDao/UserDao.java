package com.UserDao;
import java.sql.ResultSet;

import com.entity.User;
////
public interface UserDao {
	public int doDelete(User u);                 //对用户信息进行删除操作
	public int doRegister(User u);               //对用户信息进行插入操作
	public int resetUser(User u);                //对用户信息进行更改操作
	public int SetUserState(User u, int state);  //更改用户的UserState
	public int SetRegistTime(User u);            //在用户注册成功时调用，设置为当前时间
	public ResultSet getUser(int uid);           //通过UserID来获取用户的信息
	public ResultSet getUser(String email);      //通过Email来获取用户信息

}


