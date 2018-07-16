package com.Dao;

import java.sql.ResultSet;

import com.DBbase.DBDao;
import com.entity.User;

public class UserDaoImpl extends DBDao implements UserDao{

	public int doDelete(User u) {
		String sql = "DELETE FROM userlogin WHERE Email = ?";
		Object[] obs={u.getUEmail()};
		return ExecuteUpdate(sql, obs);
	}

	//��UserState����ʾ�û�״̬��100��ʾδע��ɹ���?0��ʾע��ɹ���δ��¼��?1��ʾע��ɹ����Ѿ����?
	public int doRegister(User u) {
		 String sql="INSERT INTO userlogin(UserID, UserName, Password, Email, Token, UserState, Token_Time) "
		 		+ "VALUES(null,?,?,?,?,100,now())";
		 Object[] obs={u.getUname(), u.getUpwd(), u.getUEmail(), u.getSecCode()};
		return ExecuteUpdate(sql, obs);
	}

	
	public int resetUser(User u) {
		String sql = "UPDATE Userlogin SET UserName = ?, Password = ?, sex = ?, phoneNumber = ?, "
				+ "job = ?, position = ?, hobby = ?, birthday = ?, motto = ? WHERE UserID = ?";
		Object[] obs={u.getUname(), u.getUpwd(), u.getSex(), u.getPhoneNumber(), 
				u.getJob(), u.getCity(), u.getHobby(), u.getBirthday(), u.getMotto(), u.getUid()};
		return ExecuteUpdate(sql, obs);
	}

	
	public int SetUserState(User u, int state) {
		String sql = "UPDATE Userlogin SET UserState = ? WHERE Email = ?";
		Object[] obs={state, u.getUEmail()};
		return ExecuteUpdate(sql, obs);
	}

	
	public ResultSet getUser(int uid) {
		String sql = "SELECT * FROM userlogin WHERE UserID = ?";
		Object[] obs = {uid};
		ResultSet rs = ExecuteQuery(sql, obs);
		return rs;
	}

	
	public ResultSet getUser(String email) {
		String sql = "SELECT * FROM userlogin WHERE Email = ?";
		Object[] obs = {email};
		ResultSet rs = ExecuteQuery(sql, obs);
		return rs;
	}

	
	public int SetRegistTime(User u) {
		String sql = "UPDATE Userlogin SET RegistTime = now() WHERE Email = ?";
		Object[] obs={u.getUEmail()};
		return ExecuteUpdate(sql, obs);
	}
}
