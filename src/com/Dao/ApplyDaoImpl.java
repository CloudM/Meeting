package com.Dao;

import java.sql.ResultSet;

import com.DBbase.DBDao;

import com.entity.Apply;

public class ApplyDaoImpl extends DBDao implements ApplyDao{
	public int SetApplyState(int state,int mid,int uid) {
		String sql="UPDATE ApplyList SET ApplyState = ?,CheckTime=now() WHERE MeetingID = ? AND UserID = ?";
		 Object[] obs={state, mid, uid};
		return ExecuteUpdate(sql, obs);
	}

	public int setApplyState(Apply a) {
		String sql="update ApplyList set ApplyState = ? where ApplyFormID = ?";
		Object[] obs= {a.getApplyState(),a.getApplyFormID()};
		return ExecuteUpdate(sql,obs);
	}
	
	public int AddApply(Apply apply) {
		String sql = "INSERT INTO ApplyList VALUES(null,?,?,?,?,now(),null,0)";
		Object[] obs = {apply.getMeetingID(),
				apply.getUserID(),apply.getNote(),apply.getApplyState()};
		return ExecuteUpdate(sql,obs);
	}

	public int UpdateApply(int uid, int mid) {
		String sql="update applylist set ApplyState = 1,ApplyTime=now(),CheckTime=null where MeetingID = ? AND UserID = ?";
		Object[] obs= {};
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
	//delete apply
	public int DeleteApply(int mid,int uid) {
		String sql = "delete from applylist where MeetingID=? and UserID=?";
		Object[] obs = {mid,uid};
		return ExecuteUpdate(sql,obs);
	}
	public ResultSet searchApply(int mid) {
		String sql="SELECT * FROM applylist WHERE MeetingID = ?";
		Object[] obs= {mid};
		return ExecuteQuery(sql,obs);
	}
	public ResultSet CountApply(int mid,int status) {
		String sql="SELECT count(ApplyFormID) FROM applylist WHERE MeetingID = ? and ApplyState=?";
		Object[] obs= {mid,status};
		return ExecuteQuery(sql,obs);
	}
}
