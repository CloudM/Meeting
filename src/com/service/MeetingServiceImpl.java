//KarenZhu
package com.service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Dao.MeetingDao;
import com.Dao.MeetingDaoImpl;
import com.entity.Meeting;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
public class MeetingServiceImpl implements MeetingService{
	MeetingDao dao = new MeetingDaoImpl();
//turn the result of adding meeting to boolean
	public boolean SAddMeeting(Meeting m) {
		if (dao.AddMeeting(m)>0) {
			return true;
		}
		else {
			return false;
		}
	}
//turn the result of deleting meeting to boolean
	public boolean SDeleteMeeting(Meeting m) {
	if (dao.DeleteMeeting(m)>0) {
		return true;
	}
	else {
		return false;
	}
	}
//assign the result of finding meeting to entity Meeting
	public Meeting SFindMeeting(int mid) {
		Meeting M = new Meeting();
		ResultSet rs=dao.FindMeeting(mid);
		if(rs!=null) {
			try {
				while(rs.next()) {
				M.setMid(rs.getInt(1));
				M.setTypeid(rs.getInt(2));
				M.setUserid(rs.getInt(3));
				M.setMeetingStatus(rs.getInt(4));
				M.setStartTime(rs.getString(5));
				M.setEndTime(rs.getString(6));
				M.setPlace(rs.getString(7));
				M.setGuest(rs.getString(9));
				M.setDescribe(rs.getString(10));
				M.setRemarks(rs.getString(11));
				M.setSetTime(rs.getString(12));
				M.setMname(rs.getString(13));
				M.setHost(rs.getString(14));
				/*m.put("Mid",dao.FindMeeting(mid).getInt(1));
				m.put("Typeid",dao.FindMeeting(mid).getInt(2));
				m.put("Userid",dao.FindMeeting(mid).getInt(3));
				m.put("MeetingStatus",dao.FindMeeting(mid).getInt(4));
				m.put("StartTime",dao.FindMeeting(mid).getString(5));
				m.put("EndTime",dao.FindMeeting(mid).getString(6));
				m.put("Place",dao.FindMeeting(mid).getString(7));
				m.put("Guest",dao.FindMeeting(mid).getString(9));
				m.put("Describe",dao.FindMeeting(mid).getString(10));
				m.put("Remarks",dao.FindMeeting(mid).getString(11));
				m.put("SetTime",dao.FindMeeting(mid).getString(12));
				m.put("Mname",dao.FindMeeting(mid).getString(13));
				m.put("Host",dao.FindMeeting(mid).getString(14));*/
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return M;
	}
	//turn the result of changing meeting status to boolean
	public boolean SUpdateMeeting(Meeting m,int mid) {
		// TODO Auto-generated method stub
		if (dao.UpdateMeeting(m,mid)>0) {
			return true;
		}
		else {
			return false;
		}
	
	}
	//turn the result of changing meeting status to boolean
	public boolean SReleaseMeeting(int mid) {
		// TODO Auto-generated method stub
		if (dao.ReleaseMeeting(mid)>0) {
			return true;
		}
		else {
			return false;
		}
	
	}
	
	public JSONArray ShasReleasedMeeting(int userid,int status1,int status2) {
		JSONArray M = new JSONArray(); 
		ResultSet rs = dao.hasReleasedMeeting(userid,status1,status2);
		if(rs!=null) {
		try {
			while(rs.next()) {
				//Meeting m=new Meeting();
				JSONObject m = new JSONObject();
				m.put("Mid",rs.getInt(1));
				m.put("Typeid",rs.getInt(2));
				m.put("Userid",rs.getInt(3));
				m.put("MeetingStatus",rs.getInt(4));
				m.put("StartTime",rs.getString(5));
				m.put("EndTime",rs.getString(6));
				m.put("Place",rs.getString(7));
				m.put("Guest",rs.getString(9));
				m.put("Describe",rs.getString(10));
				m.put("Remarks",rs.getString(11));
				m.put("SetTime",rs.getString(12));
				m.put("Mname",rs.getString(13));
				m.put("Host",rs.getString(14));
				M.add(m);
				}
			} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			}
		}
		return M;
	}

public JSONArray SallMeetings() {
	JSONArray M = new JSONArray(); 
	ResultSet rs = dao.allMeetings();
	if(rs!=null) {
	try {
		while(rs.next()) {
			//Meeting m=new Meeting();
			JSONObject m = new JSONObject();
			m.put("Mid",rs.getInt(1));
			m.put("Typeid",rs.getInt(2));
			m.put("Userid",rs.getInt(3));
			m.put("MeetingStatus",rs.getInt(4));
			m.put("StartTime",rs.getString(5));
			m.put("EndTime",rs.getString(6));
			m.put("Place",rs.getString(7));
			m.put("Guest",rs.getString(9));
			m.put("Describe",rs.getString(10));
			m.put("Remarks",rs.getString(11));
			m.put("SetTime",rs.getString(12));
			m.put("Mname",rs.getString(13));
			m.put("Host",rs.getString(14));
			M.add(m);
			}
		} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
		}
	}
	return M;
}
public JSONArray SapplyedMeeting(int uid,int stateid) {
	JSONArray M = new JSONArray(); 
	ResultSet rs = dao.applyedMeeting(uid,stateid);
	if(rs!=null) {
	try {
		while(rs.next()) {
			//Meeting m=new Meeting();
			JSONObject m = new JSONObject();
			m.put("Mid",rs.getInt(1));
			m.put("Typeid",rs.getInt(2));
			m.put("Userid",rs.getInt(3));
			m.put("MeetingStatus",rs.getInt(4));
			m.put("StartTime",rs.getString(5));
			m.put("EndTime",rs.getString(6));
			m.put("Place",rs.getString(7));
			m.put("Guest",rs.getString(9));
			m.put("Describe",rs.getString(10));
			m.put("Remarks",rs.getString(11));
			m.put("SetTime",rs.getString(12));
			m.put("Mname",rs.getString(13));
			m.put("Host",rs.getString(14));
			M.add(m);
			}
		} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
		}
	}
	return M;
}
}
