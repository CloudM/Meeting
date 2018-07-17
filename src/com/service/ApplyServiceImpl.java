package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.Dao.ApplyDao;
import com.Dao.ApplyDaoImpl;
import com.entity.Apply;

public class ApplyServiceImpl implements ApplyService{
	ApplyDao dao = new ApplyDaoImpl();
	public boolean ShandleApply(Apply apply) {
		if(dao.SetApplyState(apply) > 0) {
			return true;
		} 
		return false;
	}
	
	public boolean SAddApply(Apply apply) {
		if(dao.AddApply(apply) > 0) {
			return true;
		}
		return false;
	}
	
	public Apply SIsApply(int uid,int mid) {
		Apply A = new Apply();
		//A=null;
		ResultSet rs=dao.IsApply(uid,mid);
		try {
		if(rs.next()==true) {
			while(rs.next()) {
				A.setApplyFormID(dao.IsApply(uid,mid).getInt(1));
				A.setMeetingID(dao.IsApply(uid,mid).getInt(2));
				A.setUserID(dao.IsApply(uid,mid).getInt(3));
				A.setNote(dao.IsApply(uid,mid).getString(4));
				A.setApplyState(dao.IsApply(uid,mid).getInt(5));
			}
		}
		else {
			A=null;
		}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return A;
	}
	
	public boolean SSetApplyState(Apply apply) {
		if(dao.SetApplyState(apply) > 0) {
			return true;
		}
		return false;
	}
	public boolean SSetApplyState(int state,int mid,int uid) {
		if(dao.SetApplyState(state,mid,uid) > 0) {
			return true;
		}
		return false;
	}
	public boolean SDeleteApply(int mid,int uid) {
		if(dao.DeleteApply(mid,uid) > 0) {
			return true;
		}
		return false;
	}
}

