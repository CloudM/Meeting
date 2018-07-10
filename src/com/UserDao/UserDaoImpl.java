package com.UserDao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.DBbase.DBDao;
import com.entity.User;

public class UserDaoImpl extends DBDao implements UserDao{

	public int doDelete(int id) {
		String sql = "DELETE FROM userlogin WHERE UserID = " + id;
		return ExecuteUpdate(sql, null);
	}

	public ResultSet doLogin(User u) {
		String sql = "SELECT Password FROM userlogin WHERE Email = ?";
		Object[] obs = {u.getUEmail()};
		ResultSet rs = ExecuteQuery(sql, obs);
		return rs;
	}

	public int doRegister(User u) {
		 String sql="INSERT INTO userlogin(UserID, UserName, Password, Email, RegistTime) "
		 		+ "VALUES(null,?,?,?,now())";
		 Object[] obs={u.getUname(), u.getUpwd(), u.getUEmail()};
		return ExecuteUpdate(sql, obs);
	}

	
	public ResultSet haveRegister(String email) {
		String sql = "SELECT * FROM userlogin WHERE Email = ?";
		Object[] obs = {email};
		ResultSet rs = ExecuteQuery(sql, obs);
		return rs;
	}

	
	public int resetUser(User u) {
		String sql = "UPDATE User SET UserName = ?, Password = ?, Sex = ?, PhotoUrl = ?, "
				+ "PhoneNumber = ?, Job = ?, Hobby = ?, Birtuday = ? WHERE UserID = ?";
		Object[] obs={u.getUname(), u.getUpwd(), u.getSex(), u.getPhotoUrl(), 
				u.getPhoneNumber(), u.getJob(), u.getHobby(), u.getBirthday(), u.getUid()};
		return ExecuteUpdate(sql, obs);
	}

	
	public ResultSet getUser(int uid) {
		String sql = "SELECT * FROM userlogin WHERE UserID = ?";
		Object[] obs = {uid};
		ResultSet rs = ExecuteQuery(sql, obs);
		return rs;
	}
}