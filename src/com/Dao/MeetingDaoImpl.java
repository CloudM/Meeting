//Karenzhu

package com.Dao;

import java.sql.ResultSet;

import com.DBbase.DBDao;

import com.entity.Meeting;
public class MeetingDaoImpl extends DBDao implements  MeetingDao{
	//add meeting with sql statement realization
	//return row number
    public int AddMeeting(Meeting m) {
    	String sql="insert into meeting values(null,?,?,?,?,null,?,null,?,?,?,now(),?,?)";
		 Object[] obs={m.getTypeid(),m.getUserid(),m.getMeetingStatus(),m.getStartTime(),m.getPlace(),m.getGuest(),m.getDescribe(),m.getRemarks(),m.getMname(),m.getHost()};
		return ExecuteUpdate(sql, obs);
    }
    //delete meeting according to mid with sql statement realization
    //return row number
	public int DeleteMeeting(Meeting m) {
		String sql="delete from meeting where MeetingID=?";
		Object[] obs = {m.getMid()};
		return ExecuteUpdate(sql, obs);
	}
	//search meeting according to mid with sql statement realization
	//return resultset
	public ResultSet FindMeeting(int mid){
		
		String sql="select * from meeting where MeetingID=?";
		Object[]  obs= {mid};
		return ExecuteQuery(sql,obs);
		
		}
	//update meeting to change the status of meeting
	//return row number
	public int ReleaseMeeting(int mid) {
		String sql="update meeting set MeetingStateID = ? where MeetingID=?";
		Object[] obs= {2,mid};
		return ExecuteUpdate(sql,obs);

	}
	//update meeting to change the information of meeting
    //return resultset
	public int UpdateMeeting(Meeting m,int mid) {
		String sql="update meeting set MeetingTypeID=?,StartTime=?,Place=?,MainGuest=?,MeetingIntroduction=?,Note=?,MeetingName=?,Host=? where MeetingID=?";
		Object[] obs={m.getTypeid(),m.getStartTime(),m.getPlace(),m.getGuest(),m.getDescribe(),m.getRemarks(),m.getMname(),m.getHost(),mid};
		return ExecuteUpdate(sql, obs);
	
	}
	//find out all meetings with their different status
	//return reslutset
	public ResultSet hasReleasedMeeting(int userid,int status1,int status2) {
		String sql = "select * from meeting where UserID = ? and (MeetingStateID = ? or MeetingStateID=?)";
		Object[] obs = {userid,status1,status2};
		return ExecuteQuery(sql,obs);
	}
	//find all meetings
	//return reultset
	public ResultSet allMeetings() {
		String sql = "select * from meeting";
		Object[] obs = {};
		return ExecuteQuery(sql,obs);
	}
	//find meetings with applyer
	//return resutset
	public ResultSet applyedMeeting(int uid,int stateid) {
		String sql = "select * from meeting join applylist on meeting.MeetingID=applylist.MeetingID where applylist.UserID=? and applylist.ApplyState=?;";
		Object[] obs = {uid,stateid};
		return ExecuteQuery(sql,obs);
	}
}
