package com.Dao;

import java.sql.ResultSet;

import com.DBbase.DBDao;

import com.entity.Apply;

public class ApplyDaoImpl extends DBDao implements ApplyDao{
	public int SetApplyState(int state,int mid,int uid) {
		String sql="UPDATE ApplyList SET ApplyState = ? WHERE MeetingID = ? AND UserID = ?";
		 Object[] obs={state, mid, uid};
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

	
	public ResultSet IsApply(int uid,int mid) {
		String sql="SELECT * FROM applylist WHERE MeetingID = ? AND UserID = ?";
		Object[] obs= {mid, uid};
		return ExecuteQuery(sql,obs);
	}

	@Override
	public int SetApplyState(Apply apply) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int DeleteApply(int uid,int mid) {
		String sql = "delete from applylist where MeetingID=? and UserID=?";
		Object[] obs = {mid,uid};
		return ExecuteUpdate(sql,obs);
	}
}
