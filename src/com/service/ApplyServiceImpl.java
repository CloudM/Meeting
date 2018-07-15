package com.service;

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
	
	public Apply SIsApply(Apply apply) {
		Apply A = new Apply();
		if(dao.IsApply(apply) != null) {
			try {
				A.setApplyFormID(dao.IsApply(apply).getInt(1));
				A.setMeetingID(dao.IsApply(apply).getInt(2));
				A.setUserID(dao.IsApply(apply).getInt(3));
				A.setNote(dao.IsApply(apply).getString(4));
				A.setApplyState(dao.IsApply(apply).getInt(5));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return A;
	}
	
	public boolean SSetApplyState(Apply apply) {
		if(dao.SetApplyState(apply) > 0) {
			return true;
		}
		return false;
	}
}
