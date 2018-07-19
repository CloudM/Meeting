package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.Dao.ApplyDao;
import com.Dao.ApplyDaoImpl;
import com.entity.Apply;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
			if(rs != null) {
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
	public boolean SUpdateApply(int uid,int mid) {
		if(dao.UpdateApply(mid,uid) > 0) {
			return true;
		}
		return false;
	}
	public JSONArray SsearchApply(int mid) {
		JSONArray A = new JSONArray(); 
		ResultSet rs = dao.searchApply(mid);
		if(rs!=null) {
		try {
			while(rs.next()) {
				//Meeting m=new Meeting();
				JSONObject a = new JSONObject();
				a.put("applyID", rs.getInt(1));
				a.put("MeetingID", rs.getInt(2));
				a.put("UserID", rs.getInt(3));
				a.put("note", rs.getString(4));
				a.put("applyState", rs.getInt(5));
				a.put("applyTime", rs.getString(6));
				a.put("checkTime", rs.getString(7));
				
			    
				}
			} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			}
		}
		return A;
	}
	public int SCountApply(int mid,int status) {
		ResultSet rs = dao.CountApply(mid,status);
		int count=0;
		if(rs!=null) {
			try {
				while(rs.next()) {
					count=rs.getInt(1);
					}
				}
			catch (SQLException e2) {
				e2.printStackTrace();
				}
			}
		return count;
		}
}


