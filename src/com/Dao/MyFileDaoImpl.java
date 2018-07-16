package com.Dao;

import java.sql.ResultSet;

import com.DBbase.DBDao;
import com.entity.MyFile;

public class MyFileDaoImpl extends DBDao implements MyFileDao{

	public int AddFile(MyFile mf) {
		String sql = "INSERT INTO resourcelist(ResourceID, MeetingID, ResourceName, UserID) "
				+ "VALUES(null, ?, ?, ?)";
		Object[] obs={mf.getMeetingID(), mf.getResourceName(), mf.getUserID()};
		return ExecuteUpdate(sql, obs);
	}

	public int DeleteFile(MyFile mf) {
		String sql = "DELETE FROM resourcelist WHERE ResourceID = ?";
		Object[] obs={mf.getResourceID()};
		return ExecuteUpdate(sql, obs);
	}

	public int ChangeFile(MyFile mf) {
		String sql = "UPDATE resourcelist SET UserID = ? WHERE ResourceID = ?";
		Object[] obs={mf.getUserID(), mf.getResourceID()};
		return ExecuteUpdate(sql, obs);
	}

	public ResultSet GetFile(MyFile mf) {
		String sql = "SELECT * FROM resourcelist WHERE ResourceID = ?";
		Object[] obs = {mf.getResourceID()};
		ResultSet rs = ExecuteQuery(sql, obs);
		return rs;
	}

	public ResultSet GetFileList(int meetingID) {
		String sql = "SELECT * FROM resourcelist WHERE MeetingID = ?";
		Object[] obs = {meetingID};
		ResultSet rs = ExecuteQuery(sql, obs);
		return rs;
	}

	public ResultSet GetFile2(MyFile mf) {
		String sql = "SELECT * FROM resourcelist WHERE MeetingID = ? AND ResourceName = ?";
		Object[] obs = {mf.getMeetingID(), mf.getResourceName()};
		ResultSet rs = ExecuteQuery(sql, obs);
		return rs;
	}
}
