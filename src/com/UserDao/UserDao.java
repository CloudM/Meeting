package com.UserDao;
/////
import java.sql.ResultSet;

import com.entity.User;
////
public interface UserDao {
	public int doDelete(int id);
	public ResultSet doLogin(User u);
	public int doRegister(User u);
	public ResultSet haveRegister(String email);
	public int resetUser(User u);
	public ResultSet getUser(int uid);
}

