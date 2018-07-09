package com.UserDao;

import java.sql.ResultSet;

import com.DBbase.DBDao;

import com.entity.Apply;

public class ApplyDaoImpl extends DBDao implements ApplyDao{
	public int SetApplyState(Apply apply) {
		String sql="UPDATE ApplyList SET ApplyState = ? WHERE MeetingID = ? AND UserID = ?";
		 Object[] obs={apply.getApplyState(), apply.getMeetingID(), apply.getUserID()};
		return ExecuteUpdate(sql, obs);
	}

	public int setApplyState(Apply a) {
		String sql="update ApplyList set ApplyState = ? where ApplyFormID = ?";
		Object[] obs= {a.getApplyState(),a.getApplyFormID()};
		return ExecuteUpdate(sql,obs);
	}
	
	public int AddApply(Apply apply) {
		String sql = "INSERT INTO ApplyList VALUES(?,?,?,?,?)";
		Object[] obs = {apply.getApplyFormID(),apply.getMeetingID(),
				apply.getUserID(),apply.getNote(),apply.getApplyState()};
		return ExecuteUpdate(sql,obs);
	}

	
	public ResultSet IsApply(Apply apply) {
		String sql="SELECT * FROM ApplyList WHERE MeetingID = ? AND UserID = ?";
		Object[] obs= {apply.getMeetingID(), apply.getUserID()};
		return ExecuteQuery(sql,obs);
	}
}
