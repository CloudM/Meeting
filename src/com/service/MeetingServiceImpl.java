//KarenZhu
package com.service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.UserDao.MeetingDao;
import com.UserDao.MeetingDaoImpl;
import com.entity.Meeting;
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
	public Meeting SFindMeeting(Meeting m) {
		Meeting M=new Meeting();
		if(dao.FindMeeting(m)!=null) {
			try {
				M.setMid(dao.FindMeeting(m).getInt(1));
				M.setTypeid(dao.FindMeeting(m).getInt(2));
				M.setUserid(dao.FindMeeting(m).getInt(3));
				M.setMeetingStatus(dao.FindMeeting(m).getInt(4));
				M.setStartTime(dao.FindMeeting(m).getString(5));
				M.setEndTime(dao.FindMeeting(m).getString(6));
				M.setPlace(dao.FindMeeting(m).getString(7));
				M.setGuest(dao.FindMeeting(m).getString(9));
				M.setDescribe(dao.FindMeeting(m).getString(10));
				M.setRemarks(dao.FindMeeting(m).getString(11));
				M.setSetTime(dao.FindMeeting(m).getString(12));
				M.setMname(dao.FindMeeting(m).getString(13));
				M.setHost(dao.FindMeeting(m).getString(14));
				
				return M;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return M;
	}
	//turn the result of changing meeting status to boolean
	public boolean SUpdateMeeting(Meeting m) {
		// TODO Auto-generated method stub
		if (dao.UpdateMeeting(m)>0) {
			return true;
		}
		else {
			return false;
		}
	
	}
	//turn the result of changing meeting status to boolean
	public boolean SReleaseMeeting(Meeting m) {
		// TODO Auto-generated method stub
		if (dao.ReleaseMeeting(m)>0) {
			return true;
		}
		else {
			return false;
		}
	
	}
	
	public List<Meeting> ShasReleasedMeeting(int userid,int status) {
		List<Meeting> M = new ArrayList<>();
		ResultSet rs = dao.hasReleasedMeeting(userid,status);
		if(rs!=null) {
		try {
			while(rs.next()) {
				Meeting m=new Meeting();
				m.setMid(rs.getInt(1));
				m.setStartTime(rs.getString(5));
				m.setMname(rs.getString(13));
				m.setTypeid(rs.getInt(2));
				m.setHost(rs.getString(14));
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
