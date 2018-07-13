package com.UserDao;

import java.sql.ResultSet;

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
		String sql = "UPDATE Userlogin SET UserName = ?, Password = ?, sex = ?, phoneNumber = ?, "
				+ "job = ?, position = ?, hobby = ?, birthday = ?, motto = ? WHERE UserID = ?";
		Object[] obs={u.getUname(), u.getUpwd(), u.getSex(), u.getPhoneNumber(), 
				u.getJob(), u.getCity(), u.getHobby(), u.getBirthday(), u.getMotto(), u.getUid()};
		return ExecuteUpdate(sql, obs);
	}
	
	
	public ResultSet getUser(int uid) {
		String sql = "SELECT * FROM userlogin WHERE UserID = ?";
		Object[] obs = {uid};
		ResultSet rs = ExecuteQuery(sql, obs);
		return rs;
	}
	
	
	public ResultSet EmailCheck(String email) {
		String sql = "SELECT * FROM userlogin WHERE Email = ?";
		Object[] obs = {email};
		ResultSet rs = ExecuteQuery(sql, obs);
		return rs;
	}
	
}
